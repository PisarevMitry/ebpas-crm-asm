package ru.stc.ebpas.crm.pm.config.kafka;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.converter.MessagingMessageConverter;

import java.util.HashMap;
import java.util.Map;

/**
 * Конфигурация сендеров.
 */
@Configuration
public class KafkaSenderConfig {

    private static final String MAX_SIZE = "314572800";

    private final KafkaBrokerProperties properties;

    @Autowired
    public KafkaSenderConfig(KafkaBrokerProperties properties) {
        this.properties = properties;
    }

    /**
     * Apache kafka admin client bean.
     *
     * @return {@link AdminClient}
     */
    @Bean
    public AdminClient adminClient() {
        return AdminClient.create(Map.of(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, properties.getBootstrapServers()));
    }

    /**
     * Создатель DefaultKafkaProducerFactory.
     *
     * @return ProducerFactory
     */
    @Bean
    public ProducerFactory<String, String> producerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfigs());
    }

    /**
     * KafkaTemplate конфигурация.
     *
     * @return KafkaTemplate
     */
    @Bean(name = "kafkaTemplate")
    public KafkaTemplate<String, String> kafkaTemplate() {
        KafkaTemplate<String, String> template = new KafkaTemplate<>(producerFactory());
        template.setMessageConverter(new MessagingMessageConverter());
        return template;
    }

    /**
     * producer конфигурация.
     *
     * @return props
     */
    private Map<String, Object> producerConfigs() {
        final Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, properties.getBootstrapServers());
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.MAX_REQUEST_SIZE_CONFIG, MAX_SIZE);
        return props;
    }
}
