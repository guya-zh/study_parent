package com.lill.study.constant;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/**
 * @author guya
 * @project Study
 * @date 2018/9/22 18:13
 * @description 常量枚举
 */
public class ConstantEnumsBak {
    protected String name;
    protected String code;
    protected String explain;
    private static HashMap<String, HashMap<String, ConstantEnumsBak>> enumMap = new HashMap();

    public ConstantEnumsBak(String name, String code, String explain) {
        this.name = name;
        this.code = code;
        this.explain = explain;
    }

    private static <T extends ConstantEnumsBak> T parseImpl(Class<T> clazz, String code) {
        String name = clazz.getName();
        if (!enumMap.containsKey(name)) {
            synchronized (ConstantEnumsBak.class) {
                HashMap<String, ConstantEnumsBak> thisEnum = new HashMap<>();
                Field[] fields = clazz.getDeclaredFields();
                try {
                    for (Field field : fields) {
                        int mod = field.getModifiers();
                     /*判断是否是公开，静态，最终参数*/
                        if (((mod & Modifier.PUBLIC) != 0) && ((mod & Modifier.STATIC) != 0) && ((mod & Modifier.FINAL) != 0)) {
                            ConstantEnumsBak temp = (ConstantEnumsBak) field.get(null);
                            thisEnum.put(temp.getCode(), temp);
                        }
                    }
                } catch (IllegalArgumentException | IllegalAccessException e) {

                }
                enumMap.put(name, thisEnum);
            }
        }
        return clazz.cast(enumMap.get(name).get(code));
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getExplain() {
        return explain;
    }

    public static void main(String[] args) {
        ConstantEnumsBak.ModuleType.parse("");
    }

    public static class ModuleType extends ConstantEnumsBak {
        public final static ModuleType
                USER_M = new ModuleType("用户管理", "USER_M", "用户管理模块"),
                TEST_M = new ModuleType("测试模块", "TEST_M", "测试模块");

        public ModuleType(String name, String code, String explain) {
            super(name, code, explain);
        }

        public static ModuleType parse(String code) {
            return ConstantEnumsBak.parseImpl(ModuleType.class, code);
        }

    }
}
