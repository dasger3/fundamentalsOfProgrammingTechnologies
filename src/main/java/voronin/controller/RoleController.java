package voronin.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import voronin.model.RoleUser;
import voronin.service.RoleService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("Role")
public class RoleController {

    private final RoleService roleService;

    @GetMapping("/")
    public List<RoleUser> findAllRoles() {
        return roleService.getAllRole();
    }

    @GetMapping("/{id}")
    public RoleUser findRoleById(@PathVariable Long id) {
        return roleService.getRoleById(id);
    }

    @PostMapping
    public List<RoleUser> saveRole(@RequestBody RoleUser role) {
        roleService.saveRole(role);
        return findAllRoles();
    }

    @DeleteMapping("/{id}")
    public List<RoleUser> deleteRole(@PathVariable Long id) {
        roleService.deleteRole(id);
        return findAllRoles();
    }

    @PutMapping("/{id}")
    public List<RoleUser> updateRole(@PathVariable Long id, @RequestBody RoleUser role) {
        roleService.updateRole(id, role);
        return findAllRoles();
    }
}
