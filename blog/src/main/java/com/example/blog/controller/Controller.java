package com.example.blog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@org.springframework.stereotype.Controller
public class Controller {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/criar", method = RequestMethod.GET)
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

    @RequestMapping(value = "/cadastrarP", method = RequestMethod.GET)
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
