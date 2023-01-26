/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PROG05_Ejerc1_util;

/**
 *
 * @author Ángel
 * 
 * Para todos nuestros métodos estáticos
 */

//Dependencias para jugar con fechas
import java.time.LocalDate;

public class Auxiliar {
    
    
    // Se le pasa un DNI y nos devuelve true o false según si coincide o no
    public static boolean validarDNI(String dni){
        
        if(dni.length() != 9){ //La primera, en la frente
            return false;
        }
        
        String letras= "TRWAGMYFPDXBNJZSQVHLCKE";                           //A buscar
        char letra = dni.charAt(dni.length() - 1);                          //Sacamos la letra
        int numero= Integer.parseInt(dni.substring(0, dni.length()-1));     //Nos quitamos los ceros
        
        char letracalculada = letras.charAt(numero % 23);                   //Sacamos la letra que deberia ser
        String numeroEnString = String.valueOf(numero);
        
        String dniCalculado = numeroEnString + letracalculada;              //Scamos el dni calculando letra
        String dniRecalculado = numeroEnString + letra;                     //Sacamos el dni pero como venía
        
        //No funciona con === ni ==
        boolean esNegativo = ( dniRecalculado.equals(dniCalculado) ) ? true:false; //Si no coincide, a Parla
        return esNegativo;
        
        
    }
    
    //Para validar la fecha. Devuelve true o false
    public static boolean validarFechaMatriculacion(LocalDate fecha){
        LocalDate hoy = LocalDate.now();
        boolean esNegativo = ( hoy.isBefore(fecha) ) ? true:false;
        return esNegativo;
        
    }
    
    //Para validar los KMs. Devuelve true o false
    public static boolean validarKMs(int kms){
        boolean esNegativo = (kms > 0 ) ? false:true;
        return esNegativo;
    }

    //Para mostrar el menú donde nos haga falta
     public static void mostrarMenu(){
        System.out.println("##############################################");
        System.out.println("#              GESTIONAR VEHICULO            #");
        System.out.println("#              Pulsa un numero               #");
        System.out.println("#   1. Nuevo Vehiculo                        #");
        System.out.println("#   2. Ver Matricula                         #");
        System.out.println("#   3. Ver Numero de Kilometros              #");
        System.out.println("#   4. Actualizar Kilometros                 #");
        System.out.println("#   5. Ver años de antigüedad                #");
        System.out.println("#   6. Mostrar propietario                   #");
        System.out.println("#   7. Mostrar descripcion                   #");
        System.out.println("#   8. Mostrar Precio                        #");
        System.out.println("#   9. Salir.                                #");
        System.out.println("##############################################");
    }
    
     //Para mostrar el error donde haga falta
     public static void mostrarError( String mensaje){
         System.out.println("No hay "+ mensaje +". Primero, debes crear un vehiculo");
     }
}
