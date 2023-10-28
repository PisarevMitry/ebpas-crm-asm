package ru.stc.ebpas.crm.pm.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.stc.ebpas.common.data.core.mapper.SimpleModelMapper;
import ru.stc.ebpas.common.data.core.repository.SimpleModelRepository;
import ru.stc.ebpas.common.data.core.service.AbstractSimpleModelDefaultService;
import ru.stc.ebpas.crm.pm.mapper.api.AvailableProductModelMapper;
import ru.stc.ebpas.crm.pm.model.dto.AvailableProductDto;
import ru.stc.ebpas.crm.pm.model.dto.ChangeProductQuantityRequestDto;
import ru.stc.ebpas.crm.pm.model.dto.StoreDto;
import ru.stc.ebpas.crm.pm.model.entity.AvailableProductEntity;
import ru.stc.ebpas.crm.pm.model.entity.ProductEntity;
import ru.stc.ebpas.crm.pm.repository.AvailableProductRepository;
import ru.stc.ebpas.crm.pm.repository.ProductRepository;
import ru.stc.ebpas.crm.pm.service.api.AvailableProductService;
import ru.stc.ebpas.crm.pm.service.api.StoreService;

@AllArgsConstructor
@Service
public class AvailableProductServiceImpl
        extends AbstractSimpleModelDefaultService<AvailableProductEntity, AvailableProductDto>
        implements AvailableProductService {

    private final AvailableProductModelMapper availableProductMapper;

    private final ProductRepository productRepository;

    private final AvailableProductRepository availableProductRepository;

    private final StoreService storeService;

    @Override
    public SimpleModelMapper<AvailableProductEntity, AvailableProductDto> getMapper() {
        return availableProductMapper;
    }

    @Override
    public SimpleModelRepository<AvailableProductEntity> getRepository() {
        return availableProductRepository;
    }

    @Override
    public void changeProductQuantity(Long productId, ChangeProductQuantityRequestDto changeProductQuantityRequest) {
        if (changeProductQuantityRequest.getSenderStoreId() != null && changeProductQuantityRequest.getRecipientStoreId() != null) {
            StoreDto senderStore = storeService.getById(changeProductQuantityRequest.getSenderStoreId());
            AvailableProductEntity availableProductDiv =
                    availableProductRepository.findByProductNomenclatureAndStoreId(changeProductQuantityRequest.getProductNomenclature(), senderStore.getId())
                            .orElseThrow(() -> new RuntimeException("Ничего не найдено"));
            availableProductDiv.setAmountTotal(availableProductDiv.getAmountTotal() - changeProductQuantityRequest.getCount());
            StoreDto recipientStore = storeService.getById(changeProductQuantityRequest.getRecipientStoreId());
            AvailableProductEntity availableProductSum =
                    availableProductRepository.findByProductNomenclatureAndStoreId(changeProductQuantityRequest.getProductNomenclature(), recipientStore.getId()).orElse(null);
            if (availableProductSum != null) {
                availableProductSum.setAmountTotal(availableProductSum.getAmountTotal() + changeProductQuantityRequest.getCount());
            } else {
                ProductEntity product = productRepository.findByNomenclature(changeProductQuantityRequest.getProductNomenclature());
                AvailableProductEntity newAvailableProduct = new AvailableProductEntity();
                newAvailableProduct.setProduct(product);
                newAvailableProduct.setAmountTotal(changeProductQuantityRequest.getCount());
                availableProductRepository.save(newAvailableProduct);
            }
        } else if (changeProductQuantityRequest.getSenderStoreId() != null) {
            StoreDto senderStore = storeService.getById(changeProductQuantityRequest.getSenderStoreId());
            AvailableProductEntity availableProductDiv =
                    availableProductRepository.findByProductNomenclatureAndStoreId(changeProductQuantityRequest.getProductNomenclature(), senderStore.getId())
                            .orElseThrow(() -> new RuntimeException("Ничего не найдено"));
            availableProductDiv.setAmountTotal(availableProductDiv.getAmountTotal() - changeProductQuantityRequest.getCount());
        } else if (changeProductQuantityRequest.getRecipientStoreId() != null) {
            StoreDto recipientStore = storeService.getById(changeProductQuantityRequest.getRecipientStoreId());
            AvailableProductEntity availableProductSum =
                    availableProductRepository.findByProductNomenclatureAndStoreId(changeProductQuantityRequest.getProductNomenclature(), recipientStore.getId()).orElse(null);
            if (availableProductSum != null) {
                availableProductSum.setAmountTotal(availableProductSum.getAmountTotal() + changeProductQuantityRequest.getCount());
            } else {
                ProductEntity product = productRepository.findByNomenclature(changeProductQuantityRequest.getProductNomenclature());
                AvailableProductEntity newAvailableProduct = new AvailableProductEntity();
                newAvailableProduct.setProduct(product);
                newAvailableProduct.setAmountTotal(changeProductQuantityRequest.getCount());
                availableProductRepository.save(newAvailableProduct);
            }
        }
    }
}

