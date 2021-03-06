package example.micronaut;

import javax.validation.constraints.NotBlank;

public class Person {

  @NotBlank
  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}