package voronin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import voronin.model.RoleUser;
import voronin.model.User;

@Repository
public interface RoleRepository extends JpaRepository<RoleUser, Long> {

}
