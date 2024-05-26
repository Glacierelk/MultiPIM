package edu.hit.multipim.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExtendMeta {
    private Integer attributeId;
    private String attributeName;
    private Integer attributeType; // 0: int, 1: string
}
