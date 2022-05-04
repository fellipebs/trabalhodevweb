package com.example.blog.repository;

import com.example.blog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("PostRepository")
public interface PostRepository extends JpaRepository<Post, Integer> {
}
