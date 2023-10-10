/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import java.util.Map;
import model.Doctor;
import model.DoctorRepository;

/**
 *
 * @author dotha
 */
public class DoctorController {
    private final DoctorRepository repository;

    public DoctorController() {
        this.repository = new DoctorRepository();
    }

    public boolean addDoctor(Doctor doctor) {
        if (doctor == null || doctor.getCode() == null || doctor.getCode().isEmpty()) {
            return false; 
        }
        return repository.addDoctor(doctor); 
    }

    public boolean updateDoctor(Doctor doctor) {
        return repository.updateDoctor(doctor);
    }

    public boolean deleteDoctor(String code) {
        return repository.deleteDoctor(code);
    }

    public List<Doctor> searchDoctor(String searchString) {
        return repository.searchDoctor(searchString);
    }

    public void saveData() {
      
    }

    public Map<String, Doctor> getDoctorMap() {
        return repository.getDoctorMap();
    }

public Doctor getDoctorByCode(String code) {
    Map<String, Doctor> doctorMap = repository.getDoctorMap();
    if (doctorMap.containsKey(code)) {
        return doctorMap.get(code);
    } else {
        return null; 
    }
}
}