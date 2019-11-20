package com.github.wreulicke.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MyService {

  private static final Logger logger = LoggerFactory.getLogger(MyService.class);

  public void doSomething() {
    /*
     * 関数への突入時のログはDEBUGかそもそも出さない。
     */
    // logger.debug("doSomething start");

    for (int i = 0; i < 10000; i++) {
      // do something
      if (Math.random() < 0.1) { /* error happens sometimes */
        logger.error("error is occurred when user service is called. user service is down?");
      }

      // Loop内部のログは何回かに1回にサマリを出力すると良い
      if (i % 100 == 0) {
        logger.error("task-{} is executed.", i);
      }
    }

    // 関数への突入時よりもできるだけ終了時に
    logger.info("{} tasks is executed", 10000);
  }

}
