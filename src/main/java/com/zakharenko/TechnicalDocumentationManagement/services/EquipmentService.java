package com.zakharenko.TechnicalDocumentationManagement.services;

import com.zakharenko.TechnicalDocumentationManagement.models.Equipment;
import com.zakharenko.TechnicalDocumentationManagement.repositories.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class EquipmentService {

    private final EquipmentRepository equipmentRepository;

    @Autowired
    public EquipmentService(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }

    public List<Equipment> findLike(String serialNumber) {
        return equipmentRepository.findBySerialNumberLike("%"+serialNumber+"%");
    }
    public List<Equipment> findAllModelsByName(String modelName) {
        return equipmentRepository.findByModelName(modelName);
    }
    public List<Equipment> findAll(){
        return equipmentRepository.findAll();
    }
    public List<Equipment> findAllModelsByType(String modelType) {
        return equipmentRepository.findByType(modelType);
    }
}
