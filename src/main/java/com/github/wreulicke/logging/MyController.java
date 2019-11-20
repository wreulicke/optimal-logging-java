package com.github.wreulicke.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyController {

  private static final Logger logger = LoggerFactory.getLogger(MyController.class);

  @GetMapping
  public ResponseEntity<MyResponse> index() {
    return ResponseEntity.ok(new MyResponse("test"));
  }
}
