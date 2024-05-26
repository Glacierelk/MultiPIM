package edu.hit.multipim.mapper;

import edu.hit.multipim.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    /**
     * 新增用户
     * @param user 用户信息
     * @return boolean 是否新增成功
     */
    @Insert("insert into user (username, password) values (#{username}, #{password})")
    boolean insertUser(User user);

    /**
     * 根据用户名查询用户
     * @param username 用户名
     * @return User 用户信息
     */
    @Select("select * from user where username = #{username}")
    User selectUserByUsername(String username);

    /**
     * 根据用户ID查询用户
     * @param userId 用户ID
     * @return User 用户信息
     */
    @Select("select * from user where id = #{userId}")
    User selectUserByUserId(Integer userId);

    /**
     * 根据用户ID删除用户
     * @param userId 用户ID
     * @return boolean 是否删除成功
     */
    @Delete("delete from user where id = #{userId}")
    boolean deleteUserByUserId(Integer userId);

    /**
     * 根据用户ID修改用户密码
     * @param userId 用户ID
     * @param newPassword 新密码
     * @return boolean 是否修改成功
     */
    @Update("update user set password = #{newPassword} where id = #{userId}")
    boolean updateUserPasswordByUserId(Integer userId, String newPassword);

    /**
     * 查询用户数量
     * @return int 用户数量
     */
    @Select("select count(*) from user")
    int selectUserCount();

    /**
     * 查询用户
     * @param username 用户名
     * @param offset 偏移量
     * @param limit 限制量
     * @return List<User> 用户信息
     */
    List<User> selectUsers(@Param("username") String username,
                           @Param("offset") Integer offset,
                           @Param("limit") Integer limit);
}
