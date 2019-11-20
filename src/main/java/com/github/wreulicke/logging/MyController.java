package com.github.wreulicke.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyController {

  private static final Logger logger = LoggerFactory.getLogger(MyController.class);

  @Autowired
  MyService service;

  @GetMapping
  public ResponseEntity<MyResponse> index() {
    return ResponseEntity.ok(new MyResponse("index"));
  }

  @PostMapping
  public ResponseEntity<MyResponse> post() {
    service.doSomething();
    return ResponseEntity.ok(new MyResponse("post"));
  }
}
