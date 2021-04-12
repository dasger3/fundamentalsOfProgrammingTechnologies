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

    private final RoleRepository RoleRepository;

    @Override
    public List<RoleUser> getAllRole() {
        return RoleRepository.findAll();
    }

    @Override
    public RoleUser getRoleById(Long id) {
        return RoleRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(RoleUser.class.getName(), id));
    }


    @Override
    public void saveRole(RoleUser role) {
        if (RoleRepository.findAll().contains(role))
            throw new ObjectAlreadyExistsException(RoleUser.class.getSimpleName(),role.getName());
        RoleRepository.save(role);
    }

    @Override
    public void deleteRole(Long id) {
        if (RoleRepository.findById(id).isEmpty())
            throw new ObjectNotFoundException(RoleUser.class.getSimpleName(),id);
        RoleRepository.deleteById(id);
    }

    @Override
    public void updateRole(Long id, RoleUser role) {
        if (RoleRepository.findById(id).isEmpty())
            throw new ObjectNotFoundException(RoleUser.class.getSimpleName(),id);
        role.setIdRole(id);
        RoleRepository.save(role);
    }
}
