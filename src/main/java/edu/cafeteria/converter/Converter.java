package edu.cafeteria.converter;
 

public interface Converter<E, D> {
    D convertToDTO(E entity);
    E convertToEntity(D dto);
}

