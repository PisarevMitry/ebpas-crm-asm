package ru.stc.ebpas.crm.cm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication(scanBasePackages = {"ru.stc.ebpas.crm.cm"})
@EnableConfigurationProperties
public class EbpasCrmCmApplication {

    public static void main(String[] args) {
        SpringApplication.run(EbpasCrmCmApplication.class, args);
    }
}
