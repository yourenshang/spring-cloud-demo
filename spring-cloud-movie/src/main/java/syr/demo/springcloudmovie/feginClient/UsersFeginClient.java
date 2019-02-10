package syr.demo.springcloudmovie.feginClient;

import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import syr.demo.springcloudmovie.config.FeginClientConfig;
import syr.demo.springcloudmovie.bean.Users;
import syr.demo.springcloudmovie.feginFallBack.UsersFeginFallBack;
import syr.demo.springcloudmovie.feginFallBack.UsersFeginFallBackFactory;

import java.util.List;


//可以配置, fallbackFactory = UsersFeginFallBackFactory.class,来指定fallback工厂，但这种方式优先级小于, fallback = UsersFeginFallBack.class
@Repository
@FeignClient( name = "spring-cloud-user-server", configuration = FeginClientConfig.class, fallback = UsersFeginFallBack.class)
public interface UsersFeginClient {

    //并不是 fegin默认形式，加入配置之后不能用
//    @RequestMapping(value = "/find", method = RequestMethod.GET)
//    public Users findUsersByusername(); //springmvc注解下使用fegin带参数用@PathValue，fegin默认注解用@Parm

    @RequestLine("GET /find/{username}")
    public Users findUsersByusername(@Param("username") String username);

    @RequestLine("GET /find-all")
    public List<Users> findAll();


}
