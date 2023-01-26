/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PROG05_Ejerc1;

/**
 *
 * @author Ángel
 * Nustra clase Main, donde sucede toda la lógica de la aplicación
 */

import PROG05_Ejerc1_util.Auxiliar; //Biblioteca propia de comprobaciones
import java.util.Scanner;           //Biblioteca para poder añadir el input
//Dependencias para jugar con fechas
import java.time.LocalDate;
import java.time.Month;
import java.util.Locale;

public class Principal {
    
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in); 
        
        input.useDelimiter("\n");
        input.useLocale(Locale.US);
        
        boolean salir = false;

        Vehiculo nuevoVehiculo = null;
        
        while(salir== false){
            
            try{
                
                Auxiliar.mostrarMenu();
                int leerMenu = input.nextInt();
            
                switch(leerMenu){
                    case 1:
                        System.out.println("Introduce la marca");
                        String marca = input.next();

                        System.out.println("Introduce la matricula");
                        String matricula = input.next();

                        System.out.println("Introduce el numero de kilómetros");
                        int km = input.nextInt(); //A validar
                        
                        if(Auxiliar.validarKMs(km)) {
                            throw new Exception("KMs no validos, debe ser mayor que 0");
                        }

                        System.out.println("Introduce el dia de la fecha de matriculacion, en formato numérico");
                        int dia = input.nextInt();

                        System.out.println("Introduce el mes de la fecha de matriculacion, en formato numérico");
                        int mes = input.nextInt();

                        System.out.println("Introduce el año de la fecha de matriculacion, en formato numerico");
                        int anyo = input.nextInt();

                        LocalDate fechaMatriculacion = LocalDate.of(anyo, mes, dia); //A validar
                        
                        if (Auxiliar.validarFechaMatriculacion(fechaMatriculacion)) {
                            throw new Exception("Fecha no valida, debe ser anterior al dia actual");
                        }

                        System.out.println("Introduce la descripcion");
                        String descripcion = input.next();

                        System.out.println("Introduce el nombre del propietario");
                        String nombreProp = input.next();

                        System.out.println("Introduce el dni del propietario");
                        String DNIProp = input.next(); //A validar
                        
                       
                        if (!Auxiliar.validarDNI(DNIProp)) {
                            throw new Exception("DNI no valido");
                        }
                        
                        
                        System.out.println("Introduce el precio");
                        Double precio = input.nextDouble();

                        //¿Comprobamos que no exista un vehículo previo? Lo sobreescribe
                        nuevoVehiculo = new Vehiculo(marca, matricula, km, fechaMatriculacion, descripcion, precio, nombreProp, DNIProp);
                        if( Vehiculo.totalVehiculos == 0){
                            System.out.println("Vehiculo creado");
                            ++Vehiculo.totalVehiculos;
                        }else{
                            System.out.println("Vehiculo editado");
                        }



                    break;

                    case 2: //Ver Matrícula
                        if(Vehiculo.totalVehiculos > 0 | nuevoVehiculo != null) {
                                System.out.println("Matricula: " + nuevoVehiculo.getMatricula());
                        }else
                            Auxiliar.mostrarError("Matricula");
                    break;

                    case 3: //Ver KMs
                        if(Vehiculo.totalVehiculos > 0 | nuevoVehiculo != null) {
                                System.out.println("Kilómetros: " + nuevoVehiculo.getKms());
                        }else
                            Auxiliar.mostrarError("KMs");
                    break;

                    case 4: //Actualizar KMs
                        if(Vehiculo.totalVehiculos > 0 | nuevoVehiculo != null) {
                            
                            System.out.println("Introduce el numero de kilómetros");
                            int kmAct = input.nextInt(); //A validar

                            if (Auxiliar.validarKMs(kmAct)) {
                                throw new Exception("KMs no validos, debe ser mayor que 0");
                            }
                            
                            nuevoVehiculo.setKms(kmAct);
                            System.out.println("Kilómetros Actualizados");
                        
                        }else
                            Auxiliar.mostrarError("KMs");
                    break;

                    case 5: //Ver antigüedad. En Años
                        if(Vehiculo.totalVehiculos > 0 | nuevoVehiculo != null) {
                                System.out.println("El coche tiene : " + nuevoVehiculo.get_Anyos() +" años");
                        }else
                            Auxiliar.mostrarError("Antigüedad");
                    break;

                    case 6: //Ver propietario
                        if(Vehiculo.totalVehiculos > 0 | nuevoVehiculo != null) {
                                System.out.println("Propietario: " + nuevoVehiculo.getPropietario());
                        }else
                            Auxiliar.mostrarError("Propietario");
                    break;

                    case 7: //Ver descripcion
                        if(Vehiculo.totalVehiculos > 0 | nuevoVehiculo != null) {
                                System.out.println("Descripcion: " + nuevoVehiculo.getDescripcion());
                        }else
                            Auxiliar.mostrarError("Descripcion");
                    break;

                    case 8: //Ver precio
                        if(Vehiculo.totalVehiculos > 0 | nuevoVehiculo != null) {
                                System.out.println("Precio: " + nuevoVehiculo.getPrecio());
                        }else
                            Auxiliar.mostrarError("precio");
                    break;

                    case 9:
                        salir = true;
                    break;
                    
                    default:
                        System.out.println("Debes introducir una opción del menu. Elige entre 1 a 9 ");
                        

                } //Fin del switch. Que se me va la flapa
            
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
            
        }
        
    }
    
}
