/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.filesej11albertocaracuel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.Objects;
import java.util.OptionalDouble;
import java.util.PrimitiveIterator;
import java.util.Random;
import java.util.Spliterator;
import java.util.function.BiConsumer;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;
import java.util.function.DoublePredicate;
import java.util.function.DoubleToIntFunction;
import java.util.function.DoubleToLongFunction;
import java.util.function.DoubleUnaryOperator;
import java.util.function.ObjDoubleConsumer;
import java.util.function.Supplier;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 *
 * @author alber
 */
public class App {

    Random random = new Random();
    private int codigoUnico;
    private String nombre;
    private String direccion;
    private double tamaño;
    private LocalDate fechaDeCreacion;
    private static int contador;

    public App() {
        this.codigoUnico = contadorInstancias();
        this.nombre = crearNombre();
        this.direccion = crearDireccion();
        this.tamaño = tamaño;
        this.fechaDeCreacion = fechaDeCreacion;
    }
    
    private double crearTamaño(){
        DoubleStream uno =new DoubleStream();
        uno.d
    }
    private String crearDireccion() {
        ArrayList<String> lista = new ArrayList<>();

        lista.add("sirve para hacer fotos");
        lista.add("sirve para hacer dibujos");
        lista.add("sirve para hacer musica");
        lista.add("sirve para jugar");
        lista.add("sirve para grabar");
        lista.add("sirve para grabar musica");
        lista.add("no sirve para hacer fotos");
        lista.add("no sirve para nada");
        lista.add("ocupa poco");
        lista.add("ocuoa mucho");

        int a = random.nextInt(9 - 0 + 1) + 0;
        return lista.get(a);
    }

    private String crearNombre() {
        Random random = new Random();

        String numCadena = String.valueOf(contadorInstancias());

        char letraMinus = (char) (random.nextInt(26) + 'a');

        String nombreFinal = "App" + numCadena + letraMinus;

        return nombreFinal;
    }

    private int contadorInstancias() {
        return contador;
    }

    public int getCodigoUnico() {
        return codigoUnico;
    }

    public void setCodigoUnico() {
        this.codigoUnico = contadorInstancias();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre() {
        this.nombre = crearNombre();
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion() {
        this.direccion = crearDireccion();
    }

    public double getTamaño() {
        return tamaño;
    }

    public void setTamaño(double tamaño) {
        this.tamaño = tamaño;
    }

    public LocalDate getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public void setFechaDeCreacion(LocalDate fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + this.codigoUnico;
        hash = 73 * hash + Objects.hashCode(this.nombre);
        hash = 73 * hash + Objects.hashCode(this.direccion);
        hash = 73 * hash + (int) (Double.doubleToLongBits(this.tamaño) ^ (Double.doubleToLongBits(this.tamaño) >>> 32));
        hash = 73 * hash + Objects.hashCode(this.fechaDeCreacion);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final App other = (App) obj;
        if (this.codigoUnico != other.codigoUnico) {
            return false;
        }
        if (Double.doubleToLongBits(this.tamaño) != Double.doubleToLongBits(other.tamaño)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.direccion, other.direccion)) {
            return false;
        }
        if (!Objects.equals(this.fechaDeCreacion, other.fechaDeCreacion)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return codigoUnico + " " + nombre + "  " + direccion + "   " + tamaño + "  " + fechaDeCreacion;
    }

}
