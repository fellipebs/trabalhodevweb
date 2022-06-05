package com.example.blog.controller;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import com.example.blog.model.Comentario;
import com.example.blog.model.Favoritos;
import com.example.blog.model.Post;
import com.example.blog.model.Usuario;
import com.example.blog.service.CategoriaService;
import com.example.blog.service.ComentarioService;
import com.example.blog.service.FavoritosService;
import com.example.blog.service.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class PostController {

    @Autowired
    PostService postService;

    @Autowired
    ComentarioService comentarioService;

    @Autowired
    FavoritosService favoritosService;

    @Autowired
    CategoriaService categoriaService;

    @RequestMapping(value = "/post/{id}", method = RequestMethod.GET)
    public ModelAndView readPost(@SessionAttribute(name = "usuarioAtual", required = false) Usuario usuarioAtual,
            @PathVariable Integer id) {
        ModelAndView mav = new ModelAndView("readpost");

        // lista o post
        postService.getPostById(id).ifPresent(val -> mav.addObject("post", val));
        // carrega os comentarios do post
        mav.addObject("comentarios", comentarioService.getAllComentarioByPostId(id));
        // carrega a quantidade de favoritos do post
        favoritosService.getCountOfFavoritosByPostId(id)
                .ifPresent(val -> mav.addObject("favoritos", retornaFavoritoTexto(val)));
        mav.addObject("info_usuario", usuarioAtual != null && usuarioAtual.getNome() != null ? usuarioAtual : null);

        return mav;
    }

    @PostMapping("/post/insert")
    public RedirectView savePost(@SessionAttribute(name = "usuarioAtual", required = false) Usuario usuarioAtual,
            @ModelAttribute("post") Post post, @RequestParam("imageFile") MultipartFile imageFile) throws IOException {

        String fileName = imageFile.getOriginalFilename();
        String extension = fileName.substring(fileName.lastIndexOf(".") + 1);
        String newFileName = UUID.randomUUID() + "." + extension;

        post.setFoto(newFileName);
        post.setUsuario(usuarioAtual);

        postService.insertPost(post);

        String uploadDir = "post-fotos/";

        FileUploadUtil.saveFile(uploadDir, newFileName, imageFile);

        return new RedirectView("/", true);
    }

    @RequestMapping(value = "/post/insert", method = RequestMethod.GET)
    public ModelAndView insert(@SessionAttribute(name = "usuarioAtual", required = false) Usuario usuarioAtual) {
        if (usuarioAtual == null || usuarioAtual.getPerfilAcesso() == null) {
            return new ModelAndView("redirect:");
        }

        ModelAndView mav = new ModelAndView("criarpost");

        mav.addObject("allCategorias", categoriaService.getAllCategoria());
        mav.addObject("info_usuario", usuarioAtual != null && usuarioAtual.getNome() != null ? usuarioAtual : null);

        return mav;
    }

    @RequestMapping(value = "/post/update", method = RequestMethod.GET)
    public ModelAndView update(Integer id,
            @SessionAttribute(name = "usuarioAtual", required = false) Usuario usuarioAtual) {
        ModelAndView mav = new ModelAndView("editarpost");

        mav.addObject("allCategorias", categoriaService.getAllCategoria());
        mav.addObject("post", postService.getPostById(id).get());
        mav.addObject("info_usuario", usuarioAtual != null && usuarioAtual.getNome() != null ? usuarioAtual : null);

        return mav;
    }

    @RequestMapping(value = "/post/update", method = RequestMethod.POST)
    public RedirectView submitUpdate(Integer id, @Valid @ModelAttribute("post") Post post, BindingResult result,
            ModelMap model) {
        if (result.hasErrors()) {
            return new RedirectView("/post/update?id=" + id);
        }

        Post postAntigo = postService.getPostById(id).get();

        post.setIdPost(id);
        post.setFoto(postAntigo.getFoto());
        post.setUsuario(postAntigo.getUsuario());

        postService.updatePost(post);
        return new RedirectView("/post/update?id=" + id);
    }

    @RequestMapping(value = "/post/foto/update", method = RequestMethod.POST)
    public RedirectView updatePostPhoto(Integer id, @RequestParam("imageFile") MultipartFile imageFile)
            throws IOException {

        String fileName = imageFile.getOriginalFilename();
        String extension = fileName.substring(fileName.lastIndexOf(".") + 1);
        String newFileName = UUID.randomUUID() + "." + extension;

        Post postAntigo = postService.getPostById(id).get();
        postAntigo.setFoto(newFileName);

        postService.updatePost(postAntigo);

        String uploadDir = "post-fotos/";

        FileUploadUtil.saveFile(uploadDir, newFileName, imageFile);

        return new RedirectView("/post/update?id=" + id);
    }

    @RequestMapping(value = "/post/delete", method = RequestMethod.GET)
    public ModelAndView delete(Integer id) {
        return new ModelAndView("delete", "post", postService.getPostById(id).get());
    }

    @RequestMapping(value = "/post/delete", method = RequestMethod.POST)
    public RedirectView submitDelete(@Valid @ModelAttribute("post") Post post) {

        List<Comentario> postComentarios = comentarioService.getAllComentarioByPostId(post.getIdPost());
        List<Favoritos> favoritoComentarios = favoritosService.getAllFavoritosByPostId(post.getIdPost());

        postComentarios.forEach(comentario -> comentarioService.deleteComentarioById(comentario.getIdComentario()));
        favoritoComentarios.forEach(favorito -> favoritosService.deleteFavoritosById(favorito.getIdFavoritos()));
        
        postService.deletePostById(post.getIdPost());

        return new RedirectView("/", true);

    }

    public String retornaFavoritoTexto(Integer qtde) {
        String textoFavoritos = "0 favoritos";

        if (qtde != null) {
            if (qtde == 1) {
                textoFavoritos = qtde + " favorito";
            } else if (qtde > 1) {
                textoFavoritos = qtde + " favoritos";
            }
        }

        return textoFavoritos;
    }
}
