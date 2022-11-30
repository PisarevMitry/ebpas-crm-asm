package ru.stc.ebpas.crm.pm.config.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;

/**
 * Фабрика контейнеров слушателей топиков.
 */
@Configuration
public class KafkaListenerFactoryConfig {

    private final KafkaBrokerProperties properties;
    private final KafkaTemplate<?, ?> template;

    @Autowired
    public KafkaListenerFactoryConfig(@Qualifier("kafkaBrokerProperties")KafkaBrokerProperties properties,
                                      @Qualifier("kafkaTemplate")KafkaTemplate<?, ?> template) {
        this.properties = properties;
        this.template = template;
    }

    /**
     * automaticContainerFactory конфигурация.
     *
     * @return asyncRouterAutomaticContainerFactory
     */
    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, String>> automaticContainerFactory() {
        return ListenerFactory.createAutoListenerFactory(properties, template);
    }

    /**
     * defaultContainerFactory конфигурация.
     *
     * @return KafkaListenerContainerFactory
     */
    @Bean
    @Primary
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, String>> defaultContainerFactory() {
        return ListenerFactory.createDefaultListenerFactory(properties);
    }
}
