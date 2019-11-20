package com.github.wreulicke.logging;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Response for my api.
 */
public class MyResponse {

  public final String value;

  @JsonCreator
  public MyResponse(@JsonProperty("value") String value) {
    this.value = value;
  }
}
