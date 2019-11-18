package com.github.wreulicke.logging;

import io.micrometer.core.instrument.Timer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SomeService {

  private static final Logger logger = LoggerFactory.getLogger(SomeService.class);

  private final Timer timer;

  public SomeService(Timer timer) {
    this.timer = timer;
  }

  public void doSomething() {
		/*
		 * 関数への突入時のログはDEBUGかそもそも出さない。
		logger
			.atFine() // DEBUG
			.log("doSomething start");
		 */
    for (int i = 0; i < 10000; i++) {
      timer.record(() -> {
        // do something

        if (/* condition is error */ Math.random() < 0.1) {
          logger.error("error is occured when user service is called. user service is down?");
        }
      });

      // Loop内部のログは何回かに1回にサマリを出力する
      if (i % 100 == 0) {
        logger.error("task-{} is executed.", i);
      }
    }

    // 終了時に
    logger.info("{} tasks is executed", 10000);
  }

}
