package ru.stc.ebpas.crm.core.repository;

import org.springframework.stereotype.Repository;
import ru.stc.ebpas.common.data.core.repository.SimpleModelRepository;
import ru.stc.ebpas.crm.core.model.entity.ProductPhotoEntity;

@Repository
public interface ProductPhotoRepository extends SimpleModelRepository<ProductPhotoEntity> {

}
