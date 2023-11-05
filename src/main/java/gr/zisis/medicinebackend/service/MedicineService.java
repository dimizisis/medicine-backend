package gr.zisis.medicinebackend.service;

import gr.zisis.medicinebackend.model.Medicine;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

public interface MedicineService {

    Collection<Medicine> findAll();

    Optional<Medicine> findById(Long id);

    Optional<Medicine> save(Medicine medicine);

    Optional<Medicine> modify(Long id, Medicine medicine);

    void delete(Long id);

}
