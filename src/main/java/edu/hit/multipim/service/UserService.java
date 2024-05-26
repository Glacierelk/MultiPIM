package edu.hit.multipim.service;

import edu.hit.multipim.entity.Pagination;
import edu.hit.multipim.entity.User;

public interface UserService {
    /**
     * 创建用户
     * @param user 用户信息
     * @return 是否创建成功
     */
    boolean createUser(User user);

    /**
     * 用户登录
     * @param user 用户信息
     * @return token
     */
    String login(User user);

    /**
     * 删除用户
     * @param userId 用户ID
     * @return 是否删除成功
     */
    boolean deleteUser(Integer userId);

    /**
     * 根据租户ID查询用户
     * @param username 用户名
     * @param currentPage 当前页
     * @param pageSize 每页大小
     * @return 用户信息
     */
    Pagination getAllUsers(String username, Integer currentPage, Integer pageSize);
}
