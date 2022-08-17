package com.example.ebpas.crm.asm.model.entity;

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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "user_info")
@EntityListeners(AuditingEntityListener.class)
public class UserInfoEntity extends DefaultSystemAttributes implements Serializable {

    @Id
    @Column(name = "user_info_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_info_seq_gen")
    @SequenceGenerator(name = "user_info_seq_gen", sequenceName = "user_info_seq", allocationSize = 1)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "second_name")
    private String secondName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "mail")
    private String mail;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "userInfo")
    private CoreUserEntity coreUser;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        UserInfoEntity that = (UserInfoEntity) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
