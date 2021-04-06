package voronin.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import voronin.exception.ATUNotFoundException;
import voronin.model.*;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ATURepositoryImpl implements ATURepository{

    //private EntityManager em;
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Long counter = 0L;

    private ArrayList<AdministrativeTerritorialUnit>allList;

    public ATURepositoryImpl () {

        ArrayList<District> district1;
        ArrayList<District>district2;
        ArrayList<Village>village1;
        ArrayList<City>city1;
        Region region;

        allList = new ArrayList<>();

        region = new Region(TypeOfATU.REGION,"Dnipropetrovska", 22.3,10000,
                "Borys","Filatov","governor");


        district1 = new ArrayList<>();

        district1.add(new District(TypeOfATU.DISTRICT,"District1",12.4,532,
                "Alex", "main/java/Voronin","manager"));

        district1.add(new District(TypeOfATU.DISTRICT,"District2",22.4,632,
                "Dmitriy", "Kuztetsov","manager"));

        district2 = new ArrayList<>();

        district2.add(new District(TypeOfATU.DISTRICT,"District3",32.4,732,
                "Alex", "main/java/Voronin","manager"));

        district2.add(new District(TypeOfATU.DISTRICT,"District3",42.4,832,
                "Dmitriy", "Kuztetsov","manager"));

        for (District district: district1) {
            saveATU(district);
        }
        for (District district: district2) {
            saveATU(district);
        }

        city1 = new ArrayList<>();

        city1.add(new City(TypeOfATU.CITY,"Dnepr",2000,100,
                "Dmitriy", "Efremov","mayor", district1, district1.get(0).getId()));
        city1.add(new City(TypeOfATU.CITY,"Poltava",15,200,
                "Bogdanov", "Bogdan","mayor",district2, district2.get(0).getId()));

        for (City city: city1) {
            saveATU(city);
            region.addToList1(city);
        }

        village1 = new ArrayList<>();

        village1.add(new Village(TypeOfATU.VILLAGE,"Village1",162.4,10,
                "Ivan", "Ivanov","head", "cattle"));
        village1.add(new Village(TypeOfATU.VILLAGE,"Village2",20, 100,
                "Sidor", "Sidorov","head", "harvest"));
        village1.add(new Village(TypeOfATU.VILLAGE,"Village3",20,50,
                "Sidor", "Sidorov","head", "cattle"));
        village1.add(new Village(TypeOfATU.VILLAGE,"Village4",20,4,
                "Sidor", "Sidorov","head", "harvest"));

        for (Village village: village1) {
            saveATU(village);
            region.addToList2(village);
        }
        region.setCenter_id(city1.get(0).getId());
        saveATU(region);
    }

    @SuppressWarnings("unchecked")
    public List<AdministrativeTerritorialUnit> findAllATU() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from AdministrativeTerritorialUnit ").list();
    }

    @Transactional
    public void saveATU (AdministrativeTerritorialUnit atu) {
        atu.setId(++counter);
        allList.add(atu);
    }


    public Optional<AdministrativeTerritorialUnit> findATUById (Long id) {

//        TypedQuery query = em.createQuery("select d from AdministrativeTerritorialUnit d where d.id = ?1", AdministrativeTerritorialUnit.class);
//        query.setParameter(1, id);
//
//        return (Optional<AdministrativeTerritorialUnit>) query.getSingleResult();

        return allList.stream().
                filter(atu -> atu.getId().equals(id))
                .findFirst();
    }

    public  void updateATU (AdministrativeTerritorialUnit atu) {
        AdministrativeTerritorialUnit tmp = findATUById(atu.getId()).orElseThrow(() -> new ATUNotFoundException(atu.getId()));
        findAllATU().set(allList.indexOf(tmp),atu);
    }
    public void deleteATU (Long id) {
        Optional<AdministrativeTerritorialUnit> look = findATUById(id);
        look.ifPresent(allList::remove);
    }

}
