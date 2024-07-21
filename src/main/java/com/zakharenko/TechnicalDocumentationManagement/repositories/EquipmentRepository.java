package com.zakharenko.TechnicalDocumentationManagement.repositories;

import com.zakharenko.TechnicalDocumentationManagement.models.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, Integer> {
    List<Equipment> findBySerialNumberLike(String serialNumber);
    List<Equipment> findByModelName(String modelName);
    List<Equipment> findByType(String modelType);
}
