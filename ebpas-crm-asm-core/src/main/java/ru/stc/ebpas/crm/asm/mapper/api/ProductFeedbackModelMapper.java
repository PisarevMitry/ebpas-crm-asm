package ru.stc.ebpas.crm.asm.mapper.api;

import org.mapstruct.Mapper;
import ru.stc.ebpas.common.data.core.mapper.SimpleModelMapper;
import ru.stc.ebpas.crm.asm.model.dto.ProductFeedbackDto;
import ru.stc.ebpas.crm.asm.model.entity.ProductFeedbackEntity;

@Mapper(componentModel = "spring",
        config = ConfigModelMapper.class,
        uses = {ProductModelMapper.class,
                ClientModelMapper.class,
                FeedbackPhotoModelMapper.class})
public interface ProductFeedbackModelMapper extends SimpleModelMapper<ProductFeedbackEntity, ProductFeedbackDto> {

}
