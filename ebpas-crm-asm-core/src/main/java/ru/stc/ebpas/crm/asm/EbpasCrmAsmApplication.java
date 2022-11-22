package ru.stc.ebpas.crm.asm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication(scanBasePackages = {"ru.stc.ebpas.crm.asm"})
@EnableConfigurationProperties
public class EbpasCrmAsmApplication {

    public static void main(String[] args) {
        SpringApplication.run(EbpasCrmAsmApplication.class, args);
    }
}
