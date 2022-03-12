package uz.ixtiyor21.trello_magic.validator.projectMember;

import org.springframework.stereotype.Component;
import uz.ixtiyor21.trello_magic.dto.projectMember.ProjectMemberCreateDto;
import uz.ixtiyor21.trello_magic.dto.projectMember.ProjectMemberUpdateDto;
import uz.ixtiyor21.trello_magic.utils.BaseUtils;
import uz.ixtiyor21.trello_magic.validator.AbstractValidator;

import javax.xml.bind.ValidationException;

@Component
public class ProjectMemberValidator extends AbstractValidator<ProjectMemberCreateDto, ProjectMemberUpdateDto, Long> {
    protected ProjectMemberValidator(BaseUtils baseUtils) {
        super(baseUtils);
    }

    @Override
    public void validateKey(Long id) throws ValidationException {

    }

    @Override
    public void validateOnCreate(ProjectMemberCreateDto projectMemberCreateDto) throws ValidationException {

    }

    @Override
    public void validateOnUpdate(ProjectMemberUpdateDto projectMemberUpdateDto) throws ValidationException {

    }
}
