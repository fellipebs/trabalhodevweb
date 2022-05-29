package com.example.blog.controller;

import com.example.blog.model.Post;
import com.example.blog.model.Usuario;
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

import java.io.IOException;

import javax.validation.Valid;

@Controller
public class PostController {

    @Autowired
    PostService postService;

    @Autowired
    ComentarioService comentarioService;

    @Autowired
    FavoritosService favoritosService;

    @RequestMapping(value = "/post/{id}", method = RequestMethod.GET)
    public ModelAndView readPost(@SessionAttribute(name = "usuarioAtual", required = false) Usuario usuarioAtual, @PathVariable Integer id) {
        ModelAndView mav = new ModelAndView("readpost");

        // lista o post
        postService.getPostById(id).ifPresent(val -> mav.addObject("post", val));
        // carrega os comentarios do post
        mav.addObject("comentarios", comentarioService.getAllComentarioByPostId(id));
        // carrega a quantidade de favoritos do post
        favoritosService.getCountOfFavoritosByPostId(id).ifPresent(val -> mav.addObject("favoritos", retornaFavoritoTexto(val)));
        mav.addObject("info_usuario", usuarioAtual != null && usuarioAtual.getNome() != null ? usuarioAtual : null);
       
        return mav;
    }

    @PostMapping("/post/insert")
    public RedirectView savePost(@SessionAttribute(name = "usuarioAtual", required = false) Usuario usuarioAtual, @ModelAttribute("post")Post post, @RequestParam("imageFile") MultipartFile imageFile) throws IOException{

        String fileName = imageFile.getOriginalFilename();
        String extension = fileName.substring(fileName.lastIndexOf(".") + 1);
        String newFileName = "post-foto-" + post.getIdPost() + "." + extension;

        post.setFoto(newFileName);
        post.setUsuario(usuarioAtual);

        postService.insertPost(post); 

        String uploadDir = "src/main/resources/static/post-fotos/";
 
        FileUploadUtil.saveFile(uploadDir, newFileName, imageFile);
         
        return new RedirectView("/", true);
    }

    @RequestMapping(value = "/post/insert", method = RequestMethod.GET)
    public ModelAndView insert() {
        return new ModelAndView("insert", "post", new Post());
    }

    @RequestMapping(value = "/post/update", method = RequestMethod.GET)
    public ModelAndView update(Integer id) {
        return new ModelAndView("update", "post", postService.getPostById(id).get());
    }

    @RequestMapping(value = "/post/update", method = RequestMethod.POST)
    public String submitUpdate(@Valid @ModelAttribute("post") Post post, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        postService.updatePost(post);
        return "redirect:";
    }

    @RequestMapping(value = "/post/delete", method = RequestMethod.GET)
    public ModelAndView delete(Integer id) {
        return new ModelAndView("delete", "post", postService.getPostById(id).get());
    }

    @RequestMapping(value = "/post/delete", method = RequestMethod.POST)
    public String submitDelete(@Valid @ModelAttribute("post") Post post, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        postService.deletePostById(post.getIdPost());
        return "redirect:";

    }

    public String retornaFavoritoTexto(Integer qtde){
        String textoFavoritos = "0 favoritos";

        if(qtde != null){
            if (qtde == 1) {
                textoFavoritos = qtde + " favorito";
            } else if (qtde > 1) {
                textoFavoritos = qtde + " favoritos";
            }
        }

        return textoFavoritos;
    }
}
