package com.example.blog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.blog.service.PostService;
import com.example.blog.model.Post;
import com.example.blog.model.Usuario;
import com.example.blog.service.CategoriaService;

import java.util.Collections;
import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    PostService postService;

    @Autowired
    CategoriaService categoriaService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index(@SessionAttribute(name = "usuarioAtual", required = false) Usuario usuarioAtual) {
        ModelAndView mav = new ModelAndView("index");

        List<Post> posts = postService.getAllPost();
        // ordena pelos ultimos posts
        Collections.reverse(posts);

        mav.addObject("allPosts", posts);
        mav.addObject("allCategorias", categoriaService.getAllCategoria());

        mav.addObject("info_usuario", usuarioAtual != null && usuarioAtual.getNome() != null ? usuarioAtual : null);

        return mav;
    }

}
