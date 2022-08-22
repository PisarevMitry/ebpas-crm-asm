package ru.stc.ebpas.crm.asm.model.entity;

import lombok.Data;
import org.hibernate.Hibernate;
import ru.stc.ebpas.common.core.model.entity.DefaultSystemAttributes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "client_address")
public class ClientAddressEntity extends DefaultSystemAttributes implements Serializable {

    @Id
    @Column(name = "client_address_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_address_seq_gen")
    @SequenceGenerator(name = "client_address_seq_gen", sequenceName = "client_address_seq", allocationSize = 1)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", referencedColumnName = "client_id", nullable = false)
    private ClientEntity client;

    @Column(name = "nsi_address_id")
    private Long nsiAddressId;

    @Column(name = "display_status")
    private Boolean displayed;

    @Column(name = "default_using_status")
    private Boolean defaultUsed;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        ClientAddressEntity that = (ClientAddressEntity) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}