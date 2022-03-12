package uz.ixtiyor21.trello_magic.mapper.auth;

import org.springframework.stereotype.Component;
import uz.ixtiyor21.trello_magic.dto.auth.AuthUserCreateDto;
import uz.ixtiyor21.trello_magic.dto.auth.AuthUserDto;
import uz.ixtiyor21.trello_magic.dto.auth.AuthUserUpdateDto;
import uz.ixtiyor21.trello_magic.entity.auth.AuthUser;
import uz.ixtiyor21.trello_magic.mapper.BaseMapper;

import java.util.List;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 12.03.2022 9:53
 * Project : Trello_magic
 */
@Component
public class AuthUserMapper implements BaseMapper<AuthUser, AuthUserDto, AuthUserCreateDto, AuthUserUpdateDto> {

    @Override
    public AuthUserDto toDto(AuthUser authUser) {
        return null;
    }

    @Override
    public List<AuthUserDto> toDto(List<AuthUser> e) {
        return null;
    }

    @Override
    public AuthUser fromCreateDto(AuthUserCreateDto authUserCreateDto) {
        return AuthUser.builder()
                .email(authUserCreateDto.getEmail())
                .username(authUserCreateDto.getUsername())
                .firstName(authUserCreateDto.getFirstName())
                .lastName(authUserCreateDto.getLastName())
                .lang(authUserCreateDto.getLang())
                .build();
    }

    @Override
    public AuthUser fromUpdateDto(AuthUserUpdateDto authUserUpdateDto) {
        return null;
    }
}
