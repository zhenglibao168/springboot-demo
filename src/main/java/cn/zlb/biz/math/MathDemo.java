package cn.zlb.biz.math;

import java.math.BigDecimal;
import java.math.MathContext;

/**
 * @author libao.zheng
 * @date 2020/12/23 7:27 下午
 */
public class MathDemo {
    public static void main(String[] args) {
        // 加法
        BigDecimal a = BigDecimal.valueOf(1);
        BigDecimal b = BigDecimal.valueOf(1.5);
        BigDecimal c = BigDecimal.valueOf(1.4);

        BigDecimal addResult = a.add(b);
        BigDecimal addResult1 = a.add(b, new MathContext(2));
        BigDecimal addResult2 = a.add(b, new MathContext(1));
        BigDecimal addResult3 = a.add(c, new MathContext(1));

        System.out.println("addResult: " + addResult);
        System.out.println("addResult1: " + addResult1);
        System.out.println("addResult2: " + addResult2);
        System.out.println("addResult3: " + addResult3);

        // 减法
        BigDecimal d = BigDecimal.valueOf(1);
        BigDecimal e = BigDecimal.valueOf(1.5);
        BigDecimal f = BigDecimal.valueOf(1.4);

        BigDecimal subtract = d.subtract(e);
        BigDecimal subtract1 = d.subtract(e, new MathContext(2));
        BigDecimal subtract2 = d.subtract(e, new MathContext(1));
        BigDecimal subtract3 = d.subtract(f, new MathContext(1));

        System.out.println("subtract: " + subtract);
        System.out.println("subtract1: " + subtract1);
        System.out.println("subtract2: " + subtract2);
        System.out.println("subtract3: " + subtract3);

        // 乘法

        BigDecimal g = BigDecimal.valueOf(1);
        BigDecimal h = BigDecimal.valueOf(1.5);
        BigDecimal i = BigDecimal.valueOf(1.4);

        BigDecimal multiply = g.multiply(h);
        BigDecimal multiply1 = g.multiply(h, new MathContext(2));
        BigDecimal multiply2 = g.multiply(h, new MathContext(1));
        BigDecimal multiply3 = g.multiply(i, new MathContext(1));

        System.out.println("multiply: " + multiply);
        System.out.println("multiply1: " + multiply1);
        System.out.println("multiply2: " + multiply2);
        System.out.println("multiply3: " + multiply3);

        // 除法
        BigDecimal divide = a.divide(b, 2, BigDecimal.ROUND_HALF_UP);
        System.out.println("divide: " + divide);
    }
}
