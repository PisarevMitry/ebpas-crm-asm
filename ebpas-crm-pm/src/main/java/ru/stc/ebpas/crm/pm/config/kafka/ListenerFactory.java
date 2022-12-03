package ru.stc.ebpas.crm.pm.config.kafka;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.listener.DeadLetterPublishingRecoverer;
import org.springframework.kafka.listener.SeekToCurrentErrorHandler;
import org.springframework.util.backoff.FixedBackOff;

import java.util.HashMap;
import java.util.Map;

/**
 * Фабрика различных слушателей топиков Кафка.
 */
public final class ListenerFactory {

    private ListenerFactory() {
    }

    /**
     * Создаёт фабрику обрабоки сообщений с автоматической отметкой успешной транзакции.
     *
     * @param properties конфигурация приложения
     * @param template   интерфейс к брокеру
     * @return KafkaListenerContainerFactory
     */
    public static KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, String>>
    createAutoListenerFactory(final KafkaBrokerProperties properties, final KafkaTemplate<?, ?> template) {
        final Map<String, Object> props = createDefaultProperties(properties);
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, true);
        final DefaultKafkaConsumerFactory<Object, Object> consumerFactory = new DefaultKafkaConsumerFactory<>(props);
        final ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory);
        factory.setErrorHandler(new SeekToCurrentErrorHandler(new DeadLetterPublishingRecoverer(template),
                new FixedBackOff(FixedBackOff.DEFAULT_INTERVAL, properties.getMaxRetries())));
        return factory;
    }

    /**
     * Создаёт фабрику обработки сообщений по умолчанию.
     *
     * @param properties конфигурация приложения
     * @return KafkaListenerContainerFactory
     */
    public static KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, String>>
    createDefaultListenerFactory(final KafkaBrokerProperties properties) {
        final Map<String, Object> props = createDefaultProperties(properties);
        final DefaultKafkaConsumerFactory<Object, Object> consumerFactory = new DefaultKafkaConsumerFactory<>(props);
        final ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory);
        factory.setErrorHandler(new SeekToCurrentErrorHandler());
        return factory;
    }

    /**
     * Вспомогательный: возвращает список необходимых параметров для слушателя по умолчанию.
     *
     * @param properties конфигурация приложения
     * @return props
     */
    private static Map<String, Object> createDefaultProperties(final KafkaBrokerProperties properties) {
        final Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, properties.getBootstrapServers());
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, properties.getConsumer().getGroupId());
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        return props;
    }
}
