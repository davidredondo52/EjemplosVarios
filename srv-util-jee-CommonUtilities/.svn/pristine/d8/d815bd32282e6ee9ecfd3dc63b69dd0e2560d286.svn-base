package com.telefonica.cana.srv.util.commonutilities.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.MissingResourceException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.telefonica.cana.srv.util.commonutilities.msg.getlanguagesheader.GetLanguagesHeader_IN;
import com.telefonica.cana.srv.util.commonutilities.msg.getlanguagesheader.GetLanguagesHeader_OUT;
import com.telefonica.cana.srv.util.commonutilities.service.impl.CommonUtilitiesServiceImpl;
import com.telefonica.tran.comarq.cc.cabecera.TE_Cabecera;
import com.telefonica.tran.comarq.cc.cabecera.TE_GestionCabecera;
import com.telefonica.tran.comarq.cc.error.TE_Excepcion;
import com.telefonica.tran.comarq.cc.metadatos.TE_Metadatos;
import com.telefonica.tran.comarq.cc.metadatos.TE_Ordenacion;
import com.telefonica.tran.comarq.cc.metadatos.TE_Paginacion;
import com.telefonica.tran.comarq.cc.metadatos.TE_PaginacionIN;

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:META-INF/spring/srv-util-jee-CommonUtilities-test-context.xml")
public class CommonUtilitiesServiceTest {

	@Autowired
	private CommonUtilitiesService commonutilitiesService;

	@Before
	public void setUp() {
	}
	/*
	@Test
	public void testGetLanguagesHeader() throws TE_Excepcion {
	    GetLanguagesHeader_OUT o = commonutilitiesService.getLanguagesHeader(new GetLanguagesHeader_IN());
		assertThat(o).isNotNull();
		assertThat(o.getIdiomasLength() == 0);
		assertThat(o.getIdiomas()).isNotNull();
		o.setIdiomas(new Long[]{1L,2L});
		assertThat(o.getIdiomasLength() == 2);
        assertThat(o.getIdiomas()).isNotNull();
        assertThat(o.getIdiomas(0)).isNotNull();
        assertThat(o.getIdiomas(0)).isEqualTo(1L);
        o.setIdiomas(0, 3L);
        assertThat(o.getIdiomas(0)).isEqualTo(3L);
		
		assertThat(commonutilitiesService.getLanguagesHeader()).isEqualTo("1");
		
	}*/
	
