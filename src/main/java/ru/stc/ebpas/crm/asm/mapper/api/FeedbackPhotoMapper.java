package ru.stc.ebpas.crm.asm.mapper.api;

import org.mapstruct.Mapper;
import ru.stc.ebpas.common.data.core.mapper.CommonMapper;
import ru.stc.ebpas.crm.asm.model.dto.FeedbackPhotoDto;
import ru.stc.ebpas.crm.asm.model.entity.FeedbackPhotoEntity;

@Mapper(componentModel = "spring")
public interface FeedbackPhotoMapper extends CommonMapper<FeedbackPhotoEntity, FeedbackPhotoDto> {

}
