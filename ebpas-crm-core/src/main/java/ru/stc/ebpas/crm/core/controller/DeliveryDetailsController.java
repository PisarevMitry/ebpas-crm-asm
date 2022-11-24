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
import ru.stc.ebpas.crm.core.model.dto.DeliveryDetailsDto;
import ru.stc.ebpas.crm.core.service.api.DeliveryDetailsService;

import java.util.List;

@Tag(name = "API работы с деталями доставки")
@RequiredArgsConstructor
@RestController
@RequestMapping("/delivery-details")
public class DeliveryDetailsController {

    private final DeliveryDetailsService deliveryDetailsService;

    @Operation(summary = "Получить по идентификатору")
    @GetMapping("/{id}")
    public DeliveryDetailsDto getById(@PathVariable Long id) {
        return deliveryDetailsService.getById(id);
    }

    @Operation(summary = "Получить по списку идентификаторов")
    @GetMapping("/specific-list")
    public List<DeliveryDetailsDto> getById(@RequestBody List<Long> listId) {
        return deliveryDetailsService.getById(listId);
    }

    @Operation(summary = "Получить по списку идентификаторов постранично")
    @GetMapping("/specific-list/pageble")
    public Page<DeliveryDetailsDto> getById(@RequestBody List<Long> listId, Pageable pageable) {
        return deliveryDetailsService.getById(listId, pageable);
    }

    @Operation(summary = "Получить все")
    @GetMapping("/all")
    public List<DeliveryDetailsDto> getAll() {
        return deliveryDetailsService.getAll();
    }

    @Operation(summary = "Получить все постранично")
    @GetMapping("/all/pageble")
    public Page<DeliveryDetailsDto> getAll(Pageable pageable) {
        return deliveryDetailsService.getAll(pageable);
    }

    @Operation(summary = "Обновить")
    @PutMapping
    public DeliveryDetailsDto update(@RequestBody DeliveryDetailsDto dto) {
        return deliveryDetailsService.update(dto);
    }

    @Operation(summary = "Обновить список")
    @PutMapping("/specific-list")
    public List<DeliveryDetailsDto> update(@RequestBody List<DeliveryDetailsDto> dto) {
        return deliveryDetailsService.update(dto);
    }

    @Operation(summary = "Сохранить")
    @PostMapping
    public DeliveryDetailsDto save(@RequestBody DeliveryDetailsDto dto) {
        return deliveryDetailsService.save(dto);
    }

    @Operation(summary = "Сохранить список")
    @PostMapping("/specific-list")
    public List<DeliveryDetailsDto> save(@RequestBody List<DeliveryDetailsDto> dto) {
        return deliveryDetailsService.save(dto);
    }

    @Operation(summary = "Удалить по идентификатору")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        deliveryDetailsService.delete(id);
    }

    @Operation(summary = "Удалить список по идентификаторам")
    @DeleteMapping("/specific-list")
    public void delete(@RequestBody List<Long> id) {
        deliveryDetailsService.delete(id);
    }
}
