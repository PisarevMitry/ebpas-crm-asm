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
import ru.stc.ebpas.crm.asm.model.dto.PaymentDetailsDto;
import ru.stc.ebpas.crm.asm.service.api.PaymentDetailsService;

import java.util.List;

@Tag(name = "API модели 3")
@RequiredArgsConstructor
@RestController
@RequestMapping("/payment-details")
public class PaymentDetailsController {

    private final PaymentDetailsService paymentDetailsService;

    @Operation(summary = "Получить по идентификатору")
    @GetMapping("/{id}")
    public PaymentDetailsDto getById(@PathVariable Long id) {
        return paymentDetailsService.getById(id);
    }

    @Operation(summary = "Получить по списку идентификаторов")
    @GetMapping("/specific-list")
    public List<PaymentDetailsDto> getById(@RequestBody List<Long> listId) {
        return paymentDetailsService.getById(listId);
    }

    @Operation(summary = "Получить по списку идентификаторов постранично")
    @GetMapping("/specific-list/pageble")
    public Page<PaymentDetailsDto> getById(@RequestBody List<Long> listId, Pageable pageable) {
        return paymentDetailsService.getById(listId, pageable);
    }

    @Operation(summary = "Получить все")
    @GetMapping("/all")
    public List<PaymentDetailsDto> getAll() {
        return paymentDetailsService.getAll();
    }

    @Operation(summary = "Получить все постранично")
    @GetMapping("/all/pageble")
    public Page<PaymentDetailsDto> getAll(Pageable pageable) {
        return paymentDetailsService.getAll(pageable);
    }

    @Operation(summary = "Обновить")
    @PutMapping
    public PaymentDetailsDto update(@RequestBody PaymentDetailsDto dto) {
        return paymentDetailsService.update(dto);
    }

    @Operation(summary = "Обновить список")
    @PutMapping("/specific-list")
    public List<PaymentDetailsDto> update(@RequestBody List<PaymentDetailsDto> dto) {
        return paymentDetailsService.update(dto);
    }

    @Operation(summary = "Сохранить")
    @PostMapping
    public PaymentDetailsDto save(@RequestBody PaymentDetailsDto dto) {
        return paymentDetailsService.save(dto);
    }

    @Operation(summary = "Сохранить список")
    @PostMapping("/specific-list")
    public List<PaymentDetailsDto> save(@RequestBody List<PaymentDetailsDto> dto) {
        return paymentDetailsService.save(dto);
    }

    @Operation(summary = "Удалить по идентификатору")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        paymentDetailsService.delete(id);
    }

    @Operation(summary = "Удалить список по идентификаторам")
    @DeleteMapping("/specific-list")
    public void delete(@RequestBody List<Long> id) {
        paymentDetailsService.delete(id);
    }
}
