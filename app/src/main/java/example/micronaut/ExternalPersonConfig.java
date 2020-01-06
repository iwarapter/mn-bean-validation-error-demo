package example.micronaut;

import com.example.ExternalPerson;
import io.micronaut.core.annotation.Introspected;

@Introspected(classes = {ExternalPerson.class})
public class ExternalPersonConfig {
}
