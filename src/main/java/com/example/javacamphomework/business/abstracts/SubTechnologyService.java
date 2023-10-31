package com.example.javacamphomework.business.abstracts;


import com.example.javacamphomework.business.requests.subTechnology.CreateSubTechnologyRequest;
import com.example.javacamphomework.business.requests.subTechnology.UpdateSubTechnologyRequest;
import com.example.javacamphomework.business.responses.subTechnology.GetAllSubTechnologiesResponse;
import com.example.javacamphomework.business.responses.subTechnology.GetSubTechnologyResponse;
import com.example.javacamphomework.core.utils.Result;

import java.util.List;

public interface SubTechnologyService {
    Result create(CreateSubTechnologyRequest createSubTechnologyRequest);
    Result delete(int id);
    Result update(UpdateSubTechnologyRequest updateSubTechnologyRequest);
    List<GetAllSubTechnologiesResponse> getAll();
    GetSubTechnologyResponse get(int id);
}
