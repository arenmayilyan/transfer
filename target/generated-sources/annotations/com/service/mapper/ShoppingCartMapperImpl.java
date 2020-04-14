package com.service.mapper;

import com.model.domain.entity.CartItemEntity;
import com.model.domain.entity.ProductEntity;
import com.model.domain.entity.RoleEntity;
import com.model.domain.entity.ShoppingCartEntity;
import com.model.domain.entity.UserEntity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-04-14T18:26:07+0400",
    comments = "version: 1.3.0.Beta2, compiler: javac, environment: Java 1.8.0_211 (Oracle Corporation)"
)
public class ShoppingCartMapperImpl implements ShoppingCartMapper {

    @Override
    public ShoppingCartEntity dtoToEntity(ShoppingCartDto dto) {
        if ( dto == null ) {
            return null;
        }

        ShoppingCartEntity shoppingCartEntity = new ShoppingCartEntity();

        shoppingCartEntity.setId( dto.getId() );
        shoppingCartEntity.setUser( userDtoToUserEntity( dto.getUser() ) );
        shoppingCartEntity.setCartItem( cartItemDtoToCartItemEntity( dto.getCartItem() ) );

        return shoppingCartEntity;
    }

    @Override
    public Iterable<ShoppingCartEntity> dtoListToEntityList(Iterable<ShoppingCartDto> dto) {
        if ( dto == null ) {
            return null;
        }

        ArrayList<ShoppingCartEntity> iterable = new ArrayList<ShoppingCartEntity>();
        for ( ShoppingCartDto shoppingCartDto : dto ) {
            iterable.add( dtoToEntity( shoppingCartDto ) );
        }

        return iterable;
    }

    @Override
    public ShoppingCartDto entityToDto(ShoppingCartEntity entity) {
        if ( entity == null ) {
            return null;
        }

        ShoppingCartDto shoppingCartDto = new ShoppingCartDto();

        shoppingCartDto.setId( entity.getId() );
        shoppingCartDto.setUser( userEntityToUserDto( entity.getUser() ) );
        shoppingCartDto.setCartItem( cartItemEntityToCartItemDto( entity.getCartItem() ) );

        return shoppingCartDto;
    }

    @Override
    public Iterable<ShoppingCartDto> entityListToDtoList(Iterable<ShoppingCartEntity> entity) {
        if ( entity == null ) {
            return null;
        }

        ArrayList<ShoppingCartDto> iterable = new ArrayList<ShoppingCartDto>();
        for ( ShoppingCartEntity shoppingCartEntity : entity ) {
            iterable.add( entityToDto( shoppingCartEntity ) );
        }

        return iterable;
    }

    protected UserEntity userDtoToUserEntity(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setId( userDto.getId() );
        userEntity.setName( userDto.getName() );
        userEntity.setSurname( userDto.getSurname() );
        userEntity.setEmail( userDto.getEmail() );
        userEntity.setPassword( userDto.getPassword() );
        Set<ShoppingCartEntity> set = userDto.getItems();
        if ( set != null ) {
            userEntity.setItems( new HashSet<ShoppingCartEntity>( set ) );
        }
        Set<RoleEntity> set1 = userDto.getRoles();
        if ( set1 != null ) {
            userEntity.setRoles( new HashSet<RoleEntity>( set1 ) );
        }

        return userEntity;
    }

    protected ProductEntity productDtoToProductEntity(ProductDto productDto) {
        if ( productDto == null ) {
            return null;
        }

        ProductEntity productEntity = new ProductEntity();

        productEntity.setId( productDto.getId() );
        productEntity.setName( productDto.getName() );
        productEntity.setType( productDto.getType() );
        productEntity.setPrice( productDto.getPrice() );
        productEntity.setCreatedDate( productDto.getCreatedDate() );
        productEntity.setUpdatedDate( productDto.getUpdatedDate() );
        productEntity.setCountInStock( productDto.getCountInStock() );

        return productEntity;
    }

    protected CartItemEntity cartItemDtoToCartItemEntity(CartItemDto cartItemDto) {
        if ( cartItemDto == null ) {
            return null;
        }

        CartItemEntity cartItemEntity = new CartItemEntity();

        cartItemEntity.setId( cartItemDto.getId() );
        cartItemEntity.setQuantity( cartItemDto.getQuantity() );
        cartItemEntity.setStatus( cartItemDto.getStatus() );
        cartItemEntity.setProduct( productDtoToProductEntity( cartItemDto.getProduct() ) );
        cartItemEntity.setShoppingCart( dtoToEntity( cartItemDto.getShoppingCart() ) );

        return cartItemEntity;
    }

    protected UserDto userEntityToUserDto(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId( userEntity.getId() );
        userDto.setName( userEntity.getName() );
        userDto.setSurname( userEntity.getSurname() );
        userDto.setEmail( userEntity.getEmail() );
        userDto.setPassword( userEntity.getPassword() );
        Set<ShoppingCartEntity> set = userEntity.getItems();
        if ( set != null ) {
            userDto.setItems( new HashSet<ShoppingCartEntity>( set ) );
        }
        Set<RoleEntity> set1 = userEntity.getRoles();
        if ( set1 != null ) {
            userDto.setRoles( new HashSet<RoleEntity>( set1 ) );
        }

        return userDto;
    }

    protected ProductDto productEntityToProductDto(ProductEntity productEntity) {
        if ( productEntity == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        productDto.setId( productEntity.getId() );
        productDto.setName( productEntity.getName() );
        productDto.setType( productEntity.getType() );
        productDto.setPrice( productEntity.getPrice() );
        productDto.setCreatedDate( productEntity.getCreatedDate() );
        productDto.setUpdatedDate( productEntity.getUpdatedDate() );
        productDto.setCountInStock( productEntity.getCountInStock() );

        return productDto;
    }

    protected CartItemDto cartItemEntityToCartItemDto(CartItemEntity cartItemEntity) {
        if ( cartItemEntity == null ) {
            return null;
        }

        CartItemDto cartItemDto = new CartItemDto();

        cartItemDto.setId( cartItemEntity.getId() );
        cartItemDto.setQuantity( cartItemEntity.getQuantity() );
        cartItemDto.setStatus( cartItemEntity.getStatus() );
        cartItemDto.setShoppingCart( entityToDto( cartItemEntity.getShoppingCart() ) );
        cartItemDto.setProduct( productEntityToProductDto( cartItemEntity.getProduct() ) );

        return cartItemDto;
    }
}
