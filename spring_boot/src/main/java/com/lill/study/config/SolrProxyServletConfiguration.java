package com.lill.study.config;

import com.lill.study.proxy.ProxyServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertyResolver;

/**
 * @author 李亮亮
 * @project xtone-framework
 * @company 成都信通信息技术有限公司
 * @date 2018/12/4 16:54
 * @description 描述当前类的用途
 */
@Configuration
public class SolrProxyServletConfiguration implements EnvironmentAware {

    private PropertyResolver propertyResolver;

    @Bean
    public ServletRegistrationBean servletRegistrationBean1() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new ProxyServlet(), propertyResolver.getProperty("servlet_url"));
        servletRegistrationBean.setName("1");
        servletRegistrationBean.addInitParameter("targetUri", propertyResolver.getProperty("target_url"));
        servletRegistrationBean.addInitParameter(ProxyServlet.P_LOG, propertyResolver.getProperty("logging_enabled", "true"));
        return servletRegistrationBean;
    }

    @Bean
    public ServletRegistrationBean servletRegistrationBean2() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new ProxyServlet(), propertyResolver.getProperty("static_servlet_url"));
        servletRegistrationBean.setName("2");
        servletRegistrationBean.setEnabled(true);
        servletRegistrationBean.setAsyncSupported(true);
        servletRegistrationBean.addInitParameter("targetUri", propertyResolver.getProperty("static_target_url"));
        servletRegistrationBean.addInitParameter(ProxyServlet.P_LOG, propertyResolver.getProperty("logging_enabled", "true"));
        return servletRegistrationBean;
    }
    @Bean
    public ServletRegistrationBean servletRegistrationBean3() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new ProxyServlet(), propertyResolver.getProperty("report_servlet_url"));
        servletRegistrationBean.setName("3");
//        servletRegistrationBean.
        servletRegistrationBean.addInitParameter("targetUri", propertyResolver.getProperty("report_target_url"));
        servletRegistrationBean.addInitParameter(ProxyServlet.P_LOG, propertyResolver.getProperty("logging_enabled", "true"));
        return servletRegistrationBean;
    }

    @Bean
    public ServletRegistrationBean servletRegistrationBean4() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new ProxyServlet(), propertyResolver.getProperty("demo_servlet_url"));
        servletRegistrationBean.setName("4");
        servletRegistrationBean.setEnabled(true);
        servletRegistrationBean.setAsyncSupported(true);
        servletRegistrationBean.addInitParameter("targetUri", propertyResolver.getProperty("demo_target_url"));
        servletRegistrationBean.addInitParameter(ProxyServlet.P_LOG, propertyResolver.getProperty("logging_enabled", "true"));
        return servletRegistrationBean;
    }


    @Override
    public void setEnvironment(Environment environment) {
        this.propertyResolver = environment;
    }
}
