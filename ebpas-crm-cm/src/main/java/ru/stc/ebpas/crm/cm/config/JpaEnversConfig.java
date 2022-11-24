package ru.stc.ebpas.crm.cm.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {"ru.stc.ebpas.crm.cm", "ru.stc.ebpas.common.data.core"})
@EnableJpaAuditing
@EntityScan({"ru.stc.ebpas.crm.cm.model.entity"})
public class JpaEnversConfig {
}
