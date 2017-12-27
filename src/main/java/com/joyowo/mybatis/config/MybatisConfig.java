package com.joyowo.mybatis.config;

import com.github.pagehelper.PageHelper;
import com.joyowo.mybatis.mybatis.PagePlugin;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Author: chenby
 * Date: 2017-12-27
 */
@Configuration
@AutoConfigureAfter(DataSource.class)
public class MybatisConfig {

    @Autowired
    @Qualifier("myDatasource")
    DataSource dataSource;

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        PagePlugin pagePlugin = new PagePlugin();
        Properties properties = new Properties();
        properties.setProperty("dialect", "mysql");
        properties.setProperty("pageSqlId", ".*query.*");
        pagePlugin.setProperties(properties);
        sqlSessionFactoryBean.setPlugins(new Interceptor[]{pagePlugin});

        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:mapper/*Mapper.xml"));
        sqlSessionFactoryBean.setTypeAliasesPackage("com.joyowo.mybatis.pojo");

        return sqlSessionFactoryBean.getObject();
    }

}
