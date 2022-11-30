package ru.stc.ebpas.crm.pm.api.internal.producer;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import ru.stc.ebpas.common.api.internal.core.model.constant.header.MessageType;
import ru.stc.ebpas.common.api.internal.core.model.request.CommonRequestHeaders;
import ru.stc.ebpas.common.api.internal.core.producer.RouterKafkaProducer;
import ru.stc.ebpas.common.api.internal.core.utils.KafkaHeaderUtils;

import java.util.UUID;

@RequiredArgsConstructor
public class WmProducer {

    private static final String SENDER_CODE = "CRM-PM";

    private static final String RECEIVER_CODE = "WM";

    private final RouterKafkaProducer kafkaProducer;

    private final ObjectMapper objectMapper;

    @SneakyThrows
    public void startProcessConvert(Object message, UUID traceKey) {
        String mappedMessage = objectMapper.writer().withDefaultPrettyPrinter().writeValueAsString(message);

        CommonRequestHeaders headers = CommonRequestHeaders.builder()
                .senderCode(SENDER_CODE)
                .receiverCode(RECEIVER_CODE)
                .messageType(MessageType.REQUEST)
                .command(null)
                .responseCommand(null)
                .traceKey(UUID.randomUUID().toString())
                .kafkaCorrelationId(traceKey.toString())
                .build();

        kafkaProducer.sendMessage(KafkaHeaderUtils.getHeadersFromPojo(headers), mappedMessage);
    }
}
