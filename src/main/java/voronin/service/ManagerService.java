package voronin.service;

import voronin.exception.ObjectAlreadyExistsException;
import voronin.model.Manager;

import java.util.List;

public interface ManagerService {

    List<Manager> getAllManager();

    Manager getManagerById(Long id);
    Manager getManagerByName(String name);

    void saveManager(Manager manager);
    void deleteManager(Long id);
    void updateManager(Long id, Manager manager);
}
