package com.hems.springbackend.Controller;

import com.hems.springbackend.Model.User;
import com.hems.springbackend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@ComponentScan(basePackages = {"com.hems"})
@RequestMapping("/userService")
public class userController {
    @Autowired
    UserService service;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/saveData")
    public void postData(@RequestBody User user){
        service.saveService(user);
    }

        @PostMapping("/authenticate")
        public String authenticate(@RequestParam("username") String username,
                                   @RequestParam("password") String password,
                                   HttpServletRequest request) {
            try {
                Authentication authentication = authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(username, password)
                );
                SecurityContextHolder.getContext().setAuthentication(authentication);
                return "redirect:/home";
            } catch (AuthenticationException e) {
                // Handle authentication failure
                return "redirect:/login?error";
            }
        }
}