	@Test
    public void testmetadatosPagBasica() {
	    TE_Metadatos teMetadatos = new TE_Metadatos();

        TE_Ordenacion teOrdenacion = new TE_Ordenacion();
        TE_Paginacion te_paginacion = new TE_Paginacion();
        TE_PaginacionIN te_PaginacionIN = new TE_PaginacionIN();
        te_PaginacionIN.setNumeroPagina(0L);
        te_PaginacionIN.setTamanoVentana(150L);
        teMetadatos.setTE_Paginacion(te_paginacion);
        teMetadatos.getTE_Paginacion().setTE_PaginacionIN(te_PaginacionIN);
        teMetadatos.setTE_Ordenacion(teOrdenacion);
	    
        te_PaginacionIN.setNumeroPagina(0L);
        CommonUtilitiesServiceImpl.metadatosPagBasica(teMetadatos, 100L);
        assertThat(teMetadatos.getTE_Paginacion().getTE_PaginacionOUT()).isNotNull();
        assertThat(teMetadatos.getTE_Paginacion().getTE_PaginacionOUT().isHayMas()).isEqualTo(false);
        te_PaginacionIN.setNumeroPagina(1L);
        CommonUtilitiesServiceImpl.metadatosPagBasica(teMetadatos, 100L);
        assertThat(teMetadatos.getTE_Paginacion().getTE_PaginacionOUT()).isNotNull();
        assertThat(teMetadatos.getTE_Paginacion().getTE_PaginacionOUT().isHayMas()).isEqualTo(false);
        
        te_PaginacionIN.setNumeroPagina(0L);
        CommonUtilitiesServiceImpl.metadatosPagCompleta(teMetadatos, 100L);
        assertThat(teMetadatos.getTE_Paginacion().getTE_PaginacionOUT()).isNotNull();
        assertThat(teMetadatos.getTE_Paginacion().getTE_PaginacionOUT().isHayMas()).isEqualTo(false);
        te_PaginacionIN.setNumeroPagina(1L);
        CommonUtilitiesServiceImpl.metadatosPagCompleta(teMetadatos, 100L);
        assertThat(teMetadatos.getTE_Paginacion().getTE_PaginacionOUT()).isNotNull();
        assertThat(teMetadatos.getTE_Paginacion().getTE_PaginacionOUT().isHayMas()).isEqualTo(false);
        
        CommonUtilitiesServiceImpl.metadatosPagBasica(teMetadatos, 100L, false);
        assertThat(teMetadatos.getTE_Paginacion().getTE_PaginacionOUT()).isNotNull();
        assertThat(teMetadatos.getTE_Paginacion().getTE_PaginacionOUT().isHayMas()).isEqualTo(false);
        
        CommonUtilitiesServiceImpl.metadatosPagBasica(teMetadatos, 0l, false);
        assertThat(teMetadatos.getTE_Paginacion().getTE_PaginacionOUT()).isNotNull();
        assertThat(teMetadatos.getTE_Paginacion().getTE_PaginacionOUT().isHayMas()).isEqualTo(false);
        
        teMetadatos.getTE_Paginacion().setTE_PaginacionOUT(null);
        CommonUtilitiesServiceImpl.metadatosPagBasica(teMetadatos, 100L, false);
        assertThat(teMetadatos.getTE_Paginacion().getTE_PaginacionOUT()).isNotNull();
        assertThat(teMetadatos.getTE_Paginacion().getTE_PaginacionOUT().isHayMas()).isEqualTo(false);
        
        teMetadatos.setTE_Paginacion(null);
        CommonUtilitiesServiceImpl.metadatosPagBasica(teMetadatos, 100L, false);
        assertThat(teMetadatos.getTE_Paginacion().getTE_PaginacionOUT()).isNotNull();
        assertThat(teMetadatos.getTE_Paginacion().getTE_PaginacionOUT().isHayMas()).isEqualTo(false);
	    
	}
	/*
	@Test
    public void testgetMessagebyIdioma() {
	    String s = CommonUtilitiesServiceImpl.getMessagebyIdioma("1","CANA_E_000124_MSG", null);
	    assertThat(s).isNotNull();
	    String s1 = CommonUtilitiesServiceImpl.getMessagebyIdioma("1","CANA_E_000131_MSG", new String[]{"--"});
	    assertThat(s1).isNotNull();
	}*/
	
	@Test(expected = MissingResourceException.class)
    public void testgetUddi() {
	    CommonUtilitiesServiceImpl.getUddi("--");
	}
	
	@Test
    public void testcreaMultiLanguageList() throws TE_Excepcion {
	    MyMultiLanguageListClass.MyMultiLanguageClass obj = new MyMultiLanguageListClass.MyMultiLanguageClass(1L);
	    MyMultiLanguageListClass m = CommonUtilitiesServiceImpl.creaMultiLanguageList(MyMultiLanguageListClass.class, false, 1L, 1L, obj, "getDesc", "getLista");
	    assertThat(m).isNotNull();
	    m = CommonUtilitiesServiceImpl.creaMultiLanguageList(MyMultiLanguageListClass.class, true, 1L, 1L, obj, "getDesc", "getLista");
        assertThat(m).isNotNull();
        m = CommonUtilitiesServiceImpl.creaMultiLanguageList(MyMultiLanguageListClass.class, false, 1L, 2L, obj, "getDesc", "getLista");
        assertThat(m).isNotNull();
        m = CommonUtilitiesServiceImpl.creaMultiLanguageList(MyMultiLanguageListClass.class, true, 1L, 2L, obj, "getDesc", "getLista");
        assertThat(m).isNotNull();
	}
	
