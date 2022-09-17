package ru.stc.ebpas.crm.asm.repository;

import org.springframework.stereotype.Repository;
import ru.stc.ebpas.common.data.core.repository.ComplexModelRepository;
import ru.stc.ebpas.crm.asm.model.entity.ClientOrderedProductEntity;
import ru.stc.ebpas.crm.asm.model.entity.ClientOrderedProductKey;

@Repository
public interface ClientOrderedProductRepository extends ComplexModelRepository<ClientOrderedProductEntity, ClientOrderedProductKey> {

}

