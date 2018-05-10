package com.pp.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.pp.entities.AppUser;
import com.pp.entities.Product;
import com.pp.entities.ProductStore;
import com.pp.entities.ProductStorePK;
import com.pp.entities.Store;

@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
public class PersistencyConfig {

	@Autowired
	Environment env;

	@Bean
	public DataSource newDataSource() {

		DataSource datasource = null;

		JndiDataSourceLookup lookup = new JndiDataSourceLookup();

		datasource = lookup.getDataSource("java:/prizy_pricerDS");

		return datasource;
	}

	@Bean(autowire = Autowire.BY_TYPE)
	public LocalSessionFactoryBean newSessionFactory() {
		LocalSessionFactoryBean sessionFactory = null;

		sessionFactory = new LocalSessionFactoryBean();

		Properties hibernateProperties = new Properties();

		hibernateProperties.setProperty("show_sql", "true");
		hibernateProperties.setProperty("format_sql", "true");
		hibernateProperties.setProperty("hibernate.current_session_context_class", "thread");
		hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");

		sessionFactory.setHibernateProperties(hibernateProperties);
		sessionFactory.setAnnotatedClasses(
				new Class<?>[] { AppUser.class, Product.class, ProductStore.class, ProductStorePK.class, Store.class });

		return sessionFactory;

	}

	@Bean(autowire = Autowire.BY_TYPE)
	public HibernateTemplate newHibernateTemplate() {

		HibernateTemplate hibernateTemplate = new HibernateTemplate();

		hibernateTemplate.setCheckWriteOperations(false);

		return hibernateTemplate;

	}

	@Bean(name = "transactionManager", autowire = Autowire.BY_TYPE)
	public HibernateTransactionManager newTransaction() {
		HibernateTransactionManager transactionManager = null;

		transactionManager = new HibernateTransactionManager();

		return transactionManager;
	}
}
