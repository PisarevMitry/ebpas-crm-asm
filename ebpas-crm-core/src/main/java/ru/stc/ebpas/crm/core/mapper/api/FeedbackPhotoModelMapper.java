package ru.stc.ebpas.crm.core.mapper.api;

import org.mapstruct.Mapper;
import ru.stc.ebpas.common.data.core.mapper.SimpleModelMapper;
import ru.stc.ebpas.crm.core.model.dto.FeedbackPhotoDto;
import ru.stc.ebpas.crm.core.model.entity.FeedbackPhotoEntity;

@Mapper(componentModel = "spring",
        config = ConfigModelMapper.class,
        uses = {ProductFeedbackModelMapper.class})
public interface FeedbackPhotoModelMapper extends SimpleModelMapper<FeedbackPhotoEntity, FeedbackPhotoDto> {

}
