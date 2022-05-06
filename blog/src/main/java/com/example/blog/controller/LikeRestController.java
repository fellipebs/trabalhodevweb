package com.example.blog.controller;

import com.example.blog.model.Like;
import com.example.blog.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LikeRestController {
    @Autowired
    LikeService likeService;

    @RequestMapping(value = "/like", method = RequestMethod.GET)
    public List<Like> get(){
        return likeService.getAllLike();
    }

    @RequestMapping(value = "/like/{id}", method = RequestMethod.GET)
    public Optional<Like> getName(@PathVariable Integer id) { return likeService.getLikeById(id); }

    @RequestMapping(value = "/like/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        likeService.getLikeById(id);
    }
}
