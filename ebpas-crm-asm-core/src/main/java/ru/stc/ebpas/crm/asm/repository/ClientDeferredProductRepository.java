package ru.stc.ebpas.crm.asm.repository;

import org.springframework.stereotype.Repository;
import ru.stc.ebpas.common.data.core.repository.ComplexModelRepository;
import ru.stc.ebpas.crm.asm.model.entity.ClientDeferredProductEntity;
import ru.stc.ebpas.crm.asm.model.entity.ClientDeferredProductKey;

@Repository
public interface ClientDeferredProductRepository extends ComplexModelRepository<ClientDeferredProductEntity, ClientDeferredProductKey> {

}

