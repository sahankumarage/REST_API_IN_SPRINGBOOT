package edu.icet.Controller;

import edu.icet.dao.GuardianEntity;
import edu.icet.dto.Guardian;
import edu.icet.dto.Student;
import edu.icet.service.GuardianService;
import edu.icet.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/guardian")
public class GuardianController {

    //Dependency Injection
    //Spring Boot Framework

    @Autowired
    GuardianService service;


    @PostMapping
    public void createGuardian(@RequestBody Guardian guardian){
        service.registerGuardian(guardian);
    }

    @GetMapping
    public List<Guardian> retrieveAllGuardian(){
        return service.retrieveAllGuardian();
    }

    @GetMapping("/retrieve-guardian/{address}")
    public Iterable<GuardianEntity> retrieveGuardianByAddress(
            @RequestParam String address) {
        return service.retrieveGuardianByAddress(address);
    }


}


