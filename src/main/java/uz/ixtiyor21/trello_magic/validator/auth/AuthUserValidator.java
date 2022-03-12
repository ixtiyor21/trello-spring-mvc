package uz.ixtiyor21.trello_magic.validator.auth;

import org.springframework.stereotype.Component;
import uz.ixtiyor21.trello_magic.dto.auth.AuthUserCreateDto;
import uz.ixtiyor21.trello_magic.dto.auth.AuthUserUpdateDto;
import uz.ixtiyor21.trello_magic.utils.BaseUtils;
import uz.ixtiyor21.trello_magic.validator.AbstractValidator;

import javax.xml.bind.ValidationException;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 12.03.2022 10:21
 * Project : Trello_magic
 */
@Component
public class AuthUserValidator extends AbstractValidator<AuthUserCreateDto, AuthUserUpdateDto,Long> {

    protected AuthUserValidator(BaseUtils baseUtils) {
        super(baseUtils);
    }

    @Override
    public void validateKey(Long id) throws ValidationException {

    }

    @Override
    public void validateOnCreate(AuthUserCreateDto authUserCreateDto) throws ValidationException {

    }

    @Override
    public void validateOnUpdate(AuthUserUpdateDto authUserUpdateDto) throws ValidationException {

    }
}
