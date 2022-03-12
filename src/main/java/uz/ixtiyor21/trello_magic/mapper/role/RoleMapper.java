package uz.ixtiyor21.trello_magic.mapper.role;

import org.springframework.stereotype.Component;
import uz.ixtiyor21.trello_magic.dto.role.RoleCreateDto;
import uz.ixtiyor21.trello_magic.dto.role.RoleDto;
import uz.ixtiyor21.trello_magic.dto.role.RoleUpdateDto;
import uz.ixtiyor21.trello_magic.entity.role.Role;
import uz.ixtiyor21.trello_magic.mapper.BaseMapper;

import java.util.List;

@Component
public class RoleMapper implements BaseMapper<Role, RoleDto, RoleCreateDto, RoleUpdateDto> {
    @Override
    public RoleDto toDto(Role role) {
        return null;
    }

    @Override
    public List<RoleDto> toDto(List<Role> e) {
        return null;
    }

    @Override
    public Role fromCreateDto(RoleCreateDto roleCreateDto) {
        return null;
    }

    @Override
    public Role fromUpdateDto(RoleUpdateDto roleUpdateDto) {
        return null;
    }
}
