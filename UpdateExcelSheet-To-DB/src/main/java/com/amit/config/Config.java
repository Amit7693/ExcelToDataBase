package com.amit.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages= {"com.amit.*"})
@EnableTransactionManagement
public class Config extends WebMvcConfigurerAdapter{
	
	@Bean
	ViewResolver createViewResolver() {
		InternalResourceViewResolver vr=new InternalResourceViewResolver();
		vr.setViewClass(InternalResourceView.class);
		vr.setPrefix("/");
		vr.setSuffix(".jsp");
		return vr;
	}
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/mydb");
		dataSource.setUsername("root");
		dataSource.setPassword("jlcindia");
		return dataSource;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory(DataSource ds) {
		LocalSessionFactoryBean sessionFactory=new LocalSessionFactoryBean();
		sessionFactory.setDataSource(ds);	
		sessionFactory.setPackagesToScan("com.amit");
		Properties props=new Properties();
		props.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		props.put("hibernate.show_sql", true);
		props.put("hibernate.hbm2ddl.auto", "create");
		sessionFactory.setHibernateProperties(props);
		return sessionFactory;
	}
	
		@Bean 
		public HibernateTemplate hibernateTemplate(SessionFactory sf) {
			HibernateTemplate hTemp=new HibernateTemplate(sf);
			return hTemp;
		}
	
		@Bean
		public HibernateTransactionManager  transactionManager(SessionFactory sf) {
			HibernateTransactionManager txManager=new HibernateTransactionManager(sf);
			return txManager;
		}
		
		@Bean
		CommonsMultipartResolver multipartResolver(){
			CommonsMultipartResolver cmr=new CommonsMultipartResolver();
			cmr.setMaxUploadSize(500000);
			return cmr;
		}
}
