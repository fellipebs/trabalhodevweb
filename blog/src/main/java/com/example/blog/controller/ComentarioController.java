package com.example.blog.controller;

import com.example.blog.model.Comentario;
import com.example.blog.model.Post;
import com.example.blog.model.Usuario;
import com.example.blog.service.ComentarioService;
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
public class ComentarioController {
    @Autowired
    ComentarioService comentarioService;

    @Autowired
    PostService postService;

    @RequestMapping(value = "/comentario/", method = RequestMethod.GET)
    public ModelAndView form() {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("comentario", comentarioService.getAllComentario());
        return mav;
    }

    @RequestMapping(value = "/comentario/insert", method = RequestMethod.GET)
    public ModelAndView insert() {
        return new ModelAndView("insert", "comentario", new Comentario());
    }

    @RequestMapping(value = "/comentario/insert", method = RequestMethod.POST)
    public RedirectView submitInsert(@SessionAttribute(name = "usuarioAtual", required = false) Usuario usuarioAtual,
            @RequestParam("comentario") String comentario, @RequestParam("idPost") Integer idPost) {
        if (usuarioAtual == null || usuarioAtual.getNome() == null) {
            return new RedirectView("/login", true);
        }

        Post postAtual = postService.getPostById(idPost).get();
        Comentario novoComentario = new Comentario();

        novoComentario.setComentario(comentario);
        novoComentario.setPost(postAtual);
        novoComentario.setUsuario(usuarioAtual);

        comentarioService.insertComentario(novoComentario);

        return new RedirectView("/post/" + postAtual.getIdPost(), true);

    }

    @RequestMapping(value = "/comentario/update", method = RequestMethod.GET)
    public ModelAndView update(Integer id) {
        return new ModelAndView("update", "comentario", comentarioService.getComentarioById(id).get());
    }

    @RequestMapping(value = "/comentario/update", method = RequestMethod.POST)
    public String submitUpdate(@Valid @ModelAttribute("comentario") Comentario comentario, BindingResult result,
            ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        comentarioService.updateComentario(comentario);
        return "redirect:";
    }

    @RequestMapping(value = "/comentario/delete", method = RequestMethod.GET)
    public ModelAndView delete(Integer id) {
        return new ModelAndView("delete", "comentario", comentarioService.getComentarioById(id).get());
    }

    @RequestMapping(value = "/comentario/delete", method = RequestMethod.POST)
    public String submitDelete(@Valid @ModelAttribute("comentario") Comentario comentario, BindingResult result,
            ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        comentarioService.deleteComentarioById(comentario.getIdComentario());
        return "redirect:";

    }
}
