/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.filesej11albertocaracuel;

import java.io.File;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author alberto
 */
public class ServicioFicheroXML {

    public ServicioFicheroXML() {
    }

    public void crearFicheroXML(String nombre, ArrayList<App> lista) throws JAXBException {

//     // Se preparan los objetos a utilizar, en esta caso un catálogo
        ArrayList<App> listaM = lista;
        ListaApp catalogo = new ListaApp();
        catalogo.setLista(listaM);
        catalogo.setDescripcion("Mi lista");
       
        // Crea el contexto JAXB. Se encarga de definir los objetos 
        // que vamos a guardar. En nuestro caso sólo el tipo ListaApp
        JAXBContext contexto = JAXBContext.newInstance(ListaApp.class);
        
        // El contexto JAXB permite crear un objeto Marshaller, que sirve para
        // generar la estructura del fichero XML 
        // El proceso de pasar objetos Java (ListaApp) a ficheros XML 
        // se conoce como "marshalling" o "serialización"
        Marshaller serializador = contexto.createMarshaller();
        
        // Especificamos que la propiedad del formato de salida
        // del serializador sea true, lo que implica que el formato se 
        // realiza con indentación y saltos de línea
        serializador.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        // Llamando al método de serialización marshal (sobrecargado) se pueden
        // serializar objetos java en formato XML y volcarlos donde necesitemos:
        // consola, ficheros. El proceso consiste en que el contexto es el 
        // encargo de leer los objetos java, pasarlos al serializador y éste 
        // crear la salida de serialización
        
        // Serialización y salida por consola
        serializador.marshal(catalogo, System.out);

        // Volcado al fichero xml
        serializador.marshal(catalogo, new File("aplicacionesxml.xml"));
    }
    
    }

   

