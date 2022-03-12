package uz.ixtiyor21.trello_magic.repository.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uz.ixtiyor21.trello_magic.entity.auth.AuthUser;
import uz.ixtiyor21.trello_magic.repository.AbstractRepository;

import java.time.Instant;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 05.03.2022 23:01
 * Project : Trello_magic
 */

public interface AuthUserRepository extends JpaRepository<AuthUser,Long>, AbstractRepository {
    AuthUser findAuthUserByUsername(String username);

    @Modifying
    @Transactional
    @Query(value = "update simple_todo.etm.auth_user set first_name =:firstName, last_name =:lastName, username =:username, email =:email, updated_at =:updated_at, updated_by =:updated_by, lang =:lang, image_path =:image_path where id =:id", nativeQuery = true)
    void updateById(@Param("firstName") String firstName, @Param("lastName") String lastName, @Param("username") String username, @Param("email") String email, @Param("updated_at") Instant updated_at, @Param("updated_by") Long updated_by, @Param("lang") String lang, @Param("image_path") String image_path, @Param("id") Long id);

}
