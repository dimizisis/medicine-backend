package gr.zisis.medicinebackend.service.impl;

import gr.zisis.medicinebackend.model.Medicine;
import gr.zisis.medicinebackend.persistence.MedicineRepository;
import gr.zisis.medicinebackend.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class MedicineServiceBean implements MedicineService {

    private final MedicineRepository medicineRepository;

    @Autowired
    public MedicineServiceBean(MedicineRepository medicineRepository) {
        this.medicineRepository = medicineRepository;
    }

    @Override
    public Collection<Medicine> findAll() {
        return medicineRepository.findAll();
    }

    public Optional<Medicine> findById(Long id) {
        return medicineRepository.findById(id);
    }

    @Override
    public Optional<Medicine> save(Medicine medicine) {
        return Optional.of(medicineRepository.save(medicine));
    }

    @Override
    public Optional<Medicine> modify(Long id, Medicine medicine) {
        medicine.setId(id);
        if (medicineRepository.findById(id).isPresent())
            return Optional.of(medicineRepository.save(medicine));
        return Optional.empty();
    }

    @Override
    public void delete(Long id) {
        medicineRepository.delete(medicineRepository.getReferenceById(id));
    }
}
