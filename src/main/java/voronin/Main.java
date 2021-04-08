package voronin;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import voronin.exception.ObjectAlreadyExistsException;

@SpringBootApplication
public class Main {
    public static void main(String[] args) throws ObjectAlreadyExistsException {

        SpringApplication.run(Main.class);

//        View view = new ConsoleView();
//
//
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
//
//        ATUController atuController = context.getBean(ATUController.class);
//
//        view.ShowATUs(atuController.findAllATU());
//
//        AdministrativeTerritorialUnit atu1 = new AdministrativeTerritorialUnit();
//        //atu1.setManager( new Manager("Rotaliy", "Volopyhin", "head"));
//        atu1.setTypeOfATU(TypeOfATU.CITY);
//        atu1.setTitle("Poltava");
//        atu1.setSquare(123.0);
//        atu1.setPopulation(1243);
//        atuController.saveATU(atu1);
//
//        view.ShowATUs(atuController.findAllATU());
    }
}
