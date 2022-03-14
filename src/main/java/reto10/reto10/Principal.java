/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package reto10.reto10;
import reto10.reto10.Estudiante;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.averagingDouble;
import static java.util.stream.Collectors.toList;
import java.util.stream.Stream;


/**
 *
 * @author 
   Kelly Julieth Arango Henao
   Juan Camilo Rivera Avendaño
 */
public class Principal {
     public static int sumarDigitos(int num){
        if(num == 0){
                return 0;
        }
        else{
            return sumarDigitos(num / 10) + num % 10;
        }
     }
     
     public static double calcularRaizCuadrada(double num){
        num = Math.sqrt(num);
        return num;
    }
     public static void calcularRaizCuadradaLista(List<Double> lista){
        List<Double> listaRaices = new ArrayList();
        Stream<Double> streamNumeros = lista.stream();
        streamNumeros.forEach((p)->{
            listaRaices.add(calcularRaizCuadrada(p));
        });
        for(Double p:listaRaices){
            System.out.println(p);
        }
    }
     public static long calcularFactorial(long num){
        if(num <= 1){
            return 1;
        }
        else{
            return num * calcularFactorial(num - 1);
        }
    }
    
    public static void calcularFactorialStream(Stream<Long> numero){
        numero.forEach((p)->{
            System.out.printf("%nEl factorial del número %d es: %d", p, calcularFactorial(p));
        });    
    }
    public static void cadenasDeCaracteres(String[] cadenas){
        List<String> listaCadenas = new ArrayList();
        Stream<String> streamCadenas = Arrays.stream(cadenas);
        streamCadenas.forEach((p)->{
            if(p.length() >=5 ){
               listaCadenas.add(p);
            }
        });
        for(String p:listaCadenas){
            System.out.println(p);
        }
    }
    
    private static double promedio(List<Estudiante> listaEstudiantes) {
       return listaEstudiantes.stream().collect(averagingDouble(x -> x.getPromedio()));
    }
    
    public static String mayorPromedio(List<Estudiante> listaEstudiantes){
         return listaEstudiantes.stream().max((Estudiante a, Estudiante b) -> a.getPromedio() - b.getPromedio()).get();
    }
    
    public static double menorPromedio(List<Estudiante> listaEstudiantes){
       return listaEstudiantes.stream().min((Estudiante a, Estudiante b) ->  a.getPromedio()-b.getPromedio()).get();
    }
    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) {
        String set = "";
        Scanner leer = new Scanner(System.in);
        int option;
        boolean sw = true;
        while(sw){
            System.out.println("\n\t\t\tIngrese el número correspondiente al punto a desarrollar:");
            System.out.println("1. Punto 1.");
            System.out.println("2. Punto 3.a");
            System.out.println("3. Punto 3.b");
            System.out.println("4. Punto 3.c");
            System.out.println("5. Punto 4");
            System.out.println("0. Salir");
            try{
                option = leer.nextInt();
                switch(option){
                    case 0:
                        sw = false;
                        break;
                    case 1:
                        System.out.println("Ingrese un número entero: ");
                        try{
                            int num = leer.nextInt();
                            System.out.printf("%nLa suma de los dígitos del número %d es: %d", num, sumarDigitos(num));
                        }catch(InputMismatchException e){
                            System.out.println("Debe ingresar un número entero");
                        leer.next();
                        }
                        break;
                     case 2:
                        double num;
                        int op;
                        boolean masNumeros = true;
                        List<Double> listaNumeros = new ArrayList();
                        while(masNumeros){
                            System.out.println("\n\t\t¿Tiene más números para ingresar?");
                            System.out.println("1. Sí");
                            System.out.println("2. No");
                            try{
                                op = leer.nextInt();
                                switch(op){
                                    case 1:
                                        System.out.println("Ingrese el siguiente número de la lista: ");
                                        num = leer.nextDouble();
                                        listaNumeros.add(num);
                                    break;
                                    case 2:
                                        masNumeros = false;
                                    break;
                                }
                            }catch(InputMismatchException e){
                                System.out.println("Debe ingresar un número entero");
                                leer.next();
                            }  
                        }
                        calcularRaizCuadradaLista(listaNumeros);
                        break;
                    case 3:
                        long a;
                        System.out.println("Ingrese un número entero: ");
                        a = leer.nextLong();
                        Stream<Long> numero = Stream.of(a);
                        calcularFactorialStream(numero);
                        break;
                    case 4:
                        System.out.println("Ingrese las cadenas de caracteres separadas por comas: ");
                        set = leer.nextLine();
                        String[] cadenas = set.split(",");
                        cadenasDeCaracteres(cadenas);
                        break;
                    case 5:
                        
                        List<Estudiante> listaEstudiantes = new ArrayList();
                        System.out.println("Ingrese el número de estudiantes: ");
                        int numEstudiantes = leer.nextInt();
                        for(int i=0;i<numEstudiantes;i++){
                            System.out.println("Nombres: ");
                            String nombre = leer.nextLine();
                            System.out.println("Apellidos: ");
                            String apellido = leer.nextLine();
                            System.out.println("Promedio: ");
                            double promedio = leer.nextDouble();
                            Estudiante e = new Estudiante(nombre, apellido, promedio);
                            listaEstudiantes.add(e);
                            
                        }               
                        System.out.println("Promedio: "+ promedio(listaEstudiantes));
                        System.out.println("El nombre y el apellido del estudiante con el mayor promedio es: "+ mayorPromedio(listaEstudiantes));
                        System.out.println("El menor promedio entre los estudiantes es: "+ menorPromedio(listaEstudiantes));
                        break;
                        default:
                        System.out.println("Ingrese una opción válida (Número entre 0 y 5)");
        }

        }catch(InputMismatchException e){
                System.out.println("Debe ingresar un número entero");
                leer.next();
            }   
        }
     }

    
}
