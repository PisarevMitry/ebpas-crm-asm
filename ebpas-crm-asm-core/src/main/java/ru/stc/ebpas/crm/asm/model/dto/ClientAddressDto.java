package ru.stc.ebpas.crm.asm.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.stc.ebpas.common.core.model.dto.DatabaseDto;
import ru.stc.ebpas.common.core.model.entity.nsi.NsiAddressDto;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Адрес, сохраненный пользователем")
public class ClientAddressDto implements DatabaseDto {

    private Long id;

    private Long client;

    private NsiAddressDto nsiAddress;

}
