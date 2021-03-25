package services;

import exceptions.ATUNotFoundException;
import lombok.AllArgsConstructor;
import models.pojo.*;
import repository.ATURepository;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class ATUCreateUpdateServiceImpl implements ATUCreateUpdateService {

    private final ATURepository atuRepository;
    private final ATUGetService atuGetService;
    
    public ATUCreateUpdateServiceImpl (ATURepository atuRepository) {
        this.atuRepository = atuRepository;
        atuGetService = new ATUGetServiceImpl(atuRepository);
    }
    public long createATU (TypeOfATU typeOfATU, String title, double square, int population,
                           String name, String surname, String position) {
        switch (typeOfATU) {
            case REGION: return atuRepository.createATU(new Region(typeOfATU, title, square, population, name, surname, position));
            case CITY: return atuRepository.createATU(new City(typeOfATU, title, square, population, name, surname, position));
            case VILLAGE: return atuRepository.createATU(new Village(typeOfATU, title, square, population, name, surname, position));
            case DISTRICT: return atuRepository.createATU(new District(typeOfATU, title, square, population, name, surname, position));
        }
        return 0;
    }

    //    public void createRegion(TypeOfATU typeOfATU, String title, double square, int population,
//                      String name, String surname, String position,
//                      ArrayList<City> city, City regionCenter, ArrayList<Village>village) {
//        atuRepository.createRegion(new Region(typeOfATU,title,square, population, name,surname,position, city, regionCenter, village));
//    }
//    public void createCity(TypeOfATU typeOfATU, String title, double square, int population,
//                             String name, String surname, String position, ArrayList<District>districts) {
//        atuRepository.createCity(new City(typeOfATU,title,square, population, name,surname,position, districts));
//    }
//    public void createVillage(TypeOfATU typeOfATU, String title, double square, int population,
//                           String name, String surname, String position, String occupation) {
//        atuRepository.createVillage(new Village(typeOfATU,title,square, population, name,surname,position, occupation));
//    }
//    public void createDistrict(TypeOfATU typeOfATU, String title, double square, int population,
//                              String name, String surname, String position) {
//        atuRepository.createATU(new District(typeOfATU,title,square, population, name,surname,position));
//    }

    public void addCityInRegion(long idRegion, long idCity) {
        atuGetService.getRegionById(idRegion).addCity(atuGetService.getCityById(idCity));
    }

}
