package com.niit.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.model.Person;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;

@Configuration
@EnableTransactionManagement
public class DBConfiguration
{
	@Bean
	public SessionFactory sessionFactory()
	{
		LocalSessionFactoryBuilder lsf=	new LocalSessionFactoryBuilder(getDataSource());
		Properties hibernateProperties=new Properties();
		
		hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
		hibernateProperties.setProperty("hibernate.show_sql", "true");
		lsf.addProperties(hibernateProperties);
		
		Class classes[]=new Class[]{Person.class};
	    return lsf.addAnnotatedClasses(classes).buildSessionFactory();
	}
	
	@Bean
	public DataSource getDataSource() 
	{
	    BasicDataSource dataSource = new BasicDataSource();
	    
	    dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
	    dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
	    dataSource.setUsername("collaboration");
	    dataSource.setPassword("admin123");
	    
	    return dataSource;
	}
	@Bean
	public HibernateTransactionManager hibTransManagement()
	{
		return new HibernateTransactionManager(sessionFactory());
	}

}