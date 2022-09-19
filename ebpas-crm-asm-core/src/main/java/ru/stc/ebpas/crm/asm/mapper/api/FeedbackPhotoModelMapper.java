package ru.stc.ebpas.crm.asm.mapper.api;

import org.mapstruct.Mapper;
import ru.stc.ebpas.common.data.core.mapper.SimpleModelMapper;
import ru.stc.ebpas.crm.asm.model.dto.FeedbackPhotoDto;
import ru.stc.ebpas.crm.asm.model.entity.FeedbackPhotoEntity;

@Mapper(componentModel = "spring",
        config = ConfigModelMapper.class,
        uses = {ProductFeedbackModelMapper.class})
public interface FeedbackPhotoModelMapper extends SimpleModelMapper<FeedbackPhotoEntity, FeedbackPhotoDto> {

}
