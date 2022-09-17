package ru.stc.ebpas.crm.asm.mapper.impl;

import org.mapstruct.ObjectFactory;
import org.mapstruct.TargetType;
import org.springframework.stereotype.Component;
import ru.stc.ebpas.common.core.model.entity.CompositeKey;
import ru.stc.ebpas.crm.asm.model.entity.ClientDeferredProductEntity;
import ru.stc.ebpas.crm.asm.model.entity.ClientDeferredProductKey;
import ru.stc.ebpas.crm.asm.model.entity.ClientOrderedProductEntity;
import ru.stc.ebpas.crm.asm.model.entity.ClientOrderedProductKey;
import ru.stc.ebpas.crm.asm.model.entity.ClientShoppedProductEntity;
import ru.stc.ebpas.crm.asm.model.entity.ClientShoppedProductKey;

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

    public ClientShoppedProductEntity toEntity(ClientShoppedProductKey id) {
        return entityManager.getReference(ClientShoppedProductEntity.class, id);
    }

    public ClientDeferredProductEntity toEntity(ClientDeferredProductKey id) {
        return entityManager.getReference(ClientDeferredProductEntity.class, id);
    }

    public ClientOrderedProductEntity toEntity(ClientOrderedProductKey id) {
        return entityManager.getReference(ClientOrderedProductEntity.class, id);
    }

    public ClientShoppedProductKey mapClientShoppedProductKey(CompositeKey id) {
        return new ClientShoppedProductKey(id.getFirstPart(), id.getSecondPart());
    }

    public ClientDeferredProductKey mapClientDeferredProductKey(CompositeKey id) {
        return new ClientDeferredProductKey(id.getFirstPart(), id.getSecondPart());
    }

    public ClientOrderedProductKey mapClientOrderedProductKey(CompositeKey id) {
        return new ClientOrderedProductKey(id.getFirstPart(), id.getSecondPart());
    }
}

