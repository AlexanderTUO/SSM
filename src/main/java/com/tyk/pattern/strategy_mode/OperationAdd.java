package com.tyk.pattern.strategy_mode;

import java.math.BigDecimal;

/**
 * @Author: tyk
 * @Date: 2020/3/13 13:23
 * @Description: 加法
 */
public class OperationAdd implements Strategy{
    @Override
    public BigDecimal doOperation(BigDecimal number1, BigDecimal number2) {
        return number1.add(number2);
    }
}
