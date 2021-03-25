package services;

import models.pojo.*;

import java.util.List;

public interface ATUGetService {

      List<AdministrativeTerritorialUnit> getATUs ();
      AdministrativeTerritorialUnit getATUByTitle (String title);
      AdministrativeTerritorialUnit getATUById (long id);
      List<Village> getVillagesInRegion (String title);
      List<City> getCitiesInRegion (String title);
      List<District> getDistrictsInCity (String title);
      City getCityCenterByTitle (String title);
      Region getRegionById (long id);
      City getCityById (long id);

}
