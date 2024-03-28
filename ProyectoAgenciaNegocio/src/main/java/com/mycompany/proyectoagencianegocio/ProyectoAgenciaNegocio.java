/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.proyectoagencianegocio;

import BOs.AgregarPersonaBO;
import BOs.IAgregarPersonaBO;
import BOs.IRegistroLicenciaBO;
import BOs.RegistroLicenciaBO;
import Encriptacion.AlgoritmoEncriptacion;

/**
 *
 * @author PC
 */
public class ProyectoAgenciaNegocio {

    public static void main(String[] args) {
//        AlgoritmoEncriptacion prueba = new AlgoritmoEncriptacion();
//        try {
//            String textoEncriptado = prueba.encrypt("1234");
//            System.out.println("Texto encriptado: " + textoEncriptado);
//            
//            String textoDesencriptado = prueba.decrypt(textoEncriptado);
//            System.out.println("Texto desencriptado: " + textoDesencriptado);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
            IAgregarPersonaBO agregarBO = new AgregarPersonaBO();
            agregarBO.agregarPersonas();
//                IRegistroLicenciaBO licenciaBO = new RegistroLicenciaBO();
//                String rfc = "JHUA920520DEF";
//                licenciaBO.agregarLicencia(3, licenciaBO.consultarRFC(rfc, licenciaBO.verificarRFC(rfc)));
    }
}
