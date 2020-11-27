package com.company;

import java.util.ArrayList;
import java.util.ListIterator;

public class Region extends AdministrativeTerritorialUnit implements Information{
    private ArrayList<City>city;
    //private City city[];
    private City regionCenter;
    private ArrayList<Village>village;
    //private Village village[];

     public Region (TypeOfATU typeOfATU, String title,  double square, int population,
                   String name, String surname, String postion,
                   ArrayList<City>city,City regionCenter,ArrayList<Village>village) {
        super(typeOfATU,title,square, population, name,surname,postion);
        this.city = city;
        this.regionCenter = regionCenter;
        this.village = village;
    }
    public void display() {
        super.display();
        System.out.println("Region center is: " + regionCenter.title);
        System.out.println("----------------------------------------------------------------------------------------------------------------------------");
        ListIterator<City> cityIter = city.listIterator();
        while (cityIter.hasNext()) {
            cityIter.next().display();
        }
        System.out.println("----------------------------------------------------------------------------------------------------------------------------");
        ListIterator<Village> villageIter = village.listIterator();
        while (villageIter.hasNext()) {
            villageIter.next().display();
        }
        System.out.println("----------------------------------------------------------------------------------------------------------------------------");
    }
}
