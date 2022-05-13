package com.example.blog.controller;

import com.example.blog.model.Categoria;
import com.example.blog.service.CategoriaService;
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
public class CategoriaController {

    @Autowired
    CategoriaService categoriaService;

    @RequestMapping(value = "/categoria/", method = RequestMethod.GET)
    public ModelAndView form() {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("categoria", categoriaService.getAllCategoria());
        return mav;
    }

    @RequestMapping(value = "/categoria/insert", method = RequestMethod.GET)
    public ModelAndView insert() {
        return new ModelAndView("insert", "categoria", new Categoria());
    }

    @RequestMapping(value = "/categoria/insert", method = RequestMethod.POST)
    public String submitInsert(@Valid @ModelAttribute("categoria")Categoria categoria, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        categoriaService.insertCategoria(categoria);
        return "redirect:";
    }

    @RequestMapping(value = "/categoria/update", method = RequestMethod.GET)
    public ModelAndView update(Integer id) {
        return new ModelAndView("update", "categoria", categoriaService.getCategoriaById(id).get());
    }
    @RequestMapping(value = "/categoria/update", method = RequestMethod.POST)
    public String submitUpdate(@Valid @ModelAttribute("categoria")Categoria categoria, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        categoriaService.updateCategoria(categoria);
        return "redirect:";
    }

    @RequestMapping(value = "/categoria/delete", method = RequestMethod.GET)
    public ModelAndView delete(Integer id) {
        return new ModelAndView("delete", "categoria", categoriaService.getCategoriaById(id).get());
    }

    @RequestMapping(value = "/categoria/delete", method = RequestMethod.POST)
    public String submitDelete(@Valid @ModelAttribute("categoria")Categoria categoria, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        categoriaService.deleteCategoriaById(categoria.getIdCategoria());
        return "redirect:";

    }

}
