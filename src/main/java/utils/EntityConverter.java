package utils;

import org.springframework.beans.BeanUtils;

public class EntityConverter {
    public static <D, E> E convertToEntity(D dto, Class<E> entityClass) {
        E entity = BeanUtils.instantiateClass(entityClass);
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }

    public static <D, E> D convertToDto(Class<E> entityClass, D dto) {
        E entity = BeanUtils.instantiateClass(entityClass);
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }
}