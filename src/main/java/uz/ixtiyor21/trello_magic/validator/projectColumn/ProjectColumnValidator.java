package uz.ixtiyor21.trello_magic.validator.projectColumn;

import org.springframework.stereotype.Component;
import uz.ixtiyor21.trello_magic.dto.projectColumn.ProjectColumnCreateDto;
import uz.ixtiyor21.trello_magic.dto.projectColumn.ProjectColumnUpdateDto;
import uz.ixtiyor21.trello_magic.utils.BaseUtils;
import uz.ixtiyor21.trello_magic.validator.AbstractValidator;

import javax.xml.bind.ValidationException;

@Component
public class ProjectColumnValidator extends AbstractValidator<ProjectColumnCreateDto, ProjectColumnUpdateDto, Long> {

    protected ProjectColumnValidator(BaseUtils baseUtils) {
        super(baseUtils);
    }

    @Override
    public void validateKey(Long id) throws ValidationException {

    }

    @Override
    public void validateOnCreate(ProjectColumnCreateDto projectColumnCreateDto) throws ValidationException {

    }

    @Override
    public void validateOnUpdate(ProjectColumnUpdateDto projectColumnUpdateDto) throws ValidationException {

    }
}
