//package Voronin.views;
//
//import Voronin.model.*;
//
//import java.util.List;
//import java.util.ListIterator;
//import java.util.Map;
//
//public class ConsoleView implements View {
//
//    public void ShowATU (AdministrativeTerritorialUnit ATU) {
//            StringBuilder str = new StringBuilder();
//            str.append(ATU.getTypeOfATU()).append("Title: ").append(ATU.getTitle())
//               .append(" | Square: ").append(ATU.getSquare()).append(" | Population: ").append(ATU.getPopulation());
//
//            str.append("\nPosition: ").append(ATU.getManager().getPosition()).append(" of ").append(ATU.getTitle()).append(" ")
//                .append("| Name: ").append(ATU.getManager().getName()).append(" | Surname: ").append(ATU.getManager().getSurname());
//            System.out.println(str);
//            System.out.println("----------------------------------------------------------------------------------------------------------------------------");
//
//    }
//
//    public void ShowAllATU (List<AdministrativeTerritorialUnit> ATU) {
//        for (AdministrativeTerritorialUnit atu: ATU) {
//            ShowATU(atu);
//        }
//    }
//
//
//    public void ShowRegion (Region region) {
//        ShowATU(region);
//        System.out.println("Region center is: " + region.getCenterOfATU().getTitle());
//        System.out.println("----------------------------------------------------------------------------------------------------------------------------");
//        for (City city : region.getInternalList1()) {
//            ShowCity(city);
//        }
//        System.out.println("----------------------------------------------------------------------------------------------------------------------------");
//        for (Village village : region.getInternalList2()) {
//            ShowVillage(village);
//        }
//        System.out.println("----------------------------------------------------------------------------------------------------------------------------");
//    }
//
//    public void ShowCity (City city) {
//        ShowATU(city);
//        for (District district : city.getInternalList1()) {
//            ShowDistrict(district);
//        }
//        System.out.println("----------------------------------------------------------------------------------------------------------------------------");
//    }
//
//    public void ShowVillage (Village village) {
//        ShowATU(village);
//        System.out.println("Occupation of the village is " + village.getOccupation());
//        System.out.println("----------------------------------------------------------------------------------------------------------------------------");
//
//    }
//
//    public void ShowDistrict (District district) {
//        ShowATU(district);
//    }
//
//    public void ShowCityPopulationSum(int result) {
//        System.out.println("Population in cities with an area of more than 100: " + result);
//    }
//    public void ShowAveragePopulationOfVillage(double result) {
//        System.out.println("Average population of villages: " + result);
//    }
//    public void ShowCityMaxPopulation(int result) {
//        System.out.println("Maximum city population: " + result);
//    }
//    public void ShowVillageWithFilter(Map<Boolean, List<Village>> result) {
//        System.out.println("List of villages by the required condition. True: " + result);
//    }
//    public void ShowMostFrequentCityTitleNames(List<String> result) {
//        System.out.println("Most popular city name among cities with mayor and governor: " + result);
//    }
//
//}
