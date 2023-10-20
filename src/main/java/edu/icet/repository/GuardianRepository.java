package edu.icet.repository;

import edu.icet.dao.GuardianEntity;
import edu.icet.dao.StudentEntity;
import org.springframework.data.repository.CrudRepository;

public interface GuardianRepository
        extends CrudRepository<GuardianEntity,Long> {

    Iterable<GuardianEntity> findAllByAddress(String address);
}
