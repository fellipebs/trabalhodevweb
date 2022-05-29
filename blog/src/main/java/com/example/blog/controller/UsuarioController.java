package com.example.blog.controller;

import java.io.IOException;
import java.util.UUID;

import javax.validation.Valid;

import com.example.blog.model.PerfilAcesso;
import com.example.blog.model.Usuario;
import com.example.blog.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @RequestMapping(value = "/usuario/", method = RequestMethod.GET)
    public ModelAndView form() {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("usuario", usuarioService.getAllUsuario());
        return mav;
    }

    @RequestMapping(value = "/usuario/insert", method = RequestMethod.GET)
    public ModelAndView insert() {
        return new ModelAndView("insert", "usuario", new Usuario());
    }

    @RequestMapping(value = "/usuario/insert", method = RequestMethod.POST)
    public String submitInsert(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        
        usuario.setFoto("default.png");
        usuario.setPerfilAcesso(new PerfilAcesso(3, "Usuário"));
        usuario.setBiografia("Hello World!");

        usuarioService.insertUsuario(usuario);
        return "redirect:";
    }

    @RequestMapping(value = "/usuario/update", method = RequestMethod.GET)
    public ModelAndView update(Integer id) {
        return new ModelAndView("update", "usuario", usuarioService.getUsuarioById(id).get());
    }

    @RequestMapping(value = "/usuario/update", method = RequestMethod.POST)
    public RedirectView submitUpdate(@SessionAttribute(name = "usuarioAtual", required = false) Usuario usuarioAtual, @Valid @ModelAttribute("usuario") Usuario usuario, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return new RedirectView("/editarperfil", true);
        }

        if(usuario.getSenha() == "" || usuario.getSenha() == null){
            usuario.setSenha(usuarioAtual.getSenha());
        }

        usuario.setIdUsuario(usuarioAtual.getIdUsuario());
        usuario.setPerfilAcesso(usuarioAtual.getPerfilAcesso());
        usuario.setFoto(usuarioAtual.getFoto());

        usuarioService.updateUsuario(usuario);

        // Atualiza o valor da sessão atual
        usuarioAtual.setBiografia(usuario.getBiografia());
        usuarioAtual.setNome(usuario.getNome());
        usuarioAtual.setEmail(usuario.getEmail());
        usuarioAtual.setFoto(usuario.getFoto());
        usuarioAtual.setSenha(usuario.getSenha());

        return new RedirectView("/", true);
    }

    @RequestMapping(value = "/usuario/delete", method = RequestMethod.GET)
    public ModelAndView delete(Integer id) {
        return new ModelAndView("delete", "usuario", usuarioService.getUsuarioById(id).get());
    }

    @RequestMapping(value = "/usuario/delete", method = RequestMethod.POST)
    public String submitDelete(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult result, ModelMap model) {
        
        if (result.hasErrors()) {
            return "error";
        }
        usuarioService.deleteUsuarioById(usuario.getIdUsuario());
        return "redirect:";

    }

    @PostMapping("/usuario/foto/update")
    public RedirectView savePost(@SessionAttribute(name = "usuarioAtual", required = false) Usuario usuarioAtual, @RequestParam("imageFile") MultipartFile imageFile) throws IOException{

        String fileName = imageFile.getOriginalFilename();
        String extension = fileName.substring(fileName.lastIndexOf(".") + 1);
        String newFileName = UUID.randomUUID() + "." + extension;

        usuarioAtual.setFoto(newFileName);

        usuarioService.updateUsuario(usuarioAtual); 

        String uploadDir = "usuario-fotos/";
 
        FileUploadUtil.saveFile(uploadDir, newFileName, imageFile);
         
        return new RedirectView("/", true);
    }
}