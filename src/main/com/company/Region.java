package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Region extends AdministrativeTerritorialUnit implements Information{
    private ArrayList<City>city;
    private City regionCenter;
    private ArrayList<Village>village;

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

    public ArrayList<City> getCity() {
        return city;
    }

    public ArrayList<Village> getVillage() {
        return village;
    }


    public static int getCityPopulationSum(List<City> list) {
        return list.stream().
                filter(x -> x.getSquare()>100).
                mapToInt(City::getPopulation).
                sum();
    }

    public static double getAveragePopulaiton(List<Village> list) {
        return list.stream().
                mapToInt(Village::getPopulation).
                average().getAsDouble();
    }

    public static int getMaxPopulation(List<City> list) {
        return list.stream().
                mapToInt(City::getPopulation).
                max().getAsInt();
    }

    public static Map<Boolean, List<Village>> getVillageWithFilter(List<Village> list, Predicate<Village> condition) {

        return list.stream().
                collect(Collectors.partitioningBy(condition));

     }
    public static List<String> getMostFrequentTitleNames(List<Region> regionList) {
        List<String> result = new ArrayList<>();
        regionList.stream()
                .flatMap(x -> x.getCity().stream())
                .collect(Collectors.toList())
                .stream()
                .collect(Collectors.groupingBy(City::getPosition))
                .forEach((key, value) -> value.stream()
                        .collect(Collectors.groupingBy(City::getTitle, Collectors.counting()))
                        .entrySet()
                        .stream()
                        .max(Map.Entry.comparingByValue())
                        .ifPresent(x -> result.add(x.getKey())));
        return result;
    }


}
