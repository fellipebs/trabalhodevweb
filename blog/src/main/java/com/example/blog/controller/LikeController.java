package com.example.blog.controller;

import com.example.blog.model.Like;
import com.example.blog.service.LikeService;
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
public class LikeController {

    @Autowired
    LikeService likeService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView form() {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("like", likeService.getAllLike());
        return mav;
    }

    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public ModelAndView insert() {
        return new ModelAndView("insert", "like", new Like());
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String submitInsert(@Valid @ModelAttribute("like")Like like, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        likeService.insertlike(like);
        return "redirect:";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ModelAndView delete(Integer id) {
        return new ModelAndView("delete", "like", likeService.getLikeById(id).get());
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String submitDelete(@Valid @ModelAttribute("like")Like like, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        likeService.deleteLikeById(like.getIdLike());
        return "redirect:";

    }

}
