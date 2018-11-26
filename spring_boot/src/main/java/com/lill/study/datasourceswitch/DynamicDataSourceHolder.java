package com.lill.study.datasourceswitch;

import com.lill.study.constant.ConstantEnums;

/**
 * @author 李亮亮
 * @project xtone-framework
 * @company 成都信通信息技术有限公司
 * @date 2018/11/26 18:07
 * @description 动态数据源Holder
 */
public class DynamicDataSourceHolder {
    public final static ThreadLocal<String> holder = new ThreadLocal<String>();

    public static void putDataSource(ConstantEnums.DataSourceType dataSourceType) {
        holder.set(dataSourceType.getCode());
    }

    public static String getDataSource() {
        return holder.get() == null ? ConstantEnums.DataSourceType.WRITE.getCode() : holder.get();
    }

    public static void remove() {
        holder.remove();
    }

}
