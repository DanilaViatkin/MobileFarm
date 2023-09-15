package by.refor.mobilefarm.config;

import by.refor.mobilefarm.helper.ExcelExtractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@SpringBootApplication
@EnableJpaRepositories("by.refor.mobilefarm.repo")
@ComponentScan("by.refor.mobilefarm.*")
public class MobileFarmApplication {
	public static void main(String[] args) {
		SpringApplication.run(MobileFarmApplication.class, args);

	}

	@Bean
	public ResourceBundleMessageSource getResourceBundleMessageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.addBasenames("message");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}
}
