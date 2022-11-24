package ru.stc.ebpas.crm.cm.repository;

import org.springframework.stereotype.Repository;
import ru.stc.ebpas.common.data.core.repository.ComplexModelRepository;
import ru.stc.ebpas.crm.cm.model.entity.ClientShoppedProductEntity;
import ru.stc.ebpas.crm.cm.model.entity.ClientShoppedProductKey;

@Repository
public interface ClientShoppedProductRepository extends ComplexModelRepository<ClientShoppedProductEntity, ClientShoppedProductKey> {

}

