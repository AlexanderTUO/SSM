package com.tyk.pattern.state_pattern;

import lombok.Data;

import java.time.LocalDate;

/**
 * @Author: tyk
 * @Date: 2020/3/23 15:31
 * @Description:
 */
@Data
public class LeaveRequest {
    private String user;
    private LocalDate dateStart;
    private Integer leaveDays;
    private String result;
}
