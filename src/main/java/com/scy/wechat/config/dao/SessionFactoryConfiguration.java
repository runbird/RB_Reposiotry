package com.scy.wechat.config.dao;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * 类名： SessionFactoryConfiguration <br>
 * 描述：TODO <br>
 * 创建日期： 2018/3/25 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
@Configuration
public class SessionFactoryConfiguration {

    //mybatis-config.xml配置文件的路径
    @Value("${mybatis_config_file}")
    private String mybatisConfigFilePath;

    //mybatis mapper文件所在的路径
    @Value("${mapper_path}")
    private String mapperPath;

    //实体类所在的package
    @Value("${pojo_package}")
    private String pojoPackage;

    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;

    @Bean(name = "seqSessionFactory")
    public SqlSessionFactoryBean createSqlSessionFactoryBean() throws IOException {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        //mabatis-config.xml --->configLocation
        bean.setConfigLocation(new ClassPathResource(mybatisConfigFilePath));
        //mapper
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        String packageSearchPath = resolver.CLASSPATH_ALL_URL_PREFIX + mapperPath;
        bean.setMapperLocations(resolver.getResources(packageSearchPath));
        //dataSource
        bean.setDataSource(dataSource);
        //TypeAliasesPackage
        bean.setTypeAliasesPackage(pojoPackage);
        return bean;
    }
}
