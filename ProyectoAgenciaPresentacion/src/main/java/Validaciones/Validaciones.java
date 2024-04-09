/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Validaciones;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Clase de utilidad que proporciona métodos estáticos para validar diferentes
 * tipos de datos.
 */
public class Validaciones {

    /**
     * Constructor por defecto
     */
    public Validaciones() {
    }

    /**
     * Valida un RFC (Registro Federal de Contribuyentes) según el formato
     * mexicano.
     *
     * @param rfc el RFC a validar
     * @return true si el RFC es válido, false de lo contrario
     */
    public static boolean validarRFC(String rfc) {

        String regex = "^[A-Z&Ñ]{3,4}[0-9]{6}[A-Z0-9]{3}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(rfc);
        return rfc.matches(regex);
    }

    /**
     * Valida un nombre según el formato permitido.
     *
     * @param nombre el nombre a validar
     * @return true si el nombre es válido, false de lo contrario
     */
    public static boolean validarNombre(String nombre) {

        String regex = "^[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ\\s]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(nombre);
        return matcher.matches();
    }

    /**
     * Valida un apellido paterno según el formato permitido.
     *
     * @param apellidoPaterno el apellido paterno a validar
     * @return true si el apellido paterno es válido, false de lo contrario
     */
    public static boolean validarApellidoPaterno(String apellidoPaterno) {

        String regex = "^[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(apellidoPaterno);
        return matcher.matches();
    }

    /**
     * Valida un apellido materno según el formato permitido.
     *
     * @param apellidoMaterno el apellido materno a validar
     * @return true si el apellido materno es válido, false de lo contrario
     */
    public static boolean validarApellidoMaterno(String apellidoMaterno) {

        String regex = "^[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(apellidoMaterno);
        return matcher.matches();
    }

    /**
     * Valida un número de teléfono de 10 dígitos.
     *
     * @param telefono el número de teléfono a validar
     * @return true si el número de teléfono es válido, false de lo contrario
     */
    public static boolean validarTelefono(String telefono) {
        String regex = "^\\d{10}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(telefono);
        return matcher.matches();
    }

}
