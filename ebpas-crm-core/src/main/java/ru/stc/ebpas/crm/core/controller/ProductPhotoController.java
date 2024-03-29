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
import ru.stc.ebpas.crm.core.model.dto.ProductPhotoDto;
import ru.stc.ebpas.crm.core.service.api.ProductPhotoService;

import java.util.List;

@Tag(name = "API модели 7")
@RequiredArgsConstructor
@RestController
@RequestMapping("/product-photo")
public class ProductPhotoController {

    private final ProductPhotoService productPhotoService;

    @Operation(summary = "Получить по идентификатору")
    @GetMapping("/{id}")
    public ProductPhotoDto getById(@PathVariable Long id) {
        return productPhotoService.getById(id);
    }

    @Operation(summary = "Получить по списку идентификаторов")
    @GetMapping("/specific-list")
    public List<ProductPhotoDto> getById(@RequestBody List<Long> listId) {
        return productPhotoService.getById(listId);
    }

    @Operation(summary = "Получить по списку идентификаторов постранично")
    @GetMapping("/specific-list/pageble")
    public Page<ProductPhotoDto> getById(@RequestBody List<Long> listId, Pageable pageable) {
        return productPhotoService.getById(listId, pageable);
    }

    @Operation(summary = "Получить все")
    @GetMapping("/all")
    public List<ProductPhotoDto> getAll() {
        return productPhotoService.getAll();
    }

    @Operation(summary = "Получить все постранично")
    @GetMapping("/all/pageble")
    public Page<ProductPhotoDto> getAll(Pageable pageable) {
        return productPhotoService.getAll(pageable);
    }

    @Operation(summary = "Обновить")
    @PutMapping
    public ProductPhotoDto update(@RequestBody ProductPhotoDto dto) {
        return productPhotoService.update(dto);
    }

    @Operation(summary = "Обновить список")
    @PutMapping("/specific-list")
    public List<ProductPhotoDto> update(@RequestBody List<ProductPhotoDto> dto) {
        return productPhotoService.update(dto);
    }

    @Operation(summary = "Сохранить")
    @PostMapping
    public ProductPhotoDto save(@RequestBody ProductPhotoDto dto) {
        return productPhotoService.save(dto);
    }

    @Operation(summary = "Сохранить список")
    @PostMapping("/specific-list")
    public List<ProductPhotoDto> save(@RequestBody List<ProductPhotoDto> dto) {
        return productPhotoService.save(dto);
    }

    @Operation(summary = "Удалить по идентификатору")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productPhotoService.delete(id);
    }

    @Operation(summary = "Удалить список по идентификаторам")
    @DeleteMapping("/specific-list")
    public void delete(@RequestBody List<Long> id) {
        productPhotoService.delete(id);
    }
}
