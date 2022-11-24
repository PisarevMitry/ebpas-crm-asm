package ru.stc.ebpas.crm.core.repository;

import org.springframework.stereotype.Repository;
import ru.stc.ebpas.common.data.core.repository.ComplexModelRepository;
import ru.stc.ebpas.crm.core.model.entity.ClientOrderedProductEntity;
import ru.stc.ebpas.crm.core.model.entity.ClientOrderedProductKey;

@Repository
public interface ClientOrderedProductRepository extends ComplexModelRepository<ClientOrderedProductEntity, ClientOrderedProductKey> {

}

