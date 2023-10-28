package ru.stc.ebpas.crm.pm.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
import ru.stc.ebpas.crm.pm.model.dto.AvailableProductDto;
import ru.stc.ebpas.crm.pm.model.dto.ChangeProductQuantityRequestDto;
import ru.stc.ebpas.crm.pm.service.api.AvailableProductService;

import javax.validation.constraints.Min;
import java.util.List;

@Tag(name = "API для взаимодействия с доступными товарами")
@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("/available-product")
public class AvailableProductController {

    private final AvailableProductService availableProductService;

    @Operation(summary = "Изменить количество товара",
            description = "Изменить количество товара на основании прихода/расхода/перемещения")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Данные получены"),
            @ApiResponse(responseCode = "404", description = "Данные не найдены")
    })
    @PostMapping("/change-product-quantity")
    public void changeProductQuantity(@RequestParam("productId") @Min(0) @Parameter(description = "Идентификатор товара") Long productId,
                                      @RequestBody ChangeProductQuantityRequestDto changeProductQuantityRequest) {
        log.debug("Запущен процесс изменения количества товара");

        availableProductService.changeProductQuantity(productId, changeProductQuantityRequest);
    }

    @Operation(summary = "Получить по идентификатору")
    @GetMapping("/{id}")
    public AvailableProductDto getById(@PathVariable Long id) {
        return availableProductService.getById(id);
    }

    @Operation(summary = "Получить по списку идентификаторов")
    @GetMapping("/specific-list")
    public List<AvailableProductDto> getById(@RequestBody List<Long> listId) {
        return availableProductService.getById(listId);
    }

    @Operation(summary = "Получить по списку идентификаторов постранично")
    @GetMapping("/specific-list/pageble")
    public Page<AvailableProductDto> getById(@RequestBody List<Long> listId, Pageable pageable) {
        return availableProductService.getById(listId, pageable);
    }

    @Operation(summary = "Получить все")
    @GetMapping("/all")
    public List<AvailableProductDto> getAll() {
        return availableProductService.getAll();
    }

    @Operation(summary = "Получить все постранично")
    @GetMapping("/all/pageble")
    public Page<AvailableProductDto> getAll(Pageable pageable) {
        return availableProductService.getAll(pageable);
    }

    @Operation(summary = "Обновить")
    @PutMapping
    public AvailableProductDto update(@RequestBody AvailableProductDto dto) {
        return availableProductService.update(dto);
    }

    @Operation(summary = "Обновить список")
    @PutMapping("/specific-list")
    public List<AvailableProductDto> update(@RequestBody List<AvailableProductDto> dto) {
        return availableProductService.update(dto);
    }

    @Operation(summary = "Сохранить")
    @PostMapping
    public AvailableProductDto save(@RequestBody AvailableProductDto dto) {
        return availableProductService.save(dto);
    }

    @Operation(summary = "Сохранить список")
    @PostMapping("/specific-list")
    public List<AvailableProductDto> save(@RequestBody List<AvailableProductDto> dto) {
        return availableProductService.save(dto);
    }

    @Operation(summary = "Удалить по идентификатору")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        availableProductService.delete(id);
    }

    @Operation(summary = "Удалить список по идентификаторам")
    @DeleteMapping("/specific-list")
    public void delete(@RequestBody List<Long> id) {
        availableProductService.delete(id);
    }


}
