package com.service.mapper;

import com.model.domain.entity.ProductEntity;

import java.util.ArrayList;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-04-14T18:26:07+0400",
    comments = "version: 1.3.0.Beta2, compiler: javac, environment: Java 1.8.0_211 (Oracle Corporation)"
)
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductEntity dtoToEntity(ProductDto dto) {
        if ( dto == null ) {
            return null;
        }

        ProductEntity productEntity = new ProductEntity();

        productEntity.setId( dto.getId() );
        productEntity.setName( dto.getName() );
        productEntity.setType( dto.getType() );
        productEntity.setPrice( dto.getPrice() );
        productEntity.setCreatedDate( dto.getCreatedDate() );
        productEntity.setUpdatedDate( dto.getUpdatedDate() );
        productEntity.setCountInStock( dto.getCountInStock() );

        return productEntity;
    }

    @Override
    public Iterable<ProductEntity> dtoListToEntityList(Iterable<ProductDto> dto) {
        if ( dto == null ) {
            return null;
        }

        ArrayList<ProductEntity> iterable = new ArrayList<ProductEntity>();
        for ( ProductDto productDto : dto ) {
            iterable.add( dtoToEntity( productDto ) );
        }

        return iterable;
    }

    @Override
    public ProductDto entityToDto(ProductEntity entity) {
        if ( entity == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        productDto.setId( entity.getId() );
        productDto.setName( entity.getName() );
        productDto.setType( entity.getType() );
        productDto.setPrice( entity.getPrice() );
        productDto.setCreatedDate( entity.getCreatedDate() );
        productDto.setUpdatedDate( entity.getUpdatedDate() );
        productDto.setCountInStock( entity.getCountInStock() );

        return productDto;
    }

    @Override
    public Iterable<ProductDto> entityListToDtoList(Iterable<ProductEntity> entity) {
        if ( entity == null ) {
            return null;
        }

        ArrayList<ProductDto> iterable = new ArrayList<ProductDto>();
        for ( ProductEntity productEntity : entity ) {
            iterable.add( entityToDto( productEntity ) );
        }

        return iterable;
    }
}
