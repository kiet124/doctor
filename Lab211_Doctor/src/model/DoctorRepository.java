/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author dotha
 */
public class DoctorRepository {
     private final Map<String, Doctor> doctorMap;

    public DoctorRepository() {
        doctorMap = new HashMap<>();
    }

    public boolean addDoctor(Doctor doctor) {
        if (doctor == null || doctor.getCode() == null || doctorMap.containsKey(doctor.getCode())) {
            return false;
        }
        doctorMap.put(doctor.getCode(), doctor);
        return true;
    }

    public boolean updateDoctor(Doctor doctor) {
        if (doctor == null || !doctorMap.containsKey(doctor.getCode())) {
            return false;
        }
        doctorMap.put(doctor.getCode(), doctor);
        return true;
    }

    public boolean deleteDoctor(String code) {
        if (code == null || !doctorMap.containsKey(code)) {
            return false;
        }
        doctorMap.remove(code);
        return true;
    }

    public List<Doctor> searchDoctor(String searchString) {
        List<Doctor> result = new ArrayList<>();
        for (Doctor doctor : doctorMap.values()) {
            if (doctor.toString().contains(searchString)) {
                result.add(doctor);
            }
        }
        return result;
    }

    public Map<String, Doctor> getDoctorMap() {
        return new HashMap<>(doctorMap); 
    }
}
