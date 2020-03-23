package com.tyk.pattern.state_pattern;

/**
 * @Author: tyk
 * @Date: 2020/3/23 15:35
 * @Description:
 */
public class AuditOverState implements State {

    @Override
    public void doWork(Context context) {
        LeaveRequest request = context.getRequest();
        System.out.println(request.getUser()+"流程已经结束，结果为："+request.getResult());
    }
}
