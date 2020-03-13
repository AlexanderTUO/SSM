package com.tyk.design_mode.strategy_mode;

import java.math.BigDecimal;

/**
 * @Author: tyk
 * @Date: 2020/3/13 13:26
 * @Description:乘法
 */
public class OperationMultiply implements Strategy{
    @Override
    public BigDecimal doOperation(BigDecimal number1, BigDecimal number2) {
        return number1.multiply(number2);
    }
}
