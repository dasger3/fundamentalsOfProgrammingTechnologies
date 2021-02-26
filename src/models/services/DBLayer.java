package models.services;

import models.pojo.*;

public class DBLayer implements ModelLayer {

    //temporary objects, will be replaced with database inserts
    private Region region;
    private City city;
    private District district;
    private Village village;

    public Region getRegion(String title) {
        //checking if an object exists with the same name
        return region; //will get data from database
    }
    public City getCity(String title) {
        //checking if an object exists with the same name
        return city; //will get data from database
    }
    public Village getVillage(String title) {
        //checking if an object exists with the same name
        return village; //will get data from database
    }
    public District getDistrict(String title) {
        //checking if an object exists with the same name
        return district; //will get data from database
    }

    public void addRegion(Region region) {
        this.region = region; //insert in database
    }
    public void addCity(City city) {
        this.city = city; //insert in database
    }
    public void addVillage(Village village) {
        this.village = village; //insert in database
    }
    public void addDistrict(District district) {
        this.district = district; //insert in database
    }

}
