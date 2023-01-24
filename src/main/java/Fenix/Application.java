package Fenix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.time.Duration;
import java.util.Arrays;

@SpringBootApplication
@RequestMapping("api/v1")
public class Application {

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
	}


	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry
						.addMapping("/**")
						.allowedOrigins("http://localhost:3000")
						.allowedHeaders("Access-Control-Allow-Origin","content-type","Access-Control-Allow-Headers")
						.allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE")
						.allowCredentials(true);
			}
		};
	}
}