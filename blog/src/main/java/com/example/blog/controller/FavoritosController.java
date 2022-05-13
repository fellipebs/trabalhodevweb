package com.example.blog.controller;

import com.example.blog.model.Favoritos;
import com.example.blog.service.FavoritosService;
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
public class FavoritosController {
    @Autowired
    FavoritosService favoritosService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView form() {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("favoritos", favoritosService.getAllFavoritos());
        return mav;
    }

    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public ModelAndView insert() {
        return new ModelAndView("insert", "favoritos", new Favoritos());
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String submitInsert(@Valid @ModelAttribute("favoritos")Favoritos favoritos, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        favoritosService.insertFavoritos(favoritos);
        return "redirect:";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public ModelAndView update(Integer id) {
        return new ModelAndView("update", "favoritos", favoritosService.getFavoritosById(id).get());
    }
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String submitUpdate(@Valid @ModelAttribute("favoritos")Favoritos favoritos, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        favoritosService.updateFavoritos(favoritos);
        return "redirect:";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ModelAndView delete(Integer id) {
        return new ModelAndView("delete", "favoritos", favoritosService.getFavoritosById(id).get());
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String submitDelete(@Valid @ModelAttribute("favoritos")Favoritos favoritos, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        favoritosService.deleteFavoritosById(favoritos.getIdFavoritos());
        return "redirect:";

    }

}
