package models.pojo;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Region extends AdministrativeTerritorialUnit {
    private ArrayList<City>city;
    private City regionCenter;
    private ArrayList<Village>village;

    public Region () {};
    public Region (TypeOfATU typeOfATU, String title,  double square, int population,
                   String name, String surname, String position,
                   ArrayList<City>city,City regionCenter,ArrayList<Village>village) {
        super(typeOfATU,title,square, population, name,surname,position);
        this.city = city;
        this.regionCenter = regionCenter;
        this.village = village;
    }

    public ArrayList<City> getCity() {
        return city;
    }

    public void setCity(ArrayList<City> city) {
        this.city = city;
    }

    public City getRegionCenter() {
        return regionCenter;
    }

    public void setRegionCenter(City regionCenter) {
        this.regionCenter = regionCenter;
    }

    public ArrayList<Village> getVillage() {
        return village;
    }

    public void setVillage(ArrayList<Village> village) {
        this.village = village;
    }



}
