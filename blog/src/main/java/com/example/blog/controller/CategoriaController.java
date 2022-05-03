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

@Controller
public class CategoriaController {
    @Autowired
    CategoriaService categoriaService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView form() {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("categoria", categoriaService.getAllCategoria());
        return mav;
    }

    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public ModelAndView insert() {
        return new ModelAndView("insert", "categoria", new Categoria());
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String submitInsert(@ModelAttribute("categoria")Categoria categoria, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        categoriaService.insertCategoria(categoria);
        return "redirect:";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public ModelAndView update(Integer id) {
        return new ModelAndView("update", "categoria", categoriaService.getCategoriaById(id).get());
    }
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String submitUpdate(@ModelAttribute("categoria")Categoria categoria, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        categoriaService.updateCategoria(categoria);
        return "redirect:";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ModelAndView delete(Integer id) {
        return new ModelAndView("delete", "categoria", categoriaService.getCategoriaById(id).get());
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String submitDelete(@ModelAttribute("categoria")Categoria categoria, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        categoriaService.deleteCategoriaById(categoria.getIdCategoria());
        return "redirect:";

    }



}
