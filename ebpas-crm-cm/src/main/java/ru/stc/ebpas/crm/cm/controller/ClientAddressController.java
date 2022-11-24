package ru.stc.ebpas.crm.cm.controller;

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
import ru.stc.ebpas.crm.cm.model.dto.ClientAddressDto;
import ru.stc.ebpas.crm.cm.service.api.ClientAddressService;

import java.util.List;

@Tag(name = "API работы с адресами клиентов")
@RequiredArgsConstructor
@RestController
@RequestMapping("/client-address")
public class ClientAddressController {

    private final ClientAddressService clientAddressService;

    @Operation(summary = "Получить по идентификатору")
    @GetMapping("/{id}")
    public ClientAddressDto getById(@PathVariable Long id) {
        return clientAddressService.getById(id);
    }

    @Operation(summary = "Получить по списку идентификаторов")
    @GetMapping("/specific-list")
    public List<ClientAddressDto> getById(@RequestBody List<Long> listId) {
        return clientAddressService.getById(listId);
    }

    @Operation(summary = "Получить по списку идентификаторов постранично")
    @GetMapping("/specific-list/pageble")
    public Page<ClientAddressDto> getById(@RequestBody List<Long> listId, Pageable pageable) {
        return clientAddressService.getById(listId, pageable);
    }

    @Operation(summary = "Получить все")
    @GetMapping("/all")
    public List<ClientAddressDto> getAll() {
        return clientAddressService.getAll();
    }

    @Operation(summary = "Получить все постранично")
    @GetMapping("/all/pageble")
    public Page<ClientAddressDto> getAll(Pageable pageable) {
        return clientAddressService.getAll(pageable);
    }

    @Operation(summary = "Обновить")
    @PutMapping
    public ClientAddressDto update(@RequestBody ClientAddressDto dto) {
        return clientAddressService.update(dto);
    }

    @Operation(summary = "Обновить список")
    @PutMapping("/specific-list")
    public List<ClientAddressDto> updateList(@RequestBody List<ClientAddressDto> dto) {
        return clientAddressService.update(dto);
    }

    @Operation(summary = "Сохранить")
    @PostMapping
    public ClientAddressDto save(@RequestBody ClientAddressDto dto) {
        return clientAddressService.save(dto);
    }

    @Operation(summary = "Сохранить список")
    @PostMapping("/specific-list")
    public List<ClientAddressDto> save(@RequestBody List<ClientAddressDto> dto) {
        return clientAddressService.save(dto);
    }

    @Operation(summary = "Удалить по идентификатору")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        clientAddressService.delete(id);
    }

    @Operation(summary = "Удалить список по идентификаторам")
    @DeleteMapping("/specific-list")
    public void delete(@RequestBody List<Long> id) {
        clientAddressService.delete(id);
    }
}
