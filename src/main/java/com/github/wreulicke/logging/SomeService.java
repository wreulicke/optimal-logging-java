package com.github.wreulicke.logging;

import static com.google.common.flogger.LazyArgs.lazy;

import java.util.concurrent.TimeUnit;

import com.google.common.flogger.FluentLogger;
import com.google.common.flogger.LazyArgs;

import io.micrometer.core.instrument.Timer;

public class SomeService {
	
	private static final FluentLogger logger = FluentLogger.forEnclosingClass();
	
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
					logger.atSevere() // ERROR
						.log("error is occured when user service is called. user service is down?");
				}
			});
			
			// Loop内部のログは何回かに1回にサマリを出力する
			logger.atInfo()
				.every(100)
				.log("task-%s is executed. mean:%f, max:%f",
					i,
					lazy(() -> timer.mean(TimeUnit.MILLISECONDS)),
					lazy(() -> timer.max(TimeUnit.MILLISECONDS)));
		}
		
		// 終了時に
		logger.atInfo()
			.log("tasks is executed");
	}
	
}
