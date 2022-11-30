package ru.stc.ebpas.crm.pm.config.kafka;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

/**
 * Проперти для работы с брокером Кафка.
 */
@Validated
@Configuration
@ConfigurationProperties(prefix = "kafka")
@Getter
@Setter
public class KafkaBrokerProperties {

    @NotNull
    private String bootstrapServers;
    private Consumer consumer = new Consumer();
    private Integer maxRetries;
    private TopicNames topicNames = new TopicNames();

    /**
     * Вложенный класс Consumer.
     */
    @Getter
    @Setter
    public static class Consumer {
        private String groupId;
    }

    /**
     * Вложенный класс TopicNames.
     */
    @Getter
    @Setter
    public static class TopicNames {
        private String topicName;
    }
}
