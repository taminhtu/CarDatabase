/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.cardatabase.service;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;

import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import static java.util.Collections.emptyList;


/**
 *
 * @author tutm
 */
public class AuthenticationService {
    static final long EXPIRATION_TIME = 864_000_00; // 1 day in milisecon
    static final String SIGNINGKEY = "SecretKey";
    static final String PREFIX = "Bearer";
    
    // Add token to Authorization header
    static public void addToken(HttpServletResponse res, String userName) {
        String jwtToken = Jwts.builder().setSubject(userName).setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SIGNINGKEY).compact();
        res.addHeader("Authorization", PREFIX + " " + jwtToken);
        res.addHeader("Access-Control-Expose-Headers", "Authorization");
    }
    
    // Get token from Authorization header
    static public Authentication getAuthentication(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        
        if (token != null) {
            String user = Jwts.parser()
                    .setSigningKey(SIGNINGKEY)
                    .parseClaimsJws(token.replace(PREFIX, ""))
                    .getBody()
                    .getSubject();
            
            if (user != null) {
                System.out.println("getAuthentication, user: " + user);
                return new UsernamePasswordAuthenticationToken(user, null, emptyList());
            }
        }
        return null;
    }
    
    public static void main(String[] args) {
        System.out.println(EXPIRATION_TIME);
    }
    
}
