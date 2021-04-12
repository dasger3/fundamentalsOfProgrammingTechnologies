package voronin.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import voronin.model.AdministrativeTerritorialUnit;
import voronin.model.TypeOfATU;

import java.util.List;
import java.util.Optional;


@Repository
public interface ATURepository extends JpaRepository<AdministrativeTerritorialUnit, Long> {

    List<AdministrativeTerritorialUnit> findAll();

    Optional<AdministrativeTerritorialUnit> findById (Long id);

    Optional<AdministrativeTerritorialUnit> findByTitle(String title);

    List<AdministrativeTerritorialUnit> findAllByTypeOfATUEquals(TypeOfATU t);

//    Object save (AdministrativeTerritorialUnit atu);
//
//    void updateATU (AdministrativeTerritorialUnit atu);
//
//    void deleteATU (Long id);

}
