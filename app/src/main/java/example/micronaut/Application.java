package example.micronaut;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.runtime.Micronaut;
import io.micronaut.validation.Validated;
import io.swagger.model.Pet;

//@Introspected(packages = "io.swagger.model", includedAnnotations = Validated.class)
public class Application {

  public static void main(String[] args) {
    Micronaut.run(Application.class);
  }
}