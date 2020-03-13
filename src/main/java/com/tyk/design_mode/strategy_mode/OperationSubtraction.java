package com.tyk.design_mode.strategy_mode;

import java.math.BigDecimal;

/**
 * @Author: tyk
 * @Date: 2020/3/13 13:24
 * @Description:
 */
public class OperationSubtraction implements Strategy {
    @Override
    public BigDecimal doOperation(BigDecimal number1, BigDecimal number2) {
        return number1.subtract(number2);
    }
}
