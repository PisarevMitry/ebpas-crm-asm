package ru.stc.ebpas.crm.asm.mapper.impl;

import lombok.AllArgsConstructor;
import org.mapstruct.TargetType;
import org.springframework.stereotype.Component;
import ru.stc.ebpas.common.core.model.entity.nsi.NsiRecordDto;

@AllArgsConstructor
@Component
public class NsiRecordMapper {

    private final NsiFeignClient nsiFeignClient;

    public <T extends NsiRecordDto> T toDto(Long id, @TargetType Class<T> entity) {
        return (T) nsiFeignClient.getRecordById(id);
    }

    public <T extends NsiRecordDto> Long fromDtoToId(T entity) {
        return entity.getId();
    }
}

