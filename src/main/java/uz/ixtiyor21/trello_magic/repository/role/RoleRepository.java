package uz.ixtiyor21.trello_magic.repository.role;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.ixtiyor21.trello_magic.entity.role.Role;
import uz.ixtiyor21.trello_magic.repository.AbstractRepository;

public interface RoleRepository extends JpaRepository<Role, Long>, AbstractRepository {
}
