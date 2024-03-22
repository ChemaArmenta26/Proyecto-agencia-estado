/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Conexion.IConexionBD;
import Entidades.Licencia;
import Entidades.Persona;
import Entidades.Tramite;
import Persistencia.PersistenciaException;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author pc
 */
public class LicenciaDAO extends TramiteDAO implements ILicenciaDAO{

    IConexionBD conexion;

    public LicenciaDAO(IConexionBD conexion) {
        super(conexion);
        this.conexion = conexion;
    }
    
    

    @Override
    public boolean agregarLicencia(int duracion, Persona persona) throws PersistenciaException {
        if (persona != null) {
          EntityManager entityManager = conexion.conexion();

        entityManager.getTransaction().begin();
        Calendar fecha = Calendar.getInstance();
        Licencia licencia = new Licencia(duracion, fecha, this.sacarCosto(persona, duracion), persona);
        entityManager.persist(licencia);

        entityManager.getTransaction().commit();
        entityManager.close();
        return true;
        }
        return false;
    }

    @Override
    public float sacarCosto(Persona persona, int duracion) throws PersistenciaException {
        if (!persona.isDiscapacitado()) {
            if (duracion == 1) {
                return 600.00f;
            }else if(duracion == 2){
                return 900.00f;
            }else if(duracion == 3){
                return 1100.00f;
            }else{
                return 0f;
            }
        }else{
            if (duracion == 1) {
                return 200.00f;
            }else if(duracion == 2){
                return 500.00f;
            }else if(duracion == 3){
                return 700.00f;
            }else{
                return 0f;
            }
        }
    }

    
    
}
