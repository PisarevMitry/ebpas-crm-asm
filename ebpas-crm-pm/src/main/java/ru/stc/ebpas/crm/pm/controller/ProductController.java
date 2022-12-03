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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.stc.ebpas.crm.pm.model.dto.ProductDto;
import ru.stc.ebpas.crm.pm.model.dto.ProjectProductDto;
import ru.stc.ebpas.crm.pm.service.api.ProductService;

import java.util.List;

@Tag(name = "API для взаимодействия с товарами")
@RequiredArgsConstructor
@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @Operation(summary = "Получить товар по идентификатору")
    @GetMapping("/{id}")
    public ProductDto getById(@PathVariable Long id) {
        return productService.getById(id);
    }

    @Operation(summary = "Получить список товаров по списку идентификаторов")
    @GetMapping("/specific-list")
    public List<ProductDto> getById(@RequestBody List<Long> listId) {
        return productService.getById(listId);
    }

    @Operation(summary = "Получить все товары постранично")
    @GetMapping("/all/pageble")
    public Page<ProductDto> getAll(Pageable pageable) {
        return productService.getAll(pageable);
    }

    @Operation(summary = "Получить список товаров по категории постранично")
    @GetMapping("/category")
    public Page<ProductDto> getByCategory(@RequestParam Long categoryId, Pageable pageable) {
        return null;
    }

    @Operation(summary = "Получить список товаров по специальным условиям торговли постранично")
    @GetMapping("/special-condition")
    public Page<ProductDto> getBySpecialCondition(@RequestParam Long specialConditionId, Pageable pageable) {
        return null;
    }

//    @Operation(summary = "Получить список товаров по фильтру поиска постранично")
//    @GetMapping("/special-condition")
//    public Page<ProductDto> getByFilter(@RequestParam Long specialConditionId, Pageable pageable) {
//        return null;
//    }

    @Operation(summary = "Обновить товар")
    @PutMapping
    public ProductDto update(@RequestBody ProductDto dto) {
        return productService.update(dto);
    }

    @Operation(summary = "Сохранить новый товар")
    @PostMapping
    public ProductDto save(@RequestBody ProductDto dto) {
        return productService.save(dto);
    }

    @Operation(summary = "Удалить товар по идентификатору")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }


    @Operation(summary = "Сохранить проект товара")
    @PostMapping("/project")
    public ProductDto save(@RequestBody ProjectProductDto dto) {
        return productService.save(dto);
    }

}
