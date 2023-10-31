package com.example.javacamphomework.entity.concretes;

import com.example.javacamphomework.entity.abstracts.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Table(name = "CodeLanguages")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CodeLanguageEntity extends BaseEntity {

    @NotBlank(message = "İsim Boş Bırakılamaz")
    @Column(name = "name")
    private String name;
}
