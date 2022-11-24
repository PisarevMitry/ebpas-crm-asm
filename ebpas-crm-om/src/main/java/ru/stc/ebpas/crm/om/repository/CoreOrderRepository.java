package ru.stc.ebpas.crm.om.repository;

import org.springframework.stereotype.Repository;
import ru.stc.ebpas.common.data.core.repository.SimpleModelRepository;
import ru.stc.ebpas.crm.om.model.entity.CoreOrderEntity;

@Repository
public interface CoreOrderRepository extends SimpleModelRepository<CoreOrderEntity> {

}

