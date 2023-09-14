package com.example.requestResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    // http methods hier zu implementieren
    // ohne DB verbindung. DB nur Simulieren

    //get
    @GetMapping("/getStudent")
    public ResponseEntity<String> getData() {
        String  getDataFromDB="alle Studenten"; // simulation für DB

        if (getDataFromDB != null) {
            return ResponseEntity.ok(getDataFromDB); // 200 OK
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Data not found"); // 404 NOT FOUND
        }
    }




    //post
    @PostMapping("/createStudent")
    public ResponseEntity<String> createData(@RequestBody String newData) {
        String student = newData;
        System.out.println(student);
        return ResponseEntity.status(HttpStatus.CREATED).body("Data created"); // 201 CREATED
    }






    //Put

    @PutMapping("/updateStudent")
    public ResponseEntity<String> updateData(@RequestBody String updatedData) {
        String data="Paul Kellerman";
        System.out.println("vor der Request: "+ data);
        if (data != null) {
            data = updatedData;
            System.out.println("nach der Request: " + data);

            return ResponseEntity.ok("Data updated"); // 200 OK
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Data not found"); // 404 NOT FOUND
        }
    }




    //delete

    @DeleteMapping("/deleteStudent")
    public ResponseEntity<String> deleteData(@RequestBody String id) {
        // finde Student, der gegebene id hat, in db, dann lösche das
        // Angenommen id gehört zu Max Musterman
        String deleteStudent="Max Musterman";
        if (deleteStudent != null) {
            deleteStudent = null;
            return ResponseEntity.ok("Data deleted"); // 200 OK
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Data not found"); // 404 NOT FOUND
        }
    }
}
