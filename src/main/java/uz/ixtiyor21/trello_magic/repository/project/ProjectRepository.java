package uz.ixtiyor21.trello_magic.repository.project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.ixtiyor21.trello_magic.entity.project.Project;
import uz.ixtiyor21.trello_magic.repository.AbstractRepository;

import javax.transaction.Transactional;
import java.time.Instant;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 12.03.2022 11:57
 * Project : Trello_magic
 */
public interface ProjectRepository extends JpaRepository<Project,Long>, AbstractRepository {
    @Modifying
    @Transactional
    @Query(value = "update simple_todo.etm.project set name =:name, closed =:closed, updated_at =:updated_at, updated_by =:updated_by where id =:id", nativeQuery = true)
    void updateById(@Param("name") String name, @Param("closed") Boolean closed, @Param("updated_at") Instant updated_at, @Param("updated_by") Long updated_by, @Param("id") Long id);

}
