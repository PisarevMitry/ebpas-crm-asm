package ru.stc.ebpas.crm.pm.repository;

import org.springframework.stereotype.Repository;
import ru.stc.ebpas.common.data.core.repository.SimpleModelRepository;
import ru.stc.ebpas.crm.pm.model.entity.AvailableProductEntity;

@Repository
public interface AvailableProductRepository extends SimpleModelRepository<AvailableProductEntity> {

}