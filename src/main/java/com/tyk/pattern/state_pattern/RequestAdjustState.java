package com.tyk.pattern.state_pattern;

/**
 * @Author: tyk
 * @Date: 2020/3/23 16:32
 * @Description:
 */
public class RequestAdjustState implements State {
    @Override
    public void doWork(Context context) {
        LeaveRequest request = context.getRequest();
        System.out.println(request.getUser()+"请调整申请");
    }
}
