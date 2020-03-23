package com.tyk.pattern.state_pattern;

import java.util.Scanner;

/**
 * @Author: tyk
 * @Date: 2020/3/23 15:35
 * @Description:
 */
public class DeptManagerState implements State {
    @Override
    public void doWork(Context context) {
        LeaveRequest request = context.getRequest();
        System.out.println(request.getUser()+"申请从"+request.getDateStart()+"开始请假"+request.getLeaveDays()+"天");
        System.out.println("部门经理审批，同意/不同意：1/0");
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            int a = scanner.nextInt();
            String sug = "不同意";
            if (a == 1) {
                sug = "同意";
            }
            // 保存到数据库
            request.setResult("部门经理审批："+sug);

            if (a == 1) {
                context.setState(new AuditOverState());
                context.doWork();
            } else {
                context.setState(new RequestAdjustState());
                context.doWork();
            }
            scanner.close();
        }

    }
}
