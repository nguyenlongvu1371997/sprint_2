package com.example.backendchillvie.controller;

import com.example.backendchillvie.config.security.JwtTokenUtil;
import com.example.backendchillvie.model.AppUser;
import com.example.backendchillvie.projection.UserProjection;
import com.example.backendchillvie.service.IAppUserService;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/user")
public class AppUserController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private IAppUserService iAppUserService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    private static final String LOGIN_FAILED = "Đăng nhập thất bại";

    @PostMapping("/login-by-user")
    public ResponseEntity<?> loginByUser(@Valid @RequestBody UserProjection userProjection,
                                         BindingResult bindingResult) {
        System.out.println(userProjection.getUsername());
        System.out.println(userProjection.getPassword());
        new UserProjection().validate(userProjection, bindingResult);
        if (bindingResult.hasErrors()) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(LOGIN_FAILED);
        }
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    userProjection.getUsername(), userProjection.getPassword()));
        } catch (DisabledException e) {
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .body("Tài khoản của bạn đã bị vô hiệu hoá");
        } catch (BadCredentialsException e) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(LOGIN_FAILED);
        }
        AppUser appUser = new AppUser();
//        BeanUtils.copyProperties(userProjection, appUser);
        appUser.setName(userProjection.getUsername());
        appUser.setPasswordUser(userProjection.getPassword());
        UserDetails userDetails = iAppUserService.loadUserByUsername(appUser.getName());
        String jwtToken = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(jwtToken);
    }
    @PostMapping("/user-name")
    public ResponseEntity<String> getNameUserByJwt(HttpServletRequest request){
        final String requestTokenHeader = request.getHeader("Authorization");
        String userName = null;
        String jwtToken = null;
        if(requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")){
            jwtToken = requestTokenHeader.substring(7);
            try{
                userName = jwtTokenUtil.getUsernameFromToken(jwtToken);
            }catch (IllegalArgumentException | ExpiredJwtException e){
               return new ResponseEntity<>("notFound",HttpStatus.OK);
            }
        }else {
            return new ResponseEntity<>("notFound",HttpStatus.OK);
        }
        return new ResponseEntity<>(userName,HttpStatus.OK);
    }

    @PostMapping("/id-user")
    public ResponseEntity<Long> getIdUserByUserName(@RequestParam("name")String name){
        Optional<Long> id = iAppUserService.getIdUserByUserName(name);
        if(id.isPresent()){
            return ResponseEntity.ok(id.get());
        }
        return ResponseEntity.ok(null);
    }
}
