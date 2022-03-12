package uz.ixtiyor21.trello_magic.repository.project_member;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.ixtiyor21.trello_magic.entity.project.ProjectMember;
import uz.ixtiyor21.trello_magic.repository.AbstractRepository;

public interface ProjectMemberRepository extends JpaRepository<ProjectMember, Long>, AbstractRepository {
}
