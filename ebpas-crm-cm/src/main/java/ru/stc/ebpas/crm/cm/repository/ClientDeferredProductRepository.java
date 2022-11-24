package ru.stc.ebpas.crm.cm.repository;

import org.springframework.stereotype.Repository;
import ru.stc.ebpas.common.data.core.repository.ComplexModelRepository;
import ru.stc.ebpas.crm.cm.model.entity.ClientDeferredProductEntity;
import ru.stc.ebpas.crm.cm.model.entity.ClientDeferredProductKey;

@Repository
public interface ClientDeferredProductRepository extends ComplexModelRepository<ClientDeferredProductEntity, ClientDeferredProductKey> {

}

