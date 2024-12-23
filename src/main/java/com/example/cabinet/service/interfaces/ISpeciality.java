package com.example.cabinet.service.interfaces;

import com.example.cabinet.persistance.entities.Speciality;

import java.util.List;

public interface ISpeciality {
    List<Speciality> getAllSpecialites();
    Speciality getSpecialiteById(Long id);
    Speciality saveSpecialite(Speciality speciality);
    Speciality updateSpecialite(Long id, Speciality speciality);
    void deleteSpecialite(Long id);
}
