package ru.stc.ebpas.crm.asm.repository;

import org.springframework.stereotype.Repository;
import ru.stc.ebpas.common.data.core.repository.ComplexModelRepository;
import ru.stc.ebpas.crm.asm.model.entity.ClientShoppedProductEntity;
import ru.stc.ebpas.crm.asm.model.entity.ClientShoppedProductKey;

@Repository
public interface ClientShoppedProductRepository extends ComplexModelRepository<ClientShoppedProductEntity, ClientShoppedProductKey> {

}

