package com.glweems.todos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "posts")
public class Post
  extends AuditModel {
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  private Long id;

  @Column(unique = true)
  @NotNull
  @Size(max = 100)
  private String title;

  @NotNull
  @Size(max = 250)
  private String description;

  @Lob
  @NotNull
  private String content;

  @OneToMany(
    cascade = CascadeType.ALL,
    fetch = FetchType.LAZY,
    mappedBy = "post"
  )
  @JsonIgnoreProperties("post")
  private Set<Comment> comments = new HashSet<>();

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Set<Comment> getComments() {
    return comments;
  }

  public void setComments(Set<Comment> comments) {
    this.comments = comments;
  }

  // Getters and Setters (Omitted for brevity)
}

