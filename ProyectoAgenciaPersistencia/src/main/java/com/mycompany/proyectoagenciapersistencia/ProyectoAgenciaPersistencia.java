/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.proyectoagenciapersistencia;

import Conexion.ConexionBD;
import Conexion.IConexionBD;
import DAOs.AutomovilDAO;
import DAOs.IAutomovilDAO;
import DAOs.ILicenciaDAO;
import DAOs.IPersonaDAO;
import DAOs.IPlacaDAO;
import DAOs.IVehiculoDAO;
import DAOs.LicenciaDAO;
import DAOs.PersonaDAO;
import DAOs.PlacaDAO;
import DAOs.VehiculoDAO;
import Entidades.Automovil;
import Entidades.Persona;
import Entidades.Placa;
import Entidades.Vehiculo;
import Persistencia.PersistenciaException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
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
        IVehiculoDAO vehiculo = new VehiculoDAO(conexion);
        IPlacaDAO placa = new PlacaDAO(conexion);
        IAutomovilDAO auto = new AutomovilDAO(conexion);

        Calendar fechaNacimiento = Calendar.getInstance();
        fechaNacimiento.set(2004, Calendar.DECEMBER , 21);

//         Ahora, podemos agregar años, meses o días según sea necesario
//         Obtener la nueva fecha de nacimiento después de restar los años y meses
        Persona persona = new Persona("1222", "yo", "yo2", "yo3", "123456", fechaNacimiento, true);
//        persona1.agregarPersona(persona);

//        System.out.println(persona1.consultarPersonaRFC("1222"));
//        if (licencia1.agregarLicencia(3, persona1.consultarPersonaRFC("1222"))) {
//            System.out.println("SE AGREGO");
//        } else {
//            System.out.println("NO SE AGREGO");
//        }
        Automovil automovil = new Automovil("rojo", "nose", "123", "22333", "HONDA", persona1.consultarPersonaRFC("1222"));
//        auto.agregarAutomovil(automovil);
        Placa placa2 = new Placa("asas", Boolean.TRUE, automovil, persona, fechaNacimiento, Float.NaN);
//        placa.agregarPlaca(placa2);

//            List<Vehiculo> vehiculos = vehiculo.consultarVehiculosPersona(persona1.consultarPersonaRFC("1222"));
//            for (int i = 0; i <vehiculos.size(); i++) {
//                System.out.println(vehiculos.get(i));
//            System.out.println(placa.consultarPlacaNum("asdasd"));
//            System.out.println(licencia1.consultarPersonaConNumLicencia("as"));
//        Vehiculo vehiculo3 = new Vehiculo("as", "ASD", "SDASD", persona);
//        vehiculo3.setId(1l);
//        System.out.println(placa.consultarPlacaActiva(vehiculo3));
            
//            System.out.println(persona1.consultarPersonaRFC("RAGG940101ABC"));
            
            System.out.println(persona1.consultarPersonasFechaNYNombre("Luis",fechaNacimiento));
          
        

    
    }
}
