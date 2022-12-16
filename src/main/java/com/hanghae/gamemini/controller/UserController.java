package com.hanghae.gamemini.controller;

import com.hanghae.gamemini.dto.PrivateResponseBody;
import com.hanghae.gamemini.errorcode.CommonStatusCode;
import com.hanghae.gamemini.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hanghae.gamemini.dto.LoginRequestDto;
import com.hanghae.gamemini.dto.SignupRequestDto;
import com.hanghae.gamemini.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequestMapping ("/api/user")
@RequiredArgsConstructor
public class UserController {
     
     //     private final UserService userService;
     private final PasswordEncoder passwordEncoder;
     private final UserRepository userRepository;
     private final UserService userService;
     
     //ResponseEntity 사용 예시
     
     @PostMapping ("/signup")
     public ResponseEntity<PrivateResponseBody> signup(@RequestBody @Valid SignupRequestDto requestDto) {
          PrivateResponseBody privateResponseBody = new PrivateResponseBody();
          return new ResponseEntity<>(new PrivateResponseBody(CommonStatusCode.OK, userService.signUp(requestDto)), HttpStatus.OK);
     }
     
     
     
     // AuthenticationPrincipal 사용예시
     /*
     @PostMapping("/login")
     public String login(@AuthenticationPrincipal UserDetails userDetails)
      */
     
     
     @PostMapping ("/login")
     public ResponseDto login(@RequestBody LoginRequestDto loginRequestDto, HttpServletResponse response) {
          return userService.login(loginRequestDto, response);
          
     }
}
