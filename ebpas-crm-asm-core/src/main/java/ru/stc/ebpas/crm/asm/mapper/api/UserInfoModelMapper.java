package ru.stc.ebpas.crm.asm.mapper.api;

import org.mapstruct.Mapper;
import ru.stc.ebpas.common.data.core.mapper.SimpleModelMapper;
import ru.stc.ebpas.crm.asm.model.dto.UserInfoDto;
import ru.stc.ebpas.crm.asm.model.entity.UserInfoEntity;

@Mapper(componentModel = "spring",
        config = ConfigModelMapper.class,
        uses = {CoreUserModelMapper.class})
public interface UserInfoModelMapper extends SimpleModelMapper<UserInfoEntity, UserInfoDto> {
}
