package com.green.nowon.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

//@MapperScan("classpath:/mapper.board")
@Configuration
@PropertySource("classpath:/application.properties")
public class MybatisConfig {
	
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource.hikari")
	public HikariConfig hikariConfig() {
		return new HikariConfig();
	}
	
	//db접속 객체 
	@Bean
	DataSource dataSource() {
		return new HikariDataSource(hikariConfig());
	}//DataSource dataSource = new HikariDataSource(hikariConfig());
	
	//mybatis 세팅
	//기본객체 SqlSessionFactory
	//일반java : A SqlSessionFactory instance can be acquired by using the SqlSessionFactoryBuilder. SqlSessionFactoryBuilder를 사용!
	//spring : In base MyBatis, the SqlSessionFactory is built using SqlSessionFactoryBuilder. In MyBatis-Spring, SqlSessionFactoryBean is used instead. SqlSessionFactoryBean을 사용!
	
	@Autowired
	ApplicationContext ac;//ApplicationContext객체를 통해 mapper xml파일 경로에 접근
						  //ResourcePatternResolver를 사용해서 접근해도 가능
	
	@Bean
	SqlSessionFactory sqlSessionFactory() throws Exception {
		 SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		 factoryBean.setDataSource(dataSource());
		 Resource[] mapperLocations = ac.getResources("classpath:/mapper/**/mapper-*.xml");//ApplicationContext객체를 통해 mapper xml파일 경로에 접근 /**는 하위폴더 안 xml모두, mapper-*는 maaper-로 시작되는 xml모두
		 factoryBean.setMapperLocations(mapperLocations);//mapper xml파일들
		 
		 return factoryBean.getObject();
	}
	
	@Bean
	SqlSessionTemplate sqlSessionTemplate() throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory());
	}
	
	//마이바티스는 카멜케이스 따로 설정해줘야 한다..!! properties랑 config에~~~
	//위에 @Configuration이 있기 때문에 풀네임으로 설정해줘야 한다~
	@Bean
	@ConfigurationProperties(prefix = "mybatis.configuration")
	org.apache.ibatis.session.Configuration myConfiguration(){
		return new org.apache.ibatis.session.Configuration();
	};
	
}
