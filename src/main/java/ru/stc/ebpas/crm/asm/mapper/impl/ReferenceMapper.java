package ru.stc.ebpas.crm.asm.mapper.impl;

import lombok.NonNull;
import org.mapstruct.ObjectFactory;
import org.mapstruct.TargetType;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Реализация получения сущности по идентификатору.
 */
@Component
public class ReferenceMapper {
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Сопоставление сущности идентификатору.
     *
     * @param id идентификатор сущности
     * @param type тип возвращаемой сущности
     */
    @ObjectFactory
    public <T> T map(@NonNull final Long id, @TargetType Class<T> type) {
        return entityManager.getReference(type, id);
    }
}

