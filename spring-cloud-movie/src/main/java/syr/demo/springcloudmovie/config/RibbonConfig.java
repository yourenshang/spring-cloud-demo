package syr.demo.springcloudmovie.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ExcludeFromComponentScan
public class RibbonConfig {

    @Bean
    public IRule ribbonRule(){
        System.out.println("---------------- rule");
        return new RandomRule();
    }

}
