package by.refor.mobilefarm.config;

import org.apache.catalina.connector.Connector;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@SpringBootApplication
@EnableJpaRepositories("by.refor.mobilefarm.repo")
@ComponentScan("by.refor.mobilefarm.*")
public class MobileFarmApplication {

//	@Value("${http.port}")
//	private int httpPort;

	public static void main(String[] args) {
		SpringApplication.run(MobileFarmApplication.class, args);
	}
//	@Bean
//	public ServletWebServerFactory servletContainer() {
//		TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
//		tomcat.addAdditionalTomcatConnectors(createStandardConnector());
//		return tomcat;
//	}
//
//	private Connector createStandardConnector() {
//		Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
//		connector.setPort(httpPort);
//		return connector;
//	}
}
