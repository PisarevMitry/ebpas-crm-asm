package ru.stc.ebpas.crm.scm.mapper.impl;

import lombok.AllArgsConstructor;
import org.mapstruct.TargetType;
import org.springframework.stereotype.Component;
import ru.stc.ebpas.common.core.model.entity.nsi.NsiRecordDto;
import ru.stc.ebpas.crm.scm.api.external.NsiFeignClient;

@AllArgsConstructor
@Component
public class NsiRecordMapper {

    private final NsiFeignClient nsiFeignClient;

    public <T extends NsiRecordDto> T toModel(Long id, @TargetType Class<T> entity) {
        return (T) nsiFeignClient.getRecordById(id);
    }

    public <T extends NsiRecordDto> Long fromModelToId(T entity) {
        return entity.getId();
    }
}

