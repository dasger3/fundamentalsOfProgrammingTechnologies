package models.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
@Data
@NoArgsConstructor
public abstract class AdministrativeTerritorialUnit {

    private long id;
    private TypeOfATU typeOfATU;
    private String title;
    private double square;
    private int population;
    private Manager manager;

    AdministrativeTerritorialUnit(TypeOfATU typeOfATU, String title,  double square, int population, String name, String surname, String position) {
        this.typeOfATU = typeOfATU;
        this.title = title;
        this.square = square;
        this.population = population;
        manager = new Manager(name,surname,position);
    }

    public void setManager(String name, String surname, String position) {
        this.manager = new Manager(name,surname,position);
    }
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class Manager {
        String name;
        String surname;
        String position;
    }
}
