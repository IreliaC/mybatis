package com.joyowo.mybatis.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: chenby
 * Date: 2017-12-27
 */
@Configuration
public class DataSourceConfig {

    @Bean(name = "myDatasource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return new DruidDataSource();
    }

    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean
    public ServletRegistrationBean druidServlet() {
        ServletRegistrationBean srb = new ServletRegistrationBean();
        srb.setServlet(new StatViewServlet());
        srb.addUrlMappings("/druid/*");
        Map<String,String> initParams = new HashMap<>();
        initParams.put("loginUsername", "admin");// 用户名
        initParams.put("loginPassword", "admin");// 密码
        initParams.put("resetEnable", "false");// 禁用HTML页面上的“Reset All”功能
        initParams.put("allow", ""); // IP白名单 (没有配置或者为空，则允许所有访问)
        //initParam.put("deny", "192.168.20.38");// IP黑名单 (存在共同时，deny优先于allow)
        srb.setInitParameters(initParams);
        return srb;
    }

    @Bean
    public FilterRegistrationBean druidFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }

}
