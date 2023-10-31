package com.example.javacamphomework.business.requests.codeLanguage;

import com.example.javacamphomework.core.utils.Messages;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCodeLanguageRequest {
    @NotBlank(message = Messages.CodeLanguageMessages.NameCannotBeNull)
    private String name;
}
