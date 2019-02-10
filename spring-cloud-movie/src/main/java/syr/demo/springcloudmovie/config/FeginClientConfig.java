package syr.demo.springcloudmovie.config;

import feign.Contract;
import feign.Feign;
import feign.Logger;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;

@Configuration
@ExcludeFromComponentScan
public class FeginClientConfig {

    @Bean
    public Contract feginContract(){
        return new Contract.Default();
    }

    //配置http读取eureka时的用户和密码
    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor(){
        return new BasicAuthRequestInterceptor("syr", "Aa720325");
    }

    //配置fegin日志
    @Bean
    Logger.Level feginLoggerLevel(){
        return Logger.Level.FULL;
    }


    //禁用当前feign配置文件指向的feign的hystrix
//    @Bean
//    @Scope("prototype")
//    public Feign.Builder feginBuilder(){
//        return Feign.builder();
//    }
}
