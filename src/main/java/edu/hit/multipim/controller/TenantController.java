package edu.hit.multipim.controller;

import edu.hit.multipim.entity.Pagination;
import edu.hit.multipim.entity.Tenant;
import edu.hit.multipim.service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/tenant")
@RestController
@CrossOrigin
public class TenantController {
    private final TenantService tenantService;

    @Autowired
    public TenantController(TenantService tenantService) {
        this.tenantService = tenantService;
    }

    /**
     * 租户登录
     * @param tenant 租户信息
     * @return token
     */
    @PostMapping("/login")
    public String login(Tenant tenant) {
        return tenantService.login(tenant);
    }

    /**
     * 增加租户
     * @param tenant 租户信息
     * @return 是否增加成功
     */
    @PostMapping("/add")
    public boolean addTenant(Tenant tenant) {
        return tenantService.addTenant(tenant);
    }

    /**
     * 删除租户
     * @param tenantId 租户ID
     * @return 是否删除成功
     */
    @DeleteMapping("/delete/{tenantId}")
    public boolean deleteTenant(@PathVariable Integer tenantId) {
        return tenantService.deleteTenant(tenantId);
    }

    /**
     * 查询所有租户
     * @return 所有租户信息
     */
    @GetMapping("/all/{currentPage}/{pageSize}")
    public Pagination findAllTenant(@PathVariable Integer currentPage, @PathVariable Integer pageSize) {
        return tenantService.getAllTenants(currentPage, pageSize);
    }
}
