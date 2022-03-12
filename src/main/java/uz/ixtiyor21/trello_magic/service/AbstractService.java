package uz.ixtiyor21.trello_magic.service;

import uz.ixtiyor21.trello_magic.mapper.Mapper;
import uz.ixtiyor21.trello_magic.repository.AbstractRepository;
import uz.ixtiyor21.trello_magic.utils.BaseUtils;
import uz.ixtiyor21.trello_magic.validator.Validator;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 12.03.2022 9:44
 * Project : Trello_magic
 */
public abstract class AbstractService<R extends AbstractRepository,M extends Mapper,V extends Validator> {
    protected final R repository;
    protected final M mapper;
    protected final V validator;
    protected final BaseUtils baseUtils;

    protected AbstractService(R repository, M mapper, V validator, BaseUtils baseUtils) {
        this.repository = repository;
        this.mapper = mapper;
        this.validator = validator;
        this.baseUtils = baseUtils;
    }
}
