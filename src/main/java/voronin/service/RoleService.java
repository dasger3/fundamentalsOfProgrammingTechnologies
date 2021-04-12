package voronin.service;

import voronin.model.RoleUser;
import voronin.model.User;

import java.util.List;

public interface RoleService {

    List<RoleUser> getAllRole();

    RoleUser getRoleById(Long id);

    void saveRole(RoleUser user);
    void deleteRole(Long id);
    void updateRole(Long id, RoleUser roleUser);
}
