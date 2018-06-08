package com.scy.wechat.config.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.beans.PropertyVetoException;

/**
 * 类名： DataSourceConfiguration <br>
 * 描述：  <br>
 * 创建日期： 2018/3/25 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */

@Configuration
@MapperScan("com.scy.wechat.*")
public class DataSourceConfiguration {
    @Value("${jdbc.driver}")
    private String jdbcDriver;
    @Value("${jdbc.url}")
    private String jdbcUrl;
    @Value("${jdbc.username}")
    private String jdbcUsername;
    @Value("${jdbc.password}")
    private String jdbcPassword;

    @Bean(name = "dataSource")
    public ComboPooledDataSource createDataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(jdbcDriver);
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setUser(jdbcUsername);
        dataSource.setPassword(jdbcPassword);
        //关闭连接后不自动commit，这样事务才能进行控制
        dataSource.setAutoCommitOnClose(false);
        //datasource.return IDEA自动解析
        return dataSource;
    }
}
