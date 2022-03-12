package uz.ixtiyor21.trello_magic.repository.project;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.ixtiyor21.trello_magic.entity.project.ProjectColumn;
import uz.ixtiyor21.trello_magic.repository.AbstractRepository;

public interface ProjectColumnRepository extends JpaRepository<ProjectColumn, Long>, AbstractRepository {
}
