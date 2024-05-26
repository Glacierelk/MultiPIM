package edu.hit.multipim.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Extend {
    private Integer extendId;
    private Integer userId;
    private Integer attributeId;
    private String value;
}
