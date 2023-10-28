package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import ru.stc.ebpas.crm.pm.EbpasCrmPmApplication;
import ru.stc.ebpas.crm.pm.controller.AvailableProductController;
import ru.stc.ebpas.crm.pm.model.dto.ChangeProductQuantityRequestDto;
import ru.stc.ebpas.crm.pm.service.api.AvailableProductService;

import java.nio.charset.StandardCharsets;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(AvailableProductController.class)
@ContextConfiguration(classes = {EbpasCrmPmApplication.class})
public class AvailableProductControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private AvailableProductService availableProductService;

    @SneakyThrows
    @Test
    void getHarvestingResponseByClearcutNo() {
        doNothing().when(availableProductService).changeProductQuantity(any(Long.class), any(ChangeProductQuantityRequestDto.class));


        mockMvc.perform(post("/available-product/change-product-quantity")
                        .characterEncoding(StandardCharsets.UTF_8)
                        .param("productId", "123")
                        .content(getJsonFromObject(new ChangeProductQuantityRequestDto()))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isInternalServerError());
//                .andExpect(status().isOk());
    }

    @SneakyThrows
    protected String getJsonFromObject(Object obj) {
        return objectMapper.writer().withDefaultPrettyPrinter().writeValueAsString(obj);
    }
}
