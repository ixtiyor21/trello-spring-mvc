package uz.ixtiyor21.trello_magic.repository.organization;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.ixtiyor21.trello_magic.entity.org.Organization;
import uz.ixtiyor21.trello_magic.repository.AbstractRepository;

import javax.transaction.Transactional;
import java.time.Instant;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 12.03.2022 11:15
 * Project : Trello_magic
 */
public interface OrganizationRepository extends JpaRepository<Organization,Long>, AbstractRepository {

    Organization findByName(String name);

    @Modifying
    @Transactional
    @Query(value = "update simple_todo.etm.organization set name =:name, description =:description, email =:email, updated_at =:updated_at, logo_path =:logo_path where id =:id", nativeQuery = true)
    void updateById(@Param("name") String name, @Param("description") String description, @Param("email") String email, @Param("updated_at") Instant updated_at, @Param("logo_path") String logo_path, @Param("id") Long id);

}
