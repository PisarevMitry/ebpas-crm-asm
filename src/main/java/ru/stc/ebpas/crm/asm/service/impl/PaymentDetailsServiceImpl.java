package ru.stc.ebpas.crm.asm.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.stc.ebpas.common.data.core.mapper.CommonMapper;
import ru.stc.ebpas.common.data.core.repository.CommonRepository;
import ru.stc.ebpas.common.data.core.service.AbstractCommonService;
import ru.stc.ebpas.crm.asm.mapper.api.PaymentDetailsMapper;
import ru.stc.ebpas.crm.asm.model.dto.PaymentDetailsDto;
import ru.stc.ebpas.crm.asm.model.entity.PaymentDetailsEntity;
import ru.stc.ebpas.crm.asm.repository.PaymentDetailsRepository;
import ru.stc.ebpas.crm.asm.service.api.PaymentDetailsService;

@AllArgsConstructor
@Service
public class PaymentDetailsServiceImpl extends AbstractCommonService<PaymentDetailsEntity, PaymentDetailsDto> implements PaymentDetailsService {

    private final PaymentDetailsMapper PaymentDetailsMapper;

    private final PaymentDetailsRepository PaymentDetailsRepository;

    @Override
    public CommonMapper<PaymentDetailsEntity, PaymentDetailsDto> getMapper() {
        return PaymentDetailsMapper;
    }

    @Override
    public CommonRepository<PaymentDetailsEntity> getRepository() {
        return PaymentDetailsRepository;
    }
}

