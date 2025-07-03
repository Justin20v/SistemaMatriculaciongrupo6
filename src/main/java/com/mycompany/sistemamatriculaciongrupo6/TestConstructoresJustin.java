/**
 * Autor: Justin Erazo (Justin20v)
 * Descripción: Casos de prueba para métodos constructores.
 */
package com.mycompany.sistemamatriculaciongrupo6;

import java.time.LocalDate;

public class TestConstructoresJustin {

    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("  EJECUTANDO TESTS DE CONSTRUCTORES");
        System.out.println("==========================================\n");

        testVehiculoPlacaVacia_V04();
        testVehiculoPropietarioNombreInvalido_V05();
        testMatriculaDatosValidos_M01();
        testMatriculaVehiculoNulo_M02();
        testMatriculaFechaNula_M03();
        testMatriculaFechaFutura_M04();
        testPagoDatosValidos_PA01();
        testPagoMatriculaNula_PA02();
        testPagoMetodoPagoVacio_PA03();

        System.out.println("==========================================");
        System.out.println("        TESTS COMPLETADOS");
        System.out.println("==========================================");
    }

    public static void testVehiculoPlacaVacia_V04() {
        System.out.println("=== V04: Vehiculo con placa vacía ===");
        try {
            Persona propietario = new Persona("Carlos", "1234567890", "Quito", "0999999999");
            Vehiculo v = new Vehiculo("", "Kia", "Rio", "Sedan", 2019, propietario);
            System.out.println("✗ TEST FALLIDO: Se esperaba IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            System.out.println("✓ TEST APROBADO: Excepción esperada capturada");
        }
        System.out.println();
    }

    public static void testVehiculoPropietarioNombreInvalido_V05() {
        System.out.println("=== V05: Vehiculo con nombre inválido de propietario ===");
        try {
            Persona propietario = new Persona("Carlos9", "1234567890", "Guayaquil", "0999999999");
            Vehiculo v = new Vehiculo("LMN321", "Mazda", "CX5", "SUV", 2021, propietario);
            System.out.println("✗ TEST FALLIDO: Se esperaba IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            System.out.println("✓ TEST APROBADO: Excepción esperada capturada");
        }
        System.out.println();
    }

    public static void testMatriculaDatosValidos_M01() {
        System.out.println("=== M01: Matricula con datos válidos ===");
        try {
            Persona p = new Persona("Ana", "1234567890", "Quito", "0999999999");
            Vehiculo v = new Vehiculo("ABC123", "Toyota", "Yaris", "Sedan", 2020, p);
            LocalDate fecha = LocalDate.of(2023, 6, 1);
            Matricula m = new Matricula(v, fecha, true);
            System.out.println("✓ TEST APROBADO: Matricula creada correctamente");
        } catch (Exception e) {
            System.out.println("✗ TEST FALLIDO: No se esperaba excepción - " + e.getMessage());
        }
        System.out.println();
    }

    public static void testMatriculaVehiculoNulo_M02() {
        System.out.println("=== M02: Matricula con vehículo nulo ===");
        try {
            LocalDate fecha = LocalDate.of(2023, 6, 1);
            Matricula m = new Matricula(null, fecha, true);
            System.out.println("✗ TEST FALLIDO: Se esperaba IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            System.out.println("✓ TEST APROBADO: Excepción esperada capturada");
        }
        System.out.println();
    }

    public static void testMatriculaFechaNula_M03() {
        System.out.println("=== M03: Matricula con fecha nula ===");
        try {
            Persona p = new Persona("Juan", "1234567890", "Loja", "0991112233");
            Vehiculo v = new Vehiculo("XYZ123", "Nissan", "Sentra", "Sedan", 2018, p);
            Matricula m = new Matricula(v, null, false);
            System.out.println("✗ TEST FALLIDO: Se esperaba IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            System.out.println("✓ TEST APROBADO: Excepción esperada capturada");
        }
        System.out.println();
    }

    public static void testMatriculaFechaFutura_M04() {
        System.out.println("=== M04: Matricula con fecha futura ===");
        try {
            Persona p = new Persona("Luis", "1234567890", "Manta", "0987654321");
            Vehiculo v = new Vehiculo("AAA111", "Chevrolet", "Aveo", "Sedan", 2020, p);
            LocalDate fechaFutura = LocalDate.now().plusDays(10);
            Matricula m = new Matricula(v, fechaFutura, true);
            System.out.println("✗ TEST FALLIDO: Se esperaba IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            System.out.println("✓ TEST APROBADO: Excepción esperada capturada");
        }
        System.out.println();
    }

    public static void testPagoDatosValidos_PA01() {
        System.out.println("=== PA01: Pago con datos válidos ===");
        try {
            Persona p = new Persona("Sofia", "1234567890", "Ambato", "0976543210");
            Vehiculo v = new Vehiculo("PAQ987", "Hyundai", "Accent", "Sedan", 2019, p);
            Matricula m = new Matricula(v, LocalDate.of(2023, 6, 1), true);
            Pago pago = new Pago(m, "Efectivo", 100.0, LocalDate.of(2023, 6, 5));
            System.out.println("✓ TEST APROBADO: Pago creado correctamente");
        } catch (Exception e) {
            System.out.println("✗ TEST FALLIDO: No se esperaba excepción - " + e.getMessage());
        }
        System.out.println();
    }

    public static void testPagoMatriculaNula_PA02() {
        System.out.println("=== PA02: Pago con matrícula nula ===");
        try {
            Pago pago = new Pago(null, "Transferencia", 50.0, LocalDate.of(2023, 6, 5));
            System.out.println("✗ TEST FALLIDO: Se esperaba IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            System.out.println("✓ TEST APROBADO: Excepción esperada capturada");
        }
        System.out.println();
    }

    public static void testPagoMetodoPagoVacio_PA03() {
        System.out.println("=== PA03: Pago con método de pago vacío ===");
        try {
            Persona p = new Persona("Esteban", "1234567890", "Cuenca", "0981234567");
            Vehiculo v = new Vehiculo("BCD222", "Ford", "Fiesta", "Hatchback", 2022, p);
            Matricula m = new Matricula(v, LocalDate.of(2023, 5, 15), false);
            Pago pago = new Pago(m, "", 80.0, LocalDate.of(2023, 6, 10));
            System.out.println("✗ TEST FALLIDO: Se esperaba IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            System.out.println("✓ TEST APROBADO: Excepción esperada capturada");
        }
        System.out.println();
    }
}
