package com.example.demo.manage;

import com.example.demo.User;
import com.example.demo.role.Role;
import com.example.demo.dto.auth.LoginAuth;
import com.example.demo.dto.auth.NewUserAuth;
import com.example.demo.privacy.ServicePrivacy;
import com.example.demo.dto.auth.Authentication;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;


@Service
public class AuthManage {
    @Autowired
    private UserData userm;

    @Autowired
    private ServicePrivacy ServicePrivacy;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    public Authentication login(final LoginAuth request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUser(), request.getPass()));
        UserDetails user = userm.findByEmail(request.getUser()).orElseThrow();
        String token = ServicePrivacy.getToken(user);
        return new Authentication(token);
    }

    public Authentication register(final NewUserAuth request) {
        User user = new User();
        user.setName(request.getUser());
        user.setPassword(passwordEncoder.encode(request.getPass()));
        user.setRole(Role.USER);

        userm.save(user);
        return new Authentication(this.ServicePrivacy.getToken(user));
    }
}
