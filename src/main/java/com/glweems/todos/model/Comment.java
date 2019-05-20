package com.glweems.todos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "comments")
public class Comment
  extends AuditModel {
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  private Long id;

  @Lob
  @NotNull
  private String text;

  @JoinColumn(name = "post_id", nullable = false, unique = true)
  @JsonIgnoreProperties("comments")
  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private Post post;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public Post getPost() {
    return post;
  }

  public void setPost(Post post) {
    this.post = post;
  }

}

