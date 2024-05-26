package edu.hit.multipim.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {
    private Integer infoId;
    private Integer userId;
    private String name;
    private String email;
    private String phone;
    private String sex;
}
