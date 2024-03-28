/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.proyectoagenciapersistencia;

import Conexion.ConexionBD;
import Conexion.IConexionBD;
import DAOs.ILicenciaDAO;
import DAOs.IPersonaDAO;
import DAOs.LicenciaDAO;
import DAOs.PersonaDAO;
import Entidades.Persona;
import Persistencia.PersistenciaException;
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

    public static void main(String[] args) throws PersistenciaException {
        IConexionBD conexion = new ConexionBD();
        IPersonaDAO persona1 = new PersonaDAO(conexion);
        ILicenciaDAO licencia1 = new LicenciaDAO(conexion);
        
        Calendar fechaNacimiento = Calendar.getInstance();
       fechaNacimiento.set(2004, Calendar.AUGUST, 26);

        // Ahora, podemos agregar años, meses o días según sea necesario
        // Obtener la nueva fecha de nacimiento después de restar los años y meses
        Persona persona = new Persona("1222", "yo","yo2","yo3", "123456", fechaNacimiento, true);
        persona1.agregarPersona(persona);

        System.out.println(persona1.consultarPersonaRFC("1222"));
        if (licencia1.agregarLicencia(3, persona1.consultarPersonaRFC("1222"))) {
            System.out.println("SE AGREGO");
        }else{
        System.out.println("NO SE AGREGO");
        }
          
        

    }
}
