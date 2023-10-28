package ru.stc.ebpas.crm.pm.mapper.api;

import org.mapstruct.Mapper;
import ru.stc.ebpas.common.data.core.mapper.SimpleModelMapper;
import ru.stc.ebpas.crm.pm.model.dto.ProductFeedbackDto;
import ru.stc.ebpas.crm.pm.model.entity.FeedbackEntity;

@Mapper(componentModel = "spring",
        config = ConfigModelMapper.class,
        uses = {ProductModelMapper.class,
                FeedbackPhotoModelMapper.class})
public interface ProductFeedbackModelMapper extends SimpleModelMapper<FeedbackEntity, ProductFeedbackDto> {

}
