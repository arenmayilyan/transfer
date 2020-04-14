package com.service.mapper;

import com.model.domain.entity.RoleEntity;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-04-14T18:26:07+0400",
    comments = "version: 1.3.0.Beta2, compiler: javac, environment: Java 1.8.0_211 (Oracle Corporation)"
)
public class RoleMapperImpl implements RoleMapper {

    @Override
    public RoleEntity dtoToEntity(RoleDto dto) {
        if ( dto == null ) {
            return null;
        }

        RoleEntity roleEntity = new RoleEntity();

        roleEntity.setId( dto.getId() );
        roleEntity.setName( dto.getName() );

        return roleEntity;
    }

    @Override
    public RoleDto entityToDto(RoleEntity entity) {
        if ( entity == null ) {
            return null;
        }

        RoleDto roleDto = new RoleDto();

        roleDto.setId( entity.getId() );
        roleDto.setName( entity.getName() );

        return roleDto;
    }
}
