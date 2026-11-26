package com.hr_user.hr_user.resources;

import com.hr_user.hr_user.entity.User;
import com.hr_user.hr_user.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserResource {

    @Autowired
    private UserServices userServices;

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        User user = userServices.findById(id);
        return ResponseEntity.ok().body(user);
    }
}
