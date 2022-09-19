package ru.stc.ebpas.crm.asm.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.stc.ebpas.common.core.model.dto.SimpleDatabaseDto;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Отзыв пользователя о товаре")
public class ProductFeedbackDto implements SimpleDatabaseDto {

    private Long id;

    private Long product;

    private Long client;

    private Short grade;

    private String description;

    private Set<Long> photos;
}
