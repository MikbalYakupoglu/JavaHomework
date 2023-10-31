package com.example.javacamphomework.business.requests.subTechnology;

import com.example.javacamphomework.core.utils.Messages;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateSubTechnologyRequest {
    private Integer id;
    @NotBlank(message = Messages.SubTechnologyMessages.NameCannotBeNull)
    private String name;
    private Integer codeLanguageId;
}
