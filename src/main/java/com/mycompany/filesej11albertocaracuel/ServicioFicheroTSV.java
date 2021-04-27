/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.filesej11albertocaracuel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author alberto
 */
public class ServicioFicheroTSV {

    public ServicioFicheroTSV() {
    }

    public void escribirArchivoTSV(String nombre, ArrayList<App> lista) throws IOException {

        String ruta = nombre;
        File f = new File(ruta);
        FileOutputStream fw = new FileOutputStream(f);
        try (ObjectOutputStream escritura = new ObjectOutputStream(fw)) {
            for (App o : lista) {

                escritura.writeObject(o + "\n");

            }
        }

    }
}
