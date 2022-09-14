package com.example.shoponlineapi.controller;



import com.example.shoponlineapi.security.util.JwtTokenUtil;
import com.example.shoponlineapi.security.util.LoginUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class LogoutController {

    @Autowired
    private LoginUtil loginUtil;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    /**
     * @param token
     * @return
     * @author: PhuongTD
     * @date-create 15/8/2022
     */
    @ResponseBody
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/logoutSecurity/{token}")
    public ResponseEntity<?> logoutSecurity(@PathVariable String token) {
        if (token.equals("")) {
            return new ResponseEntity<>("isLogout", HttpStatus.UNAUTHORIZED);
        }
        if (this.loginUtil.getTokenMap().isEmpty()) {
            return new ResponseEntity<>("LoginExpired", HttpStatus.UNAUTHORIZED);
        }
        if (this.loginUtil.getTokenMap()
                .get(this.jwtTokenUtil.getUsernameFromToken(token)).equals(token)) {
            this.loginUtil.getTokenMap().remove(this.jwtTokenUtil.getUsernameFromToken(token));
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity<>("Logout Success", HttpStatus.OK);
    }
}
