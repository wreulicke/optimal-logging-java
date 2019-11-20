package com.github.wreulicke.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

public class MyFilter extends OncePerRequestFilter {

  private static final Logger logger = LoggerFactory.getLogger(MyFilter.class);

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
    String requestId = UUID.randomUUID().toString();
    MDC.put("RequestId", requestId);
    logger.debug("requestId is generated. requestId:{}", requestId);

    response.setHeader("RequestId", requestId);

    try {
      filterChain.doFilter(request, response);
    } finally {
      MDC.remove("RequestId");
    }
  }
}
