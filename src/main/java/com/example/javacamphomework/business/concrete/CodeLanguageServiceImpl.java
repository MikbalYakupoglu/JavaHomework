package com.example.javacamphomework.business.concrete;

import com.example.javacamphomework.business.abstracts.CodeLanguageService;
import com.example.javacamphomework.business.requests.codeLanguage.CreateCodeLanguageRequest;
import com.example.javacamphomework.business.requests.codeLanguage.UpdateCodeLanguageRequest;
import com.example.javacamphomework.business.responses.codeLanguage.GetAllCodeLanguagesResponse;
import com.example.javacamphomework.business.responses.codeLanguage.GetCodeLanguageResponse;
import com.example.javacamphomework.core.utils.Messages;
import com.example.javacamphomework.core.utils.Result;
import com.example.javacamphomework.dataAccess.abstracts.CodeLanguageRepository;
import com.example.javacamphomework.entity.concretes.CodeLanguageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CodeLanguageServiceImpl implements CodeLanguageService {
    private final CodeLanguageRepository codeLanguageRepository;

    @Autowired
    public CodeLanguageServiceImpl(CodeLanguageRepository codeLanguageRepository) {
        this.codeLanguageRepository = codeLanguageRepository;
    }

    @Override
    public Result create(CreateCodeLanguageRequest createCodeLanguageRequest) {
        var codeLanguageList = codeLanguageRepository.findAll();

        if (codeLanguageList.stream().anyMatch(cl -> cl.getName().equals(createCodeLanguageRequest.getName())))
            return new Result(false, Messages.CodeLanguageMessages.AlreadyExist);

        CodeLanguageEntity codeLanguage = new CodeLanguageEntity();
        codeLanguage.setName(createCodeLanguageRequest.getName());

        codeLanguageRepository.save(codeLanguage);
        return new Result(true, Messages.CodeLanguageMessages.CreateSuccess);
    }

    @Override
    public Result delete(int id) {
        var codeLanguageList = codeLanguageRepository.findAll();
        if (codeLanguageList.stream().noneMatch(cl -> cl.getId() == id))
            return new Result(false, Messages.IdNotFound);

        codeLanguageRepository.deleteById(id);
        return new Result(true, Messages.CodeLanguageMessages.DeleteSuccess);
    }

    @Override
    public Result update(UpdateCodeLanguageRequest updateCodeLanguageRequest) {
        var languageToUpdate = codeLanguageRepository.getReferenceById(updateCodeLanguageRequest.getId());
        languageToUpdate.setName(updateCodeLanguageRequest.getName());
        codeLanguageRepository.save(languageToUpdate);

        return new Result(true, Messages.CodeLanguageMessages.UpdateSuccess);
    }

    @Override
    public List<GetAllCodeLanguagesResponse> getAll() {
        var codeLanguages = codeLanguageRepository.findAll();
        var codeLanguagesResponse = new ArrayList<GetAllCodeLanguagesResponse>();
        for (CodeLanguageEntity language : codeLanguages) {
            GetAllCodeLanguagesResponse languagesResponse = new GetAllCodeLanguagesResponse();
            languagesResponse.setName(language.getName());

            codeLanguagesResponse.add(languagesResponse);
        }
        return codeLanguagesResponse;
    }

    @Override
    public GetCodeLanguageResponse get(int id) {
        var codeLanguage = codeLanguageRepository.getReferenceById(id);
        GetCodeLanguageResponse languagesResponse = new GetCodeLanguageResponse();
        languagesResponse.setName(codeLanguage.getName());
        return languagesResponse;
    }
}
