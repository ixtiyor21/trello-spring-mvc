package uz.ixtiyor21.trello_magic.validator.role;

import org.springframework.stereotype.Component;
import uz.ixtiyor21.trello_magic.dto.role.RoleCreateDto;
import uz.ixtiyor21.trello_magic.dto.role.RoleUpdateDto;
import uz.ixtiyor21.trello_magic.utils.BaseUtils;
import uz.ixtiyor21.trello_magic.validator.AbstractValidator;

import javax.xml.bind.ValidationException;

@Component
public class RoleValidator extends AbstractValidator<RoleCreateDto, RoleUpdateDto, Long> {
    protected RoleValidator(BaseUtils baseUtils) {
        super(baseUtils);
    }

    @Override
    public void validateKey(Long id) throws ValidationException {

    }

    @Override
    public void validateOnCreate(RoleCreateDto roleCreateDto) throws ValidationException {

    }

    @Override
    public void validateOnUpdate(RoleUpdateDto roleUpdateDto) throws ValidationException {

    }
}
