/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Validaciones;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Carlo
 */
public class Validaciones {

    public static boolean validarRFC(String rfc) {

        String regex = "^[A-Z&Ñ]{3,4}[0-9]{6}[A-Z0-9]{3}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(rfc);
        return rfc.matches(regex);
    }

    public static boolean validarNombre(String nombre) {

        String regex = "^[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ\\s]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(nombre);
        return matcher.matches();
    }

    public static boolean validarApellidoPaterno(String apellidoPaterno) {

        String regex = "^[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(apellidoPaterno);
        return matcher.matches();
    }
    
    public static boolean validarApellidoMaterno(String apellidoMaterno) {

        String regex = "^[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(apellidoMaterno);
        return matcher.matches();
    }

    public static boolean validarTelefono(String telefono) {
        String regex = "^\\d{10}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(telefono);
        return matcher.matches();
    }

}
