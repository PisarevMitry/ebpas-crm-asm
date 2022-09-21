package ru.stc.ebpas.crm.asm.controller.provision;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.assertj.core.api.Assertions.assertThat;

public class ResponseBodyMatchers {

    private static final ObjectMapper OBJECT_MAPPER;

    static {
        OBJECT_MAPPER = new ObjectMapper();
        OBJECT_MAPPER.registerModule(new JavaTimeModule());
    }

    public <T> ResultMatcher isEmpty() {
        return mvcResult -> {
            String json = mvcResult.getResponse().getContentAsString();
            assertThat(json).isEmpty();
        };
    }

    public <T> ResultMatcher containsObjectAsJson(
            Object expectedObject,
            Class<T> targetClass) {
        return mvcResult -> {
            String json = mvcResult.getResponse().getContentAsString();
            T actualObject = OBJECT_MAPPER.readValue(json, targetClass);
            assertThat(actualObject).usingRecursiveComparison().isEqualTo(expectedObject);
        };
    }

    public <T> ResultMatcher containsObjectAsJson(
            Object expectedObject,
            TypeReference<T> typeReference) {
        return mvcResult -> {
            String json = mvcResult.getResponse().getContentAsString();
            T actualObject = OBJECT_MAPPER.readValue(json, typeReference);
            assertThat(actualObject).usingRecursiveComparison().isEqualTo(expectedObject);
        };
    }

    public static ResponseBodyMatchers responseBody() {
        return new ResponseBodyMatchers();
    }

}

