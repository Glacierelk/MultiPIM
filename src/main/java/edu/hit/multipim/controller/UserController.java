package edu.hit.multipim.controller;

import edu.hit.multipim.entity.Pagination;
import edu.hit.multipim.entity.User;
import edu.hit.multipim.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 创建用户
     *
     * @param user 用户信息
     * @return 是否创建成功
     */
    @PostMapping("/create")
    public boolean createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    /**
     * 用户登录
     *
     * @param user 用户信息
     * @return token
     */
    @PostMapping("/login")
    public String login(@RequestBody User user) {
        return userService.login(user);
    }

    /**
     * 删除用户
     *
     * @param userId 用户ID
     * @return 是否删除成功
     */
    @DeleteMapping("/delete/{userId}")
    public boolean deleteUser(@PathVariable Integer userId) {
        return userService.deleteUser(userId);
    }

    /**
     * 根据租户ID查询用户
     *
     * @param currentPage 当前页
     * @param pageSize    每页大小
     * @return 用户信息
     */
    @GetMapping("/list/{name}/{currentPage}/{pageSize}")
    public Pagination findAllUser(@PathVariable String name, @PathVariable Integer currentPage, @PathVariable Integer pageSize) {
        return userService.getAllUsers(name, currentPage, pageSize);
    }
}
