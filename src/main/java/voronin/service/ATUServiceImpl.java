package voronin.service;

import lombok.RequiredArgsConstructor;
import voronin.exception.ATUNotFoundException;
import voronin.model.AdministrativeTerritorialUnit;
import voronin.model.TypeOfATU;
import voronin.repository.ATURepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ATUServiceImpl implements ATUService {

    //@Autowired
    private final ATURepository atuRepository;

    public List<AdministrativeTerritorialUnit> getATUs () {
        return atuRepository.findAllATU();
    }

    public AdministrativeTerritorialUnit getATUById(Long id) {
        return  atuRepository.findATUById(id).orElseThrow(() -> new ATUNotFoundException(id));
    }

    public AdministrativeTerritorialUnit getATUByTitle(String title) {
        return  atuRepository.findAllATU().stream()
                        .filter(sub -> sub.getTitle().equals(title))
                        .findAny()
                        .orElseThrow(() -> new ATUNotFoundException(title));
    }

    public List<AdministrativeTerritorialUnit> getInternalList1ById (Long id) {
        return getATUById(id).getInternalList1();
    }
    public List<AdministrativeTerritorialUnit> getInternalList2ById (Long id) {
        return getATUById(id).getInternalList2();
    }
    public List<AdministrativeTerritorialUnit> getAllATUByType (String type) {
        return atuRepository.findAllATU().stream()
                .filter(atu -> atu.getTypeOfATU().equals(TypeOfATU.getTypeByUrl(type))).collect(Collectors.toList());
    }




}
