package com.lill.study.config;

/**
 * @author 李亮亮
 * @project xtone-framework
 * @company 成都信通信息技术有限公司
 * @date 2018/12/5 15:13
 * @description 描述当前类的用途
 */

//@Component
public class ProxyConfig {

/*
    @Bean
    public ServletUnitClient servletUnitClient1(@Value("servlet_url") String servletUrl, @Value("target_url") String targetUrl) {
        ServletRunner servletRunner = new ServletRunner();
        Properties servletProps = new Properties();
        servletProps.setProperty("http.protocol.handle-redirects", "false");
        servletProps.setProperty(ProxyServlet.P_LOG, "true");
        servletProps.setProperty(ProxyServlet.P_FORWARDEDFOR, "true");
        servletProps.setProperty("targetUri", targetUrl);
        servletRunner.registerServlet(servletUrl, ProxyServlet.class.getName(), servletProps);//also matches /proxyMe (no path info)
        ServletUnitClient sc = servletRunner.newClient();
        sc.getClientProperties().setAutoRedirect(false);
        return sc;
    }


    @Bean
    public ServletUnitClient servletUnitClient2(@Value("static_servlet_url") String servletUrl, @Value("static_target_url") String targetUrl) {
        ServletRunner servletRunner = new ServletRunner();
        Properties servletProps = new Properties();
        servletProps.setProperty("http.protocol.handle-redirects", "false");
        servletProps.setProperty(ProxyServlet.P_LOG, "true");
        servletProps.setProperty(ProxyServlet.P_FORWARDEDFOR, "true");
        servletProps.setProperty("targetUri", targetUrl);
        servletRunner.registerServlet(servletUrl, ProxyServlet.class.getName(), servletProps);//also matches /proxyMe (no path info)
        ServletUnitClient sc = servletRunner.newClient();
        sc.getClientProperties().setAutoRedirect(false);
        return sc;
    }

    @Bean
    public ServletUnitClient servletUnitClient3(@Value("report_servlet_url") String servletUrl, @Value("report_target_url") String targetUrl) {
        ServletRunner servletRunner = new ServletRunner();
        Properties servletProps = new Properties();
        servletProps.setProperty("http.protocol.handle-redirects", "false");
        servletProps.setProperty(ProxyServlet.P_LOG, "true");
        servletProps.setProperty(ProxyServlet.P_FORWARDEDFOR, "true");
        servletProps.setProperty("targetUri", targetUrl);
        servletRunner.registerServlet(servletUrl, ProxyServlet.class.getName(), servletProps);//also matches /proxyMe (no path info)
        ServletUnitClient sc = servletRunner.newClient();
        sc.getClientProperties().setAutoRedirect(false);
        return sc;
    }*/
}
