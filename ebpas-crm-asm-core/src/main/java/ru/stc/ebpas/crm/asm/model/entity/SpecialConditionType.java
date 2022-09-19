package ru.stc.ebpas.crm.asm.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import ru.stc.ebpas.common.core.model.entity.DefaultSystemAttributes;
import ru.stc.ebpas.common.core.model.entity.SimpleDatabaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "special_condition_method")
public class SpecialConditionType extends DefaultSystemAttributes implements Serializable, SimpleDatabaseEntity {

    @Id
    @Column(name = "special_condition_method_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "special_condition_method_seq_gen")
    @SequenceGenerator(name = "special_condition_method_seq_gen", sequenceName = "special_condition_method_seq", allocationSize = 1)
    private Long id;

    @Column(name = "method_name")
    private String specialConditionName;

    @Column(name = "system_details")
    private String systemDetails;

    @OneToMany(mappedBy = "specialConditionType")
    private Set<CoreSpecialConditionEntity> specialConditionDetails;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        SpecialConditionType that = (SpecialConditionType) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
