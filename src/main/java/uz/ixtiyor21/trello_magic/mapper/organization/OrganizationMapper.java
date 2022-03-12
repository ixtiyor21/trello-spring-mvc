package uz.ixtiyor21.trello_magic.mapper.organization;

import org.springframework.stereotype.Component;
import uz.ixtiyor21.trello_magic.dto.org.OrganizationCreateDto;
import uz.ixtiyor21.trello_magic.dto.org.OrganizationDto;
import uz.ixtiyor21.trello_magic.dto.org.OrganizationUpdateDto;
import uz.ixtiyor21.trello_magic.entity.org.Organization;
import uz.ixtiyor21.trello_magic.mapper.BaseMapper;

import java.util.List;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 12.03.2022 11:17
 * Project : Trello_magic
 */
@Component
public class OrganizationMapper implements BaseMapper<Organization, OrganizationDto, OrganizationCreateDto, OrganizationUpdateDto> {
    @Override
    public OrganizationDto toDto(Organization organization) {
        return OrganizationDto.builder()
                .id(organization.getId())
                .name(organization.getName())
                .description(organization.getDescription())
                .email(organization.getEmail())
                .logo_path(organization.getLogo_path())
                .build();
    }

    @Override
    public List<OrganizationDto> toDto(List<Organization> e) {
        return null;
    }

    @Override
    public Organization fromCreateDto(OrganizationCreateDto organizationCreateDto) {
        return Organization.builder()
                .name(organizationCreateDto.getName())
                .email(organizationCreateDto.getEmail())
                .description(organizationCreateDto.getDescription())
                .build();
    }

    @Override
    public Organization fromUpdateDto(OrganizationUpdateDto organizationUpdateDto) {
        return null;
    }
}
