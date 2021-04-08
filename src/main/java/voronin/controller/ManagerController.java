package voronin.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import voronin.model.AdministrativeTerritorialUnit;
import voronin.model.Manager;
import voronin.service.ManagerService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("Manager")
public class ManagerController {

    private final ManagerService managerService;

    @GetMapping("/")
    public List<Manager> findAllManager () {
        return managerService.getAllManager();
    }

    @GetMapping("/{id}")
    public Manager findManagerById (@PathVariable Long id) {
        return managerService.getManagerById(id);
    }

    @GetMapping("/name/{name}")
    public Manager findManagerById (@PathVariable String name) {
        return managerService.getManagerByName(name);
    }

    @PostMapping
    public List<Manager> saveManager (@RequestBody Manager manager) {
        managerService.saveManager(manager);
        return findAllManager();
    }

    @DeleteMapping("/{id}")
    public List<Manager> deleteManager (@PathVariable Long id) {
        managerService.deleteManager(id);
        return findAllManager();
    }

    @PutMapping("/{id}")
    public List<Manager> updateManager (@PathVariable Long id, @RequestBody Manager manager) {
        managerService.updateManager(id, manager);
        return findAllManager();
    }
}
