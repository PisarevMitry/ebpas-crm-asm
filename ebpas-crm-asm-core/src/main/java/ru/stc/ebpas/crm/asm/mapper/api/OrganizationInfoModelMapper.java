package ru.stc.ebpas.crm.asm.mapper.api;

import org.mapstruct.Mapper;
import ru.stc.ebpas.common.data.core.mapper.SimpleModelMapper;
import ru.stc.ebpas.crm.asm.model.dto.OrganizationInfoDto;
import ru.stc.ebpas.crm.asm.model.entity.OrganizationInfoEntity;

@Mapper(componentModel = "spring",
        config = ConfigModelMapper.class,
        uses = {CoreUserModelMapper.class})
public interface OrganizationInfoModelMapper extends SimpleModelMapper<OrganizationInfoEntity, OrganizationInfoDto> {

}
