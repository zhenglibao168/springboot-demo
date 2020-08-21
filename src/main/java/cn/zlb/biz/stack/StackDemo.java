package cn.zlb.biz.stack;

import java.util.ArrayDeque;
import java.util.Stack;

/**
 * 栈
 * 后进先出
 *
 * @author libao.zheng
 * @date 2020/7/22 11:00 上午
 */
public class StackDemo {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
      // System.out.println(stack.pop());//返回2
      // System.out.println(stack.pop());//返回1

        //ArrayDeque性能高于Stack
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        arrayDeque.push(1);
        arrayDeque.push(2);
      // System.out.println(arrayDeque.poll());//返回2
      // System.out.println(arrayDeque.poll());//返回1
    }
}
