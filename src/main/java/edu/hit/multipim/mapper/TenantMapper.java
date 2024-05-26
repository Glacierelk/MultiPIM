package edu.hit.multipim.mapper;

import edu.hit.multipim.entity.Tenant;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TenantMapper {
    /**
     * 增加租户
     *
     * @param tenant 租户信息
     * @return 是否增加成功
     */
    @Insert("INSERT INTO tenant (username, password) VALUES (#{tenantUsername}, #{tenantPassword})")
    boolean addTenant(Tenant tenant);

    /**
     * 根据用户名查询租户
     *
     * @param username 用户名
     * @return 租户信息
     */
    @Select("SELECT * FROM tenant WHERE username = #{tenantUsername}")
    Tenant getTenantByUsername(String username);

    /**
     * 根据租户ID查询租户
     *
     * @param tenantId 租户ID
     * @return 租户信息
     */
    @Select("SELECT * FROM tenant WHERE id = #{tenantId}")
    Tenant getTenantById(Integer tenantId);

    /**
     * 根据租户ID删除租户
     * @param tenantId 租户ID
     * @return 是否删除成功
     */
    @Delete("DELETE FROM tenant WHERE id = #{tenantId}")
    boolean deleteTenantById(Integer tenantId);

    /**
     * 根据租户ID修改租户密码
     * @param tenantId 租户ID
     * @param newPassword 新密码
     * @return 是否修改成功
     */
    @Update("UPDATE tenant SET password = #{newPassword} WHERE id = #{tenantId}")
    boolean updateTenantPasswordById(Integer tenantId, String newPassword);

    /**
     * 获取租户总数
     * @return 租户总数
     */
    @Select("SELECT COUNT(*) FROM tenant")
    Integer getTenantCount();

    /**
     * 分页查询租户
     * @param offset 偏移量
     * @param pageSize 每页大小
     * @return 租户列表
     */
    @Select("SELECT * FROM tenant LIMIT #{offset}, #{pageSize}")
    List<Tenant> getAllTenants(Integer offset, Integer pageSize);
}
