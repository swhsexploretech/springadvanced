package com.photoapp.api.gateway;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class MyPreFilter implements GlobalFilter, Ordered {
	
	final Logger logger = LoggerFactory.getLogger(MyPreFilter.class);

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		logger.info("My Prefilter is executed");
		String requestPath = exchange.getRequest().getPath().toString();
		logger.info("request path is "+requestPath);
		HttpHeaders headers = exchange.getRequest().getHeaders();
		Set<String> headerSet=headers.keySet();
		headerSet.forEach(header -> {
			logger.info("header value is "+header);
		});
		return chain.filter(exchange);
	}

	@Override
	public int getOrder() {
		return 0;
	}

}
