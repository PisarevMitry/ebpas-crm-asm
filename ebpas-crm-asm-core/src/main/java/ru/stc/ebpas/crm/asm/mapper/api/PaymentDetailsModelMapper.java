package ru.stc.ebpas.crm.asm.mapper.api;

import org.mapstruct.Mapper;
import ru.stc.ebpas.common.data.core.mapper.SimpleModelMapper;
import ru.stc.ebpas.crm.asm.model.dto.PaymentDetailsDto;
import ru.stc.ebpas.crm.asm.model.entity.PaymentDetailsEntity;

@Mapper(componentModel = "spring",
        config = ConfigModelMapper.class,
        uses = {PaymentTypeModelMapper.class,
                CoreOrderModelMapper.class})
public interface PaymentDetailsModelMapper extends SimpleModelMapper<PaymentDetailsEntity, PaymentDetailsDto> {

}
