package com.example.JavaDay10ex.model.Controllers;

import com.example.JavaDay10ex.model.ApiResponse;
import com.example.JavaDay10ex.model.Employees;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/auth")
public class EmployeesController {
    ArrayList<Employees> employees=new ArrayList<>();

    @GetMapping("/employees")
    public ResponseEntity GetEmployee(){
        return ResponseEntity.status(200).body(employees);
    }


    @PostMapping("/reg")
    public ResponseEntity addEmployees(@RequestBody @Valid Employees employee, Errors errors){
      if(errors.hasErrors()){
          String message=errors.getFieldError().getDefaultMessage();
          return ResponseEntity.status(400).body(new ApiResponse(message,400));
      }
      employees.add(employee);
      return ResponseEntity.status(201).body(new ApiResponse("Employee has been added!",201));
    }

    @PutMapping("/{index}")
    public ResponseEntity updateemployee(@PathVariable int index,@RequestBody @Valid Employees employee,Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message,400));
        }
        if(index>=employees.size()){
            return ResponseEntity.status(400).body(new ApiResponse("invalid index",400));
        }
        employees.set(index,employee);
        return ResponseEntity.status(201).body(new ApiResponse("Employee has been updated!",201));
    }

    @DeleteMapping("/{index}")
    public ResponseEntity deleteEmployee(@PathVariable int index,Errors errors){
        if(index>=employees.size()){
            return ResponseEntity.status(400).body(new ApiResponse("invalid index",400));
        }
        employees.remove(index);
        return ResponseEntity.status(201).body(new ApiResponse("Employee has been removed!",201));
    }

    @PostMapping  ("/onleave")
    public ResponseEntity onleave(@RequestBody int index){
        Employees emp=employees.get(index);
       int empannuals=emp.getAnnualLeave();
        if(emp.isOnLeave()){
            return ResponseEntity.status(400).body(new ApiResponse("you are already on leave",400));
        }
        if(emp.getAnnualLeave()==0){
            return ResponseEntity.status(400).body(new ApiResponse("You don't have leave days",400));
        }
        emp.setOnLeave(true);
        emp.setAnnualLeave(empannuals-1);

        return  ResponseEntity.status(200).body(new ApiResponse("your leave has been granted ",200));




    }
}





