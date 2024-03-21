/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.proyectoagencianegocio;

import Encriptacion.AlgoritmoEncriptacion;

/**
 *
 * @author PC
 */
public class ProyectoAgenciaNegocio {

    public static void main(String[] args) {
        AlgoritmoEncriptacion prueba = new AlgoritmoEncriptacion();
        try {
            String textoEncriptado = prueba.encrypt("1234");
            System.out.println("Texto encriptado: " + textoEncriptado);
            
            String textoDesencriptado = prueba.decrypt(textoEncriptado);
            System.out.println("Texto desencriptado: " + textoDesencriptado);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
