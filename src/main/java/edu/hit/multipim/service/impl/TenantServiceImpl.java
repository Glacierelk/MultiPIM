package edu.hit.multipim.service.impl;

import edu.hit.multipim.entity.Pagination;
import edu.hit.multipim.entity.Tenant;
import edu.hit.multipim.mapper.TenantMapper;
import edu.hit.multipim.service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TenantServiceImpl implements TenantService {
    private final TenantMapper tenantMapper;

    @Autowired
    public TenantServiceImpl(TenantMapper tenantMapper) {
        this.tenantMapper = tenantMapper;
    }

    @Override
    public boolean addTenant(Tenant tenant) {
        return tenantMapper.addTenant(tenant);
    }

    @Override
    public boolean deleteTenant(int tenantId) {
        return tenantMapper.deleteTenantById(tenantId);
    }

    @Override
    public boolean updateTenant(Tenant tenant) {
        return tenantMapper.updateTenantPasswordById(tenant.getTenantId(), tenant.getTenantPassword());
    }

    @Override
    public Tenant findTenantByName(String tenantName) {
        return tenantMapper.getTenantByUsername(tenantName);
    }

    @Override
    public String login(Tenant tenant) {
        Tenant tenant1 = tenantMapper.getTenantByUsername(tenant.getTenantUsername());
        if (tenant1 != null && tenant1.getTenantPassword().equals(tenant.getTenantPassword())) {
            return "token";
        }
        return "";
    }

    @Override
    public Pagination getAllTenants(Integer currentPage, Integer pageSize) {
        Pagination pagination = new Pagination();
        pagination.setTotal(tenantMapper.getTenantCount());
        pagination.setCurrentPage(currentPage);
        pagination.setPageSize(pageSize);
        pagination.setData(tenantMapper.getAllTenants((currentPage - 1) * pageSize, pageSize));
        return pagination;
    }
}
