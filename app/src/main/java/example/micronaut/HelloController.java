package example.micronaut;

import com.example.ExternalPerson;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Produces;
import io.micronaut.validation.Validated;
import io.swagger.model.Pet;
import javax.validation.Valid;

@Validated
@Controller("/hello")
public class HelloController {
  @Get
  @Produces(MediaType.TEXT_PLAIN)
  public String index() {
    return "Hello World";
  }

  @Post
  public String validation(@Body @Valid Pet p) {
      return p.getName();
  }

  @Post("/person")
  public String personValidation(@Body @Valid Person p) {
    return p.getName();
  }


  @Post("/externalperson")
  public String personValidation(@Body @Valid ExternalPerson p) {
    return p.getName();
  }
}