package ru.stc.ebpas.crm.asm.model.entity;

import lombok.Data;
import org.hibernate.Hibernate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import ru.stc.ebpas.common.core.model.entity.DefaultSystemAttributes;

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

@Data
@Entity
@Table(name = "assembly_details")
@EntityListeners(AuditingEntityListener.class)
public class AssemblyDetailsEntity extends DefaultSystemAttributes implements Serializable {

    @Id
    @Column(name = "assembly_details_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "assembly_details_seq_gen")
    @SequenceGenerator(name = "assembly_details_seq_gen", sequenceName = "assembly_details_seq", allocationSize = 1)
    private Long id;

    @Column(name = "nsi_assembly_status")
    private Long nsiAssemblyStatus;

    @OneToMany(mappedBy = "assemblyDetails")
    private Set<ClientOrderedProductEntity> orderedProducts;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "assemblyDetails")
    private CoreOrderEntity coreOrder;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        AssemblyDetailsEntity that = (AssemblyDetailsEntity) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}