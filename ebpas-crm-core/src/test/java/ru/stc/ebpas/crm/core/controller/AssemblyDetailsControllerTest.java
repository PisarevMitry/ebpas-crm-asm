package ru.stc.ebpas.crm.core.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.stc.ebpas.crm.core.model.dto.AssemblyDetailsDto;
import ru.stc.ebpas.crm.core.service.api.AssemblyDetailsService;

import static com.natpryce.makeiteasy.MakeItEasy.a;
import static com.natpryce.makeiteasy.MakeItEasy.make;
import static com.natpryce.makeiteasy.MakeItEasy.with;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.stc.ebpas.crm.core.controller.provision.ResponseBodyMatchers.responseBody;
import static ru.stc.ebpas.crm.core.controller.provision.maker.dto.AssemblyDetailsDtoMaker.ASSEMBLY_DETAILS_DTO;
import static ru.stc.ebpas.crm.core.controller.provision.maker.dto.AssemblyDetailsDtoMaker.ID;


@WebMvcTest(controllers = AssemblyDetailsController.class)
@Disabled
class AssemblyDetailsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AssemblyDetailsService assemblyDetailsService;

    @Autowired
    private ObjectMapper objectMapper;

    @Captor
    private ArgumentCaptor<AssemblyDetailsDto> assemblyDetailsDtoArgumentCaptor;

    @SneakyThrows
    @Test
    void getById() {
        AssemblyDetailsDto response = make(a(ASSEMBLY_DETAILS_DTO));
        when(assemblyDetailsService.getById(anyLong())).thenReturn(response);

        mockMvc.perform(get("/assembly-detail/{id}", response.getId()))
                .andExpect(status().isOk())
                .andExpect(responseBody().containsObjectAsJson(response, AssemblyDetailsDto.class));

        verify(assemblyDetailsService, times(1)).getById(anyLong());
    }

    @SneakyThrows
    @Test
    void update() {
        AssemblyDetailsDto dto = make(a(ASSEMBLY_DETAILS_DTO, with(ID, 1L)));

        when(assemblyDetailsService.update(any(AssemblyDetailsDto.class))).thenReturn(dto);

        mockMvc.perform(put("/assembly-detail")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(responseBody().containsObjectAsJson(dto, AssemblyDetailsDto.class));

        verify(assemblyDetailsService, times(1)).update(assemblyDetailsDtoArgumentCaptor.capture());
        verify(assemblyDetailsService, times(0)).save(assemblyDetailsDtoArgumentCaptor.capture());
        assertThat(assemblyDetailsDtoArgumentCaptor.getValue().getId()).isEqualTo(1L);
    }
}