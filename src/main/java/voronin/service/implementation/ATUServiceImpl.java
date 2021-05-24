package voronin.service.implementation;

import voronin.exception.ObjectAlreadyExistsException;
import voronin.exception.ObjectNotFoundException;
import voronin.model.AdministrativeTerritorialUnit;
import voronin.model.Manager;
import voronin.model.TypeOfATU;
import voronin.repository.ATURepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import voronin.repository.ManagerRepository;
import voronin.service.ATUService;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class ATUServiceImpl implements ATUService {

    private final ATURepository atuRepository;
    private final ManagerRepository managerRepository;

    public List<AdministrativeTerritorialUnit> getAllATU () {
        return new ArrayList<>(atuRepository.findAll());
    }

    public AdministrativeTerritorialUnit getATUById(Long id) {
        return  atuRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(AdministrativeTerritorialUnit.class.getName(), id));
    }

    public AdministrativeTerritorialUnit getATUByTitle(String title) {
        return  atuRepository.findByTitle(title).orElseThrow(() -> new ObjectNotFoundException(AdministrativeTerritorialUnit.class.getName(), title));
    }

    public List<AdministrativeTerritorialUnit> getAllATUByType (String type) {
        return atuRepository.findAllByTypeOfATUEquals(TypeOfATU.getTypeByUrl(type));
    }

    @Override
    public void saveATU(AdministrativeTerritorialUnit atu) {
        if(atuRepository.findAll().contains(atu))
            throw new ObjectAlreadyExistsException(AdministrativeTerritorialUnit.class.getName(),atu.getAtuId());
        atuRepository.save(atu);
    }

    @Override
    public void deleteATU(Long id) {
        if(atuRepository.findById(id).isEmpty())
            throw new ObjectNotFoundException(AdministrativeTerritorialUnit.class.getName(),id);
        atuRepository.deleteById(id);
    }

    @Override
    public void updateATU(Long id, AdministrativeTerritorialUnit atu) {
        if(atuRepository.findById(id).isEmpty())
            throw new ObjectNotFoundException(AdministrativeTerritorialUnit.class.getName(),id);
        atu.setAtuId(id);
        atuRepository.save(atu);
    }

    @Override
    public void addParentATU(Long id, Long idParent) {
        AdministrativeTerritorialUnit atu =
                atuRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(AdministrativeTerritorialUnit.class.getName(), id));
        atu.setParent(atuRepository.findById(idParent).orElseThrow(() -> new ObjectNotFoundException(AdministrativeTerritorialUnit.class.getName(), idParent)));
        atuRepository.save(atu);
    }

    @Override
    public void addCenterATU(Long id, Long idCenter) {
        AdministrativeTerritorialUnit atu =
                atuRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(AdministrativeTerritorialUnit.class.getName(), id));
        atu.setCenter_id(atuRepository.findById(idCenter).orElseThrow(() -> new ObjectNotFoundException(AdministrativeTerritorialUnit.class.getName(), idCenter)));
        atuRepository.save(atu);
    }

    @Override
    public void addManagerToATU(Long id, Long idManager) {
        AdministrativeTerritorialUnit atu =
                atuRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(AdministrativeTerritorialUnit.class.getName(), id));
        atu.setManager(managerRepository.findById(idManager).orElseThrow(() -> new ObjectNotFoundException(Manager.class.getName(), idManager)));
        atuRepository.save(atu);
    }

    public long getUsersCount(ArrayList<Manager> managers) {
        return managers.stream().filter(manager -> manager.getManagerId() > 18).count();
    }

}
