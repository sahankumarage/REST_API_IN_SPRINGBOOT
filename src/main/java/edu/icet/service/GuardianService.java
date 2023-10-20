package edu.icet.service;

import edu.icet.dao.GuardianEntity;
import edu.icet.dao.StudentEntity;
import edu.icet.dto.Guardian;
import edu.icet.dto.Student;

import java.util.List;

public interface GuardianService {

    void registerGuardian(Guardian guardian);

    List<Guardian> retrieveAllGuardian();

    public Iterable<GuardianEntity> retrieveGuardianByAddress(String address);



}
