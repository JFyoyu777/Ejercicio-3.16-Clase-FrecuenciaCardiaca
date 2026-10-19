package aplicacion;

import calculadora.FrecuenciasCardiacas;
import java.util.Scanner;
import java.time.LocalDate;

public class PruebaFrecuenciasCardiacas {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("=== CALCULADORA DE FRECUENCIA CARDIACA ===");

        System.out.print("Ingrese su primer nombre: ");
        String nombre = entrada.nextLine();

        while (nombre.trim().isEmpty()) {
            System.out.print("Ingrese un nombre válido: ");
            nombre = entrada.nextLine();
        }

        System.out.print("Ingrese su apellido: ");
        String apellido = entrada.nextLine();

        while (apellido.trim().isEmpty()) {
            System.out.print("Ingrese un apellido válido: ");
            apellido = entrada.nextLine();
        }

        int dia = 0;
        int mes = 0;
        int anio = 0;
        boolean fechaValida = false;

        while (!fechaValida) {
            try {
                System.out.print("Ingrese el día de nacimiento: ");
                dia = Integer.parseInt(entrada.nextLine());

                System.out.print("Ingrese el mes de nacimiento: ");
                mes = Integer.parseInt(entrada.nextLine());

                System.out.print("Ingrese el año de nacimiento: ");
                anio = Integer.parseInt(entrada.nextLine());

                LocalDate fecha = LocalDate.of(anio, mes, dia);

                if (fecha.isAfter(LocalDate.now())) {
                    System.out.println("La fecha no puede ser futura.");
                } else if (anio < 1900) {
                    System.out.println("Ingrese un año desde 1900.");
                } else {
                    fechaValida = true;
                }

            } catch (Exception e) {
                System.out.println("Fecha inválida. Intente nuevamente.");
            }
        }

        // Crear objeto
        FrecuenciasCardiacas persona = new FrecuenciasCardiacas(
                nombre, apellido, mes, dia, anio);

        // Mostrar resultados
        System.out.println("\n=== RESULTADOS ===");

        System.out.println("Nombre: " + persona.getPrimerNombre());
        System.out.println("Apellido: " + persona.getApellido());

        System.out.println("Fecha de nacimiento: "
                + persona.getDiaNacimiento() + "/"
                + persona.getMesNacimiento() + "/"
                + persona.getAnioNacimiento());

        System.out.println("Edad: "
                + persona.calcularEdad() + " años");

        System.out.println("Frecuencia cardiaca máxima: "
                + persona.calcularFrecuenciaMaxima() + " ppm");

        System.out.println("Frecuencia cardiaca esperada: "
                + persona.calcularFrecuenciaEsperada() + " ppm");

        entrada.close();
    }
}

