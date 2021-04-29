/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.filesej11albertocaracuel;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.xml.bind.JAXBException;

/**
 *
 * @author alberto
 */
public class Programa {

    public static void main(String[] args) throws IOException, JAXBException {

        crearDirectorio("appstsv");
        crearDirectorio("appsxml");
        crearDirectorio("appsjson");
        crearDirectorio("copias");
        crearDirectorio("aplicaciones");

        ServicioFicheroTSV o = new ServicioFicheroTSV();

        o.escribirArchivoTSV( "./appstsv/Aplicaciones.tsv",crearLista(50));

        ServicioFicheroXML a = new ServicioFicheroXML();
        a.crearFicheroXML("./appsxml/Aplicaciones.xml", crearLista(50));
        
        ServicioFicheroJSON e = new ServicioFicheroJSON();

        e.escribirArchivo("./appsjson/Aplicaciones.json", crearLista(50));

        for (App z : crearLista(50)) {
            ArrayList<App> nuva = new ArrayList<>();
            nuva.add(z);
            ObjectMapper mapeador = new ObjectMapper();

            mapeador.configure(SerializationFeature.INDENT_OUTPUT, true);

            // Escribe en un fichero JSON el catálogo de muebles
            mapeador.writeValue(new File("./aplicaciones/" + z.getNombre() + ".json"), nuva);
        }

    }
    //metodo que crea un objeto,mediante una lista y for al q le doy el numero de objetos que quiera
    //y se lo voy añadiendo mientras la recorro
    private static ArrayList<App> crearLista(int numeroDeObjetos) {
        ArrayList<App> lista = new ArrayList<>();
        for (int i = 0; i < numeroDeObjetos; i++) {
            App o = new App();
            lista.add(o);
        }

        return lista;
    }
    //metodo que crea un directorio
    private static void crearDirectorio(String directorio) {
        Path directory = Paths.get(directorio);
        try {
            Files.createDirectory(directory);
        } catch (IOException e) {
            System.out.println("Problema creando el directorio.");
            System.out.println(e.toString());
        }

    }
}
