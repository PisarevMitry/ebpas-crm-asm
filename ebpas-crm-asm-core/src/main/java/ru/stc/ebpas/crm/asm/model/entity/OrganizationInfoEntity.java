package ru.stc.ebpas.crm.asm.model.entity;

import lombok.Data;
import org.hibernate.Hibernate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import ru.stc.ebpas.common.core.model.entity.DefaultSystemAttributes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@Table(name = "organization_info")
@EntityListeners(AuditingEntityListener.class)
public class OrganizationInfoEntity extends DefaultSystemAttributes implements Serializable {

    @Id
    @Column(name = "organization_info_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "organization_info_seq_gen")
    @SequenceGenerator(name = "organization_info_seq_gen", sequenceName = "organization_info_seq", allocationSize = 1)
    private Long id;

    @OneToMany(mappedBy = "organizationInfo")
    private Set<CoreUserEntity> coreUsers;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        OrganizationInfoEntity that = (OrganizationInfoEntity) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
