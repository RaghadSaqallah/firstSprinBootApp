/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.Raghad.springbootapp.Repository;

import com.Raghad.springbootapp.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Raghad Saqallah 
 * ID: 220232444
 */
@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>{

}
