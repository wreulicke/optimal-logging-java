/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.github.wreulicke.logging;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApplicationTest {

  @Autowired
  TestRestTemplate testRestTemplate;

  @Test
  public void HTTP経由でindex() {
    ResponseEntity<MyResponse> response = testRestTemplate.getForEntity("/api", MyResponse.class);
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(response.getBody().value).isEqualTo("index");
  }


  @Test
  public void HTTP経由でpost() {
    ResponseEntity<MyResponse> response = testRestTemplate.postForEntity("/api", null, MyResponse.class);
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(response.getBody().value).isEqualTo("post");
  }

}
