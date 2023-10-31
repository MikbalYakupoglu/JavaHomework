package com.example.javacamphomework.business.concrete;

import com.example.javacamphomework.business.abstracts.SubTechnologyService;
import com.example.javacamphomework.business.requests.subTechnology.CreateSubTechnologyRequest;
import com.example.javacamphomework.business.requests.subTechnology.UpdateSubTechnologyRequest;
import com.example.javacamphomework.business.responses.subTechnology.GetAllSubTechnologiesResponse;
import com.example.javacamphomework.business.responses.subTechnology.GetSubTechnologyResponse;
import com.example.javacamphomework.core.utils.Messages;
import com.example.javacamphomework.core.utils.Result;
import com.example.javacamphomework.dataAccess.abstracts.CodeLanguageRepository;
import com.example.javacamphomework.dataAccess.abstracts.SubTechnologyRepository;
import com.example.javacamphomework.entity.concretes.SubTechnologyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubTechnologyServiceImpl implements SubTechnologyService {
    private final SubTechnologyRepository subTechnologyRepository;
    private final CodeLanguageRepository codeLanguageRepository;

    @Autowired
    public SubTechnologyServiceImpl(SubTechnologyRepository subTechnologyRepository,
                                    CodeLanguageRepository codeLanguageRepository) {
        this.subTechnologyRepository = subTechnologyRepository;
        this.codeLanguageRepository = codeLanguageRepository;
    }

    @Override
    public Result create(CreateSubTechnologyRequest createSubTechnologyRequest) {
        var subTechnologies = subTechnologyRepository.findAll();

        if (subTechnologies.stream().anyMatch(st -> st.getName().equals(createSubTechnologyRequest.getName())))
            return new Result(false, Messages.SubTechnologyMessages.AlreadyExist);

        var subTechnologyToCreate = new SubTechnologyEntity();
        subTechnologyToCreate.setName(createSubTechnologyRequest.getName());
        subTechnologyToCreate.setCodeLanguage(codeLanguageRepository.getCodeLanguageById(createSubTechnologyRequest.getCodeLanguageId()));
        subTechnologyRepository.save(subTechnologyToCreate);

        return new Result(true, Messages.SubTechnologyMessages.CreateSuccess);
    }

    @Override
    public Result delete(int id) {
        var subTechnologies = subTechnologyRepository.findAll();
        if (subTechnologies.stream().noneMatch(st -> st.getId() == id))
            return new Result(false, Messages.IdNotFound);

        subTechnologyRepository.deleteById(id);
        return new Result(true, Messages.SubTechnologyMessages.DeleteSuccess);
    }

    @Override
    public Result update(UpdateSubTechnologyRequest updateSubTechnologyRequest) {
        var codeLanguages = codeLanguageRepository.findAll();

        var subTechnologyToUpdate = subTechnologyRepository.getReferenceById(updateSubTechnologyRequest.getId());
        subTechnologyToUpdate.setName(updateSubTechnologyRequest.getName());

        if (updateSubTechnologyRequest.getCodeLanguageId() != null) {
            Integer codeLanguageId = updateSubTechnologyRequest.getCodeLanguageId();
            codeLanguages.stream()
                    .filter(cl -> cl.getId().equals(codeLanguageId))
                    .findFirst()
                    .ifPresent(subTechnologyToUpdate::setCodeLanguage);
        }


        subTechnologyRepository.save(subTechnologyToUpdate);

        return new Result(true, Messages.SubTechnologyMessages.UpdateSuccess);
    }

    @Override
    public List<GetAllSubTechnologiesResponse> getAll() {
        var subTechnologies = subTechnologyRepository.findAll();
        var subTechnologiesResponse = new ArrayList<GetAllSubTechnologiesResponse>();

        for (SubTechnologyEntity technology : subTechnologies) {
            GetAllSubTechnologiesResponse subTechnologyResponse = new GetAllSubTechnologiesResponse();
            subTechnologyResponse.setName(technology.getName());
            subTechnologyResponse.setLanguageName(technology.getCodeLanguage().getName());

            subTechnologiesResponse.add(subTechnologyResponse);
        }

        return subTechnologiesResponse;
    }

    @Override
    public GetSubTechnologyResponse get(int id) {
        var subTechnology = subTechnologyRepository.getReferenceById(id);
        GetSubTechnologyResponse subTechnologyResponse = new GetSubTechnologyResponse();
        subTechnologyResponse.setName(subTechnology.getName());
        subTechnologyResponse.setLanguageName(subTechnology.getCodeLanguage().getName());

        return subTechnologyResponse;
    }
}
