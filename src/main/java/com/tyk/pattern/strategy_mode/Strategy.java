package com.tyk.pattern.strategy_mode;

import java.math.BigDecimal;

/**
 * @Author: tyk
 * @Date: 2020/3/13 13:22
 * @Description: 策略接口
 */
public interface Strategy {
    BigDecimal doOperation(BigDecimal number1, BigDecimal number2);
}
