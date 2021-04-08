package voronin.service;

import voronin.model.AdministrativeTerritorialUnit;


import java.util.List;


public interface ATUService {

    List<AdministrativeTerritorialUnit> getAllATU ();

    AdministrativeTerritorialUnit getATUById(Long id);
    AdministrativeTerritorialUnit getATUByTitle(String title);
    List<AdministrativeTerritorialUnit> getAllATUByType (String type);

    void saveATU (AdministrativeTerritorialUnit atu);
    void deleteATU (Long id);
    void updateATU (Long id, AdministrativeTerritorialUnit atu);

    void addParentATU (Long id, Long idParent);
    void addCenterATU (Long id, Long idCenter);
    void addManagerToATU (Long id, Long idManager);

}
