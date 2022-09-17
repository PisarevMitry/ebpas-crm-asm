package ru.stc.ebpas.crm.asm.repository;

import org.springframework.stereotype.Repository;
import ru.stc.ebpas.common.data.core.repository.SimpleModelRepository;
import ru.stc.ebpas.crm.asm.model.entity.StoreEntity;

@Repository
public interface StoreRepository extends SimpleModelRepository<StoreEntity> {

}

