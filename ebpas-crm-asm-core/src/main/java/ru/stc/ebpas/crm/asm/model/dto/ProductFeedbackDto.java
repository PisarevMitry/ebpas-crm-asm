package ru.stc.ebpas.crm.asm.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.stc.ebpas.common.core.model.dto.DatabaseDto;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Отзыв пользователя о товаре")
public class ProductFeedbackDto implements DatabaseDto {

    private Long id;

    private ProductDto product;

    private ClientDto client;

    private Short grade;

    private String description;

    private Set<FeedbackPhotoDto> photos;
}
