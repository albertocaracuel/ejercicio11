/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.filesej11albertocaracuel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

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
     @XmlJavaTypeAdapter(value = LocalDateAdapter.class)
    private LocalDate fechaDeCreacion;
    private static int contador;

    public App() {
        this.codigoUnico = contadorInstancias();
        this.nombre = crearNombre();
        this.direccion = crearDescripcion();
        this.tamaño = crearTamaño();
        this.fechaDeCreacion = crearFecha();

        contador++;
    }

    private LocalDate crearFecha() {
        LocalDate fecha =  LocalDate.now();

        int a = random.nextInt(2 - 1 + 1) + 1;

        switch(a){
            case 1:
                int b = random.nextInt(30 - 1 + 1) + 1;
                fecha.plusDays(contador);
                break;
                
            case 2:
                int c = random.nextInt(30 - 1 + 1) + 1;
                fecha.minusDays(codigoUnico);
                break;
        }

        return fecha;
    }

    //hago un random double para hacer el tamaño
    private double crearTamaño() {

        return random.doubles(1, 100.0, 1024.0).sum();
    }

    //hago una lista de 10 descripciones,un aleatorio de 0 a 9 que me darta una posicion de la lista
    private String crearDescripcion() {
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

    //sumo los string q contiene app la letra aleatoria y el contador
    private String crearNombre() {

        String numCadena = String.valueOf(contadorInstancias());

        char letraMinus = (char) (random.nextInt(26) + 'a');

        String nombreFinal = "App" + numCadena + letraMinus;

        return nombreFinal;
    }

    //creo variable q se va sumando con cada constructor y te lo devuelve
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
        this.direccion = crearDescripcion();
    }

    public double getTamaño() {
        return tamaño;
    }

    public void setTamaño() {
        this.tamaño = crearTamaño();
    }

    public LocalDate getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public void setFechaDeCreacion() {
        this.fechaDeCreacion = crearFecha();
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
        return "{" + codigoUnico + " " + nombre + "  " + direccion + "   " + tamaño + "  " + fechaDeCreacion + "}";
    }

}
