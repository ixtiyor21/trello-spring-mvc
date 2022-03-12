package uz.ixtiyor21.trello_magic.service.role;

import org.springframework.stereotype.Service;
import uz.ixtiyor21.trello_magic.entity.role.Role;
import uz.ixtiyor21.trello_magic.mapper.role.RoleMapper;
import uz.ixtiyor21.trello_magic.repository.role.RoleRepository;
import uz.ixtiyor21.trello_magic.service.AbstractService;
import uz.ixtiyor21.trello_magic.utils.BaseUtils;
import uz.ixtiyor21.trello_magic.validator.role.RoleValidator;

import java.util.List;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 12.03.2022 9:43
 * Project : Trello_magic
 */
@Service
public class RoleService extends AbstractService<RoleRepository, RoleMapper, RoleValidator> {


    protected RoleService(RoleRepository repository, RoleMapper mapper, RoleValidator validator, BaseUtils baseUtils) {
        super(repository, mapper, validator, baseUtils);
    }

    public Role getByCode(String code) {
        List<Role> all=repository.findAll();
        for (Role role : all) {
            if(role.getCode().equals(code))
                return role;
        }
        return null;
    }
}
