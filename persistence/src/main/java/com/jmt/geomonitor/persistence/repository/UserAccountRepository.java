package com.jmt.geomonitor.persistence.repository;

import com.jmt.geomonitor.persistence.model.UserAccountPersistenceModel;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

/**
 * User account repo.
 */
@Repository
public interface UserAccountRepository extends EntityRepository<UserAccountPersistenceModel, Long> {

}
