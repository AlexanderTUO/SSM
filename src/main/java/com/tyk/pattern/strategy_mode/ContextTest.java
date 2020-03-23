package com.tyk.pattern.strategy_mode;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.Assert.*;

/**
 * @Author: tyk
 * @Date: 2020/3/13 13:33
 * @Description:
 */
public class ContextTest {

    @Test
    public void executeOperation() {
        Context context = new Context(new OperationAdd());
        BigDecimal result = context.executeOperation(new BigDecimal(1),new BigDecimal(2));
        assertEquals(new BigDecimal(3),result);

        Context context1 = new Context(new OperationMultiply());
        BigDecimal result1 = context1.executeOperation(new BigDecimal(2.5), new BigDecimal(3));
        assertEquals(new BigDecimal(7.5), result1);
    }
}