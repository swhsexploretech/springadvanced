package com.photoapp.api.gateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import reactor.core.publisher.Mono;

@Configuration
public class GlobalFiltersConfig {
	
	final Logger logger = LoggerFactory.getLogger(GlobalFiltersConfig.class);
	
	@Order(2)
	@Bean
	public GlobalFilter secondPreFilter() {
		return(exchange,chain)-> {
			
			logger.info("My Second pre global filter is executed");
			
			return chain.filter(exchange).then(Mono.fromRunnable(()->{
				logger.info("My second post filter is called.");
			}));
		};
	}
	
	@Order(1)
	@Bean
	public GlobalFilter thirdPreFilter() {
		return(exchange,chain)-> {
			
			logger.info("My third pre global filter is executed");
			
			return chain.filter(exchange).then(Mono.fromRunnable(()->{
				logger.info("My third post filter is called.");
			}));
		};
	}
	
	@Order(3)
	@Bean
	public GlobalFilter fourthPreFilter() {
		return(exchange,chain)-> {
			
			logger.info("My fourth pre global filter is executed");
			
			return chain.filter(exchange).then(Mono.fromRunnable(()->{
				logger.info("My fourth post filter is called.");
			}));
		};
	}

}
