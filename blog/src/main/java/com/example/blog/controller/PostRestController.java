package com.example.blog.controller;

import com.example.blog.model.Post;
import com.example.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
// import java.util.Optional;

@RestController
public class PostRestController {

    @Autowired
    PostService postService;

    @RequestMapping(value = "/post", method = RequestMethod.GET)
    public List<Post> get(){
        return postService.getAllPost();
    }

    // @RequestMapping(value = "/post/{id}", method = RequestMethod.GET)
    // public Optional<Post> getName(@PathVariable Integer id) {
    //     return postService.getPostById(id);
    // }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public void post(@RequestBody Post post) { postService.updatePost(post); }

    @RequestMapping(value = "/post/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        postService.getPostById(id);
    }

}
