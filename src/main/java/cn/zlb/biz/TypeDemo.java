package cn.zlb.biz;

import org.springframework.core.ResolvableType;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * java类型
 *
 * @author libao.zheng
 * @date 2020/8/1 4:15 下午
 */
public class TypeDemo {
    private HashMap<Integer, List<String>> myMap;
    private ArrayList<String> list;

    public static void main(String[] args) throws NoSuchFieldException {
        //基本类型，byte short int long  double float char boolean
        Class<Integer> integerClass = int.class;
        System.out.println("integerClass = " + integerClass);

        //泛型数组类型
        Class<int[]> aClass = int[].class;
        System.out.println("aClass = " + aClass);

        //原始类型，类、枚举、数组、注解等
        Class<String> stringClass = String.class;
        System.out.println("stringClass = " + stringClass);

        //参数化类型
        Method[] methods = TypeDemo.class.getDeclaredMethods();
        for (Method method : methods) {
            Class<?>[] parameterizedTypes = method.getParameterTypes();
            for (Class<?> parameterizedType : parameterizedTypes) {
                System.out.println("parameterizedType = " + parameterizedType);
            }

        }

        //类型变量
        TypeVariable<Class<ArrayList>>[] typeVariables = ArrayList.class.getTypeParameters();
        for (TypeVariable<Class<ArrayList>> typeVariable : typeVariables) {
            System.out.println("typeVariable = " + typeVariable);
        }


        //泛型类型
        Type genericSuperclass = ArrayList.class.getGenericSuperclass();
        System.out.println("genericSuperclass = " + genericSuperclass);

        //Spring ResolvableType
        ResolvableType t = ResolvableType.forField(TypeDemo.class.getDeclaredField("myMap"));
        System.out.println("t.getSuperType() = " + t.getSuperType());// AbstractMap<Integer, List<String>>
        System.out.println("t.asMap() = " + t.asMap());// Map<Integer, List<String>>
        System.out.println("t.getGeneric(0).resolve() = " + t.getGeneric(0).resolve());// Integer
        System.out.println("t.getGeneric(1).resolve() = " + t.getGeneric(1).resolve());// List
        System.out.println("t.getGeneric(1) = " + t.getGeneric(1));// List<String>
        System.out.println("t.resolveGeneric(1, 0)t = " + t.resolveGeneric(1, 0));// String

    }

    public Map<String, String> parameterizedType(Map<String, String> map) {
        return map;
    }
}
