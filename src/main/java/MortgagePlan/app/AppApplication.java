package MortgagePlan.app;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Bean;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.service.ApiInfo;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages={"MortgagePlan.app"})
public class AppApplication {
	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

	@Bean
	public Docket swaggerConfiguration(){
		return new Docket(DocumentationType.SWAGGER_2)
		.select()
		.paths(PathSelectors.ant("/mortgages/*"))
		.apis(RequestHandlerSelectors.basePackage("MortgagePlan.app"))
		.build()
		.apiInfo(apiDetails());
	}

	private ApiInfo apiDetails() {
		return new ApiInfo(
			"Mortgage Plan API",
			"Mortgage Plan API for coding exercise",
			"1.0",
			"Free to use",
			new springfox.documentation.service.Contact("Sebastian Penttinen", "https://sebastianpenttinen.com/", "abc@com"),
			"API License",
			"API license URL",
			Collections.emptyList());
	}
}
