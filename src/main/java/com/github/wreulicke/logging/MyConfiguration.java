package com.github.wreulicke.logging;

import ch.qos.logback.classic.helpers.MDCInsertingServletFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

@Configuration
public class MyConfiguration {

  @Bean
  public FilterRegistrationBean<MyFilter> myFilter() {
    FilterRegistrationBean<MyFilter> bean = new FilterRegistrationBean<>();
    bean.setFilter(new MyFilter());
    bean.setOrder(Ordered.HIGHEST_PRECEDENCE + 1);
    return bean;
  }

  @Bean
  public FilterRegistrationBean<MDCInsertingServletFilter> mdcInsertingServletFilter() {
    FilterRegistrationBean<MDCInsertingServletFilter> bean = new FilterRegistrationBean<>();
    bean.setFilter(new MDCInsertingServletFilter());
    bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
    return bean;
  }

}
