package com.telefonica.cana.srv.util.commonutilities.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.telefonica.tran.comarq.cc.cabecera.TE_Cabecera;
import com.telefonica.tran.comarq.cc.error.TE_Excepcion;

/**
 * Clase de utilidad para trabajar con ficheros del gestor documental. USO:
 * GestorDocumental.getGestorDocumental().ficheroParaGestorDocumental(...)
 */
public class GestorDocumentalServiceImpl {

    private static final Logger LOGGER = LoggerFactory.getLogger(GestorDocumentalServiceImpl.class);

    /** Directorio de aplicacion. */
    private String DIR;

    /** Path donde se reciben los ficheros del gestor documental. */
    private String pathGestorDocumental;

    /** Path donde se guardan los ficheros para el gestor documental. */
    private String pathGestorDocumentalCana;

    /** Error de carga del componente comun del gestor documental. */
    private IOException error;

    /**
     * @return the pathGestorDocumental
     */
    public String getPathGestorDocumental() {
        return pathGestorDocumental;
    }

    /**
     * @return the pathGestorDocumentalCana
     */
    public String getPathGestorDocumentalCana() {
        return pathGestorDocumentalCana;
    }

    /**
     * Constructor.
     * @param dir 
     * @param pathGestorDocumentalCana2 
     * @param pathGestorDocumental2 
     */
    public GestorDocumentalServiceImpl(String pathGestDoc, String pathGestDocCana, String directorio) {
        LOGGER.info("Se inicializan las variables del gestor documental:");
        LOGGER.info("pathGestorDocumental: " + pathGestDoc);
        pathGestorDocumental = pathGestDoc;
        LOGGER.info("pathGestorDocumentalCana: " + pathGestDocCana);
        pathGestorDocumentalCana = pathGestDocCana;
        LOGGER.info("DIR: " + directorio);
        DIR = directorio;
    }

    /**
     * Guarda un fichero en la ruta para el gestor documental.
     * 
     * @param contenido
     *            contenido
     * @param teCabecera
     *            cabecera comun
     * @return ruta donde se ha guardado el fichero
     * @throws TE_Excepcion
     *             error de acceso
     */
    public String ficheroParaGestorDocumental(String nombre, byte[] contenido,
            TE_Cabecera teCabecera) throws TE_Excepcion {

        LOGGER.info("Inicio de ficheroParaGestorDocumental");

        LOGGER.info("pathGestorDocumentalCana: " + pathGestorDocumentalCana);

        if (StringUtils.isEmpty(pathGestorDocumentalCana)) {
            throw new TE_Excepcion(
                    CommonUtilitiesServiceImpl.getMessagebyIdioma(null, "CANA_E_000132", null),
                    CommonUtilitiesServiceImpl.getMessagebyIdioma(null, "CANA_E_000132_MSG",
                            new String[] { GestorDocumentalServiceImpl.class.getName() }));
        }

        String nombreFichero = UUID.randomUUID().toString();
        LOGGER.info("nombreFichero: " + nombreFichero);
        if (StringUtils.isNotEmpty(nombre)) {
            nombreFichero += "-" + nombre;
        }
        LOGGER.info("nombreFichero + nombre: " + nombreFichero);

    
        FileOutputStream os = null;
        try {
            
            Path pathGestorDoc = Paths.get(pathGestorDocumentalCana);
            LOGGER.info("pathGestorDoc: " + pathGestorDoc);

            LOGGER.info("Se procede a crear el fichero: " + pathGestorDocumentalCana + File.separator + nombreFichero);
            File f = new File(pathGestorDocumentalCana + File.separator + nombreFichero);
            LOGGER.info("Fichero creado correctamente");
       
            LOGGER.info("Se procede a añadir el contenido");
            os = new FileOutputStream(f);
            os.write(contenido);
            os.flush();
            LOGGER.info("Contenido añadido correctamente");

            f.setReadable(true, false);
            f.setWritable(true, false);

            LOGGER.info("Retornamos: " + DIR + File.separator + nombreFichero);
            return DIR + File.separator + nombreFichero;

        } catch (IOException e) {
            LOGGER.info("Se ha producido un error al añadir el contenido al fichero: " + e.getMessage());
            LOGGER.error("Se ha producido un error al añadir el contenido al fichero: " + e.getMessage());
            throw new TE_Excepcion(
                    CommonUtilitiesServiceImpl.getMessagebyIdioma(null, "INCL_E_000000", null),
                    CommonUtilitiesServiceImpl.getMessagebyIdioma(null, "INCL_E_000000_MSG", null));
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.toString();
                }
            }
        }
    }

    /**
     * Borrado del fichero.
     * 
     * @param fichero
     *            ruta del fichero.
     */
    public void borrarFichero(String fichero) {
        File f = new File(fichero);
        if (f.exists() && f.isFile()) {
            f.delete();
        }
    }

    /**
     * Borrado del fichero.
     * 
     * @param fichero
     *            ruta relativa del fichero.
     */
    public void borrarFicheroRelativo(String fichero) {
        borrarFichero(pathGestorDocumental + File.separator + fichero);
    }

    /**
     * Lee un fichero dejado por el gestor documental.
     * 
     * @param ruta
     *            nombre y ruta del fichero
     * @param teCabecera
     *            cabecera comun
     * @return contenido del fichero
     * @throws TE_Excepcion
     *             error de acceso
     */
    public byte[] ficheroDesdeGestorDocumental(String ruta, TE_Cabecera teCabecera)
            throws TE_Excepcion {
        if (StringUtils.isEmpty(pathGestorDocumental)) {
            throw new TE_Excepcion(
                    CommonUtilitiesServiceImpl.getMessagebyIdioma(null, "CANA_E_000132", null),
                    CommonUtilitiesServiceImpl.getMessagebyIdioma(null, "CANA_E_000132_MSG",
                            new String[] { GestorDocumentalServiceImpl.class.getName() }));
        }

        FileInputStream is = null;
        try {
            is = new FileInputStream(pathGestorDocumental + File.separator + ruta);
            byte[] contenido = new byte[is.available()];
            is.read(contenido);
            return contenido;
        } catch (IOException e) {
            throw new TE_Excepcion(
                    CommonUtilitiesServiceImpl.getMessagebyIdioma(null, "CANA_E_000132", null),
                    CommonUtilitiesServiceImpl.getMessagebyIdioma(null, "CANA_E_000132_MSG",
                            new String[] { GestorDocumentalServiceImpl.class.getName() }));
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.toString();
                }
            }
        }
    }

    /**
     * @return the error
     */
    public final IOException getError() {
        return error;
    }
}
