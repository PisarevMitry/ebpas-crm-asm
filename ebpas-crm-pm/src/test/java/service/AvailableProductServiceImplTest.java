package service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.stc.ebpas.crm.pm.mapper.api.AvailableProductModelMapperImpl;
import ru.stc.ebpas.crm.pm.repository.AvailableProductRepository;
import ru.stc.ebpas.crm.pm.service.impl.AvailableProductServiceImpl;

import java.util.Collections;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class AvailableProductServiceImplTest {

    @Mock
    private AvailableProductRepository availableProductRepository;
    @Mock
    private AvailableProductModelMapperImpl availableProductModelMapper;
    @InjectMocks
    private AvailableProductServiceImpl availableProductService;

    @Test
    public void test() {
        //given

        //when
        when(availableProductRepository.findAll()).thenReturn(Collections.emptyList());

        //then
        assertThatThrownBy(() -> availableProductService.getAll())
                .isInstanceOf(Exception.class);
//                .hasMessageContaining(ExceptionCodes.ENTITY_NOT_FOUND);
    }

    @Test
    public void test2() {
        //given
        //when
        when(availableProductRepository.findAll()).thenReturn(Collections.emptyList());

        //then
        assertEquals(Collections.emptyList(), availableProductService.getAll());
    }

}
