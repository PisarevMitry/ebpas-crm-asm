package ru.stc.ebpas.crm.om.model.entity;

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
import javax.persistence.ManyToOne;
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
@Table(name = "defective_product")
@EntityListeners(AuditingEntityListener.class)
public class DefectiveProductEntity extends DefaultSystemAttributes implements Serializable, SimpleDatabaseEntity {

    @Id
    @Column(name = "defective_product_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "defective_product_seq_gen")
    @SequenceGenerator(name = "defective_product_seq_gen", sequenceName = "defective_product_seq", allocationSize = 1)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "return_details_id", referencedColumnName = "return_details_id", nullable = false)
    private ReturnDetailsEntity returnDetails;

    @Column(name = "product_id")
    private Long product;

    @Column(name = "defect_description")
    private String defectDescription;

    @Column(name = "receiving_status")
    private Boolean receivingStatus;

//    @Column(name = "system_details")
//    private Object systemDetails;

    @OneToMany(mappedBy = "defectiveProduct")
    private Set<DefectiveProductPhotoEntity> defectiveProductPhotos;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        DefectiveProductEntity that = (DefectiveProductEntity) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
