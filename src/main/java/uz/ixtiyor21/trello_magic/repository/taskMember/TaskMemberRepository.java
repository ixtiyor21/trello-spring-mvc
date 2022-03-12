package uz.ixtiyor21.trello_magic.repository.taskMember;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.ixtiyor21.trello_magic.entity.task.TaskMember;
import uz.ixtiyor21.trello_magic.repository.AbstractRepository;

public interface TaskMemberRepository extends JpaRepository<TaskMember, Long>, AbstractRepository {
}
