package ua.lviv.home.SpringWebHomework18;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringWebHomework18Application extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
		return application.sources(SpringWebHomework18Application.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringWebHomework18Application.class, args);
	}

}
