///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// */
//package com.mycompany.proyectoagencianegocio;
//
//import BOs.AgregarPersonaBO;
//import BOs.IAgregarPersonaBO;
//import BOs.IRegistroAutomovilBO;
//import BOs.IRegistroLicenciaBO;
//import BOs.IRegistroPlacaBO;
//import BOs.IReporteTramiteBO;
//import BOs.RegistroAutomovilBO;
//import BOs.RegistroLicenciaBO;
//import BOs.RegistroPlacaBO;
//import BOs.ReporteTramiteBO;
//import DTO.AutomovilDTO;
//import DTO.PersonaDTO;
//import DTO.PlacaDTO;
//import Encriptacion.AlgoritmoEncriptacion;
//import Entidades.Automovil;
//import Entidades.Persona;
//import Entidades.Vehiculo;
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.List;
//
//
//public class ProyectoAgenciaNegocio {
//
//    /**
//     *
//     * @param args
//     */
//    public static void main(String[] args) {
////        AlgoritmoEncriptacion prueba = new AlgoritmoEncriptacion();
////        try {
////            String textoEncriptado = prueba.encrypt("1234");
////            System.out.println("Texto encriptado: " + textoEncriptado);
////            
////            String textoDesencriptado = prueba.decrypt(textoEncriptado);
////            System.out.println("Texto desencriptado: " + textoDesencriptado);
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
//
//
//
//
//        IAgregarPersonaBO agregarBO = new AgregarPersonaBO();
////            agregarBO.agregarPersonas();
//        IRegistroLicenciaBO licenciaBO = new RegistroLicenciaBO();
//        IReporteTramiteBO reporteBO = new ReporteTramiteBO();
//        String rfc = "RAGG940101ABC";
////                licenciaBO.agregarLicencia(3, licenciaBO.consultarRFC(rfc, licenciaBO.verificarRFC(rfc)));
//
////        IRegistroPlacaBO placa = new RegistroPlacaBO();
////        IRegistroAutomovilBO auto = new RegistroAutomovilBO();
//////        Persona persona1 = licenciaBO.consultarRFC(rfc, true);
////        PersonaDTO persona2 = new PersonaDTO(persona1.getRFC(), persona1.getNombre(), persona1.getApellidoPaterno(), persona1.getApellidoMaterno(), persona1.getDiscapacitado(), persona1.getFechaNacimiento(), persona1.getTelefono());
////        AutomovilDTO auto2 = new AutomovilDTO("rojo", "h000", "222", "as", "adasd", persona2);
//////            auto.agregarAutomovil(auto2);
////        Vehiculo vehiculo = new Vehiculo("as", "asd", "asasdasd", persona1);
////        vehiculo.setId(1l);
////        Calendar fechaNacimiento = Calendar.getInstance();
////        PlacaDTO placa2 = new PlacaDTO("GKM-970", fechaNacimiento, true, vehiculo, persona1, fechaNacimiento, 1000.0F);
////                placa.agregarPlaca(placa2);
////                    placa.agregarPlaca(placa.consultarPlaca("FKO-162"));
////                        System.out.println(auto.obtenerPersonaConLicencia("srpf02p70"));
////        System.out.println(auto.obtenerIdConNumeroDeSerie("asda"));
//        Calendar fechaNacimiento = Calendar.getInstance();
//        fechaNacimiento.set(2004, Calendar.DECEMBER, 21);
//        PersonaDTO persona = new PersonaDTO("JLMG791115QRS", "luis", "", "", false, null, "");
//        List<Persona> personas = new ArrayList<>();
//        personas = reporteBO.obtenerListaDePersonas(persona);
//        for (int i = 0; i < personas.size(); i++) {
//            System.out.println(personas.get(i).getId());
//        }
//    }
//}
