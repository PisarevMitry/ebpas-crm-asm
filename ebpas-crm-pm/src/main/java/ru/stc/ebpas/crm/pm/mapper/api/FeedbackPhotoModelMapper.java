package ru.stc.ebpas.crm.pm.mapper.api;

import org.mapstruct.Mapper;
import ru.stc.ebpas.common.data.core.mapper.SimpleModelMapper;
import ru.stc.ebpas.crm.pm.model.dto.FeedbackPhotoDto;
import ru.stc.ebpas.crm.pm.model.entity.FeedbackPhotoEntity;

@Mapper(componentModel = "spring",
        config = ConfigModelMapper.class,
        uses = {ProductFeedbackModelMapper.class})
public interface FeedbackPhotoModelMapper extends SimpleModelMapper<FeedbackPhotoEntity, FeedbackPhotoDto> {

}
