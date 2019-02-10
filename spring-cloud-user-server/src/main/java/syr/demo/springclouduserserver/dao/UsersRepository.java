package syr.demo.springclouduserserver.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import syr.demo.springclouduserserver.bean.Users;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {

    @Query("select u from Users u where username=:username")
    public Users findByUserName(@Param("username") String username);

    public List<Users> findAll();

}
