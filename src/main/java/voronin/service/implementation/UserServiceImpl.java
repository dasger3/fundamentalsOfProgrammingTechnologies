package voronin.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import voronin.exception.ObjectAlreadyExistsException;
import voronin.exception.ObjectNotFoundException;
import voronin.model.RoleUser;
import voronin.model.User;
import voronin.repository.RoleRepository;
import voronin.repository.UserRepository;
import voronin.service.UserService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(User.class.getName(), id));
    }


    @Override
    public void saveUser(User user) {
        if (userRepository.findAll().contains(user))
            throw new ObjectAlreadyExistsException(User.class.getSimpleName(),user.getName());
        if(user.getRole() == null)
            user.setRole(roleRepository.findById(1L).orElseThrow(() -> new ObjectNotFoundException(RoleUser.class.getName(), 1L)));
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        if (userRepository.findById(id).isEmpty())
            throw new ObjectNotFoundException(User.class.getSimpleName(),id);
        userRepository.deleteById(id);
    }

    @Override
    public void updateUser(Long id, User user) {
        if (userRepository.findById(id).isEmpty())
            throw new ObjectNotFoundException(User.class.getSimpleName(),id);
        user.setId(id);
        userRepository.save(user);
    }

    @Override
    public void addRoleId(Long id, Long idRole) {
        User user = userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(User.class.getName(), id));
        RoleUser role = roleRepository.findById(idRole).orElseThrow(() -> new ObjectNotFoundException(RoleUser.class.getName(), idRole));
        user.setRole(role);
        userRepository.save(user);
    }


}
