package voronin.repository;


import voronin.model.AdministrativeTerritorialUnit;
import voronin.model.City;
import voronin.model.User;
import voronin.model.Village;

import java.util.List;
import java.util.Optional;

public interface ATURepository {

    List<AdministrativeTerritorialUnit> findAllATU();
    Optional<AdministrativeTerritorialUnit> findATUById (Long id);
    void saveATU (AdministrativeTerritorialUnit atu);
    void updateATU (AdministrativeTerritorialUnit atu);
    void deleteATU (Long id);

}
