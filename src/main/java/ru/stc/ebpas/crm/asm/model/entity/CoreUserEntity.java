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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@Table(name = "core_user")
@EntityListeners(AuditingEntityListener.class)
public class CoreUserEntity extends DefaultSystemAttributes implements Serializable {

    @Id
    @Column(name = "core_user_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "core_user_seq_gen")
    @SequenceGenerator(name = "core_user_seq_gen", sequenceName = "core_user_seq", allocationSize = 1)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_info_id", referencedColumnName = "user_info_id", nullable = false)
    private UserInfoEntity userInfo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_info_id", referencedColumnName = "organization_info_id", nullable = false)
    private OrganizationInfoEntity organizationInfo;

    @Column(name = "blocked_status")
    private Boolean blocked;

    @OneToMany(mappedBy = "coreUser")
    private Set<ClientEntity> clients;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        CoreUserEntity that = (CoreUserEntity) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
