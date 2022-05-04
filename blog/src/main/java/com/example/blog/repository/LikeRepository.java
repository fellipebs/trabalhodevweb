package com.example.blog.repository;

import com.example.blog.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("LikeRepository")
public interface LikeRepository extends JpaRepository<Like, Integer> {
}
