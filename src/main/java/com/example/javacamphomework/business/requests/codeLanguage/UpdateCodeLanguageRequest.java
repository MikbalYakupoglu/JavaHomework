package com.example.javacamphomework.business.requests.codeLanguage;

import com.example.javacamphomework.core.utils.Messages;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCodeLanguageRequest {
    private Integer id;

    @NotBlank(message = Messages.CodeLanguageMessages.NameCannotBeNull)
    private String name;
}
