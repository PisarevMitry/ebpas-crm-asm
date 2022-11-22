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
import ru.stc.ebpas.crm.asm.model.dto.ClientPaymentMethodDto;
import ru.stc.ebpas.crm.asm.service.api.ClientPaymentMethodService;

import java.util.List;

@Tag(name = "API работы со способами оплаты клиентов")
@RequiredArgsConstructor
@RestController
@RequestMapping("/client-payment-method")
public class ClientPaymentMethodController {

    private final ClientPaymentMethodService clientPaymentMethodService;

    @Operation(summary = "Получить по идентификатору")
    @GetMapping("/{id}")
    public ClientPaymentMethodDto getById(@PathVariable Long id) {
        return clientPaymentMethodService.getById(id);
    }

    @Operation(summary = "Получить по списку идентификаторов")
    @GetMapping("/specific-list")
    public List<ClientPaymentMethodDto> getById(@RequestBody List<Long> listId) {
        return clientPaymentMethodService.getById(listId);
    }

    @Operation(summary = "Получить по списку идентификаторов постранично")
    @GetMapping("/specific-list/pageble")
    public Page<ClientPaymentMethodDto> getById(@RequestBody List<Long> listId, Pageable pageable) {
        return clientPaymentMethodService.getById(listId, pageable);
    }

    @Operation(summary = "Получить все")
    @GetMapping("/all")
    public List<ClientPaymentMethodDto> getAll() {
        return clientPaymentMethodService.getAll();
    }

    @Operation(summary = "Получить все постранично")
    @GetMapping("/all/pageble")
    public Page<ClientPaymentMethodDto> getAll(Pageable pageable) {
        return clientPaymentMethodService.getAll(pageable);
    }

    @Operation(summary = "Обновить")
    @PutMapping
    public ClientPaymentMethodDto update(@RequestBody ClientPaymentMethodDto dto) {
        return clientPaymentMethodService.update(dto);
    }

    @Operation(summary = "Обновить список")
    @PutMapping("/specific-list")
    public List<ClientPaymentMethodDto> update(@RequestBody List<ClientPaymentMethodDto> dto) {
        return clientPaymentMethodService.update(dto);
    }

    @Operation(summary = "Сохранить")
    @PostMapping
    public ClientPaymentMethodDto save(@RequestBody ClientPaymentMethodDto dto) {
        return clientPaymentMethodService.save(dto);
    }

    @Operation(summary = "Сохранить список")
    @PostMapping("/specific-list")
    public List<ClientPaymentMethodDto> save(@RequestBody List<ClientPaymentMethodDto> dto) {
        return clientPaymentMethodService.save(dto);
    }

    @Operation(summary = "Удалить по идентификатору")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        clientPaymentMethodService.delete(id);
    }

    @Operation(summary = "Удалить список по идентификаторам")
    @DeleteMapping("/specific-list")
    public void delete(@RequestBody List<Long> id) {
        clientPaymentMethodService.delete(id);
    }
}
