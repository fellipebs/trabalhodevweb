package com.example.blog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.blog.service.PostService;
import com.example.blog.service.CategoriaService;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    PostService postService;

    @Autowired
    CategoriaService categoriaService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("allPosts", postService.getAllPost());
        mav.addObject("allCategorias", categoriaService.getAllCategoria());
        return mav;
    }

    @RequestMapping(value = "/criarpost", method = RequestMethod.GET)
    public String criarPost() {
        return "criarpost";
    }

    @RequestMapping(value = "/readpost", method = RequestMethod.GET)
    public String readPost() {
        return "readpost";
    }

    @RequestMapping(value = "/editarpost", method = RequestMethod.GET)
    public String editarPost() {
        return "editarpost";
    }

    @RequestMapping(value = "/cadastrar", method = RequestMethod.GET)
    public String cadastrar() {
        return "cadastrar";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/editarperfil", method = RequestMethod.GET)
    public String editarPerfil() {
        return "editarperfil";
    }

}
