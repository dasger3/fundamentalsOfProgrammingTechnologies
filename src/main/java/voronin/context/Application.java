package voronin.context;

import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = {"voronin.controller","voronin.service","voronin.repository" })
@Import(HibernateConfCommon.class)
public class Application {

        //            @Bean
//    public ATUControll    er ATUApi() {
//        return new ATUController(ATUGetService());
//    }
//
//    @Bean
//    public ATUService ATUGetService() {
//        return new ATUServiceImpl(ATURepository());
//    }
//
//    @Bean
//    protected ATURepository ATURepository() {
//        return new ATURepositoryImpl();
//    }
}
