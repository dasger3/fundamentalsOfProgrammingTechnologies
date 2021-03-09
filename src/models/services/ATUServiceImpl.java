package models.services;

import models.exceptions.ATUNotFoundException;
import models.pojo.*;
import models.repository.ATURepository;

import java.util.List;

public class ATUServiceImpl implements ATUService {

    private ATURepository atuRepository;

    public ATUServiceImpl (ATURepository atuRepository) {
        this.atuRepository = atuRepository;
    }

    public List<AdministrativeTerritorialUnit> getATUs () {
        return atuRepository.getAllATU();
    }

    public AdministrativeTerritorialUnit getATUByTitle(String title) {
        return  atuRepository.getAllATU().stream()
                        .filter(sub -> sub.getTitle().equals(title))
                        .findAny()
                        .orElseThrow(() -> new ATUNotFoundException(title));
    }

}
