package com.lill.study.config;

import com.lill.study.constant.ConstantEnums;
import com.lill.study.datasourceswitch.DynamicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 李亮亮
 * @project xtone-framework
 * @company 成都信通信息技术有限公司
 * @date 2018/11/23 13:34
 * @description 读写分离配置 basePackages 覆盖会覆盖其它配置
 */
@Configuration("myReadWriteDataSource")
@MapperScan(basePackages ={"com.lill.study.mapper.read","com.lill.study.mapper.write"}, sqlSessionTemplateRef = "readWriteSqlSessionTemplate")
public class ReadWriteSepDataSource {
    @Autowired
    @Qualifier("readDataSource")
    private DataSource readDataSource;
    @Autowired
    @Qualifier("writeDataSource")
    private DataSource writeDataSource;


    @Bean(name = "readWriteSqlSessionFactory")
    @Primary
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("roundRobinDataSouceProxy") AbstractRoutingDataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mappers/*/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "readWriteTransactionManager")
    @Primary
    public DataSourceTransactionManager testTransactionManager(@Qualifier("roundRobinDataSouceProxy") AbstractRoutingDataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "readWriteSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("readWriteSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean(name="roundRobinDataSouceProxy")
    public AbstractRoutingDataSource roundRobinDataSouceProxy() {

        Map<Object, Object> targetDataSources = new HashMap<Object, Object>();
        //把所有数据库都放在targetDataSources中,注意key值要和determineCurrentLookupKey()中代码写的一至，
        //否则切换数据源时找不到正确的数据源
        targetDataSources.put(ConstantEnums.DataSourceType.WRITE.getCode(), writeDataSource);
        targetDataSources.put(ConstantEnums.DataSourceType.READ.getCode(), readDataSource);

        //路由类，寻找对应的数据源
        AbstractRoutingDataSource proxy = new DynamicDataSource();

        proxy.setDefaultTargetDataSource(writeDataSource);//默认库
        proxy.setTargetDataSources(targetDataSources);
        return proxy;
    }
}
