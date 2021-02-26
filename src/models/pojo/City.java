package models.pojo;

import java.util.ArrayList;
import java.util.ListIterator;

public class City extends AdministrativeTerritorialUnit {
    private ArrayList<District>district;

    public City () {};
    public City (TypeOfATU typeOfATU, String title,  double square, int population,
                   String name, String surname, String position,
                   ArrayList <District>district) {
        super(typeOfATU,title,square, population, name,surname,position);
        this.district = district;
    }

    public ArrayList<District> getDistrict() {
        return district;
    }

    public void setDistrict(ArrayList<District> district) {
        this.district = district;
    }

    public String getPosition() {
        return super.getManager().getPosition();
    }

}
