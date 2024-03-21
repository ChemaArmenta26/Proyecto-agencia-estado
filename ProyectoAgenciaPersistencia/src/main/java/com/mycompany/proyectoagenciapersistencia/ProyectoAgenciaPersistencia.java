/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyectoagenciapersistencia;

import Entidades.Persona;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author PC
 */
public class ProyectoAgenciaPersistencia {

    public static void main(String[] args) {
        EntityManagerFactory entity = Persistence.createEntityManagerFactory("conexionPU");
        //2. 
        EntityManager entityManager = entity.createEntityManager();
        //3. TRANSACCIONES
        entityManager.getTransaction().begin();
        Date fechaNacimiento = new Date(); // Esta es solo una fecha de ejemplo, debes proporcionar la fecha real

        // Creamos un objeto Calendar y lo configuramos con la fecha de nacimiento
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaNacimiento);

        // Ahora, podemos agregar años, meses o días según sea necesario
        calendar.add(Calendar.YEAR, -20); // Restamos 20 años a la fecha de nacimiento
        calendar.add(Calendar.MONTH, -6);  // Restamos 6 meses a la fecha de nacimiento

        // Obtener la nueva fecha de nacimiento después de restar los años y meses
        Date nuevaFechaNacimiento = calendar.getTime();
        Persona persona = new Persona("123", "yo", "123456", nuevaFechaNacimiento, true);
        
        
        entityManager.persist(persona);
        
        entityManager.close();
        entity.close();
        
        
    }
}
