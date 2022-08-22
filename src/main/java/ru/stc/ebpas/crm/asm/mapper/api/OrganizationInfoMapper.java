package ru.stc.ebpas.crm.asm.mapper.api;

import org.mapstruct.Mapper;
import ru.stc.ebpas.common.data.core.mapper.CommonMapper;
import ru.stc.ebpas.crm.asm.model.dto.OrganizationInfoDto;
import ru.stc.ebpas.crm.asm.model.entity.OrganizationInfoEntity;

@Mapper(componentModel = "spring")
public interface OrganizationInfoMapper extends CommonMapper<OrganizationInfoEntity, OrganizationInfoDto> {

}
