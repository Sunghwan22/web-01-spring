package com.makao.letter.models;

import com.makao.letter.utils.RegistrationNumber;

public class Post {
  private int registrationNumber;

  private String title;
  private String author;
  private String content;

  public Post(String title, String author, String content) {
    this.title = title;
    this.author = author;
    this.content = content;
    this.registrationNumber = RegistrationNumber.giveRegistrationNumber();
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

  public int registrationNumber() {
    return registrationNumber;
  }
}
