package uz.ixtiyor21.trello_magic.repository.task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.ixtiyor21.trello_magic.entity.task.Task;
import uz.ixtiyor21.trello_magic.repository.AbstractRepository;

import javax.transaction.Transactional;
import java.time.Instant;

public interface TaskRepository extends JpaRepository<Task, Long>, AbstractRepository {
    @Modifying
    @Transactional
    @Query(value = "update simple_todo.etm.task set column_id =:column_id, updated_at =:updated_at, updated_by =:updated_by where id =:id", nativeQuery = true)
    void updateColumn(@Param("column_id") Long column_id, @Param("updated_at") Instant updated_at, @Param("updated_by") Long updated_by, @Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "update simple_todo.etm.task set level =:level, updated_at =:updated_at, updated_by =:updated_by where id =:id", nativeQuery = true)
    void updateLevel(@Param("level") String level, @Param("updated_at") Instant updated_at, @Param("updated_by") Long updated_by, @Param("id") Long id);
}
