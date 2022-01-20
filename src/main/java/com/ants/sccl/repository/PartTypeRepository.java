package com.ants.sccl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ants.sccl.model.PartTypes;

@Repository
public interface PartTypeRepository extends JpaRepository<PartTypes, Integer> {

}
