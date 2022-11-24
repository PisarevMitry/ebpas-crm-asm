package ru.stc.ebpas.crm.om.controller;

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
import ru.stc.ebpas.crm.om.model.dto.PaymentTypeDto;
import ru.stc.ebpas.crm.om.service.api.PaymentTypeService;

import java.util.List;

@Tag(name = "API модели 4")
@RequiredArgsConstructor
@RestController
@RequestMapping("/payment-type")
public class PaymentTypeController {

    private final PaymentTypeService paymentTypeService;

    @Operation(summary = "Получить по идентификатору")
    @GetMapping("/{id}")
    public PaymentTypeDto getById(@PathVariable Long id) {
        return paymentTypeService.getById(id);
    }

    @Operation(summary = "Получить по списку идентификаторов")
    @GetMapping("/specific-list")
    public List<PaymentTypeDto> getById(@RequestBody List<Long> listId) {
        return paymentTypeService.getById(listId);
    }

    @Operation(summary = "Получить по списку идентификаторов постранично")
    @GetMapping("/specific-list/pageble")
    public Page<PaymentTypeDto> getById(@RequestBody List<Long> listId, Pageable pageable) {
        return paymentTypeService.getById(listId, pageable);
    }

    @Operation(summary = "Получить все")
    @GetMapping("/all")
    public List<PaymentTypeDto> getAll() {
        return paymentTypeService.getAll();
    }

    @Operation(summary = "Получить все постранично")
    @GetMapping("/all/pageble")
    public Page<PaymentTypeDto> getAll(Pageable pageable) {
        return paymentTypeService.getAll(pageable);
    }

    @Operation(summary = "Обновить")
    @PutMapping
    public PaymentTypeDto update(@RequestBody PaymentTypeDto dto) {
        return paymentTypeService.update(dto);
    }

    @Operation(summary = "Обновить список")
    @PutMapping("/specific-list")
    public List<PaymentTypeDto> update(@RequestBody List<PaymentTypeDto> dto) {
        return paymentTypeService.update(dto);
    }

    @Operation(summary = "Сохранить")
    @PostMapping
    public PaymentTypeDto save(@RequestBody PaymentTypeDto dto) {
        return paymentTypeService.save(dto);
    }

    @Operation(summary = "Сохранить список")
    @PostMapping("/specific-list")
    public List<PaymentTypeDto> save(@RequestBody List<PaymentTypeDto> dto) {
        return paymentTypeService.save(dto);
    }

    @Operation(summary = "Удалить по идентификатору")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        paymentTypeService.delete(id);
    }

    @Operation(summary = "Удалить список по идентификаторам")
    @DeleteMapping("/specific-list")
    public void delete(@RequestBody List<Long> id) {
        paymentTypeService.delete(id);
    }
}
