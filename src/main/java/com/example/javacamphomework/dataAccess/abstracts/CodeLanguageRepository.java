package com.example.javacamphomework.dataAccess.abstracts;

import com.example.javacamphomework.entity.concretes.CodeLanguageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CodeLanguageRepository extends JpaRepository<CodeLanguageEntity, Integer> {
    @Query("SELECT c FROM CodeLanguageEntity c WHERE c.id = :id")
    CodeLanguageEntity getCodeLanguageById(@Param("id") Integer id);
}
