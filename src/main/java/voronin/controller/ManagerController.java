package voronin.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Manager>> findAllManager () {
        return ResponseEntity.ok(managerService.getAllManager());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Manager> findManagerById (@PathVariable Long id) {
        return ResponseEntity.ok(managerService.getManagerById(id));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Manager>> findManagerByName (@PathVariable String name) {
        return ResponseEntity.ok(managerService.getManagerByName(name));
    }

    @PostMapping
    public ResponseEntity<List<Manager>> saveManager (@RequestBody Manager manager) {
        managerService.saveManager(manager);
        return findAllManager();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<Manager>> deleteManager (@PathVariable Long id) {
        managerService.deleteManager(id);
        return findAllManager();
    }

    @PutMapping("/{id}")
    public ResponseEntity<List<Manager>> updateManager (@PathVariable Long id, @RequestBody Manager manager) {
        managerService.updateManager(id, manager);
        return findAllManager();
    }
}
