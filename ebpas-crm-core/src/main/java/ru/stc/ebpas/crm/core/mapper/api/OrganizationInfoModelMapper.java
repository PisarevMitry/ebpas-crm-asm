package ru.stc.ebpas.crm.core.mapper.api;

import org.mapstruct.Mapper;
import ru.stc.ebpas.common.data.core.mapper.SimpleModelMapper;
import ru.stc.ebpas.crm.core.model.dto.OrganizationInfoDto;
import ru.stc.ebpas.crm.core.model.entity.OrganizationInfoEntity;

@Mapper(componentModel = "spring",
        config = ConfigModelMapper.class,
        uses = {CoreUserModelMapper.class})
public interface OrganizationInfoModelMapper extends SimpleModelMapper<OrganizationInfoEntity, OrganizationInfoDto> {

}
