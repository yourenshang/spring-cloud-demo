package syr.demo.springclouddashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class SpringCloudDashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudDashboardApplication.class, args);
    }

}

