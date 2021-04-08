package voronin.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import voronin.exception.ObjectAlreadyExistsException;
import voronin.exception.ObjectNotFoundException;
import voronin.model.Manager;
import voronin.repository.ManagerRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ManagerServiceImpl implements ManagerService{

    private final ManagerRepository managerRepository;

    @Override
    public List<Manager> getAllManager() {
        return managerRepository.findAll();
    }

    @Override
    public Manager getManagerById(Long id) {
        return managerRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(Manager.class.getName(), id));
    }

    @Override
    public Manager getManagerByName(String name) {
        return managerRepository.findByName(name).orElseThrow(() -> new ObjectNotFoundException(Manager.class.getName(), name));
    }

    @Override
    public void saveManager(Manager manager) {
        if (managerRepository.findAll().contains(manager))
            throw new ObjectAlreadyExistsException(Manager.class.getSimpleName(),manager.getName());
        managerRepository.save(manager);
    }

    @Override
    public void deleteManager(Long id) {
        if (managerRepository.findById(id).isEmpty())
            throw new ObjectNotFoundException(Manager.class.getSimpleName(),id);
        managerRepository.deleteById(id);
    }

    @Override
    public void updateManager(Long id, Manager manager) {
        if (managerRepository.findById(id).isEmpty())
            throw new ObjectNotFoundException(Manager.class.getSimpleName(),id);
        managerRepository.save(manager);
    }
}
