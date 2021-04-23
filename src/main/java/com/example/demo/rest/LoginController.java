package com.example.demo.rest;

import com.example.demo.dao.LoginDAO;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
public class LoginController {
    private LoginDAO loginDAO;
    @Autowired
    public LoginController(@Qualifier("loginIMPL") LoginDAO loginDAO) {
        this.loginDAO = loginDAO;
    }
    @GetMapping("retrieveAllUsers")
    public List<User> findAllUsers(){
        return loginDAO.findAllUser();
    }
    @GetMapping("retrieveUserById/{userId}")
    public User findUserById(@PathVariable int userId){
        return (User) loginDAO.findById(userId);
    }
    @PostMapping("/addUser")
    public User addUser(@RequestBody User newUser){
        newUser.setId(0);
        loginDAO.save(newUser);
        return newUser;
    }
    @PostMapping("/updateUser")
    public User updateUser(@RequestBody User updatedUser){
        loginDAO.save(updatedUser);
        return updatedUser;
    }
    @DeleteMapping("/deleteUser/{userId}")
    public String deleteUser(@PathVariable int userId){
        loginDAO.deleteUserById(userId);
        return "Deleted User Id: "+userId;
    }

}
