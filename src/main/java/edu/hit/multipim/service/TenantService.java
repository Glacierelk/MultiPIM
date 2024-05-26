package edu.hit.multipim.service;

import edu.hit.multipim.entity.Pagination;
import edu.hit.multipim.entity.Tenant;

public interface TenantService {
    /**
     * 增加租户
     * @param tenant 租户信息
     * @return 是否增加成功
     */
    boolean addTenant(Tenant tenant);

    /**
     * 删除租户
     * @param tenantId 租户ID
     * @return 是否删除成功
     */
    boolean deleteTenant(int tenantId);

    /**
     * 更新租户信息
     * @param tenant 租户信息
     * @return 是否更新成功
     */
    boolean updateTenant(Tenant tenant);

    /**
     * 根据租户用户名查找租户
     * @param tenantName 租户用户名
     * @return 租户信息
     */
    Tenant findTenantByName(String tenantName);

    /**
     * 租户登录
     * @param tenant 租户信息
     * @return token
     */
    String login(Tenant tenant);

    /**
     * 查询所有租户
     * @return 所有租户信息
     */
    Pagination getAllTenants(Integer currentPage, Integer pageSize);
}
