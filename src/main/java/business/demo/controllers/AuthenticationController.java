package business.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import business.demo.entities.User;
import business.demo.services.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {
  private final UserService userService;
  
  @PostMapping("/register")
  public ResponseEntity<?> registerUser (@RequestBody User user) {
      userService.registerUser(user);
      return ResponseEntity.ok("User Successfully registered");
  }
  
}
