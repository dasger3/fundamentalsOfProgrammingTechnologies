package services;

import exceptions.ATUNotFoundException;
import lombok.AllArgsConstructor;
import models.pojo.*;
import repository.ATURepository;

import java.util.List;

@AllArgsConstructor
public class ATUGetServiceImpl implements ATUGetService {

    private final ATURepository atuRepository;

    public List<AdministrativeTerritorialUnit> getATUs () {
        return atuRepository.getAllATU();
    }

    public AdministrativeTerritorialUnit getATUByTitle(String title) {
        return  atuRepository.getAllATU().stream()
                        .filter(sub -> sub.getTitle().equals(title))
                        .findAny()
                        .orElseThrow(() -> new ATUNotFoundException(title));
    }

    public AdministrativeTerritorialUnit getATUById(long id) {
        return  atuRepository.getAllATU().stream()
                .filter(sub -> sub.getId() == id)
                .findAny()
                .orElseThrow(() -> new ATUNotFoundException(id));
    }

    public Region getRegionById (long id) {
        return  atuRepository.getAllRegion().stream()
                .filter(sub -> sub.getId() == id)
                .findAny()
                .orElseThrow(() -> new ATUNotFoundException(id));
    }
    public City getCityById (long id) {
        return  atuRepository.getAllCities().stream()
                .filter(sub -> sub.getId() == id)
                .findAny()
                .orElseThrow(() -> new ATUNotFoundException(id));
    }
    public List<Village> getVillagesInRegion (String title) {
        return atuRepository.findRegionByID(getATUByTitle(title).getId()).getVillage();
    }
    public List<City> getCitiesInRegion (String title) {
        return atuRepository.findRegionByID(getATUByTitle(title).getId()).getCity();
    }
    public List<District> getDistrictsInCity (String title) {
        return atuRepository.findCityByID(getATUByTitle(title).getId()).getDistrict();
    }
    public City getCityCenterByTitle (String title) {
        return atuRepository.findRegionByID(getATUByTitle(title).getId()).getRegionCenter();
    }



}
