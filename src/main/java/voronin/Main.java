package voronin;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {

        SpringApplication.run(Main.class);
//        ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
//        final ATUFindController ATUController = context.getBean(ATUFindController.class);
//
//        View view = new ConsoleView();
//        view.ShowAllATU(ATUController.allATU());
    }
}
