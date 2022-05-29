package com.example.blog.controller;

import com.example.blog.model.Usuario;
import com.example.blog.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@org.springframework.stereotype.Controller
@SessionAttributes("usuarioAtual")
public class LoginController {

    @Autowired
    UsuarioService usuarioService;

    @ModelAttribute("usuarioAtual")
    public Usuario setUpUserForm() {
        return new Usuario();
    }

    @PostMapping("/login-user")
    public String loginUser(@ModelAttribute("usuarioAtual") Usuario usuario) {

        Usuario login = usuarioService.findByEmailAndSenha(usuario.getEmail(), usuario.getSenha());

        if (login != null) {
            usuario.setBiografia(login.getBiografia());
            usuario.setEmail(login.getEmail());
            usuario.setFoto(login.getFoto());
            usuario.setIdUsuario(login.getIdUsuario());
            usuario.setNome(login.getNome());
            usuario.setPerfilAcesso(login.getPerfilAcesso());

            return "redirect:";
        } else {
            usuario = null;
            return "login";
        }

    }

    @RequestMapping(value = "/cadastrar", method = RequestMethod.GET)
    public ModelAndView cadastrar(@SessionAttribute(name = "usuarioAtual", required = false) Usuario usuarioAtual) {
        if (usuarioAtual != null && usuarioAtual.getPerfilAcesso() != null) {
            return new ModelAndView("redirect:");
        }

        return new ModelAndView("cadastrar");
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(@SessionAttribute(name = "usuarioAtual", required = false) Usuario usuarioAtual) {
        if (usuarioAtual != null && usuarioAtual.getPerfilAcesso() != null) {
            return new ModelAndView("redirect:");
        }

        return new ModelAndView("login");
    }

    @RequestMapping(value = "/editarperfil", method = RequestMethod.GET)
    public ModelAndView editarPerfil(@SessionAttribute(name = "usuarioAtual", required = false) Usuario usuarioAtual) {
        if (usuarioAtual == null || usuarioAtual.getPerfilAcesso() == null) {
            return new ModelAndView("redirect:");
        }

        ModelAndView mav = new ModelAndView("editarperfil");
        mav.addObject("info_usuario", usuarioAtual);
        return mav;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public RedirectView logout(@SessionAttribute(name = "usuarioAtual", required = false) Usuario usuarioAtual) {
        usuarioAtual.setBiografia(null);
        usuarioAtual.setEmail(null);
        usuarioAtual.setFoto("default.png");
        usuarioAtual.setIdUsuario(0);
        usuarioAtual.setNome(null);
        usuarioAtual.setPerfilAcesso(null);
        usuarioAtual.setIdUsuario(0);

        return new RedirectView("/", true);
    }

}
