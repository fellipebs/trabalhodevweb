package com.example.blog.controller;

import com.example.blog.model.Usuario;
import com.example.blog.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import javax.validation.Valid;

@Controller
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView form() {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("usuario", usuarioService.getAllUsuario());
        return mav;
    }

    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public ModelAndView insert() {
        return new ModelAndView("insert", "usuario", new Usuario());
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String submitInsert(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        usuarioService.insertUsuario(usuario);
        return "redirect:";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public ModelAndView update(Integer id) {
        return new ModelAndView("update", "usuario", usuarioService.getUsuarioById(id).get());
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String submitUpdate(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        usuarioService.updateUsuario(usuario);
        return "redirect:";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ModelAndView delete(Integer id) {
        return new ModelAndView("delete", "usuario", usuarioService.getUsuarioById(id).get());
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String submitDelete(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        usuarioService.deleteUsuarioById(usuario.getIdUsuario());
        return "redirect:";

    }
}