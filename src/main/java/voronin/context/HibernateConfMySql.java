package voronin.context;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@PropertySource("classpath:hibernate.properties")
public class HibernateConfMySql {

    private Environment environment;

    @Autowired
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
        dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
        dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
        dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));

        return dataSource;
    }

    /*
        create – Hibernate first drops existing tables, then creates new tables
        update – the object model created based on the mappings (annotations or XML) is compared with the existing schema, and then Hibernate updates the schema according to the diff. It never deletes the existing tables or columns even if they are no more required by the application
        create-drop – similar to create, with the addition that Hibernate will drop the database after all operations are completed. Typically used for unit testing
        validate – Hibernate only validates whether the tables and columns exist, otherwise it throws an exception
        none – this value effectively turns off the DDL generation
    */
    @Bean
    public Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty(
                "hibernate.hbm2ddl.auto", "update"); //update, validate, create, create-drop create-drop
        hibernateProperties.setProperty(
                "hibernate.dialect",
                "org.hibernate.dialect.MySQL5InnoDBDialect"
        );
        hibernateProperties.setProperty("hibernate.format_sql", "true");
        hibernateProperties.setProperty("hibernate.show_sql", "true");
        hibernateProperties.setProperty("globally_quoted_identifiers","true");
        return hibernateProperties;
    }

}