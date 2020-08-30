package com.sda;

import com.sda.controller.HomeController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class ShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopApplication.class, args);
	}

////reczne wrzucanie funkcji jako springowej, przy uzyciu Bean
//	@Bean
//	public HomeController homeController() {
//		return new HomeController();
//	}

}
