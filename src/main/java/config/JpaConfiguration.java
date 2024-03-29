package config;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.cfg.ImprovedNamingStrategy;
import org.hibernate.dialect.MySQL5Dialect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import domain.user.UserDao;

@Configuration
public class JpaConfiguration {

  @Value("#{dataSource}")
  private javax.sql.DataSource dataSource;


  @Bean
  public Map<String, Object> jpaProperties() {
    Map<String, Object> props = new HashMap<String, Object>();
    props.put("hibernate.dialect", MySQL5Dialect.class.getName());
    props.put("javax.persistence.validation.factory", validator());
    props.put("hibernate.ejb.naming_strategy", ImprovedNamingStrategy.class.getName());
    return props;
  }

  @Bean
  public LocalValidatorFactoryBean validator() {
    return new LocalValidatorFactoryBean();
  }

  @Bean
  public JpaVendorAdapter jpaVendorAdapter() {
    HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
    hibernateJpaVendorAdapter.setGenerateDdl(true);
    hibernateJpaVendorAdapter.setDatabase(Database.MYSQL);
    hibernateJpaVendorAdapter.setShowSql(true);
    return hibernateJpaVendorAdapter;
  }

  @Bean
  public PlatformTransactionManager transactionManager() {
    return new JpaTransactionManager(
        localContainerEntityManagerFactoryBean().getObject());
  }

  @Bean
  public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean() {
    LocalContainerEntityManagerFactoryBean lef = new LocalContainerEntityManagerFactoryBean();
    lef.setDataSource(this.dataSource);
		lef.setPackagesToScan("domain");
    lef.setJpaPropertyMap(this.jpaProperties());
    lef.setJpaVendorAdapter(this.jpaVendorAdapter());
    return lef;
  }

}
