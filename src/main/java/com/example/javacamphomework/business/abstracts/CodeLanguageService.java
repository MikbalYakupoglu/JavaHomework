package com.example.javacamphomework.business.abstracts;

import com.example.javacamphomework.business.requests.codeLanguage.CreateCodeLanguageRequest;
import com.example.javacamphomework.business.requests.codeLanguage.UpdateCodeLanguageRequest;
import com.example.javacamphomework.business.responses.codeLanguage.GetAllCodeLanguagesResponse;
import com.example.javacamphomework.business.responses.codeLanguage.GetCodeLanguageResponse;
import com.example.javacamphomework.core.utils.Result;

import java.util.List;

public interface CodeLanguageService {
    Result create(CreateCodeLanguageRequest createCodeLanguageRequest);
    Result delete(int id);
    Result update(UpdateCodeLanguageRequest updateCodeLanguageRequest);
    List<GetAllCodeLanguagesResponse> getAll();
    GetCodeLanguageResponse get(int id);
}
