package com.tyk.pattern.proxy_pattern.jdkdynamicproxy;

import com.tyk.annotation.CustomTransactional;

public interface Subject {
    @CustomTransactional(id=1,propagation = "REQUIRED")
    public void doSomething();
    @CustomTransactional(id=1,propagation = "REQUIRED")
    public void doSomething2();
}
