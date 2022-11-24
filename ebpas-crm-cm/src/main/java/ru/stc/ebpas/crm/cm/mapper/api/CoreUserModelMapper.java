package ru.stc.ebpas.crm.cm.mapper.api;


import org.mapstruct.Mapper;
import ru.stc.ebpas.common.data.core.mapper.SimpleModelMapper;
import ru.stc.ebpas.crm.cm.model.dto.CoreUserDto;
import ru.stc.ebpas.crm.cm.model.entity.CoreUserEntity;

@Mapper(componentModel = "spring",
        config = ConfigModelMapper.class,
        uses = {UserInfoModelMapper.class,
                OrganizationInfoModelMapper.class,
                ClientModelMapper.class})
public interface CoreUserModelMapper extends SimpleModelMapper<CoreUserEntity, CoreUserDto> {

}