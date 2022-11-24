package ru.stc.ebpas.crm.core.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.stc.ebpas.crm.core.model.dto.ClientDeferredProductDto;
import ru.stc.ebpas.crm.core.model.entity.ClientDeferredProductKey;
import ru.stc.ebpas.crm.core.service.api.ClientDeferredProductService;

import java.util.List;

@Tag(name = "API работы с отложенными товарами клиентов")
@RequiredArgsConstructor
@RestController
@RequestMapping("/client-deferred-product")
public class ClientDeferredProductController {

    private final ClientDeferredProductService clientDeferredProductService;

    @Operation(summary = "Получить по идентификатору")
    @GetMapping
    public ClientDeferredProductDto getById(@RequestBody ClientDeferredProductKey id) {
        return clientDeferredProductService.getById(id);
    }

    @Operation(summary = "Получить по списку идентификаторов")
    @GetMapping("/specific-list")
    public List<ClientDeferredProductDto> getById(@RequestBody List<ClientDeferredProductKey> listId) {
        return clientDeferredProductService.getById(listId);
    }

    @Operation(summary = "Получить по списку идентификаторов постранично")
    @GetMapping("/specific-list/pageble")
    public Page<ClientDeferredProductDto> getById(@RequestBody List<ClientDeferredProductKey> listId, Pageable pageable) {
        return clientDeferredProductService.getById(listId, pageable);
    }

    @Operation(summary = "Получить все")
    @GetMapping("/all")
    public List<ClientDeferredProductDto> getAll() {
        return clientDeferredProductService.getAll();
    }

    @Operation(summary = "Получить все постранично")
    @GetMapping("/all/pageble")
    public Page<ClientDeferredProductDto> getAll(Pageable pageable) {
        return clientDeferredProductService.getAll(pageable);
    }

    @Operation(summary = "Обновить")
    @PutMapping
    public ClientDeferredProductDto update(@RequestBody ClientDeferredProductDto dto) {
        return clientDeferredProductService.update(dto);
    }

    @Operation(summary = "Обновить список")
    @PutMapping("/specific-list")
    public List<ClientDeferredProductDto> update(@RequestBody List<ClientDeferredProductDto> dto) {
        return clientDeferredProductService.update(dto);
    }

    @Operation(summary = "Сохранить")
    @PostMapping
    public ClientDeferredProductDto save(@RequestBody ClientDeferredProductDto dto) {
        return clientDeferredProductService.save(dto);
    }

    @Operation(summary = "Сохранить список")
    @PostMapping("/specific-list")
    public List<ClientDeferredProductDto> save(@RequestBody List<ClientDeferredProductDto> dto) {
        return clientDeferredProductService.save(dto);
    }

    @Operation(summary = "Удалить по идентификатору")
    @DeleteMapping
    public void delete(@RequestBody ClientDeferredProductKey id) {
        clientDeferredProductService.delete(id);
    }

    @Operation(summary = "Удалить список по идентификаторам")
    @DeleteMapping("/specific-list")
    public void delete(@RequestBody List<ClientDeferredProductKey> id) {
        clientDeferredProductService.delete(id);
    }
}
