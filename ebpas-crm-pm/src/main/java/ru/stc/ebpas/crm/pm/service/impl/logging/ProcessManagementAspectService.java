package ru.stc.ebpas.crm.pm.service.impl.logging;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import ru.stc.ebpas.crm.pm.model.dto.ChangeProductQuantityRequestDto;

@RequiredArgsConstructor
@Aspect
@Component
@Slf4j
public class ProcessManagementAspectService {

    /**
     * Отслеживание процесса.
     **/
    @Around(
            value = "execution(* ru.stc.ebpas.crm.pm.controller.AvailableProductController." +
                    "changeProductQuantity(..)) && args(changeProductQuantityRequest)",
            argNames = "joinPoint, changeProductQuantityRequest")
    public Object executePulVerificationProcess(ProceedingJoinPoint joinPoint,
                                                ChangeProductQuantityRequestDto changeProductQuantityRequest) {
        Object object = null;
        log.debug("Запущен процесс изменения количества товара");
        try {
            object = joinPoint.proceed(joinPoint.getArgs());
            log.debug("Процесс изменения количества товара завершен успешно");
        } catch (Throwable e) {
            e.printStackTrace();
            log.debug("Процесс изменения количества товара прерван из-за возникновения ошибки");
        }

        return object;
    }
}