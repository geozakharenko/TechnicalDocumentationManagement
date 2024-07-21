package com.zakharenko.TechnicalDocumentationManagement.controllers;

import com.zakharenko.TechnicalDocumentationManagement.dto.EquipmentDTO;
import com.zakharenko.TechnicalDocumentationManagement.dto.EquipmentWithDescriptionDTO;
import com.zakharenko.TechnicalDocumentationManagement.models.Equipment;
import com.zakharenko.TechnicalDocumentationManagement.services.EquipmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class EquipmentController {
    private final EquipmentService equipmentService;
    private final ModelMapper modelMapper;

    @Autowired
    public EquipmentController(EquipmentService equipmentService, ModelMapper modelMapper) {
        this.equipmentService = equipmentService;
        this.modelMapper = modelMapper;
    }


    @GetMapping("/equipments/types")
    public Set<String> getAllModelTypes() {
        List<Equipment> equipments = equipmentService.findAll();
        return equipments.stream()
                .map(Equipment::getType)
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());
    }
        @GetMapping("/equipments/types/{modelType}")
    public List<EquipmentDTO> getAllModelTypes(@PathVariable String modelType) {
        List<Equipment> equipments = equipmentService.findAllModelsByType(modelType);
        return equipments.stream()
                .map(this::convertToEquipmentDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/images/search/{serialNumber}")
    public List<EquipmentDTO> getEquipmentLike(@PathVariable String serialNumber) {
        List<Equipment> equipments = equipmentService.findLike(serialNumber);

        return equipments.stream()
                .map(this::convertToEquipmentDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/images/all/{modelName}")
    public List<EquipmentWithDescriptionDTO> getEquipmentForModel(@PathVariable String modelName) {
        List<Equipment> equipments = equipmentService.findAllModelsByName(modelName);

        return equipments.stream()
                .map(this::convertToEquipmentDTOWithDescription)
                .sorted(Comparator.comparing(EquipmentWithDescriptionDTO::getImageUrl))
                .collect(Collectors.toList());
    }

    private EquipmentDTO convertToEquipmentDTO(Equipment equipment) {
        equipment.setImageUrl("http://localhost:8080/images/" + equipment.getImageUrl());
        return modelMapper.map(equipment, EquipmentDTO.class);
    }

    private EquipmentWithDescriptionDTO convertToEquipmentDTOWithDescription(Equipment equipment) {
        equipment.setImageUrl("http://localhost:8080/images/" + equipment.getImageUrl());
        return modelMapper.map(equipment, EquipmentWithDescriptionDTO.class);
    }
}
