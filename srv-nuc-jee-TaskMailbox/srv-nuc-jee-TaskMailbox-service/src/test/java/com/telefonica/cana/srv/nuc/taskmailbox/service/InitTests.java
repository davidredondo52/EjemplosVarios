package com.telefonica.cana.srv.nuc.taskmailbox.service;

import java.net.URL;

import org.junit.BeforeClass;
import org.junit.Ignore;

import com.telefonica.tran.comarq.cc.idioma.TE_Idioma;
@Ignore
public class InitTests {
	
	@BeforeClass
    public static void setUpBaseClass() {
        
        URL uri = ClassLoader.getSystemClassLoader().getResource("idioma/idiomas.properties");
        if (uri != null) {
        	String ruta = uri.getFile();
        	ruta = ruta.substring(0, ruta.indexOf("/idiomas.properties"));
        	System.setProperty("ruta.idioma", ruta);
        	TE_Idioma.getTEIdioma();
        }
    }

}
