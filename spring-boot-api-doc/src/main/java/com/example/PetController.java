package com.example;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pet")
@Api(value = "Pet Application Document")
public class PetController {

    private List<Pet> petList = new ArrayList<>();

//    @PostConstruct
//    public void init(){
//        petList.add(new Pet(1,"TEST",new Date()));
//    }

    @PostMapping
    @ApiOperation(value = "New Pet Add Metod")
    public ResponseEntity<Pet> save(@RequestBody @ApiParam(value = "animal") Pet pet) {
        petList.add(pet);
        return ResponseEntity.ok(pet);
    }

    @GetMapping
    @ApiOperation(value = "All Pet List")
    public ResponseEntity<List<Pet>> AllUsers() {
        return ResponseEntity.ok(petList);
    }
}
