package ru.stc.ebpas.crm.om.repository;

import org.springframework.stereotype.Repository;
import ru.stc.ebpas.common.data.core.repository.SimpleModelRepository;
import ru.stc.ebpas.crm.om.model.entity.DefectiveProductEntity;

@Repository
public interface DefectiveProductRepository extends SimpleModelRepository<DefectiveProductEntity> {

}

