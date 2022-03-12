package uz.ixtiyor21.trello_magic.validator;

import uz.ixtiyor21.trello_magic.utils.BaseUtils;

import javax.xml.bind.ValidationException;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 12.03.2022 10:18
 * Project : Trello_magic
 */
public abstract class AbstractValidator<CD,UD,K> implements Validator{

    protected final BaseUtils baseUtils;

    protected AbstractValidator(BaseUtils baseUtils) {
        this.baseUtils = baseUtils;
    }

    public abstract void validateKey(K id) throws ValidationException;

    public abstract void validateOnCreate(CD cd) throws ValidationException;

    public abstract void validateOnUpdate(UD ud) throws ValidationException;
}
