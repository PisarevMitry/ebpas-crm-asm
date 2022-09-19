package ru.stc.ebpas.crm.asm.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.stc.ebpas.common.core.model.dto.SimpleDatabaseDto;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Основные данные специальных торговых условий")
public class CoreSpecialConditionDto implements SimpleDatabaseDto {

    private Long id;

    private Long specialConditionType;

    private String description;

    private LocalDateTime startConditionDttm;

    private LocalDateTime endConditionDttm;

    private String systemDetailsValue;

    private Boolean displayed;

    private Boolean blocked;

    private Set<Long> availableProducts;

    private Set<Long> categories;

    private Set<Long> clients;

    private Set<Long> products;

    private Set<Long> stores;
}
