package com.example.javacamphomework.webApi;

import com.example.javacamphomework.business.abstracts.CodeLanguageService;
import com.example.javacamphomework.business.requests.codeLanguage.CreateCodeLanguageRequest;
import com.example.javacamphomework.business.requests.codeLanguage.UpdateCodeLanguageRequest;
import com.example.javacamphomework.business.responses.codeLanguage.GetAllCodeLanguagesResponse;
import com.example.javacamphomework.business.responses.codeLanguage.GetCodeLanguageResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/codelanguages")
public class CodeLanguageController {
    private final CodeLanguageService codeLanguageService;

    @Autowired
    public CodeLanguageController(CodeLanguageService codeLanguageService) {
        this.codeLanguageService = codeLanguageService;
    }

    @PostMapping("")
    public ResponseEntity<String> create(@RequestBody @Valid CreateCodeLanguageRequest createCodeLanguageRequest) {
        var result = codeLanguageService.create(createCodeLanguageRequest);
        if (!result.isSuccess)
            return new ResponseEntity<String>(result.message, HttpStatus.BAD_REQUEST);

        return new ResponseEntity<String>(result.message, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id) {
        var result = codeLanguageService.delete(id);
        if (!result.isSuccess)
            return new ResponseEntity<String>(result.message, HttpStatus.BAD_REQUEST);

        return new ResponseEntity<String>(result.message, HttpStatus.OK);
    }

    @PatchMapping("")
    public ResponseEntity<String> update(@RequestBody @Valid UpdateCodeLanguageRequest updateCodeLanguageRequest) {
        var result = codeLanguageService.update(updateCodeLanguageRequest);
        if (!result.isSuccess)
            return new ResponseEntity<String>(result.message, HttpStatus.BAD_REQUEST);

        return new ResponseEntity<String>(result.message, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<GetAllCodeLanguagesResponse>> getAll() {
        return new ResponseEntity<List<GetAllCodeLanguagesResponse>>(codeLanguageService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetCodeLanguageResponse> get(@PathVariable("id") int id) {
        return new ResponseEntity<GetCodeLanguageResponse>(codeLanguageService.get(id), HttpStatus.OK);
    }
}
