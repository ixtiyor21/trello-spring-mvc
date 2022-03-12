package uz.ixtiyor21.trello_magic.validator.project;

import org.springframework.stereotype.Component;
import uz.ixtiyor21.trello_magic.dto.project.ProjectCreateDto;
import uz.ixtiyor21.trello_magic.dto.project.ProjectUpdateDto;
import uz.ixtiyor21.trello_magic.utils.BaseUtils;
import uz.ixtiyor21.trello_magic.validator.AbstractValidator;

import javax.xml.bind.ValidationException;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 12.03.2022 12:00
 * Project : Trello_magic
 */
@Component
public class ProjectValidator extends AbstractValidator<ProjectCreateDto, ProjectUpdateDto,Long> {

    protected ProjectValidator(BaseUtils baseUtils) {
        super(baseUtils);
    }

    @Override
    public void validateKey(Long id) throws ValidationException {

    }

    @Override
    public void validateOnCreate(ProjectCreateDto projectCreateDto) throws ValidationException {

    }

    @Override
    public void validateOnUpdate(ProjectUpdateDto projectUpdateDto) throws ValidationException {

    }
}
