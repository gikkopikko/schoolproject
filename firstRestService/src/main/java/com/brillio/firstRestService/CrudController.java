package com.brillio.firstRestService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brillio.firstRestService.entity.SDetailsDTO;

@RestController
@RequestMapping("/sdetails")
@Component
public class CrudController {

    @Autowired
    StudentDAO studentDAO;

    @PostMapping("/insert")
    //Add @RequestBody for the parameter of the function which has a @PostMapping Annotation to fetch values from the request.
    //For this to work remove @GeneratedMapping in the DTO
    public String insertStudent(@RequestBody SDetailsDTO sDTO){
        try{
            studentDAO.save(sDTO);
            return "Data is Inserted";
        }catch (Exception e){
            return (e.getMessage());
        }
    }

    @PutMapping("/update")
    public String updateStudent(@RequestBody SDetailsDTO sDTO){
        try{
            studentDAO.save(sDTO);
            return "Data is Updated";
        }catch (Exception e){
            return (e.getMessage());
        }
    }

    @PatchMapping("/patch")
    public String patchStudent(@RequestBody SDetailsDTO sDTO){
        try{
            studentDAO.save(sDTO);
            return "Data is Patched";
        }catch (Exception e){
            return (e.getMessage());
        }
    }

    @DeleteMapping("/delete/{sid}")
    public String deleteStudent(@PathVariable String sid){
        try{
            studentDAO.deleteById(sid);
            return "Data is Deleted";
        }catch (Exception e){
            return (e.getMessage());
        }
    }
//    
//    @GetMapping("/find/{sid}")
//    @Cacheable(key="#sid",value="StudentDTO")
//    public Optional<SDetailsDTO> findStudent(@PathVariable String sid)
//    {
//        return studentDAO.findById(sid);
//    }

}