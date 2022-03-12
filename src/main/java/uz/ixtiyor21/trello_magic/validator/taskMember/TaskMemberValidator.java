package uz.ixtiyor21.trello_magic.validator.taskMember;

import org.springframework.stereotype.Component;
import uz.ixtiyor21.trello_magic.dto.taskMember.TaskMemberCreateDto;
import uz.ixtiyor21.trello_magic.dto.taskMember.TaskMemberUpdateDto;
import uz.ixtiyor21.trello_magic.utils.BaseUtils;
import uz.ixtiyor21.trello_magic.validator.AbstractValidator;

import javax.xml.bind.ValidationException;

@Component
public class TaskMemberValidator extends AbstractValidator<TaskMemberCreateDto, TaskMemberUpdateDto, Long> {
    protected TaskMemberValidator(BaseUtils baseUtils) {
        super(baseUtils);
    }

    @Override
    public void validateKey(Long id) throws ValidationException {

    }

    @Override
    public void validateOnCreate(TaskMemberCreateDto taskMemberCreateDto) throws ValidationException {

    }

    @Override
    public void validateOnUpdate(TaskMemberUpdateDto taskMemberUpdateDto) throws ValidationException {

    }
}
