package com.example.javacamphomework.webApi;

import com.example.javacamphomework.business.abstracts.SubTechnologyService;
import com.example.javacamphomework.business.requests.subTechnology.CreateSubTechnologyRequest;
import com.example.javacamphomework.business.requests.subTechnology.UpdateSubTechnologyRequest;
import com.example.javacamphomework.business.responses.subTechnology.GetAllSubTechnologiesResponse;
import com.example.javacamphomework.business.responses.subTechnology.GetSubTechnologyResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/subtechnologies")
public class SubTechnologyController {
    private final SubTechnologyService subTechnologyService;

    public SubTechnologyController(SubTechnologyService subTechnologyService) {
        this.subTechnologyService = subTechnologyService;
    }


    @PostMapping("")
    public ResponseEntity<String> create(@RequestBody @Valid CreateSubTechnologyRequest createSubTechnologyRequest) {
        var result = subTechnologyService.create(createSubTechnologyRequest);
        if (!result.isSuccess)
            return new ResponseEntity<String>(result.message, HttpStatus.BAD_REQUEST);

        return new ResponseEntity<String>(result.message, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id) {
        var result = subTechnologyService.delete(id);
        if (!result.isSuccess)
            return new ResponseEntity<String>(result.message, HttpStatus.BAD_REQUEST);

        return new ResponseEntity<String>(result.message, HttpStatus.OK);
    }

    @PatchMapping("")
    public ResponseEntity<String> update(@RequestBody @Valid UpdateSubTechnologyRequest updateSubTechnologyRequest) {
        var result = subTechnologyService.update(updateSubTechnologyRequest);
        if (!result.isSuccess)
            return new ResponseEntity<String>(result.message, HttpStatus.BAD_REQUEST);

        return new ResponseEntity<String>(result.message, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<GetAllSubTechnologiesResponse>> getAll() {
        return new ResponseEntity<List<GetAllSubTechnologiesResponse>>(subTechnologyService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetSubTechnologyResponse> get(@PathVariable("id") int id) {
        return new ResponseEntity<GetSubTechnologyResponse>(subTechnologyService.get(id), HttpStatus.OK);
    }
}
