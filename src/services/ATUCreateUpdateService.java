package services;

import models.pojo.*;

import java.util.ArrayList;
import java.util.List;

public interface ATUCreateUpdateService {

      long createATU (TypeOfATU typeOfATU, String title, double square, int population,
                      String name, String surname, String position);

      //      void createRegion(TypeOfATU typeOfATU, String title, double square, int population,
//                        String name, String surname, String position,
//                        ArrayList<City> city, City regionCenter, ArrayList<Village>village);
//      void createCity(TypeOfATU typeOfATU, String title, double square, int population,
//                        String name, String surname, String position, ArrayList<District> districts);
//      void createVillage(TypeOfATU typeOfATU, String title, double square, int population,
//                      String name, String surname, String position, String occupation);
//      void createDistrict(TypeOfATU typeOfATU, String title, double square, int population,
//                      String name, String surname, String position);

      void addCityInRegion(long idRegion, long idCity);
}
