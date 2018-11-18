package com.lill.study.constant;

/**
 * @author guya
 * @project Study
 * @date 2018/9/22 18:13
 * @description 常量枚举
 */
public interface ConstantEnums {
    default void ff(){

    }
     interface BaseEnum {

//        public String name;
//        public String code;
//        public String explain;

//        private BaseEnum(String name, String code, String explain) {
//            this.code = code;
//            this.name = name;
//            this.explain = explain;
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        public String getCode() {
//            return code;
//        }
//
//        public String getExplain() {
//            return explain;
//        }
    }

    static enum EmptyType implements ConstantEnums.BaseEnum {
        USER_M("未定义", "empty", "未定义");
        private String name;
        private String code;
        private String explain;

        private EmptyType(String name, String code, String explain) {
            this.code = code;
            this.name = name;
            this.explain = explain;
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
    }

    static enum ModuleType {
        USER_M("用户管理", "user_m", "用户管理模块"),
        TEST_M("测试模块", "test_m", "测试模块"),;

        private String name;
        private String code;
        private String explain;

        private ModuleType(String name, String code, String explain) {
            this.code = code;
            this.name = name;
            this.explain = explain;
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
    }
}
