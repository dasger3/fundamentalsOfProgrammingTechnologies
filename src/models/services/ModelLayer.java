package models.services;

import models.pojo.*;

public interface ModelLayer {
    Region getRegion(String title);
    City getCity(String title);
    Village getVillage(String title);
    District getDistrict(String title);

    void addRegion(Region region);
    void addCity(City city);
    void addVillage(Village village);
    void addDistrict(District village);

}
