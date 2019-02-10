package syr.demo.springcloudmovie.feginFallBack;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import syr.demo.springcloudmovie.bean.Users;
import syr.demo.springcloudmovie.feginClient.UsersFeginClient;

import java.util.ArrayList;
import java.util.List;

@Component
public class UsersFeginFallBackFactory implements FallbackFactory<UsersFeginClient> {

    @Component
    public interface UsersFeginInterface extends UsersFeginClient{

    }

    @Override
    public UsersFeginClient create(Throwable throwable) {
        return new UsersFeginInterface() {
            @Override
            public Users findUsersByusername(String username) {
                throwable.printStackTrace();
                return new Users();
            }

            @Override
            public List<Users> findAll() {
                throwable.printStackTrace();
                return new ArrayList<>();
            }
        };
    }
}

