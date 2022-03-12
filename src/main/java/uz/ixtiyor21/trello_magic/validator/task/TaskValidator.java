package uz.ixtiyor21.trello_magic.validator.task;

import org.springframework.stereotype.Component;
import uz.ixtiyor21.trello_magic.dto.task.TaskCreateDto;
import uz.ixtiyor21.trello_magic.dto.task.TaskUpdateDto;
import uz.ixtiyor21.trello_magic.utils.BaseUtils;
import uz.ixtiyor21.trello_magic.validator.AbstractValidator;

import javax.xml.bind.ValidationException;

@Component
public class TaskValidator extends AbstractValidator<TaskCreateDto, TaskUpdateDto, Long> {
    protected TaskValidator(BaseUtils baseUtils) {
        super(baseUtils);
    }

    @Override
    public void validateKey(Long id) throws ValidationException {

    }

    @Override
    public void validateOnCreate(TaskCreateDto taskCreateDto) throws ValidationException {

    }

    @Override
    public void validateOnUpdate(TaskUpdateDto taskUpdateDto) throws ValidationException {

    }
}
