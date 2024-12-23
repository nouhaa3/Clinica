package com.example.cabinet.service.impliments;

import com.example.cabinet.persistance.entities.Speciality;
import com.example.cabinet.persistance.dao.SpecialityRepository;
import com.example.cabinet.service.impliments.SpecialityService;
import com.example.cabinet.service.interfaces.ISpeciality;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialityService implements ISpeciality {

    @Autowired
    private SpecialityRepository specialityRepository;
    
    public long count() {
        return specialityRepository.count();
    }

    @Override
    public List<Speciality> getAllSpecialites() {
        return specialityRepository.findAll();
    }

    @Override
    public Speciality getSpecialiteById(Long id) {
        return specialityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Specialite not found with id: " + id));
    }

    @Override
    public Speciality saveSpecialite(Speciality specialite) {
        return specialityRepository.save(specialite);
    }

    @Override
    public Speciality updateSpecialite(Long id, Speciality specialite) {
        Speciality existingSpecialite = getSpecialiteById(id);
        existingSpecialite.setNomspecialite(specialite.getNomspecialite());
        return specialityRepository.save(existingSpecialite);
    }

    @Override
    public void deleteSpecialite(Long id) {
        specialityRepository.deleteById(id);
    }
}
