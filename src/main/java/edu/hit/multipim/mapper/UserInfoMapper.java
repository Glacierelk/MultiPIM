package edu.hit.multipim.mapper;

import edu.hit.multipim.entity.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserInfoMapper {
    /**
     * 新增用户信息
     * @param userInfo 用户信息
     * @return boolean 是否新增成功
     */
    @Insert("INSERT INTO userinfo (name, sex, phone, email, user_id) VALUES (#{name}, #{sex}, #{phone}, #{email}, #{userId})")
    boolean insertUserInfo(UserInfo userInfo);

    /**
     * 根据用户ID查询用户信息
     * @param userId 用户ID
     * @return UserInfo 用户信息
     */
    @Select("SELECT * FROM userinfo WHERE user_id = #{userId}")
    UserInfo selectUserInfoByUserId(Integer userId);

    /**
     * 根据用户ID删除用户信息
     * @param userId 用户ID
     * @return boolean 是否删除成功
     */
    @Select("DELETE FROM userinfo WHERE user_id = #{userId}")
    boolean deleteUserInfoByUserId(Integer userId);

    /**
     * 根据用户ID修改用户信息
     * @param newUserInfo 新用户信息
     * @return boolean 是否修改成功
     */
    @Update("UPDATE userinfo SET name = #{name}, sex = #{sex}, phone = #{phone}, email = #{email} WHERE user_id = #{userId}")
    boolean updateUserInfoByUserId(UserInfo newUserInfo);
}
