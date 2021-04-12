package voronin.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import voronin.exception.ObjectAlreadyExistsException;
import voronin.exception.ObjectNotFoundException;
import voronin.model.User;
import voronin.repository.UserRepository;
import voronin.service.UserService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository UserRepository;

    @Override
    public List<User> getAllUser() {
        return UserRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return UserRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(User.class.getName(), id));
    }


    @Override
    public void saveUser(User user) {
        if (UserRepository.findAll().contains(user))
            throw new ObjectAlreadyExistsException(User.class.getSimpleName(),user.getName());
        UserRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        if (UserRepository.findById(id).isEmpty())
            throw new ObjectNotFoundException(User.class.getSimpleName(),id);
        UserRepository.deleteById(id);
    }

    @Override
    public void updateUser(Long id, User user) {
        if (UserRepository.findById(id).isEmpty())
            throw new ObjectNotFoundException(User.class.getSimpleName(),id);
        user.setId(id);
        UserRepository.save(user);
    }
}
