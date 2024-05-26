package edu.hit.multipim.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tenant {
    private Integer tenantId;
    private String tenantUsername;
    private String tenantPassword;
}
