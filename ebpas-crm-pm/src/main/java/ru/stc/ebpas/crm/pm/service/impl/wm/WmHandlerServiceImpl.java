package ru.stc.ebpas.crm.pm.service.impl.wm;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.stc.ebpas.crm.pm.service.api.ProductService;
import ru.stc.ebpas.crm.pm.service.api.wm.WmHandlerService;

@RequiredArgsConstructor
@Service
public class WmHandlerServiceImpl implements WmHandlerService {

    private final ProductService productService;

    private final ObjectMapper objectMapper;

    @Override
    public void handleCreateProductRequest(String message) {
//        ProductDto convertedMessage = objectMapper.readValue(message, ProductDto.class);
//        productService.save(convertedMessage);
    }
}
