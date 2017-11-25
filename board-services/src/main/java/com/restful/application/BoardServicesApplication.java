package com.restful.application;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@SpringBootApplication(scanBasePackages={"com.restful.controller", "com.restful.services"})
@MapperScan(value = {"com.restful.mapper"})
public class BoardServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoardServicesApplication.class, args);
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource); //db connection
		
		//Get mapper resources
		Resource[] res = new PathMatchingResourcePatternResolver().getResources("classpath:mappers/*Mapper.xml");
		
		sessionFactory.setMapperLocations(res);
		
		return sessionFactory.getObject();
	}
}
