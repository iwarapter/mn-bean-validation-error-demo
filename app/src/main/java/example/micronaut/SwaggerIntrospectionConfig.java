package example.micronaut;

import io.micronaut.core.annotation.Introspected;
import io.swagger.model.Pet;
import io.swagger.model.Pets;

@Introspected(classes = {Pet.class, Pets.class})
public class SwaggerIntrospectionConfig {
}
