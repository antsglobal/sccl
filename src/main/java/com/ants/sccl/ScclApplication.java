package com.ants.sccl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.ants.sccl.mqtttest.MQTTTestController;

@SpringBootApplication
@EnableJpaAuditing
public class ScclApplication extends SpringBootServletInitializer  {
	public static void main(String[] args) {
		SpringApplication.run(ScclApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ScclApplication.class);
	}
}