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
import ru.stc.ebpas.crm.core.model.dto.ProductCategoryDto;
import ru.stc.ebpas.crm.core.service.api.ProductCategoryService;

import java.util.List;

@Tag(name = "API модели 5")
@RequiredArgsConstructor
@RestController
@RequestMapping("/product-category")
public class ProductCategoryController {

    private final ProductCategoryService productCategoryService;

    @Operation(summary = "Получить по идентификатору")
    @GetMapping("/{id}")
    public ProductCategoryDto getById(@PathVariable Long id) {
        return productCategoryService.getById(id);
    }

    @Operation(summary = "Получить по списку идентификаторов")
    @GetMapping("/specific-list")
    public List<ProductCategoryDto> getById(@RequestBody List<Long> listId) {
        return productCategoryService.getById(listId);
    }

    @Operation(summary = "Получить по списку идентификаторов постранично")
    @GetMapping("/specific-list/pageble")
    public Page<ProductCategoryDto> getById(@RequestBody List<Long> listId, Pageable pageable) {
        return productCategoryService.getById(listId, pageable);
    }

    @Operation(summary = "Получить все")
    @GetMapping("/all")
    public List<ProductCategoryDto> getAll() {
        return productCategoryService.getAll();
    }

    @Operation(summary = "Получить все постранично")
    @GetMapping("/all/pageble")
    public Page<ProductCategoryDto> getAll(Pageable pageable) {
        return productCategoryService.getAll(pageable);
    }

    @Operation(summary = "Обновить")
    @PutMapping
    public ProductCategoryDto update(@RequestBody ProductCategoryDto dto) {
        return productCategoryService.update(dto);
    }

    @Operation(summary = "Обновить список")
    @PutMapping("/specific-list")
    public List<ProductCategoryDto> update(@RequestBody List<ProductCategoryDto> dto) {
        return productCategoryService.update(dto);
    }

    @Operation(summary = "Сохранить")
    @PostMapping
    public ProductCategoryDto save(@RequestBody ProductCategoryDto dto) {
        return productCategoryService.save(dto);
    }

    @Operation(summary = "Сохранить список")
    @PostMapping("/specific-list")
    public List<ProductCategoryDto> save(@RequestBody List<ProductCategoryDto> dto) {
        return productCategoryService.save(dto);
    }

    @Operation(summary = "Удалить по идентификатору")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productCategoryService.delete(id);
    }

    @Operation(summary = "Удалить список по идентификаторам")
    @DeleteMapping("/specific-list")
    public void delete(@RequestBody List<Long> id) {
        productCategoryService.delete(id);
    }
}
