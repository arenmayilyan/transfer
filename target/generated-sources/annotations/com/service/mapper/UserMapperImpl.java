package com.service.mapper;

import com.model.domain.entity.ShoppingCartEntity;
import com.model.domain.entity.UserEntity;
import com.model.domain.entity.RoleEntity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-04-14T18:26:07+0400",
    comments = "version: 1.3.0.Beta2, compiler: javac, environment: Java 1.8.0_211 (Oracle Corporation)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public Iterable<UserEntity> dtoListToEntityList(Iterable<UserDto> dto) {
        if ( dto == null ) {
            return null;
        }

        ArrayList<UserEntity> iterable = new ArrayList<UserEntity>();
        for ( UserDto userDto : dto ) {
            iterable.add( dtoToEntity( userDto ) );
        }

        return iterable;
    }

    @Override
    public UserEntity dtoToEntity(UserDto dto) {
        if ( dto == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setId( dto.getId() );
        userEntity.setName( dto.getName() );
        userEntity.setSurname( dto.getSurname() );
        userEntity.setEmail( dto.getEmail() );
        userEntity.setPassword( dto.getPassword() );
        Set<ShoppingCartEntity> set = dto.getItems();
        if ( set != null ) {
            userEntity.setItems( new HashSet<ShoppingCartEntity>( set ) );
        }
        Set<RoleEntity> set1 = dto.getRoles();
        if ( set1 != null ) {
            userEntity.setRoles( new HashSet<RoleEntity>( set1 ) );
        }

        return userEntity;
    }

    @Override
    public Iterable<UserDto> entityListToDtoList(Iterable<UserEntity> entity) {
        if ( entity == null ) {
            return null;
        }

        ArrayList<UserDto> iterable = new ArrayList<UserDto>();
        for ( UserEntity userEntity : entity ) {
            iterable.add( entityToDto( userEntity ) );
        }

        return iterable;
    }

    @Override
    public UserDto entityToDto(UserEntity entity) {
        if ( entity == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId( entity.getId() );
        userDto.setName( entity.getName() );
        userDto.setSurname( entity.getSurname() );
        userDto.setEmail( entity.getEmail() );
        userDto.setPassword( entity.getPassword() );
        Set<ShoppingCartEntity> set = entity.getItems();
        if ( set != null ) {
            userDto.setItems( new HashSet<ShoppingCartEntity>( set ) );
        }
        Set<RoleEntity> set1 = entity.getRoles();
        if ( set1 != null ) {
            userDto.setRoles( new HashSet<RoleEntity>( set1 ) );
        }

        return userDto;
    }
}
