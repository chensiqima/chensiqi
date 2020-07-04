package com.atguigu.springcloud.jdbc;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * order_manager 数据库配置
 *
 * @auth panpan gao
 * @date 2020/7/1
 */
@Configuration
// 扫描 Mapper 接口并容器管理
@MapperScan(basePackages = com.atguigu.springcloud.jdbc.OrderDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "orderSqlSessionFactory")
public class OrderDataSourceConfig {

    // 精确到 cluster 目录，以便跟其他数据源隔离
    static final String PACKAGE = "com.atguigu.springcloud.mapper";
    static final String MAPPER_LOCATION = "classpath:mapper/*.xml";

    @Value("${spring.order.datasource.url}")
    private String url;

    @Value("${spring.order.datasource.username}")
    private String user;

    @Value("${spring.order.datasource.password}")
    private String password;

    @Value("${spring.order.datasource.driver-class-name}")
    private String driverClass;

    @Bean(name = "orderDataSource")
    public DataSource clusterDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean(name = "orderTransactionManager")
    public DataSourceTransactionManager clusterTransactionManager() {
        return new DataSourceTransactionManager(clusterDataSource());
    }

    @Bean(name = "orderSqlSessionFactory")
    public SqlSessionFactory clusterSqlSessionFactory(@Qualifier("orderDataSource") DataSource clusterDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(clusterDataSource);
//        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
//                .getResources(OrderDataSourceConfig.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }
}
