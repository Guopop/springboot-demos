package me.guopop.ddd.interfaces.dto;

import lombok.Data;

import java.util.List;

/**
 * @author guopop
 * @date 2021/10/25 11:23
 */
@Data
public class LeaveDTO {

    String leaveId;
    ApplicantDTO applicantDTO;
    ApproverDTO approverDTO;
    String leaveType;
    ApprovalInfoDTO currentApprovalInfoDTO;
    List<ApprovalInfoDTO> historyApprovalInfoDTOList;
    String startTime;
    String endTime;
    long duration;
    String status;
}