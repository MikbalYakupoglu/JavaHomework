package com.example.javacamphomework.dataAccess.abstracts;

import com.example.javacamphomework.entity.concretes.SubTechnologyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubTechnologyRepository extends JpaRepository<SubTechnologyEntity, Integer> {

}
