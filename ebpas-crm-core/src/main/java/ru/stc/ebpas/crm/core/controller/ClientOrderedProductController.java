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
import ru.stc.ebpas.crm.core.model.dto.ClientOrderedProductDto;
import ru.stc.ebpas.crm.core.model.entity.ClientOrderedProductKey;
import ru.stc.ebpas.crm.core.service.api.ClientOrderedProductService;

import java.util.List;

@Tag(name = "API работы с заказанными товарами клиентов")
@RequiredArgsConstructor
@RestController
@RequestMapping("/client-ordered-product")
public class ClientOrderedProductController {

    private final ClientOrderedProductService clientOrderedProductService;

    @Operation(summary = "Получить по идентификатору")
    @GetMapping
    public ClientOrderedProductDto getById(@RequestBody ClientOrderedProductKey id) {
        return clientOrderedProductService.getById(id);
    }

    @Operation(summary = "Получить по списку идентификаторов")
    @GetMapping("/specific-list")
    public List<ClientOrderedProductDto> getById(@RequestBody List<ClientOrderedProductKey> listId) {
        return clientOrderedProductService.getById(listId);
    }

    @Operation(summary = "Получить по списку идентификаторов постранично")
    @GetMapping("/specific-list/pageble")
    public Page<ClientOrderedProductDto> getById(@RequestBody List<ClientOrderedProductKey> listId, Pageable pageable) {
        return clientOrderedProductService.getById(listId, pageable);
    }

    @Operation(summary = "Получить все")
    @GetMapping("/all")
    public List<ClientOrderedProductDto> getAll() {
        return clientOrderedProductService.getAll();
    }

    @Operation(summary = "Получить все постранично")
    @GetMapping("/all/pageble")
    public Page<ClientOrderedProductDto> getAll(Pageable pageable) {
        return clientOrderedProductService.getAll(pageable);
    }

    @Operation(summary = "Обновить")
    @PutMapping
    public ClientOrderedProductDto update(@RequestBody ClientOrderedProductDto dto) {
        return clientOrderedProductService.update(dto);
    }

    @Operation(summary = "Обновить список")
    @PutMapping("/specific-list")
    public List<ClientOrderedProductDto> update(@RequestBody List<ClientOrderedProductDto> dto) {
        return clientOrderedProductService.update(dto);
    }

    @Operation(summary = "Сохранить")
    @PostMapping
    public ClientOrderedProductDto save(@RequestBody ClientOrderedProductDto dto) {
        return clientOrderedProductService.save(dto);
    }

    @Operation(summary = "Сохранить список")
    @PostMapping("/specific-list")
    public List<ClientOrderedProductDto> save(@RequestBody List<ClientOrderedProductDto> dto) {
        return clientOrderedProductService.save(dto);
    }

    @Operation(summary = "Удалить по идентификатору")
    @DeleteMapping
    public void delete(@RequestBody ClientOrderedProductKey id) {
        clientOrderedProductService.delete(id);
    }

    @Operation(summary = "Удалить список по идентификаторам")
    @DeleteMapping("/specific-list")
    public void delete(@RequestBody List<ClientOrderedProductKey> id) {
        clientOrderedProductService.delete(id);
    }
}
