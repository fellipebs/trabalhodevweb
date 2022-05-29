package com.example.blog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.blog.service.PostService;

import com.example.blog.model.Usuario;
import com.example.blog.service.CategoriaService;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    PostService postService;

    @Autowired
    CategoriaService categoriaService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index(@SessionAttribute(name = "usuarioAtual", required = false) Usuario usuarioAtual) {
        ModelAndView mav = new ModelAndView("index");

        mav.addObject("allPosts", postService.getAllPost());
        mav.addObject("allCategorias", categoriaService.getAllCategoria());

        mav.addObject("info_usuario", usuarioAtual != null && usuarioAtual.getNome() != null ? usuarioAtual : null);

        return mav;
    }

    @RequestMapping(value = "/criarpost", method = RequestMethod.GET)
    public ModelAndView criarPost(@SessionAttribute(name = "usuarioAtual", required = false) Usuario usuarioAtual) {        
        if (usuarioAtual == null || usuarioAtual.getPerfilAcesso() == null) {
            return new ModelAndView("redirect:");
        }

        ModelAndView mav = new ModelAndView("criarpost");

        mav.addObject("allCategorias", categoriaService.getAllCategoria());
        mav.addObject("info_usuario", usuarioAtual != null && usuarioAtual.getNome() != null ? usuarioAtual : null);

        return mav;
    }

    @RequestMapping(value = "/editarpost", method = RequestMethod.GET)
    public String editarPost() {
        return "editarpost";
    }

}
