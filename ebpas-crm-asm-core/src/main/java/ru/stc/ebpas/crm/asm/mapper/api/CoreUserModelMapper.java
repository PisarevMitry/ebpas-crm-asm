package ru.stc.ebpas.crm.asm.mapper.api;


import org.mapstruct.Mapper;
import ru.stc.ebpas.common.data.core.mapper.SimpleModelMapper;
import ru.stc.ebpas.crm.asm.model.dto.CoreUserDto;
import ru.stc.ebpas.crm.asm.model.entity.CoreUserEntity;

@Mapper(componentModel = "spring",
        config = ConfigModelMapper.class,
        uses = {UserInfoModelMapper.class,
                OrganizationInfoModelMapper.class,
                ClientModelMapper.class})
public interface CoreUserModelMapper extends SimpleModelMapper<CoreUserEntity, CoreUserDto> {

}