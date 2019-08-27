package org.sis.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
@MapperScan(basePackages="org.sis.mapper")
public class MapperConfig {
	
	
	 	@Bean
	    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {

	        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();

	        sessionFactory.setDataSource(dataSource);
	        sessionFactory.setMapperLocations(
	        		new PathMatchingResourcePatternResolver().getResources("classpath:/mybatis/mapper/*.xml"));
	        return sessionFactory.getObject();
	    }
	 
	 @Bean
	    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) throws Exception {
	      final SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
	      return sqlSessionTemplate;
	    }


	

}
