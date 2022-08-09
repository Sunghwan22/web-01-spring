package com.makao.letter.models;

public class Post {
  private String title;
  private String author;
  private String content;

  public Post(String title, String author, String content) {
    this.title = title;
    this.author = author;
    this.content = content;
  }

  public String title() {
    return title;
  }

  public String author() {
    return author;
  }

  public String content() {
    return content;
  }
}
