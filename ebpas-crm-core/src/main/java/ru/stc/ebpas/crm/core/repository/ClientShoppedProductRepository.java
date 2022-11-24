package ru.stc.ebpas.crm.core.repository;

import org.springframework.stereotype.Repository;
import ru.stc.ebpas.common.data.core.repository.ComplexModelRepository;
import ru.stc.ebpas.crm.core.model.entity.ClientShoppedProductEntity;
import ru.stc.ebpas.crm.core.model.entity.ClientShoppedProductKey;

@Repository
public interface ClientShoppedProductRepository extends ComplexModelRepository<ClientShoppedProductEntity, ClientShoppedProductKey> {

}

