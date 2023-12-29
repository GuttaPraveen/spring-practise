package com.trio.praveen.configuration;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


@Configuration
@ComponentScan(basePackages="com.trio.praveen.*")
public class StudentConfiguration
{
	@Bean
	public DataSource dataSource()
	{
		return new DriverManagerDataSource("jdbc:mysql://localhost:3306/kphb","root","Maha@143");
	}
	@Bean
	public JdbcTemplate jdbcTemplate()
	{
		return new JdbcTemplate(dataSource());
	}
}
