package uz.ixtiyor21.trello_magic.controller;

import uz.ixtiyor21.trello_magic.service.BaseService;

public abstract class AbstractController<S extends BaseService> {
    protected final S service;

    public AbstractController(S service) {
        this.service = service;
    }
}
