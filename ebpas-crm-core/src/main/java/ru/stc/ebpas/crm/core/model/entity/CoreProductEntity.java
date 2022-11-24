package ru.stc.ebpas.crm.core.model.entity;

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
@Table(name = "core_product")
@EntityListeners(AuditingEntityListener.class)
public class CoreProductEntity extends DefaultSystemAttributes implements Serializable, SimpleDatabaseEntity {

    @Id
    @Column(name = "core_product_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "core_product_seq_gen")
    @SequenceGenerator(name = "core_product_seq_gen", sequenceName = "core_product_seq", allocationSize = 1)
    private Long id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "core_description")
    private String coreDescription;

//    @Column(name = "core_option")
//    @JdbcTypeCode(SqlTypes.JSON)
//    private ObjectNode options;

    @OneToMany(mappedBy = "coreProduct")
    private Set<ProductEntity> products;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        CoreProductEntity that = (CoreProductEntity) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
