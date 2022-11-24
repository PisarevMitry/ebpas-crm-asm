package ru.stc.ebpas.crm.cm.mapper.impl;

import org.mapstruct.ObjectFactory;
import org.mapstruct.TargetType;
import org.springframework.stereotype.Component;
import ru.stc.ebpas.common.core.model.entity.CompositeKey;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class ReferenceMapper {

    @PersistenceContext
    private EntityManager entityManager;

    @ObjectFactory
    public <T> T toEntity(Long id, @TargetType Class<T> type) {
        return entityManager.getReference(type, id);
    }

    @ObjectFactory
    public <T> T toEntity(CompositeKey id, @TargetType Class<T> type) {
        return entityManager.getReference(type, id);
    }
}

