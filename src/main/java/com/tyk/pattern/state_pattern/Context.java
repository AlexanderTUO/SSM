package com.tyk.pattern.state_pattern;

import lombok.Data;

/**
 * @Author: tyk
 * @Date: 2020/3/23 15:30
 * @Description:
 */
@Data
public class Context {
    private State state;
    private LeaveRequest request;

    public void doWork() {
        state.doWork(this);
    }
}
