package ru.stc.ebpas.crm.cm.repository;

import org.springframework.stereotype.Repository;
import ru.stc.ebpas.common.data.core.repository.SimpleModelRepository;
import ru.stc.ebpas.crm.cm.model.entity.UserInfoEntity;

@Repository
public interface UserInfoRepository extends SimpleModelRepository<UserInfoEntity> {

}

