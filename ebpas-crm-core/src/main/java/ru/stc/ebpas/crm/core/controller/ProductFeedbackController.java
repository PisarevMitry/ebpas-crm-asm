package ru.stc.ebpas.crm.core.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.stc.ebpas.crm.core.model.dto.ProductFeedbackDto;
import ru.stc.ebpas.crm.core.service.api.ProductFeedbackService;

import java.util.List;

@Tag(name = "API модели 7")
@RequiredArgsConstructor
@RestController
@RequestMapping("/product-feedback")
public class ProductFeedbackController {

    private final ProductFeedbackService productFeedbackService;

    @Operation(summary = "Получить по идентификатору")
    @GetMapping("/{id}")
    public ProductFeedbackDto getById(@PathVariable Long id) {
        return productFeedbackService.getById(id);
    }

    @Operation(summary = "Получить по списку идентификаторов")
    @GetMapping("/specific-list")
    public List<ProductFeedbackDto> getById(@RequestBody List<Long> listId) {
        return productFeedbackService.getById(listId);
    }

    @Operation(summary = "Получить по списку идентификаторов постранично")
    @GetMapping("/specific-list/pageble")
    public Page<ProductFeedbackDto> getById(@RequestBody List<Long> listId, Pageable pageable) {
        return productFeedbackService.getById(listId, pageable);
    }

    @Operation(summary = "Получить все")
    @GetMapping("/all")
    public List<ProductFeedbackDto> getAll() {
        return productFeedbackService.getAll();
    }

    @Operation(summary = "Получить все постранично")
    @GetMapping("/all/pageble")
    public Page<ProductFeedbackDto> getAll(Pageable pageable) {
        return productFeedbackService.getAll(pageable);
    }

    @Operation(summary = "Обновить")
    @PutMapping
    public ProductFeedbackDto update(@RequestBody ProductFeedbackDto dto) {
        return productFeedbackService.update(dto);
    }

    @Operation(summary = "Обновить список")
    @PutMapping("/specific-list")
    public List<ProductFeedbackDto> update(@RequestBody List<ProductFeedbackDto> dto) {
        return productFeedbackService.update(dto);
    }

    @Operation(summary = "Сохранить")
    @PostMapping
    public ProductFeedbackDto save(@RequestBody ProductFeedbackDto dto) {
        return productFeedbackService.save(dto);
    }

    @Operation(summary = "Сохранить список")
    @PostMapping("/specific-list")
    public List<ProductFeedbackDto> save(@RequestBody List<ProductFeedbackDto> dto) {
        return productFeedbackService.save(dto);
    }

    @Operation(summary = "Удалить по идентификатору")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productFeedbackService.delete(id);
    }

    @Operation(summary = "Удалить список по идентификаторам")
    @DeleteMapping("/specific-list")
    public void delete(@RequestBody List<Long> id) {
        productFeedbackService.delete(id);
    }
}
