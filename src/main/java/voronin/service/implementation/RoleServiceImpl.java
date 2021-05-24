package voronin.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import voronin.exception.ObjectAlreadyExistsException;
import voronin.exception.ObjectNotFoundException;
import voronin.model.RoleUser;
import voronin.repository.RoleRepository;
import voronin.service.RoleService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public List<RoleUser> getAllRole() {
        return roleRepository.findAll();
    }

    @Override
    public RoleUser getRoleById(Long id) {
        return roleRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(RoleUser.class.getName(), id));
    }


    @Override
    public RoleUser saveRole(RoleUser role) {
        if (roleRepository.findAll().contains(role))
            throw new ObjectAlreadyExistsException(RoleUser.class.getSimpleName(),role.getName());
        return roleRepository.save(role);
    }

    @Override
    public void deleteRole(Long id) {
        if (roleRepository.findById(id).isEmpty())
            throw new ObjectNotFoundException(RoleUser.class.getSimpleName(),id);
        roleRepository.deleteById(id);
    }

    @Override
    public void updateRole(Long id, RoleUser role) {
        if (roleRepository.findById(id).isEmpty())
            throw new ObjectNotFoundException(RoleUser.class.getSimpleName(),id);

        role.setIdRole(id);
        roleRepository.save(role);
    }
}
