package com.telefonica.cana.srv.util.commonutilities.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.telefonica.cana.srv.util.commonutilities.msg.getlanguagesheader.GetLanguagesHeader_IN;
import com.telefonica.cana.srv.util.commonutilities.msg.getlanguagesheader.GetLanguagesHeader_OUT;
import com.telefonica.tran.comarq.cc.cabecera.TE_Cabecera;
import com.telefonica.tran.comarq.cc.error.TE_Excepcion;

/**
 * The Service interface for the entities
 */
public interface CommonUtilitiesService {

	GetLanguagesHeader_OUT getLanguagesHeader(@NotNull @Valid GetLanguagesHeader_IN in)
			throws TE_Excepcion;

	String getLanguagesHeader() throws TE_Excepcion;

    String ficheroParaGestorDocumental(String pathGestorDocumental, String pathGestorDocumentalCana, String directorio,
            String nombre, byte[] contenido, TE_Cabecera teCabecera) throws TE_Excepcion;
}