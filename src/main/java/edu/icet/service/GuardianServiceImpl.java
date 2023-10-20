package edu.icet.service;

import edu.icet.dao.GuardianEntity;
import edu.icet.dao.StudentEntity;
import edu.icet.dto.Guardian;
import edu.icet.dto.Student;
import edu.icet.repository.GuardianRepository;
import edu.icet.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@Primary
public class GuardianServiceImpl implements GuardianService{



    @Autowired
    GuardianRepository guardianRepository;


    public void registerGuardian(Guardian guardian){
        GuardianEntity guardianEntity = new GuardianEntity();
        guardianEntity.setName(guardian.getName());
        guardianEntity.setAddress(guardian.getAddress());
        guardianEntity.setContact(guardian.getContact());
        guardianRepository.save(guardianEntity);
    }

    public List<Guardian> retrieveAllGuardian(){

        Iterable<GuardianEntity> guardianList =  guardianRepository.findAll();
        List<Guardian> GuardianModelList = new ArrayList();

        Iterator<GuardianEntity> iterator = guardianList.iterator();

        while(iterator.hasNext()){
            GuardianEntity guardianDao = iterator.next();

            //Model Mapping
            Guardian guardianDto = Guardian.builder()
                    .name(guardianDao.getName())
                    .address(guardianDao.getAddress())
                    .contact(guardianDao.getContact())
                    .build();

            GuardianModelList.add(guardianDto);
        }
        return GuardianModelList;
    }

    public Iterable<GuardianEntity> retrieveGuardianByAddress(String address){
        return guardianRepository.findAllByAddress(address);
    }


}
