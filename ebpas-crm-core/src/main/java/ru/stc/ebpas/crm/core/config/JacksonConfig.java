package ru.stc.ebpas.crm.core.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.io.IOException;

/**
 * Конфигурация Jackson маппенра.
 */
@Configuration
public class JacksonConfig {

    /**
     * Конфигурация Jackson2HttpMessageConverter для нормального отображения
     * объекта типа Page при использовании @JsonView.
     *
     * @return MappingJackson2HttpMessageConverter
     */
    @Bean
    public MappingJackson2HttpMessageConverter jackson2HttpMessageConverter() {
        Jackson2ObjectMapperBuilder mapperBuilder = new Jackson2ObjectMapperBuilder()
                //.serializationInclusion(JsonInclude.Include.NON_NULL)
                .failOnEmptyBeans(false)
                .failOnUnknownProperties(false)
                .featuresToEnable(MapperFeature.DEFAULT_VIEW_INCLUSION)
                .defaultViewInclusion(true)
                .serializerByType(Page.class, new JsonPageSerializer());

        return new MappingJackson2HttpMessageConverter(mapperBuilder.build());
    }

    /**
     * Класс сериализатор для типа Page.
     */
    public static class JsonPageSerializer extends JsonSerializer<Page<?>> {

        @Override
        public void serialize(Page<?> page, JsonGenerator jsonGen, SerializerProvider serializerProvider)
                throws IOException {
            ObjectMapper om = new ObjectMapper()
                    .disable(MapperFeature.DEFAULT_VIEW_INCLUSION)
                    .setSerializationInclusion(JsonInclude.Include.ALWAYS);
            jsonGen.writeStartObject();

            jsonGen.writeFieldName("totalElements");
            jsonGen.writeNumber(page.getTotalElements());
            jsonGen.writeFieldName("totalPages");
            jsonGen.writeNumber(page.getTotalPages());
            jsonGen.writeFieldName("number");
            jsonGen.writeNumber(page.getNumber());
            jsonGen.writeFieldName("size");
            jsonGen.writeNumber(page.getSize());
            jsonGen.writeFieldName("first");
            jsonGen.writeBoolean(page.isFirst());
            jsonGen.writeFieldName("last");
            jsonGen.writeBoolean(page.isLast());
            jsonGen.writeFieldName("numberOfElements");
            jsonGen.writeNumber(page.getNumberOfElements());
            jsonGen.writeObjectField("sort", page.getSort());
            jsonGen.writeFieldName("content");
            jsonGen.writeRawValue(om.writerWithView(serializerProvider.getActiveView())
                    .writeValueAsString(page.getContent()));
            jsonGen.writeEndObject();
        }
    }

//    public static class JsonFgislkPageResponseSerializer extends JsonSerializer<FgislkPageResponse<?>> {
//
//        @Override
//        public void serialize(FgislkPageResponse<?> page, JsonGenerator jsonGen, SerializerProvider serializerProvider)
//                throws IOException {
//            ObjectMapper om = new ObjectMapper()
//                    .disable(MapperFeature.DEFAULT_VIEW_INCLUSION)
//                    .setSerializationInclusion(JsonInclude.Include.ALWAYS);
//            jsonGen.writeStartObject();
//
//            jsonGen.writeFieldName("totalElements");
//            jsonGen.writeNumber(page.getTotalElements());
//            jsonGen.writeFieldName("totalPages");
//            jsonGen.writeNumber(page.getTotalPages());
//            jsonGen.writeFieldName("content");
//            jsonGen.writeRawValue(om.writerWithView(serializerProvider.getActiveView())
//                    .writeValueAsString(page.getContent()));
//            jsonGen.writeEndObject();
//        }
//    }
}
