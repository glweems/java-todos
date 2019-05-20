package com.glweems.todos.repo;

import com.glweems.todos.model.Post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository
  extends JpaRepository<Post, Long> {}

