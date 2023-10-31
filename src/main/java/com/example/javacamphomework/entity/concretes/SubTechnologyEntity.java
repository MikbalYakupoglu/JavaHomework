package com.example.javacamphomework.entity.concretes;

import com.example.javacamphomework.entity.abstracts.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "SubTechnologies")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubTechnologyEntity extends BaseEntity {
    @NotBlank(message = "Teknoloji Adı Boş Bırakılamaz")
    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "codelanguage_id", unique = false)
    private CodeLanguageEntity codeLanguage;
}
