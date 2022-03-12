package uz.ixtiyor21.trello_magic.repository.taskComment;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.ixtiyor21.trello_magic.entity.task.TaskComment;
import uz.ixtiyor21.trello_magic.repository.AbstractRepository;

public interface TaskCommentRepository extends JpaRepository<TaskComment, Long>, AbstractRepository {
}