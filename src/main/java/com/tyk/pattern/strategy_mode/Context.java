package com.tyk.pattern.strategy_mode;

import java.math.BigDecimal;

/**
 * @Author: tyk
 * @Date: 2020/3/13 13:26
 * @Description:
 */
public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public BigDecimal executeOperation(BigDecimal num1, BigDecimal num2) {
        return strategy.doOperation(num1, num2);
    }
}
