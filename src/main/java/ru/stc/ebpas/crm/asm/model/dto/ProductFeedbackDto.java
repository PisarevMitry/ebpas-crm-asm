package ru.stc.ebpas.crm.asm.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Set;

@Schema(description = "Отзыв пользователя о товаре")
@Data
public class ProductFeedbackDto {

    private Long id;

    private ProductDto product;

    private ClientDto client;

    private Short grade;

    private String description;

    private Set<FeedbackPhotoDto> photos;
}
