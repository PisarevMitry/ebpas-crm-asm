package ru.stc.ebpas.crm.pm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication(scanBasePackages = {"ru.stc.ebpas.crm.pm"})
@EnableConfigurationProperties
public class EbpasCrmPmApplication {

    public static void main(String[] args) {
        SpringApplication.run(EbpasCrmPmApplication.class, args);
    }
}
