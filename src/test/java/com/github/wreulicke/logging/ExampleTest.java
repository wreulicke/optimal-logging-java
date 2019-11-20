package com.github.wreulicke.logging;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExampleTest {

  private static final Logger logger = LoggerFactory.getLogger(ExampleTest.class);

  @Test
  public void 例外を一番後ろに渡してあげるとスタックトレースが表示される() {
    String s = "Hello World";
    try {
      Integer.parseInt(s);
    } catch (NumberFormatException e) {
      logger.error("整数文字列ではありません。入力: {}", s, e);
    }
  }

}
