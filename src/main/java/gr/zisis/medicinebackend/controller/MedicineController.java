package gr.zisis.medicinebackend.controller;

import gr.zisis.medicinebackend.dto.CreateMedicineDTO;
import gr.zisis.medicinebackend.dto.ModifyMedicineDTO;
import gr.zisis.medicinebackend.model.Medicine;
import gr.zisis.medicinebackend.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utils.EntityConverter;

import java.util.Collection;

@RequestMapping(path = "api/v1/medicine")
@RestController
public class MedicineController {

    private final MedicineService medicineService;

    @Autowired
    public MedicineController(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<Collection<Medicine>> getMedicine() {
        return ResponseEntity.ok(medicineService.findAll());
    }

    @GetMapping(path = "{medicineId}")
    ResponseEntity<Medicine> getMedicine(@PathVariable Long medicineId) {
        return ResponseEntity.ok(medicineService.findById(medicineId).orElseThrow());
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    Medicine createMedicine(@RequestBody CreateMedicineDTO createMedicineDTO) {
        return medicineService.save(EntityConverter.convertToEntity(createMedicineDTO, Medicine.class)).orElseThrow();
    }

    @PutMapping(path = "{medicineId}")
    ResponseEntity<Medicine> modifyMedicine(@PathVariable Long medicineId, @RequestBody ModifyMedicineDTO modifyMedicineDTO) {
       return ResponseEntity.ok(medicineService.modify(medicineId, EntityConverter.convertToEntity(modifyMedicineDTO, Medicine.class)).orElseThrow());
    }

    @DeleteMapping(path = "{medicineId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    ResponseEntity<Void> deleteMedicine(@PathVariable Long id) {
        medicineService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
