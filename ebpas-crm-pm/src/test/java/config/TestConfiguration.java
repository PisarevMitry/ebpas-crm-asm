package config;

import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.jeasy.random.FieldPredicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Configuration
public class TestConfiguration {

    /**
     * Бин EasyRandom (заполнение объектов рандомными значениями).
     * @return {@link EasyRandom}
     */
    @Bean
    public EasyRandom easyRandom() {
        return new EasyRandom(getEasyRandomParameters());
    }

    private EasyRandomParameters getEasyRandomParameters() {
        EasyRandomParameters parameters = new EasyRandomParameters();
        parameters.setCollectionSizeRange(new EasyRandomParameters.Range<>(0, 0));
        parameters.setStringLengthRange(new EasyRandomParameters.Range<>(1, 1));

        parameters.excludeField(FieldPredicates.named("id"));
        parameters.excludeField(FieldPredicates.isAnnotatedWith(JoinColumn.class));
        parameters.excludeField(FieldPredicates.isAnnotatedWith(ManyToOne.class));
        parameters.excludeField(FieldPredicates.isAnnotatedWith(OneToMany.class));
        parameters.excludeField(FieldPredicates.isAnnotatedWith(OneToOne.class));
        return parameters;
    }
}
