package example.micronaut;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.http.client.exceptions.HttpClientResponseException;
import io.micronaut.test.annotation.MicronautTest;
import io.swagger.model.Pet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@MicronautTest
public class HelloControllerTest {

  @Inject
  @Client("/")
  RxHttpClient client;

  @Test
  public void testHello() {
    HttpRequest<String> request = HttpRequest.GET("/hello");
    String body = client.toBlocking().retrieve(request);

    assertNotNull(body);
    assertEquals("Hello World", body);
  }

  @Test
  public void testValidation() {
    HttpRequest<Pet> request = HttpRequest.POST("/hello", new Pet());
    String body = client.toBlocking().retrieve(request);

    assertNotNull(body);
    assertEquals("Hello World", body);
  }

  @Test
  public void testPersonValidation() {
    HttpClientResponseException e = Assertions.assertThrows(HttpClientResponseException.class, () -> {
      Person p = new Person();
      p.setName("");
      client.toBlocking().exchange(HttpRequest.POST("/hello/person", p));
    });
    HttpResponse response = e.getResponse();
    assertEquals(HttpStatus.BAD_REQUEST, response.getStatus());
  }


  @Test
  public void testExternalPersonValidation() {
    HttpClientResponseException e = Assertions.assertThrows(HttpClientResponseException.class, () -> {
      Person p = new Person();
      p.setName("");
      client.toBlocking().exchange(HttpRequest.POST("/hello/externalperson", p));
    });
    HttpResponse response = e.getResponse();
    assertEquals(HttpStatus.BAD_REQUEST, response.getStatus());
  }

}