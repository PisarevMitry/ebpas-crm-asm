package ru.stc.ebpas.crm.asm.controller;

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
import ru.stc.ebpas.crm.asm.model.dto.ProductDto;
import ru.stc.ebpas.crm.asm.service.api.ProductService;

import java.util.List;

@Tag(name = "API модели 6")
@RequiredArgsConstructor
@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @Operation(summary = "Получить по идентификатору")
    @GetMapping("/{id}")
    public ProductDto getById(@PathVariable Long id) {
        return productService.getById(id);
    }

    @Operation(summary = "Получить по списку идентификаторов")
    @GetMapping("/specific-list")
    public List<ProductDto> getById(@RequestBody List<Long> listId) {
        return productService.getById(listId);
    }

    @Operation(summary = "Получить по списку идентификаторов постранично")
    @GetMapping("/specific-list/pageble")
    public Page<ProductDto> getById(@RequestBody List<Long> listId, Pageable pageable) {
        return productService.getById(listId, pageable);
    }

    @Operation(summary = "Получить все")
    @GetMapping("/all")
    public List<ProductDto> getAll() {
        return productService.getAll();
    }

    @Operation(summary = "Получить все постранично")
    @GetMapping("/all/pageble")
    public Page<ProductDto> getAll(Pageable pageable) {
        return productService.getAll(pageable);
    }

    @Operation(summary = "Обновить")
    @PutMapping
    public ProductDto update(@RequestBody ProductDto dto) {
        return productService.update(dto);
    }

    @Operation(summary = "Обновить список")
    @PutMapping("/specific-list")
    public List<ProductDto> update(@RequestBody List<ProductDto> dto) {
        return productService.update(dto);
    }

    @Operation(summary = "Сохранить")
    @PostMapping
    public ProductDto save(@RequestBody ProductDto dto) {
        return productService.save(dto);
    }

    @Operation(summary = "Сохранить список")
    @PostMapping("/specific-list")
    public List<ProductDto> save(@RequestBody List<ProductDto> dto) {
        return productService.save(dto);
    }

    @Operation(summary = "Удалить по идентификатору")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }

    @Operation(summary = "Удалить список по идентификаторам")
    @DeleteMapping("/specific-list")
    public void delete(@RequestBody List<Long> id) {
        productService.delete(id);
    }
}
