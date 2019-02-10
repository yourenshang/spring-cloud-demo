package syr.demo.springclouduserserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringCloudUserServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudUserServerApplication.class, args);
	}

}

