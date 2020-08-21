package cn.zlb.biz.expression;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;

/**
 * 表达式计算
 *
 * @author libao.zheng
 * @date 2020/7/23 4:59 下午
 */
public class ExpressionDemo {
    public static void main(String[] args) {
        String expression = "(a <= 1 || b >= 10) && c == 0 && d < 60";
        Expression compiledExp = AviatorEvaluator.compile(expression);
        Boolean result = (Boolean) compiledExp.execute(compiledExp.newEnv("a", 10, "b", 9, "c", 0, "d", 10));
      // System.out.println(result);
    }
}
