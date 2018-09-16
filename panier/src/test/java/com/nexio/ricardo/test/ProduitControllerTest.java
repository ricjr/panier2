package com.nexio.ricardo.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.nexio.ricardo.controller.ProduitController;

public class ProduitControllerTest extends TestApplicationTests{
	
	private MockMvc mockMvc;
	
	@Autowired
	private ProduitController produitController;
	
	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(produitController).build();
	}
	
	/**
	 * Teste la recherche du catalogue de produits
	 * @throws Exception
	 */
	@Test
	public void testCatalogueProduitController() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/api/produit/catalogue"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	/**
	 * Teste le détail d'un produit
	 * @throws Exception
	 */
	@Test
	public void testDetailProduitController() throws Exception {
		Long idProduit = 1L;
		this.mockMvc.perform(MockMvcRequestBuilders.get("/api/produit/detail/"+idProduit))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

}
