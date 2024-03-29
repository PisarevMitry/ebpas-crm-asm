package ru.stc.ebpas.crm.scm.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import ru.stc.ebpas.common.core.model.entity.DefaultSystemAttributes;
import ru.stc.ebpas.common.core.model.entity.SimpleDatabaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "special_condition_details")
@EntityListeners(AuditingEntityListener.class)
public class CoreSpecialConditionEntity extends DefaultSystemAttributes implements Serializable, SimpleDatabaseEntity {

    @Id
    @Column(name = "special_condition_details_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "special_condition_details_seq_gen")
    @SequenceGenerator(name = "special_condition_details_seq_gen", sequenceName = "special_condition_details_seq", allocationSize = 1)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "special_condition_method_id", referencedColumnName = "special_condition_method_id", nullable = false)
    private SpecialConditionType specialConditionType;

    @Column(name = "condition_description")
    private String description;

    @Column(name = "start_condition_dttm")
    private LocalDateTime startConditionDttm;

    @Column(name = "end_condition_dttm")
    private LocalDateTime endConditionDttm;

//    @Column(name = "system_details")
//    private Object systemDetails;

    @Column(name = "display_status")
    private Boolean displayed;

    @Column(name = "blocked_status")
    private Boolean blocked;

    //ToDo
    private Set<Long> availableProducts;

    private Set<Long> categories;

    private Set<Long> clients;

    private Set<Long> products;

    private Set<Long> stores;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        CoreSpecialConditionEntity that = (CoreSpecialConditionEntity) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
