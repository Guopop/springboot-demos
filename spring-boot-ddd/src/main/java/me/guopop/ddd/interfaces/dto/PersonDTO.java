package me.guopop.ddd.interfaces.dto;

import lombok.Data;

/**
 * @author guopop
 * @date 2021/10/25 11:23
 */
@Data
public class PersonDTO {

    String personId;
    String personName;
    String roleId;
    String personType;
    String createTime;
    String lastModifyTime;
    String status;
}