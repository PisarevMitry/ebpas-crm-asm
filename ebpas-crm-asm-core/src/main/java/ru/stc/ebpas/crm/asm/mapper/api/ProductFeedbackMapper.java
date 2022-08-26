package ru.stc.ebpas.crm.asm.mapper.api;

import org.mapstruct.Mapper;
import ru.stc.ebpas.common.data.core.mapper.CommonMapper;
import ru.stc.ebpas.crm.asm.model.dto.ProductFeedbackDto;
import ru.stc.ebpas.crm.asm.model.entity.ProductFeedbackEntity;

@Mapper(componentModel = "spring")
public interface ProductFeedbackMapper extends CommonMapper<ProductFeedbackEntity, ProductFeedbackDto> {

}
