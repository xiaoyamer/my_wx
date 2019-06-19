package com.my.demo1.config;

import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.google.common.collect.Lists;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//注明是配置类
@Configuration
public class DruidConfig {

    //该方法的返回值作为bean交给spring容器管理
    @Bean(value = "druidDataSource",initMethod = "init",destroyMethod = "close")
    //对应applicatio.yml的druid
    @ConfigurationProperties(prefix = "spring.druid")
    public DruidDataSource druidDataSource(){
        DruidDataSource druidDataSource =new DruidDataSource();
        druidDataSource.setProxyFilters(Lists.newArrayList(statFilter()));
        return druidDataSource;
    }
    @Bean
    public StatFilter statFilter(){
        StatFilter statFilter=new StatFilter();
        //慢查询是否记录日志
        statFilter.setLogSlowSql(true);
        //慢查询时间
        statFilter.setSlowSqlMillis(5);
        statFilter.setLogSlowSql(true);
        //格式化sql
        statFilter.setMergeSql(true);
        return statFilter;
    }

    @Bean
    public ServletRegistrationBean servletRegistrationBean(){
        //druid监控，输入...8080/druid即可访问
        return new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
    }
}
