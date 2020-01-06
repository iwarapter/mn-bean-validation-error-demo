package com.example;

import javax.validation.constraints.NotBlank;

public class ExternalPerson {

  @NotBlank
  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
