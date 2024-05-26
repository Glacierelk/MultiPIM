package edu.hit.multipim.service.impl;

import cn.hutool.jwt.JWT;
import edu.hit.multipim.config.JwtConfig;
import edu.hit.multipim.entity.Pagination;
import edu.hit.multipim.entity.User;
import edu.hit.multipim.mapper.UserMapper;
import edu.hit.multipim.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;
//    private final AuthenticationManager authenticationManager;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public boolean createUser(User user) {
        return userMapper.insertUser(user);
    }

    @Override
    public String login(User user) {
        User user1 = userMapper.selectUserByUsername(user.getUsername());
        if (user1 != null && user1.getPassword().equals(user.getPassword())) {
//            try {
//                UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user1.getUsername(), user1.getPassword());
//                authenticationManager.authenticate(token);
//            } catch (Exception e) {
//                return "";
//            }
//
//            JwtConfig jwtConfig = JwtConfig.getInstance();
//
//            return JWT.create()
//                    .setPayload("userId", user1.getUserId())
//                    .setKey(jwtConfig.getJWT_SIGN_KEY().getBytes(StandardCharsets.UTF_8))
//                    .sign();
            return "token";
        }
        return "";
    }

    @Override
    public boolean deleteUser(Integer userId) {
        return userMapper.deleteUserByUserId(userId);
    }

    @Override
    public Pagination getAllUsers(String username, Integer currentPage, Integer pageSize) {
        if (username.equals("null")) {
            username = null;
        }

        Pagination pagination = new Pagination();
        pagination.setCurrentPage(currentPage);
        pagination.setPageSize(pageSize);
        pagination.setTotal(userMapper.selectUserCount());
        pagination.setData(userMapper.selectUsers(username, (currentPage - 1) * pageSize, pageSize));
        return pagination;
    }
}
