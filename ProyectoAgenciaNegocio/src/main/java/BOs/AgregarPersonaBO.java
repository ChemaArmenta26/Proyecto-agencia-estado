/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BOs;

import Conexion.ConexionBD;
import Conexion.IConexionBD;
import DAOs.IPersonaDAO;
import DAOs.PersonaDAO;
import Encriptacion.AlgoritmoEncriptacion;
import Entidades.Persona;
import Persistencia.PersistenciaException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Clase que implementa la lógica de negocio para AgregarPersonaBO
 */
public class AgregarPersonaBO implements IAgregarPersonaBO {

    IConexionBD conexionBD = new ConexionBD();
    private IPersonaDAO personaDAO = new PersonaDAO(conexionBD);
    private AlgoritmoEncriptacion aes = new AlgoritmoEncriptacion();

    /**
     * Constructor por defecto de la clase AgregarPersonaBO.
     */
    public AgregarPersonaBO() {
    }

    /**
     * Agrega personas al sistema
     *
     * Este método recupera una lista de personas utilizando el método
     * crearPersonas(), encripta los números de teléfono de cada persona y los
     * agrega a la base de datos y por ultimo muestra un mensaje indicando si el
     * registro fue exitoso o no.
     */
    @Override
    public void agregarPersonas() {
        List<Persona> listaPersonas = this.crearPersonas();
        boolean validacion = true;
        for (int i = 0; i < listaPersonas.size(); i++) {
            try {
                listaPersonas.get(i).setTelefono(aes.encrypt(listaPersonas.get(i).getTelefono()));
                personaDAO.agregarPersona(listaPersonas.get(i));
            } catch (PersistenciaException ex) {
                validacion = false;
                Logger.getLogger(AgregarPersonaBO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                validacion = false;
                Logger.getLogger(AgregarPersonaBO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (validacion) {
            JOptionPane.showMessageDialog(null, "Registro de Personas exitoso");
        } else {
            JOptionPane.showMessageDialog(null, "Algo ocurrio mal");
        }
    }

    /**
     * Método que crea personas con información predefinida y las agrega a una
     * lista.
     *
     * @return Una lista de objetos Persona con información predefinida.
     */
    @Override
    public List<Persona> crearPersonas() {
        List<Persona> listaPersonas = new ArrayList<>();
        Calendar fechaNacimiento1 = Calendar.getInstance();
        fechaNacimiento1.set(2004, Calendar.MARCH, 21);
        Persona persona1 = new Persona("RAGG940101ABC", "Ricardo", "Gutierrez", "Garces", "6441425567", fechaNacimiento1, false);

        Calendar fechaNacimiento2 = Calendar.getInstance();
        fechaNacimiento2.set(2004, Calendar.NOVEMBER, 28);
        Persona persona2 = new Persona("JHUA920520DEF", "Jose Angel", "Huerta", "Amparan", "6441695314", fechaNacimiento2, true);

        Calendar fechaNacimiento3 = Calendar.getInstance();
        fechaNacimiento3.set(2004, Calendar.MAY, 16);
        Persona persona3 = new Persona("AAMO890210GHI", "Asiel", "Apodaca", "Monge", "6441214697", fechaNacimiento3, true);

        Calendar fechaNacimiento4 = Calendar.getInstance();
        fechaNacimiento4.set(2004, Calendar.SEPTEMBER, 21);
        Persona persona4 = new Persona("HEED800305JKL", "Hector Alberto", "Espinoza", "Duarte", "6441547896", fechaNacimiento4, false);

        Calendar fechaNacimiento5 = Calendar.getInstance();
        fechaNacimiento5.set(2004, Calendar.OCTOBER, 27);
        Persona persona5 = new Persona("JEGC750624MNO", "Jesus Rene", "Gonzalez", "Castro", "6441234987", fechaNacimiento5, true);

        Calendar fechaNacimiento6 = Calendar.getInstance();
        fechaNacimiento6.set(2004, Calendar.APRIL, 21);
        Persona persona6 = new Persona("ERAN830713PQR", "Enrique", "Rodriguez", "Angulo", "6441425567", fechaNacimiento6, true);

        Calendar fechaNacimiento7 = Calendar.getInstance();
        fechaNacimiento7.set(2004, Calendar.FEBRUARY, 10);
        Persona persona7 = new Persona("CCAA870502STU", "Carlos Armando", "Clark", "Aviles", "6441253648", fechaNacimiento7, false);

        Calendar fechaNacimiento8 = Calendar.getInstance();
        fechaNacimiento8.set(2004, Calendar.AUGUST, 25);
        Persona persona8 = new Persona("DIVP910320VWX", "Diego", "Valenzuela", "Parra", "6441698745", fechaNacimiento8, false);

        Calendar fechaNacimiento9 = Calendar.getInstance();
        fechaNacimiento9.set(2004, Calendar.JANUARY, 15);
        Persona persona9 = new Persona("EMME880215YZA", "Esmeralda", "Molina", "Estrada", "6441236986", fechaNacimiento9, true);

        Calendar fechaNacimiento10 = Calendar.getInstance();
        fechaNacimiento10.set(2004, Calendar.JULY, 19);
        Persona persona10 = new Persona("VVBE900731BCD", "Victoria", "Vega", "Bernal", "6441557890", fechaNacimiento10, false);

        Calendar fechaNacimiento11 = Calendar.getInstance();
        fechaNacimiento11.set(2004, Calendar.DECEMBER, 21);
        Persona persona11 = new Persona("HICC810802EFG", "Hisamy", "Cinco", "Cota", "6442134567", fechaNacimiento11, true);

        Calendar fechaNacimiento12 = Calendar.getInstance();
        fechaNacimiento12.set(2004, Calendar.MARCH, 21);
        Persona persona12 = new Persona("GRCM850116HIJ", "Gael Rafael", "Castro", "Molina", "6442876543", fechaNacimiento12, false);

        Calendar fechaNacimiento13 = Calendar.getInstance();
        fechaNacimiento13.set(2004, Calendar.DECEMBER, 21);
        Persona persona13 = new Persona("JFVV800902KLM", "Jose Karim", "Franco", "Valencia", "6442432198", fechaNacimiento13, true);

        Calendar fechaNacimiento14 = Calendar.getInstance();
        fechaNacimiento14.set(2004, Calendar.MARCH, 21);
        Persona persona14 = new Persona("VHEG870710NOP", "Victor Humberto", "Encinaz", "Guzman", "6442789034", fechaNacimiento14, false);

        Calendar fechaNacimiento15 = Calendar.getInstance();
        fechaNacimiento15.set(2004, Calendar.DECEMBER, 21);
        Persona persona15 = new Persona("JLMG791115QRS", "Jose Luis", "Madero", "Lopez", "6442229876", fechaNacimiento15, false);

        Calendar fechaNacimiento16 = Calendar.getInstance();
        fechaNacimiento16.set(2004, Calendar.MARCH, 26);
        Persona persona16 = new Persona("JAMB860401TUV", "Jose Maria", "Armenta", "Baca", "6442912345", fechaNacimiento16, false);

        Calendar fechaNacimiento17 = Calendar.getInstance();
        fechaNacimiento17.set(2004, Calendar.AUGUST, 12);
        Persona persona17 = new Persona("GAML950101ABC", "Maria Guadalupe", "Garcia", "Lopez", "6442145698", fechaNacimiento17, true);

        Calendar fechaNacimiento18 = Calendar.getInstance();
        fechaNacimiento18.set(2004, Calendar.SEPTEMBER, 24);
        Persona persona18 = new Persona("MJRR780520DEF", "Juan", "Martinez", "Rodriguez", "6442498765", fechaNacimiento18, true);

        Calendar fechaNacimiento19 = Calendar.getInstance();
        fechaNacimiento19.set(2004, Calendar.OCTOBER, 30);
        Persona persona19 = new Persona("AHLA891210GHI", "Ana Laura", "Hernandez", "Perez", "6442321987", fechaNacimiento19, true);

        Calendar fechaNacimiento20 = Calendar.getInstance();
        fechaNacimiento20.set(2004, Calendar.JANUARY, 26);
        Persona persona20 = new Persona("CAGS700305JKL", "Carlos Alberto", "Gomez", "Sanchez", "6442113456", fechaNacimiento20, true);

        listaPersonas.add(persona1);
        listaPersonas.add(persona2);
        listaPersonas.add(persona3);
        listaPersonas.add(persona4);
        listaPersonas.add(persona5);
        listaPersonas.add(persona6);
        listaPersonas.add(persona7);
        listaPersonas.add(persona8);
        listaPersonas.add(persona9);
        listaPersonas.add(persona10);
        listaPersonas.add(persona11);
        listaPersonas.add(persona12);
        listaPersonas.add(persona13);
        listaPersonas.add(persona14);
        listaPersonas.add(persona15);
        listaPersonas.add(persona16);
        listaPersonas.add(persona17);
        listaPersonas.add(persona18);
        listaPersonas.add(persona19);
        listaPersonas.add(persona20);

        return listaPersonas;
    }

}
