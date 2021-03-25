package models.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class Region extends AdministrativeTerritorialUnit {
    private ArrayList<City>city;
    private City regionCenter;
    private ArrayList<Village>village;

    public Region (TypeOfATU typeOfATU, String title,  double square, int population,
                   String name, String surname, String position,
                   ArrayList<City>city,City regionCenter,ArrayList<Village>village) {
        super(typeOfATU,title,square, population, name,surname,position);
        this.city = city;
        this.regionCenter = regionCenter;
        this.village = village;
    }
    public Region (TypeOfATU typeOfATU, String title,  double square, int population,
                   String name, String surname, String position) {
        super(typeOfATU,title,square, population, name,surname,position);
        this.city = new ArrayList<City>();
        this.village = new ArrayList<Village>();
    }

    public void addCity (City city) {
        this.city.add(city);
    }
    public void addVillage (Village village) {
        this.village.add(village);
    }
}
