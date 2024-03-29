package ru.stc.ebpas.crm.pm.repository;

import org.springframework.stereotype.Repository;
import ru.stc.ebpas.common.data.core.repository.SimpleModelRepository;
import ru.stc.ebpas.crm.pm.model.entity.ProductFeedbackEntity;

@Repository
public interface ProductFeedbackRepository extends SimpleModelRepository<ProductFeedbackEntity> {

}

