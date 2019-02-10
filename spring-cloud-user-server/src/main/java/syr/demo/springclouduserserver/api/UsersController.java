package syr.demo.springclouduserserver.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import syr.demo.springclouduserserver.bean.Users;
import syr.demo.springclouduserserver.dao.UsersRepository;

import java.util.List;

@RestController
public class UsersController {

    @Autowired
    private UsersRepository usersRepository;

    @GetMapping("/find/{username}")
    public Object findUsersByusername(@PathVariable("username") String username){
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//            return "延时失败";
//        }
        return usersRepository.findByUserName(username);
    }

    @GetMapping("find-all")
    public List<Users> findAllUsers(){
        return this.usersRepository.findAll();
    }
}
