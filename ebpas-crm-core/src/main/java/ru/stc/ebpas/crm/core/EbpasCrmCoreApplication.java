package ru.stc.ebpas.crm.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication(scanBasePackages = {"ru.stc.ebpas.crm.core"})
@EnableConfigurationProperties
public class EbpasCrmCoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(EbpasCrmCoreApplication.class, args);
    }
}
