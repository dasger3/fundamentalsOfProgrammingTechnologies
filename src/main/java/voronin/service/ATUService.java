package voronin.service;

import voronin.model.AdministrativeTerritorialUnit;


import java.util.List;


public interface ATUService {

    List<AdministrativeTerritorialUnit> getATUs ();
    AdministrativeTerritorialUnit getATUById(Long id);
    AdministrativeTerritorialUnit getATUByTitle(String title);
//    //List<AdministrativeTerritorialUnit> getInternalList1ById (Long id);
//    //List<AdministrativeTerritorialUnit> getInternalList2ById (Long id);
    List<AdministrativeTerritorialUnit> getAllATUByType (String type);

}
