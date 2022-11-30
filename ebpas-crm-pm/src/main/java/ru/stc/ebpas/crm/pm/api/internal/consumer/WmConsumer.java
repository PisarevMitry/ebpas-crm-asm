package ru.stc.ebpas.crm.pm.api.internal.consumer;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import ru.stc.ebpas.crm.pm.service.api.wm.WmHandlerService;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class WmConsumer {

    private final WmHandlerService wmHandlerService;

    @KafkaListener(topics = "${kafka.consumer.topicName.wmCrmSaveProduct}",
            groupId = "${kafka.consumer.groupId}",
            containerFactory = "routerDefaultContainerFactory")
    public void receiveCreateProductRequest(@Payload String message,
                                            @Header("kafka_correlationId") UUID kafkaCorrelationId) {
        wmHandlerService.handleCreateProductRequest(message);
    }
}