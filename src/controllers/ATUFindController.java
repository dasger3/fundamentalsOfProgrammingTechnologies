package controllers;

import lombok.AllArgsConstructor;
import models.pojo.AdministrativeTerritorialUnit;
import models.pojo.City;
import models.pojo.District;
import services.ATUGetService;

import java.util.List;

@AllArgsConstructor
public class ATUFindController {

    private final ATUGetService atuGetService;

    public AdministrativeTerritorialUnit findATUByTitle (String title) {
        return atuGetService.getATUByTitle(title);
    }
    public AdministrativeTerritorialUnit findATUById (long id) {
        return atuGetService.getATUById(id);
    }
    public List<City> findCitiesInRegion (String title) {
        return atuGetService.getCitiesInRegion(title);
    }
    public List<District> findDistrictsInCity (String title) {
        return atuGetService.getDistrictsInCity(title);
    }
    public City findCityCenterByTitle (String title) {
        return atuGetService.getCityCenterByTitle(title);
    }


}
