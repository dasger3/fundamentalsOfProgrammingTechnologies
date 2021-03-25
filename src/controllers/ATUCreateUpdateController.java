package controllers;

import lombok.AllArgsConstructor;
import models.pojo.City;
import models.pojo.District;
import models.pojo.TypeOfATU;
import models.pojo.Village;
import services.ATUCreateUpdateService;
import services.ATUGetService;

import java.util.ArrayList;

@AllArgsConstructor
public class ATUCreateUpdateController {

    private final ATUCreateUpdateService atuCreateUpdateService;


    public long insertATU (TypeOfATU typeOfATU, String title, double square, int population,
                              String name, String surname, String position) {
        //validate data
        return atuCreateUpdateService.createATU(typeOfATU,title,square, population, name,surname,position);
    }

    //    public void insertCity(TypeOfATU typeOfATU, String title, double square, int population,
//                    String name, String surname, String position, ArrayList<District> districts) {
//
//        //validate data
//        atuCreateUpdateService.createCity(typeOfATU,title,square, population, name,surname,position, districts);
//    }
//    public void insertVillage(TypeOfATU typeOfATU, String title, double square, int population,
//                           String name, String surname, String position, String occupation) {
//
//        //validate data
//        atuCreateUpdateService.createVillage(typeOfATU,title,square, population, name,surname,position, occupation);
//    }
//    public void insertDistrict(TypeOfATU typeOfATU, String title, double square, int population,
//                              String name, String surname, String position) {
//
//        //validate data
//        atuCreateUpdateService.createDistrict(typeOfATU,title,square, population, name,surname,position);
//    }

    public void insertCityInRegion (long idRegion, TypeOfATU typeOfATU, String title, double square, int population,
                                    String name, String surname, String position, ArrayList<District> districts) {
        //validate data
        atuCreateUpdateService.addCityInRegion(idRegion, atuCreateUpdateService.createATU(typeOfATU,title,square, population, name,surname,position));
    }
}
