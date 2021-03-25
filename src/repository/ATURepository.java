package repository;

import models.pojo.*;

import java.util.Collections;
import java.util.List;

public class ATURepository {

    public List<AdministrativeTerritorialUnit> getAllATU() {
        return Collections.emptyList();
    }
    public List<Region> getAllRegion() {
        return Collections.emptyList();
    }
    public List<City> getAllCities() {
        return Collections.emptyList();
    }

    public AdministrativeTerritorialUnit findATUByID (long id) {
        return null;
    }
    public Region findRegionByID (long id) {
        return null;
    }
    public City findCityByID (long id) {
        return null;
    }

    public long createATU (AdministrativeTerritorialUnit atu) {
        return 0;
    }

    public  AdministrativeTerritorialUnit updateATU (AdministrativeTerritorialUnit atu) {
        return null;
    }
    public void deleteATU (long id) {

    }

}
