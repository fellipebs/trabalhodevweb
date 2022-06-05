package com.example.blog.controller;

import com.example.blog.model.Favoritos;
import com.example.blog.model.Post;
import com.example.blog.model.Usuario;
import com.example.blog.service.FavoritosService;
import com.example.blog.service.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;

@Controller
public class FavoritosController {

    @Autowired
    FavoritosService favoritosService;

    @Autowired
    PostService postService;

    @RequestMapping(value = "/favoritos/", method = RequestMethod.GET)
    public ModelAndView form() {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("favoritos", favoritosService.getAllFavoritos());
        return mav;
    }

    @RequestMapping(value = "/favoritos/insert", method = RequestMethod.GET)
    public ModelAndView insert() {
        return new ModelAndView("insert", "favoritos", new Favoritos());
    }

    @RequestMapping(value = "/favoritos/insert", method = RequestMethod.POST)
    public RedirectView submitInsert(@SessionAttribute(name = "usuarioAtual", required = false) Usuario usuarioAtual,
            @RequestParam("idPost") Integer idPost) {
        if (usuarioAtual == null || usuarioAtual.getNome() == null) {
            return new RedirectView("/login", true);
        }

        Favoritos novoFavorito = new Favoritos();
        Post postAtual = postService.getPostById(idPost).get();

        novoFavorito.setPost(postAtual);
        novoFavorito.setUsuario(usuarioAtual);

        favoritosService.insertFavoritos(novoFavorito);
        return new RedirectView("/post/" + postAtual.getIdPost(), true);
    }

    @RequestMapping(value = "/favoritos/update", method = RequestMethod.GET)
    public ModelAndView update(Integer id) {
        return new ModelAndView("update", "favoritos", favoritosService.getFavoritosById(id).get());
    }

    @RequestMapping(value = "/favoritos/update", method = RequestMethod.POST)
    public String submitUpdate(@Valid @ModelAttribute("favoritos") Favoritos favoritos, BindingResult result,
            ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        favoritosService.updateFavoritos(favoritos);
        return "redirect:";
    }

    @RequestMapping(value = "/favoritos/delete", method = RequestMethod.GET)
    public ModelAndView delete(Integer id) {
        return new ModelAndView("delete", "favoritos", favoritosService.getFavoritosById(id).get());
    }

    @RequestMapping(value = "/favoritos/delete", method = RequestMethod.POST)
    public RedirectView submitDelete(@SessionAttribute(name = "usuarioAtual", required = false) Usuario usuarioAtual, @RequestParam("idPost") Integer idPost) {
                    
        favoritosService.deleteFavoritosByPostIdAndUserId(idPost, usuarioAtual.getIdUsuario());
        return new RedirectView("/post/" + idPost, true);

    }

}
