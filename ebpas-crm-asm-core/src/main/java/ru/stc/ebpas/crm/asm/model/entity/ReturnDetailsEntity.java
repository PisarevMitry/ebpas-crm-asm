package ru.stc.ebpas.crm.asm.model.entity;

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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "return_details")
@EntityListeners(AuditingEntityListener.class)
public class ReturnDetailsEntity extends DefaultSystemAttributes implements Serializable, SimpleDatabaseEntity {

    @Id
    @Column(name = "return_details_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "return_details_seq_gen")
    @SequenceGenerator(name = "return_details_seq_gen", sequenceName = "return_details_seq", allocationSize = 1)
    private Long id;

    @Column(name = "nsi_return_reason")
    private Long nsiReturnReason;

    @Column(name = "nsi_return_status")
    private Long nsiReturnStatus;

    @Column(name = "nsi_return_requirement")
    private Long nsiReturnRequirement;

//    @Column(name = "system_details")
//    private Object systemDetails;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "returnDetails")
    private CoreOrderEntity coreOrder;

    @OneToMany(mappedBy = "returnDetails")
    private Set<DefectiveProductEntity> defectiveProducts;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        ReturnDetailsEntity that = (ReturnDetailsEntity) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
