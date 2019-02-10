package syr.demo.springcloudmovie.api;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import syr.demo.springcloudmovie.bean.Users;
import syr.demo.springcloudmovie.feginClient.UsersFeginClient;

import java.util.Arrays;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;


    //restTemplate请求的对象返回list时，要用数组接收，比如  Users[].class
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UsersFeginClient usersFeginClient;


    @HystrixCommand(fallbackMethod = "fallBack")
//    当报出cannot find the scoped context异常时配置使hystrix的线程为SEMAPHORE（使用信号量），即使hystrix运行在当前线程， 也可以使用hystrix.shareSecurityContext＝true配置
//    @HystrixCommand(fallbackMethod = "fallBack" , commandProperties = @HystrixProperty(name = "execution.isolation.strategy", value = "SEMAPHORE"))
    @GetMapping("/")
    public List<Users> find(){
        Users[] users = restTemplate.getForObject("http://spring-cloud-user-server/find-all", Users[].class);
        List<Users> list = Arrays.asList(users);
        System.out.println(list.get(0).getUsername() + "------------------");
        return list;
    }

    public List<Users> fallBack(Throwable cause){
        System.out.print("--------------" );
        cause.printStackTrace();
        return null;
    }


//
//    @GetMapping("/test")
//    public String test(){
//        ServiceInstance serviceInstance = this.loadBalancerClient.choose("spring-cloud-user-server");
//        System.out.println("----------------------- 111:  " + serviceInstance.getHost() + ":" + serviceInstance.getPort());
//
////        ServiceInstance serviceInstance2 = this.loadBalancerClient.choose("spring-cloud-user-server2");
////        System.out.println("----------------------- 222:  " + serviceInstance2.getHost() + ":" + serviceInstance2.getPort());
//        return "OK";
//    }

    @GetMapping("/find/{username}")
    public Users findUser(@PathVariable("username") String username){
        return usersFeginClient.findUsersByusername(username);
    }

    @GetMapping("/find-all")
    public List<Users> findAllUsers(){
        return this.usersFeginClient.findAll();
    }



}
