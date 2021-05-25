package voronin.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<RoleUser>> findAllRoles() {
        return ResponseEntity.ok(roleService.getAllRole());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleUser> findRoleById(@PathVariable Long id) {
        return ResponseEntity.ok(roleService.getRoleById(id));
    }

    @PostMapping
    public RoleUser saveRole(@RequestBody RoleUser role) {
        return roleService.saveRole(role);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<RoleUser>> deleteRole(@PathVariable Long id) {
        roleService.deleteRole(id);
        return findAllRoles();
    }

    @PutMapping("/{id}")
    public ResponseEntity<List<RoleUser>> updateRole(@PathVariable Long id, @RequestBody RoleUser role) {
        roleService.updateRole(id, role);
        return findAllRoles();
    }
}
