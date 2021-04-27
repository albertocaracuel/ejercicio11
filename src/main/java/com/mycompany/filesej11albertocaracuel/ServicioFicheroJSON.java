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
import java.util.ArrayList;

/**
 *
 * @author alberto
 */
public class ServicioFicheroJSON {

    public ServicioFicheroJSON() {
    }
//metodo que crea el json
    public void escribirArchivo(String nombre, ArrayList<App> lista) throws IOException {

        ObjectMapper mapeador = new ObjectMapper();

        mapeador.configure(SerializationFeature.INDENT_OUTPUT, true);

        // Escribe en un fichero JSON el catálogo de muebles
        mapeador.writeValue(new File(nombre), lista);

    }
}
