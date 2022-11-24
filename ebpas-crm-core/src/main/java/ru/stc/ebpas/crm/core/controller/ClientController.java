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
import ru.stc.ebpas.crm.core.model.dto.ClientDto;
import ru.stc.ebpas.crm.core.service.api.ClientService;

import java.util.List;

@Tag(name = "API работы с клиентами")
@RequiredArgsConstructor
@RestController
@RequestMapping("/client")
public class ClientController {

    private final ClientService clientService;

    @Operation(summary = "Получить по идентификатору")
    @GetMapping("/{id}")
    public ClientDto getById(@PathVariable Long id) {
        return clientService.getById(id);
    }

    @Operation(summary = "Получить по списку идентификаторов")
    @GetMapping("/specific-list")
    public List<ClientDto> getById(@RequestBody List<Long> listId) {
        return clientService.getById(listId);
    }

    @Operation(summary = "Получить по списку идентификаторов постранично")
    @GetMapping("/specific-list/pageble")
    public Page<ClientDto> getById(@RequestBody List<Long> listId, Pageable pageable) {
        return clientService.getById(listId, pageable);
    }

    @Operation(summary = "Получить все")
    @GetMapping("/all")
    public List<ClientDto> getAll() {
        return clientService.getAll();
    }

    @Operation(summary = "Получить все постранично")
    @GetMapping("/all/pageble")
    public Page<ClientDto> getAll(Pageable pageable) {
        return clientService.getAll(pageable);
    }

    @Operation(summary = "Обновить")
    @PutMapping
    public ClientDto update(@RequestBody ClientDto dto) {
        return clientService.update(dto);
    }

    @Operation(summary = "Обновить список")
    @PutMapping("/specific-list")
    public List<ClientDto> update(@RequestBody List<ClientDto> dto) {
        return clientService.update(dto);
    }

    @Operation(summary = "Сохранить")
    @PostMapping
    public ClientDto save(@RequestBody ClientDto dto) {
        return clientService.save(dto);
    }

    @Operation(summary = "Сохранить список")
    @PostMapping("/specific-list")
    public List<ClientDto> save(@RequestBody List<ClientDto> dto) {
        return clientService.save(dto);
    }

    @Operation(summary = "Удалить по идентификатору")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        clientService.delete(id);
    }

    @Operation(summary = "Удалить список по идентификаторам")
    @DeleteMapping("/specific-list")
    public void delete(@RequestBody List<Long> id) {
        clientService.delete(id);
    }
}
