package syr.demo.springcloudmovie.feginFallBack;

import org.springframework.stereotype.Component;
import syr.demo.springcloudmovie.bean.Users;
import syr.demo.springcloudmovie.feginClient.UsersFeginClient;

import java.util.List;


@Component
public class UsersFeginFallBack implements UsersFeginClient {

    @Override
    public Users findUsersByusername(String username) {
        return null;
    }

    @Override
    public List<Users> findAll() {
        return null;
    }
}
