package com.example.blog.controller;

import java.io.IOException;
import java.util.List;

import com.example.blog.model.PerfilAcesso;
import com.example.blog.model.Post;
import com.example.blog.model.Usuario;
import com.example.blog.service.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

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

    @PostMapping("/post/save")
    public RedirectView savePost(@ModelAttribute("post")Post post, @RequestParam("imageFile") MultipartFile imageFile) throws IOException{

        String fileName = imageFile.getOriginalFilename();
        String extension = fileName.substring(fileName.lastIndexOf(".") + 1);
        String newFileName = "post-foto-" + post.getIdPost() + "." + extension;

        PerfilAcesso admin = new PerfilAcesso(1, "Admin");

        post.setFoto(newFileName);
        post.setUsuario(new Usuario(1, "Giugiu ademir", "giu@bloggersin.com", "senha123", "foto.png", "lorem ipsum ai que dor", admin));

        postService.insertPost(post); 

        String uploadDir = "src/main/resources/static/post-fotos/";
 
        FileUploadUtil.saveFile(uploadDir, newFileName, imageFile);
         
        return new RedirectView("/", true);
    }

}
