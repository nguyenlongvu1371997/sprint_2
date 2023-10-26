package com.example.backendchillvie.controller;

import com.example.backendchillvie.config.security.JwtTokenUtil;
import com.example.backendchillvie.projection.ITicketProjection;
import com.example.backendchillvie.service.IAppUserService;
import com.example.backendchillvie.service.ITicketService;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/ticket")
public class TicketController {
    @Autowired
    private ITicketService iTicketService;

    @Autowired
    private IAppUserService iAppUserService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping("/ticket")
    public ResponseEntity<?> getTicket(@RequestBody List<Long> list, HttpServletRequest request){
        final String requestTokenHeader = request.getHeader("Authorization");
        String userName = null;
        String jwtToken = null;
        if(requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")){
            jwtToken = requestTokenHeader.substring(7);
            try{
                userName = jwtTokenUtil.getUsernameFromToken(jwtToken);
            }catch (IllegalArgumentException | ExpiredJwtException e){
                return new ResponseEntity<>("notFound", HttpStatus.OK);
            }
        }else {
            return new ResponseEntity<>("notFound", HttpStatus.OK);
        }
        Optional<Long> id = iAppUserService.getIdUserByUserName(userName);
        if(id.isPresent()){
            Boolean check = iTicketService.getTicket(list,id.get());
            if(check){
                return new ResponseEntity<>("ok", HttpStatus.OK);
            }
            return new ResponseEntity<>("not", HttpStatus.OK);
        }
        return new ResponseEntity<>("notFound", HttpStatus.OK);
    }

    @PostMapping("/check-ticket")
    public ResponseEntity<?> checkTicket(@RequestBody List<Long> list, HttpServletRequest request){
        final String requestTokenHeader = request.getHeader("Authorization");
        String userName = null;
        String jwtToken = null;
        if(requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")){
            jwtToken = requestTokenHeader.substring(7);
            try{
                userName = jwtTokenUtil.getUsernameFromToken(jwtToken);
            }catch (IllegalArgumentException | ExpiredJwtException e){
                return new ResponseEntity<>("notFound", HttpStatus.OK);
            }
        }else {
            return new ResponseEntity<>("notFound", HttpStatus.OK);
        }
        Optional<Long> id = iAppUserService.getIdUserByUserName(userName);
        if(id.isPresent()){
            Boolean check = iTicketService.checkTicket(list,id.get());
            if(check){
                return new ResponseEntity<>("ok", HttpStatus.OK);
            }
            return new ResponseEntity<>("not", HttpStatus.OK);
        }
        return new ResponseEntity<>("notFound", HttpStatus.OK);
    }



    @GetMapping("/history-ticket")
    public ResponseEntity<?> getHistoryTicket(HttpServletRequest request){
        final String requestTokenHeader = request.getHeader("Authorization");
        String userName = null;
        String jwtToken = null;
        if(requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")){
            jwtToken = requestTokenHeader.substring(7);
            try{
                userName = jwtTokenUtil.getUsernameFromToken(jwtToken);
            }catch (IllegalArgumentException | ExpiredJwtException e){
                return new ResponseEntity<>("notFound", HttpStatus.OK);
            }
        }else {
            return new ResponseEntity<>("notFound", HttpStatus.OK);
        }
        Optional<Long> id = iAppUserService.getIdUserByUserName(userName);
        if(id.isPresent()){
           List<ITicketProjection> list = iTicketService.getListTicketByCustomerId(id.get());
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
        return new ResponseEntity<>("notFound", HttpStatus.OK);
    }

}
