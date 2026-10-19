package calculadora;

import java.time.LocalDate;
import java.time.Period;

public class FrecuenciasCardiacas {

    // Atributos
    private String primerNombre;
    private String apellido;
    private int mesNacimiento;
    private int diaNacimiento;
    private int anioNacimiento;

    // Constructor
    public FrecuenciasCardiacas(String primerNombre, String apellido,
                                int mesNacimiento, int diaNacimiento,
                                int anioNacimiento) {
        setPrimerNombre(primerNombre);
        setApellido(apellido);
        setFechaNacimiento(mesNacimiento, diaNacimiento, anioNacimiento);
    }

    // Setters y Getters
    public void setPrimerNombre(String primerNombre) {
        if (primerNombre != null && !primerNombre.trim().isEmpty()) {
            this.primerNombre = primerNombre;
        }
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setApellido(String apellido) {
        if (apellido != null && !apellido.trim().isEmpty()) {
            this.apellido = apellido;
        }
    }

    public String getApellido() {
        return apellido;
    }

    // Validación conjunta de la fecha
    public void setFechaNacimiento(int mes, int dia, int anio) {
        try {
            LocalDate fecha = LocalDate.of(anio, mes, dia);

            if (!fecha.isAfter(LocalDate.now())) {
                this.mesNacimiento = mes;
                this.diaNacimiento = dia;
                this.anioNacimiento = anio;
            }
        } catch (Exception e) {
            System.out.println("Fecha de nacimiento no válida.");
        }
    }

    public void setMesNacimiento(int mesNacimiento) {
        setFechaNacimiento(mesNacimiento, diaNacimiento, anioNacimiento);
    }

    public int getMesNacimiento() {
        return mesNacimiento;
    }

    public void setDiaNacimiento(int diaNacimiento) {
        setFechaNacimiento(mesNacimiento, diaNacimiento, anioNacimiento);
    }

    public int getDiaNacimiento() {
        return diaNacimiento;
    }

    public void setAnioNacimiento(int anioNacimiento) {
        setFechaNacimiento(mesNacimiento, diaNacimiento, anioNacimiento);
    }

    public int getAnioNacimiento() {
        return anioNacimiento;
    }

    // Calcular edad
    public int calcularEdad() {
        LocalDate nacimiento = LocalDate.of(
                anioNacimiento, mesNacimiento, diaNacimiento);

        return Period.between(nacimiento, LocalDate.now()).getYears();
    }

    // Calcular frecuencia cardiaca máxima
    public int calcularFrecuenciaMaxima() {
        return 220 - calcularEdad();
    }

    // Calcular frecuencia cardiaca esperada mínima
    public double calcularFrecuenciaMinima() {
        return calcularFrecuenciaMaxima() * 0.50;
    }

    // Calcular frecuencia cardiaca esperada máxima
    public double calcularFrecuenciaEsperadaMaxima() {
        return calcularFrecuenciaMaxima() * 0.85;
    }

    // Devolver el rango esperado
    public String calcularFrecuenciaEsperada() {
        return String.format("%.1f - %.1f",
                calcularFrecuenciaMinima(),
                calcularFrecuenciaEsperadaMaxima());
    }
}
