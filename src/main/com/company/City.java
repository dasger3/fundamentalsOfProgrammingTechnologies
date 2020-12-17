package com.company;

import java.util.ArrayList;
import java.util.ListIterator;

public class City extends AdministrativeTerritorialUnit implements Information{
    private ArrayList<District>district;

    public City (TypeOfATU typeOfATU, String title,  double square, int population,
                   String name, String surname, String postion,
                   ArrayList <District>district) {
        super(typeOfATU,title,square, population, name,surname,postion);
        this.district = district;
    }

    public String getPosition() {
        return super.getManager().getPosition();
    }

    public void display() {
        super.display();
        ListIterator<District> districtIter = district.listIterator();
        while (districtIter.hasNext()) {
            districtIter.next().display();
        }
        System.out.println("----------------------------------------------------------------------------------------------------------------------------");
    }
}
