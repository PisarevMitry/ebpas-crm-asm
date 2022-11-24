package ru.stc.ebpas.crm.core.repository;

import org.springframework.stereotype.Repository;
import ru.stc.ebpas.common.data.core.repository.ComplexModelRepository;
import ru.stc.ebpas.crm.core.model.entity.ClientDeferredProductEntity;
import ru.stc.ebpas.crm.core.model.entity.ClientDeferredProductKey;

@Repository
public interface ClientDeferredProductRepository extends ComplexModelRepository<ClientDeferredProductEntity, ClientDeferredProductKey> {

}

