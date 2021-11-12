package me.guopop.ddd.interfaces.dto;

import lombok.Data;

/**
 * @author guopop
 * @date 2021/10/25 11:22
 */
@Data
public class ApplicantDTO {

    String personId;
    String personName;
    String leaderId;
    String applicantType;
    String roleLevel;
}