package com.example.blog.controller;

import com.example.blog.model.Post;
import com.example.blog.service.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import javax.validation.Valid;

@Controller
public class PostController {

    @Autowired
    PostService postService;    

    @RequestMapping(value = "/post/{id}", method = RequestMethod.GET)
    public ModelAndView readPost(@PathVariable Integer id) {
        ModelAndView mav = new ModelAndView("readpost");
        postService.getPostById(id).ifPresent(val -> mav.addObject("post", val));
        return mav;
    }

    @RequestMapping(value = "/post/insert", method = RequestMethod.GET)
    public ModelAndView insert() { return new ModelAndView("insert", "post", new Post()); }

    @RequestMapping(value = "/post/insert", method = RequestMethod.POST)
    public String submitInsert(@Valid @ModelAttribute("post")Post post, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        postService.insertPost(post);
        return "redirect:";
    }

    @RequestMapping(value = "/post/update", method = RequestMethod.GET)
    public ModelAndView update(Integer id) {
        return new ModelAndView("update", "post", postService.getPostById(id).get());
    }

    @RequestMapping(value = "/post/update", method = RequestMethod.POST)
    public String submitUpdate(@Valid @ModelAttribute("post")Post post, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        postService.updatePost(post);
        return "redirect:";
    }

    @RequestMapping(value = "/post/delete", method = RequestMethod.GET)
    public ModelAndView delete(Integer id) {
        return new ModelAndView("delete", "post", postService.getPostById(id).get());
    }

    @RequestMapping(value = "/post/delete", method = RequestMethod.POST)
    public String submitDelete(@Valid @ModelAttribute("post")Post post, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        postService.deletePostById(post.getIdPost());
        return "redirect:";

    }

}
