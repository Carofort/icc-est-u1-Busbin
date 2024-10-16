import java.util.Scanner;
import java.util.Arrays;

public class Metodos {
    Scanner leer = new Scanner(System.in);
    
    public void ingresoArreglo(){
        int cantidadPersonas = leerEnteroValido(leer, "Ingrese cantidad de Personas: ", false);

        Persona[] personas = new Persona[cantidadPersonas];

        int[] arreglo = new int[cantidadPersonas];
        for(int i = 0; i < cantidadPersonas; i++){
            System.out.println("Ingrese el nombre de la persona: ");
            String nombre = leer.nextLine();
            int edad = leerEnteroValido(leer, "Ingrese la edad de la persona: ", false);
            leer.nextLine();
            arreglo[i] = edad;
            personas[i] = new Persona(nombre, edad);
        }
    }
    
    

    public void sortByEdad(Persona[] personas){
        for(int i = 0; i< cantidadPersonas; i++){
            for(int j = i+1; j < cantidadPersonas; j++){
                if(personas[i].getEdad() > personas[j].getEdad()){
                    Persona aux = personas [i];
                    personas[i] = personas[j];
                    personas[j] = aux;
                }
            }
        }
        System.out.println(Arrays.toString(personas));
    }
    
    public int busquedaBinaria(int[]arreglo, int edad){
        int inicio = 0;
        int fin = arreglo.length - 1;
        edad = leerEnteroValido(leer, "Edad a buscar: ", false);
        while(inicio <= fin){
            int medio = inicio + (fin - inicio) /2;
            count++;
            System.out.println("Valor centro: " + medio);
            if(arreglo[medio] == edad){
                //Elemento encontrado
                System.out.println("bajo= " + inicio+"" );
                System.out.println("Valor centro: " + medio);
                return medio;
            }

            if(arreglo[medio] < edad){
                inicio = medio + 1; //Busca mitad derecha
                System.out.println("centro= "+medio+"Valor centro: " + arreglo[medio]);
            } else{
                fin = medio - 1; //Busca mitad izquierda
                System.out.println("centro= "+medio+"Valor centro: " + arreglo[medio]);
            }

        }
        return -1;
    }

    public static int leerEnteroValido(Scanner leer, String mensaje, boolean numerosNegativos){
        int numero;
        do{
            System.out.println(mensaje);
            while(!leer.hasNextInt()){
                System.out.println("Le pedí un entero válido");
                System.out.println(mensaje);
                leer.next();
            }
            numero = leer.nextInt();
            if(!numerosNegativos && numero < 0){
                System.out.println("No se permiten números negativos");

            }
        } while(!numerosNegativos && numero < 0);
        return numero;
    }  
       
}