	public static class MyMultiLanguageListClass {
	    public static class MyMultiLanguageClass {
	        private Long ll;
	        public MyMultiLanguageClass() { this.ll = 1L; }
	        public MyMultiLanguageClass(Long l) { this.ll = l; }
	        public String getDesc() { return "--"; }
	        public void setValue(String v) {}
	        public void setLanguageCode(Long l) {}
	        public String getValue() { return "--"; }
            public Long getLanguageCode() { return ll; }
            public Long getLangCoLanguage() { return ll; }
	        public List<MyMultiLanguageClass> getLista() { return Arrays.asList(new MyMultiLanguageClass(1L), new MyMultiLanguageClass(2L)); }
	    }
	    
	    public MyMultiLanguageClass[] getMultiLanguages() { return new MyMultiLanguageClass[]{new MyMultiLanguageClass(1L), new MyMultiLanguageClass(2L)}; }
	    public void setMultiLanguages(MyMultiLanguageClass[] o) { }
	}
	
	@Test
	public void testCrearMetadatos() {
	    CommonUtilitiesServiceImpl.crearMetadatos("", 0l, 150l);
	}

	@Test
    public void testgestordocumental() throws TE_Excepcion, URISyntaxException {
	    TE_Cabecera teCabecera = TE_GestionCabecera.crearNuevaCabecera("RangeOfPinsServicio", "AD_ManageRangeOfPins");

        teCabecera.setDominioOrigen("1");
        teCabecera.setFechaPeticion(new Date());
        teCabecera.setIdGeneral("1");
        teCabecera.setIdGrupo("1");
        teCabecera.setIdMensaje("1");
        teCabecera.setIdOrigen("1");
        teCabecera.setIdProceso("1");
        teCabecera.setIdUsuario("1");
        teCabecera.setLenguaje("1");
        teCabecera.setOperacion("1");
        teCabecera.setUriOrigen("1");
        File f = new File(Thread.currentThread().getContextClassLoader().getResource("module.properties").toURI());
//        commonutilitiesService;
//        assertThat(commonutilitiesService.getPathGestorDocumental()).isNotNull();
//        assertThat(commonutilitiesService.getPathGestorDocumentalCana()).isNotNull();
//        assertThat(commonutilitiesService.getError()).isNull();
        
//        try {
//            commonutilitiesService.ficheroDesdeGestorDocumental("-", teCabecera);
//            //assertThat(true).isEqualTo(false);
//        } catch(TE_Excepcion e) {
//            assertThat(e).isNotNull();
//        }
        
//        try {
//            commonutilitiesService.ficheroParaGestorDocumental("n", "..".getBytes(), teCabecera);
//            //assertThat(true).isEqualTo(false);
//        } catch(TE_Excepcion e) {
//            assertThat(e).isNotNull();
//        }
        
        System.setProperty("telco3.properties", f.getParent());
        
//        try {
//	        commonutilitiesService.ficheroDesdeGestorDocumental("-", teCabecera);
//	       //assertThat(true).isEqualTo(false);
//        } catch(TE_Excepcion e) {
//            assertThat(e).isNotNull();
//        }
        
//        try {
//            commonutilitiesService.ficheroParaGestorDocumental("n", "..".getBytes(), teCabecera);
//            //assertThat(true).isEqualTo(false);
//        } catch(TE_Excepcion e) {
//            assertThat(e).isNotNull();
//        }
        
//        try {
//            commonutilitiesService.ficheroParaGestorDocumental("n", "..".getBytes(), teCabecera);
//            //assertThat(true).isEqualTo(false);
//        } catch(TE_Excepcion e) {
//            assertThat(e).isNotNull();
//        }
        
        //assertThat(commonutilitiesService.getError()).isNull();
        //commonutilitiesService.borrarFicheroRelativo("n");
        
//        assertThat(commonutilitiesService.getPathGestorDocumental()).isNotNull();
        //assertThat(commonutilitiesService.getPathGestorDocumentalCana()).isNotNull();
	}
}