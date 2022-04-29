package com.example.blog.service;

import com.example.blog.model.Post;
import java.util.List;
import java.util.Optional;

public interface PostService {
    Optional<Post> getPostById(Integer id);
    List<Post> getAllPost();
    void deleteAllPost();
    void deletePostById(Integer id);
    void updatePostById(Integer id, Post post);
    void updatePost(Post post);
    void insertPost(Post post);
}
