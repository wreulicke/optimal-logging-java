/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.github.wreulicke.logging;

import io.micrometer.core.instrument.Timer;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class AppTest {

	private static final Logger logger = LoggerFactory.getLogger(AppTest.class);
	
	@Test
	public void test() {
		final SimpleMeterRegistry registry = new SimpleMeterRegistry();
		final Timer timer = Timer.builder("test.timer")
			.publishPercentiles(0.5, 0.95) // median and 95th percentile
			.publishPercentileHistogram()
			.minimumExpectedValue(Duration.ofMillis(1))
			.register(registry);
		final SomeService service = new SomeService(timer);
		service.doSomething();
	}

	@Test
	public void 例外を一番後ろに渡してあげるとスタックトレースが表示される() {
		String s = "Hello World";
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException e) {
			logger.error("整数文字列ではありません。入力: {}", s,  e);
		}
	}
	
}
