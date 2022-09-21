package ru.stc.ebpas.crm.asm.controller;

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
import ru.stc.ebpas.crm.asm.model.dto.ClientShoppedProductDto;
import ru.stc.ebpas.crm.asm.model.entity.ClientShoppedProductKey;
import ru.stc.ebpas.crm.asm.service.api.ClientShoppedProductService;

import java.util.List;

@Tag(name = "API работы с деталями о заказе")
@RequiredArgsConstructor
@RestController
@RequestMapping("/client-shopped-product")
public class ClientShoppedProductController {

    private final ClientShoppedProductService clientShoppedProductService;

    @Operation(summary = "Получить по идентификатору")
    @GetMapping
    public ClientShoppedProductDto getById(@RequestBody ClientShoppedProductKey id) {
        return clientShoppedProductService.getById(id);
    }

    @Operation(summary = "Получить по списку идентификаторов")
    @GetMapping("/specific-list")
    public List<ClientShoppedProductDto> getById(@RequestBody List<ClientShoppedProductKey> listId) {
        return clientShoppedProductService.getById(listId);
    }

    @Operation(summary = "Получить по списку идентификаторов постранично")
    @GetMapping("/specific-list/pageble")
    public Page<ClientShoppedProductDto> getById(@RequestBody List<ClientShoppedProductKey> listId, Pageable pageable) {
        return clientShoppedProductService.getById(listId, pageable);
    }

    @Operation(summary = "Получить все")
    @GetMapping("/all")
    public List<ClientShoppedProductDto> getAll() {
        return clientShoppedProductService.getAll();
    }

    @Operation(summary = "Получить все постранично")
    @GetMapping("/all/pageble")
    public Page<ClientShoppedProductDto> getAll(Pageable pageable) {
        return clientShoppedProductService.getAll(pageable);
    }

    @Operation(summary = "Обновить")
    @PutMapping
    public ClientShoppedProductDto update(@RequestBody ClientShoppedProductDto dto) {
        return clientShoppedProductService.update(dto);
    }

    @Operation(summary = "Обновить список")
    @PutMapping("/specific-list")
    public List<ClientShoppedProductDto> update(@RequestBody List<ClientShoppedProductDto> dto) {
        return clientShoppedProductService.update(dto);
    }

    @Operation(summary = "Сохранить")
    @PostMapping
    public ClientShoppedProductDto save(@RequestBody ClientShoppedProductDto dto) {
        return clientShoppedProductService.save(dto);
    }

    @Operation(summary = "Сохранить список")
    @PostMapping("/specific-list")
    public List<ClientShoppedProductDto> save(@RequestBody List<ClientShoppedProductDto> dto) {
        return clientShoppedProductService.save(dto);
    }

    @Operation(summary = "Удалить по идентификатору")
    @DeleteMapping
    public void delete(@RequestBody ClientShoppedProductKey id) {
        clientShoppedProductService.delete(id);
    }

    @Operation(summary = "Удалить список по идентификаторам")
    @DeleteMapping("/specific-list")
    public void delete(@RequestBody List<ClientShoppedProductKey> id) {
        clientShoppedProductService.delete(id);
    }
}
