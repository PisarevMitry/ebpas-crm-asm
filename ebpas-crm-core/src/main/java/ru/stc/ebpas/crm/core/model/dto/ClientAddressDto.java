package ru.stc.ebpas.crm.core.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import ru.stc.ebpas.common.core.model.dto.SimpleDatabaseDto;
import ru.stc.ebpas.common.core.model.entity.nsi.NsiAddressDto;

@Data
@Schema(description = "Адрес, сохраненный пользователем")
public class ClientAddressDto implements SimpleDatabaseDto {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    private ClientDto client;

    private NsiAddressDto nsiAddress;

}
