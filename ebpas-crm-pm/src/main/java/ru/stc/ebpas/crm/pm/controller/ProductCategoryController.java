package ru.stc.ebpas.crm.pm.controller;

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
import ru.stc.ebpas.crm.pm.model.dto.ProductCategoryDto;
import ru.stc.ebpas.crm.pm.service.api.ProductCategoryService;

import java.util.List;

@Tag(name = "API для взаимодействия с категориями")
@RequiredArgsConstructor
@RestController
@RequestMapping("/product-category")
public class ProductCategoryController {

    private final ProductCategoryService productCategoryService;


    @Operation(summary = "Получить категорию по идентификатору")
    @GetMapping("/{id}")
    public ProductCategoryDto getById(@PathVariable Long id) {
        return productCategoryService.getById(id);
    }

    @Operation(summary = "Получить список категорий по списку идентификаторов")
    @GetMapping("/specific-list")
    public List<ProductCategoryDto> getById(@RequestBody List<Long> listId) {
        return productCategoryService.getById(listId);
    }

    @Operation(summary = "Получить все категории постранично")
    @GetMapping("/all/pageble")
    public Page<ProductCategoryDto> getAll(Pageable pageable) {
        return productCategoryService.getAll(pageable);
    }

    @Operation(summary = "Обновить категорию")
    @PutMapping
    public ProductCategoryDto update(@RequestBody ProductCategoryDto dto) {
        return productCategoryService.update(dto);
    }

    @Operation(summary = "Сохранить новую категорию")
    @PostMapping
    public ProductCategoryDto save(@RequestBody ProductCategoryDto dto) {
        return productCategoryService.save(dto);
    }

    @Operation(summary = "Удалить категорию по идентификатору")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productCategoryService.delete(id);
    }
}
