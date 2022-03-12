package uz.ixtiyor21.trello_magic.validator.org;

import org.springframework.stereotype.Component;
import uz.ixtiyor21.trello_magic.dto.org.OrganizationCreateDto;
import uz.ixtiyor21.trello_magic.dto.org.OrganizationUpdateDto;
import uz.ixtiyor21.trello_magic.utils.BaseUtils;
import uz.ixtiyor21.trello_magic.validator.AbstractValidator;

import javax.xml.bind.ValidationException;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 12.03.2022 11:34
 * Project : Trello_magic
 */
@Component
public class OrganizationValidator extends AbstractValidator<OrganizationCreateDto, OrganizationUpdateDto,Long> {

    protected OrganizationValidator(BaseUtils baseUtils) {
        super(baseUtils);
    }

    @Override
    public void validateKey(Long id) throws ValidationException {

    }

    @Override
    public void validateOnCreate(OrganizationCreateDto organizationCreateDto) throws ValidationException {

    }

    @Override
    public void validateOnUpdate(OrganizationUpdateDto organizationUpdateDto) throws ValidationException {

    }
}
