package com.pm.patientservice.controller;

import com.pm.patientservice.dto.PatientRequestDTO;
import com.pm.patientservice.dto.PatientResponseDTO;
import com.pm.patientservice.dto.validators.CreatePatientValidationGroup;
import com.pm.patientservice.service.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.groups.Default;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/patients")
@Tag(name="Patient", description = "API for managing patients")
public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    @Operation(summary = "Get all patients")
    public ResponseEntity<List<PatientResponseDTO>> getPatients() {
        List<PatientResponseDTO> patients = patientService.getPatients();
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @PostMapping
    @Operation(summary = "Create pacient.")
    public ResponseEntity<PatientResponseDTO> createPatient(@Validated({Default.class, CreatePatientValidationGroup.class})
                                                            @RequestBody PatientRequestDTO patientRequestDTO) {
        PatientResponseDTO newPatient = patientService.createPatient(patientRequestDTO);
        return new ResponseEntity<>(newPatient, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update pacient.")
    public ResponseEntity<PatientResponseDTO> updatePatient(@PathVariable UUID id,
                                                           @Validated({Default.class})
                                                           @RequestBody PatientRequestDTO patientRequestDTO) {
        PatientResponseDTO newPatient = patientService.updatePatient(id, patientRequestDTO);
        return new ResponseEntity<>(newPatient, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete pacient.")
    public ResponseEntity<Void> deletePatient(@PathVariable UUID id){
        patientService.deletePatient(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
