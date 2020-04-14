package com.service.mapper;

import com.model.domain.entity.CartItemEntity;
import com.model.domain.entity.ProductEntity;
import com.model.domain.entity.RoleEntity;
import com.model.domain.entity.ShoppingCartEntity;
import com.model.domain.entity.UserEntity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-04-14T18:26:07+0400",
    comments = "version: 1.3.0.Beta2, compiler: javac, environment: Java 1.8.0_211 (Oracle Corporation)"
)
public class CartItemMapperImpl implements CartItemMapper {

    @Override
    public CartItemEntity dtoToEntity(CartItemDto dto) {
        if ( dto == null ) {
            return null;
        }

        CartItemEntity cartItemEntity = new CartItemEntity();

        cartItemEntity.setId( dto.getId() );
        cartItemEntity.setQuantity( dto.getQuantity() );
        cartItemEntity.setStatus( dto.getStatus() );
        cartItemEntity.setProduct( productDtoToProductEntity( dto.getProduct() ) );
        cartItemEntity.setShoppingCart( shoppingCartDtoToShoppingCartEntity( dto.getShoppingCart() ) );

        return cartItemEntity;
    }

    @Override
    public Iterable<CartItemEntity> dtoListToEntityList(Iterable<CartItemDto> dto) {
        if ( dto == null ) {
            return null;
        }

        ArrayList<CartItemEntity> iterable = new ArrayList<CartItemEntity>();
        for ( CartItemDto cartItemDto : dto ) {
            iterable.add( dtoToEntity( cartItemDto ) );
        }

        return iterable;
    }

    @Override
    public CartItemDto entityToDto(CartItemEntity entity) {
        if ( entity == null ) {
            return null;
        }

        CartItemDto cartItemDto = new CartItemDto();

        cartItemDto.setId( entity.getId() );
        cartItemDto.setQuantity( entity.getQuantity() );
        cartItemDto.setStatus( entity.getStatus() );
        cartItemDto.setShoppingCart( shoppingCartEntityToShoppingCartDto( entity.getShoppingCart() ) );
        cartItemDto.setProduct( productEntityToProductDto( entity.getProduct() ) );

        return cartItemDto;
    }

    @Override
    public CartItemDto optionalEntityToDto(Optional<CartItemEntity> entity) {
        if ( entity == null ) {
            return null;
        }

        CartItemDto cartItemDto = new CartItemDto();

        return cartItemDto;
    }

    @Override
    public Iterable<CartItemDto> entityListToDtoList(Iterable<CartItemEntity> entity) {
        if ( entity == null ) {
            return null;
        }

        ArrayList<CartItemDto> iterable = new ArrayList<CartItemDto>();
        for ( CartItemEntity cartItemEntity : entity ) {
            iterable.add( entityToDto( cartItemEntity ) );
        }

        return iterable;
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

    protected ShoppingCartEntity shoppingCartDtoToShoppingCartEntity(ShoppingCartDto shoppingCartDto) {
        if ( shoppingCartDto == null ) {
            return null;
        }

        ShoppingCartEntity shoppingCartEntity = new ShoppingCartEntity();

        shoppingCartEntity.setId( shoppingCartDto.getId() );
        shoppingCartEntity.setUser( userDtoToUserEntity( shoppingCartDto.getUser() ) );
        shoppingCartEntity.setCartItem( dtoToEntity( shoppingCartDto.getCartItem() ) );

        return shoppingCartEntity;
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

    protected ShoppingCartDto shoppingCartEntityToShoppingCartDto(ShoppingCartEntity shoppingCartEntity) {
        if ( shoppingCartEntity == null ) {
            return null;
        }

        ShoppingCartDto shoppingCartDto = new ShoppingCartDto();

        shoppingCartDto.setId( shoppingCartEntity.getId() );
        shoppingCartDto.setUser( userEntityToUserDto( shoppingCartEntity.getUser() ) );
        shoppingCartDto.setCartItem( entityToDto( shoppingCartEntity.getCartItem() ) );

        return shoppingCartDto;
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
}
