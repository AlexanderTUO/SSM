package com.tyk.mode.proxy_mode.jdkdynamicproxy;

import com.tyk.annotation.CustomTransactional;

public interface Subject {
    @CustomTransactional(id=1,propagation = "REQUIRED")
    public void doSomething();
    @CustomTransactional(id=1,propagation = "REQUIRED")
    public void doSomething2();
}
