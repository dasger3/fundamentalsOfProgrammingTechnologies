package voronin.service;

import voronin.exception.ObjectAlreadyExistsException;
import voronin.exception.ObjectNotFoundException;
import voronin.model.AdministrativeTerritorialUnit;
import voronin.model.TypeOfATU;
import voronin.repository.ATURepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class ATUServiceImpl implements ATUService {

    private final ATURepository atuRepository;

    public List<AdministrativeTerritorialUnit> getAllATU () {
        return new ArrayList<>(atuRepository.findAll());
    }

    public AdministrativeTerritorialUnit getATUById(Long id) {
        return  atuRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(AdministrativeTerritorialUnit.class.getName(), id));
    }

    public AdministrativeTerritorialUnit getATUByTitle(String title) {
        return  atuRepository.findByTitle(title);
    }

    public List<AdministrativeTerritorialUnit> getAllATUByType (String type) {
        return atuRepository.findAllByTypeOfATUEquals(TypeOfATU.getTypeByUrl(type));
    }

    @Override
    public void saveATU(AdministrativeTerritorialUnit atu) {
        if(atuRepository.findAll().contains(atu)) {
            throw new ObjectAlreadyExistsException(AdministrativeTerritorialUnit.class.getName(),atu.getAtuId());
        }
        else {
            atuRepository.save(atu);
        }
    }
}
