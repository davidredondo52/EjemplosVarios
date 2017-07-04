package com.telefonica.cana.srv.util.commonutilities.service.impl;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.telefonica.cana.srv.util.commonutilities.msg.getlanguagesheader.GetLanguagesHeader_IN;
import com.telefonica.cana.srv.util.commonutilities.msg.getlanguagesheader.GetLanguagesHeader_OUT;
import com.telefonica.cana.srv.util.commonutilities.service.CommonUtilitiesService;
import com.telefonica.tran.comarq.cc.cabecera.TE_Cabecera;
import com.telefonica.tran.comarq.cc.error.TE_Excepcion;
import com.telefonica.tran.comarq.cc.idioma.TE_Idioma;
import com.telefonica.tran.comarq.cc.metadatos.TE_Metadatos;
import com.telefonica.tran.comarq.cc.metadatos.TE_Ordenacion;
import com.telefonica.tran.comarq.cc.metadatos.TE_Paginacion;
import com.telefonica.tran.comarq.cc.metadatos.TE_PaginacionIN;
import com.telefonica.tran.comarq.cc.metadatos.TE_PaginacionOUT;

@Validated
@Transactional(propagation = Propagation.SUPPORTS, rollbackFor = { TE_Excepcion.class })
@Service
public class CommonUtilitiesServiceImpl implements CommonUtilitiesService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommonUtilitiesServiceImpl.class);

    @Autowired
    Environment env;

    private static final String CANA_UDDI_PROPERTIES = "Uddi_CANA";
    private static final String CANA_MSGS_PROPERTIES = "messages_ES";

    @Override
    public GetLanguagesHeader_OUT getLanguagesHeader(GetLanguagesHeader_IN in) throws TE_Excepcion {
        return new GetLanguagesHeader_OUT();
    }

    @Override
    public String getLanguagesHeader() throws TE_Excepcion {
        return TE_Idioma.getTEIdioma().getIdiomaPorDefecto();
    }

    /**
     * 
     * Crea un MultiLanguageList en función de los parámetros pasados. Realiza
     * todo el tratamiento de multiidioma. - Migrado por MRGOMAAL
     * 
     * @param mlListClass
     *            clase del MultiLanguageList con el paquete incluido
     * @param isMultilanguage
     *            Indica si ha seteado el multilanguage
     * @param idiomaPorDefecto
     *            Id del idioma por defecto
     * @param idiomaUsuario
     *            Id del idioma del usuario
     * @param objetoPrincipal
     *            Objeto del modelo que se está procesando para sacar el nombre
     *            o la descripción
     * @param nombreMetodoDescripcion
     *            Nombre del método del objeto que devuelve el nombre o la
     *            descripción
     * @param nombreMetodoListaIdiomas
     *            Nombre del método que devuelve la lista de traducciones del
     *            nombre o la descripción
     * @return
     * @throws TE_Excepcion
     */
    @SuppressWarnings("rawtypes")
    public static <T> T creaMultiLanguageList(Class<T> mlListClass, Boolean isMultilanguage,
            Long idiomaPorDefecto, Long idiomaUsuario, Object objetoPrincipal,
            String nombreMetodoDescripcion, String nombreMetodoListaIdiomas) throws TE_Excepcion {
        
        LOGGER.debug("Inicio de la llamada al método de utilidades creaMultiLanguageList",
                String.valueOf(new Date()), String.valueOf(new Date()));

        T multiLanguageList = null;

        Class[] cArgL = { Long.class };
        Class[] cArgS = { String.class };

        try {
            multiLanguageList = mlListClass.newInstance();
            Boolean esIdiomaPorDefecto = idiomaPorDefecto.equals(idiomaUsuario);

            List<Object> listaMultilenguaje = new ArrayList<Object>();

            Class<?> claseMultilanguage = mlListClass.getMethod("getMultiLanguages").getReturnType()
                    .getComponentType();

            if (Boolean.TRUE.equals(isMultilanguage)) {
                // Si es multilanguage, debemos devolver todos los idiomas

                Object multilenguaje = claseMultilanguage.newInstance();

                Object valorObject = objetoPrincipal.getClass().getMethod(nombreMetodoDescripcion)
                        .invoke(objetoPrincipal);
                if (valorObject != null && !"".equals(valorObject.toString())) {
                    claseMultilanguage.getMethod("setValue", cArgS).invoke(multilenguaje,
                            valorObject.toString());
                    claseMultilanguage.getMethod("setLanguageCode", cArgL).invoke(multilenguaje,
                            idiomaPorDefecto);
                    listaMultilenguaje.add(multilenguaje);
                }

                List<?> traduccionesList = (List<?>) objetoPrincipal.getClass()
                        .getMethod(nombreMetodoListaIdiomas).invoke(objetoPrincipal);

                if (traduccionesList != null && !traduccionesList.isEmpty()) {
                    for (Object dfpsl : traduccionesList) {
                        multilenguaje = claseMultilanguage.newInstance();
                        Object valorLang = dfpsl.getClass().getMethod(nombreMetodoDescripcion)
                                .invoke(dfpsl);
                        if (valorLang != null && !"".equals(valorLang.toString())) {
                            Long codLanguage = Long.valueOf(dfpsl.getClass()
                                    .getMethod("getLangCoLanguage").invoke(dfpsl).toString());
                            claseMultilanguage.getMethod("setLanguageCode", cArgL)
                                    .invoke(multilenguaje, codLanguage);
                            claseMultilanguage.getMethod("setValue", cArgS).invoke(multilenguaje,
                                    valorLang.toString());
                            listaMultilenguaje.add(multilenguaje);
                        }
                    }
                    Iterator<?> iterator = listaMultilenguaje.iterator();
                    while (iterator.hasNext()) {
                        multilenguaje = iterator.next();
                        Long codLanguage = Long.valueOf(multilenguaje.getClass()
                                .getMethod("getLanguageCode").invoke(multilenguaje).toString());
                        if (codLanguage.equals(idiomaUsuario)) {
                            Object multilenguajeClon = claseMultilanguage.newInstance();
                            claseMultilanguage.getMethod("setLanguageCode", cArgL)
                                    .invoke(multilenguajeClon, codLanguage);
                            String valorLang = multilenguaje.getClass().getMethod("getValue")
                                    .invoke(multilenguaje).toString();
                            claseMultilanguage.getMethod("setValue", cArgS)
                                    .invoke(multilenguajeClon, valorLang);
                            iterator.remove();
                            listaMultilenguaje.add(0, multilenguajeClon);
                            break;
                        }
                    }
                }

            } else {

                Object multilenguaje = claseMultilanguage.newInstance();

                Object valorObject = objetoPrincipal.getClass().getMethod(nombreMetodoDescripcion)
                        .invoke(objetoPrincipal);
                if (valorObject != null && !"".equals(valorObject.toString())) {
                    claseMultilanguage.getMethod("setValue", cArgS).invoke(multilenguaje,
                            valorObject.toString());
                    claseMultilanguage.getMethod("setLanguageCode", cArgL).invoke(multilenguaje,
                            idiomaPorDefecto);
                }

                if (!esIdiomaPorDefecto) {
                    List<?> traduccionesList = (List<?>) objetoPrincipal.getClass()
                            .getMethod(nombreMetodoListaIdiomas).invoke(objetoPrincipal);
                    if (traduccionesList != null && !traduccionesList.isEmpty()) {
                        for (Object dfpsl : traduccionesList) {
                            Long codLanguage = Long.valueOf(dfpsl.getClass()
                                    .getMethod("getLangCoLanguage").invoke(dfpsl).toString());
                            if (codLanguage.equals(idiomaUsuario)) {
                                Object valorLang = dfpsl.getClass()
                                        .getMethod(nombreMetodoDescripcion).invoke(dfpsl);
                                if (valorLang != null && !"".equals(valorLang.toString())) {
                                    claseMultilanguage.getMethod("setLanguageCode", cArgL)
                                            .invoke(multilenguaje, codLanguage);
                                    claseMultilanguage.getMethod("setValue", cArgS)
                                            .invoke(multilenguaje, valorLang.toString());
                                    break;
                                }
                            }
                        }
                    }
                }

                Object valorNuevo = claseMultilanguage.getMethod("getValue").invoke(multilenguaje);
                if (valorNuevo != null && !"".equals(valorNuevo.toString())) {
                    listaMultilenguaje.add(multilenguaje);
                }
            }

            Object mlArray = Array.newInstance(claseMultilanguage, listaMultilenguaje.size());

            int i = 0;
            for (Object mul : listaMultilenguaje) {
                Array.set(mlArray, i, mul);
                i++;
            }

            Class[] cArgML = { mlArray.getClass() };
            mlListClass.getMethod("setMultiLanguages", cArgML).invoke(multiLanguageList, mlArray);
        } catch (InstantiationException | InvocationTargetException | IllegalAccessException | NoSuchMethodException e) {
            throw new TE_Excepcion("Error 9900-00009",
                        "Error al volcar los datos de multilenguaje", e);
        }
        
        LOGGER.debug("Fin de la llamada al método de utilidades creaMultiLanguageList",
                String.valueOf(new Date()), String.valueOf(new Date()));

        return multiLanguageList;
    }

    /**
     * @author MRROGAJM - Migrado MRGOMAAL
     * @descripcion Vuelca los datos de la paginación básica a los métadatos
     *              para indicar si hay más registros.
     */

    public static void metadatosPagBasica(TE_Metadatos teMetadatos, Long size) {
        LOGGER.debug("Inicio de la llamada al método de utilidades metadatosPagBasica",
                String.valueOf(new Date()), String.valueOf(new Date()));
        
        teMetadatos.getTE_Paginacion().setTE_PaginacionOUT(new TE_PaginacionOUT());
        // controlamos el caso de la primera página (0)
        if (teMetadatos.getTE_Paginacion().getTE_PaginacionIN().getNumeroPagina().equals(0L)) {
            teMetadatos.getTE_Paginacion().getTE_PaginacionOUT().setHayMas(
                    teMetadatos.getTE_Paginacion().getTE_PaginacionIN().getTamanoVentana() < size);
        } else {
            teMetadatos.getTE_Paginacion().getTE_PaginacionOUT()
                    .setHayMas(teMetadatos.getTE_Paginacion().getTE_PaginacionIN().getNumeroPagina()
                            * teMetadatos.getTE_Paginacion().getTE_PaginacionIN()
                                    .getTamanoVentana() < size);
        }
        
        LOGGER.debug("Fin de la llamada al método de utilidades metadatosPagBasica",
                String.valueOf(new Date()), String.valueOf(new Date()));
    }
    
    public static void metadatosPagCompleta(TE_Metadatos teMetadatos, Long size) {
        teMetadatos.getTE_Paginacion().setTE_PaginacionOUT(new TE_PaginacionOUT());
        // controlamos el caso de la primera página (0)
        if (teMetadatos.getTE_Paginacion().getTE_PaginacionIN().getNumeroPagina().equals(0L)) {
            teMetadatos.getTE_Paginacion().getTE_PaginacionOUT().setHayMas(
                    teMetadatos.getTE_Paginacion().getTE_PaginacionIN().getTamanoVentana() < size);
        } else {
            teMetadatos.getTE_Paginacion().getTE_PaginacionOUT()
                    .setHayMas(teMetadatos.getTE_Paginacion().getTE_PaginacionIN().getNumeroPagina()
                            * teMetadatos.getTE_Paginacion().getTE_PaginacionIN()
                                    .getTamanoVentana() < size);
        }

        teMetadatos.getTE_Paginacion().getTE_PaginacionOUT().setTotalElementos(size);
    }
    
    public static void metadatosPagBasica(TE_Metadatos teMetadatos, Long size, boolean hayMas) {
        if (teMetadatos.getTE_Paginacion() == null) {
            teMetadatos.setTE_Paginacion(new TE_Paginacion());
        }
        if (teMetadatos.getTE_Paginacion().getTE_PaginacionOUT() == null) {
            teMetadatos.getTE_Paginacion().setTE_PaginacionOUT(new TE_PaginacionOUT());
        }
        
        teMetadatos.getTE_Paginacion().getTE_PaginacionOUT().setHayMas(hayMas);
        teMetadatos.getTE_Paginacion().getTE_PaginacionOUT().setTotalElementos(size);
    }

    /**
     * Método que obtiene un mensaje del properties de mensaje, se le pasará un
     * idioma, para obtener el código de mensaje de acuerdo al idioma el código
     * del mensaje que queremos obtener y en el caso de que el mensaje tenga
     * valores dinámicos pasaremos una lista de String por el parámetro
     * arguments.
     * 
     * Por defecto obtendrá los mensajes del properties de español, pero si le
     * pasamos el parámetro de idioma, obtendrá el valor del fichero de
     * properties que coincida con dicho idioma
     * 
     * @param idioma
     * @param codigo
     * @param arguments
     * @return
     */
    public static String getMessagebyIdioma(String idioma, String codigo, String[] arguments) {
        LOGGER.debug("Inicio de la llamada al método de utilidades getMessagebyIdioma",
                String.valueOf(new Date()), String.valueOf(new Date()));

        String ficheIdioma = CANA_MSGS_PROPERTIES;
        for (Map.Entry<String, String> e : TE_Idioma.getTEIdioma().getListaIdiomas().entrySet()) {
            if (e.getValue() != null && e.getValue().equals(idioma)) {
                ficheIdioma = "messages_" + e.getKey().toUpperCase();
            }
        }

        if (arguments != null && arguments.length > 0) {
            return MessageFormat.format(ResourceBundle.getBundle(ficheIdioma).getString(codigo),
                    arguments);
        }

        LOGGER.debug("Fin de la llamada al método de utilidades getMessagebyIdioma",
                String.valueOf(new Date()), String.valueOf(new Date()));

        return ResourceBundle.getBundle(ficheIdioma).getString(codigo);
    }

    /**
     * Obtiene una uddi del fichero de propiedades según el código pasado por
     * parámetro
     * 
     * @param codUddi
     * @return
     */
    public static String getUddi(String codUddi) {
        LOGGER.debug("Inicio de la llamada al método de utilidades getUddi",
                String.valueOf(new Date()), String.valueOf(new Date()));
        return ResourceBundle.getBundle(CANA_UDDI_PROPERTIES).getString(codUddi);
    }

    /**
     * metodo encargado de crear un objeto de tipo metadatos para la llamada
     * a los servicios externos
     * 
     * @author MRROGAJM
     * @param criterioOrdenacion
     * @return
     */
    public static TE_Metadatos crearMetadatos(String critOrdenacion, Long numPagina,
            Long tamVentana) {
        LOGGER.debug("Inicio de la llamada al método de utilidades crearMetadatos");

        TE_Metadatos metadatos = new TE_Metadatos();
        // paginación
        metadatos.setTE_Paginacion(new TE_Paginacion());
        metadatos.getTE_Paginacion().setTE_PaginacionIN(new TE_PaginacionIN());
        metadatos.getTE_Paginacion().getTE_PaginacionIN().setNumeroPagina(numPagina);
        metadatos.getTE_Paginacion().getTE_PaginacionIN().setTamanoVentana(tamVentana);

        // ordenacion
        TE_Ordenacion te_Ordenacion = new TE_Ordenacion();
        te_Ordenacion.setCriterioOrdenacions(new String[] { critOrdenacion });
        metadatos.setTE_Ordenacion(te_Ordenacion);
        LOGGER.debug("Fin de la llamada al método de utilidades crearMetadatos");
        return metadatos;
    }

    @Override
    public String ficheroParaGestorDocumental(String pathGestorDocumental, String pathGestorDocumentalCana, String directorio,
            String nombre, byte[] contenido, TE_Cabecera teCabecera) throws TE_Excepcion {

        GestorDocumentalServiceImpl gestorDocumental = new GestorDocumentalServiceImpl(pathGestorDocumental, pathGestorDocumentalCana, directorio);
        return gestorDocumental.ficheroParaGestorDocumental(nombre, contenido, teCabecera);
    }
}