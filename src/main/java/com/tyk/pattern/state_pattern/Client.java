package com.tyk.pattern.state_pattern;

import java.time.LocalDate;

/**
 * @Author: tyk
 * @Date: 2020/3/23 16:41
 * @Description:
 */
public class Client {
    public static void main(String[] args) {
        LeaveRequest request = new LeaveRequest();
        request.setUser("tyk");
        request.setDateStart(LocalDate.of(2020,3,23));
        request.setLeaveDays(4);

        Context context = new Context();
        context.setRequest(request);
        context.setState(new ProjectManagerState());
        context.doWork();
    }
}
