package com.tyk.pattern.state_pattern;

import java.util.Scanner;

/**
 * @Author: tyk
 * @Date: 2020/3/23 15:35
 * @Description:
 */
public class ProjectManagerState implements State {
    @Override
    public void doWork(Context context) {
        LeaveRequest request = context.getRequest();
        System.out.println("等待项目经理审批中。。。。。");
        System.out.println(request.getUser()+"申请从"+request.getDateStart()+"开始请假"+request.getLeaveDays()+"天");
        System.out.println("项目经理审批，同意/不同意：1/0");
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            int a = scanner.nextInt();
            String sug = "不同意";
            if (a == 1) {
                sug = "同意";
            }
            // 保存到数据库
            request.setResult("项目经理审批："+sug);

            if (a == 1) {
                if (request.getLeaveDays() <= 3) {
                    // 小于3天，项目经理同意后结束
                    context.setState(new AuditOverState());
                    context.doWork();
                } else {
                    // 大于3天，转入部门经理审批
                    context.setState(new DeptManagerState());
                    context.doWork();
                }
            } else {
                // 拒绝后调整申请
                context.setState(new RequestAdjustState());
                context.doWork();
            }
            scanner.close();
        }


    }
}
