package ru.stc.ebpas.crm.asm.repository;

import org.springframework.stereotype.Repository;
import ru.stc.ebpas.common.data.core.repository.CommonRepository;
import ru.stc.ebpas.crm.asm.model.entity.PaymentDetailsEntity;

@Repository
public interface PaymentDetailsRepository extends CommonRepository<PaymentDetailsEntity> {

}
