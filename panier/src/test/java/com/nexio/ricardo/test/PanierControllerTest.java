package com.nexio.ricardo.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nexio.ricardo.controller.PanierController;
import com.nexio.ricardo.model.PanierItem;
import com.nexio.ricardo.model.ProduitItem;
import com.nexio.ricardo.service.PanierService;

public class PanierControllerTest extends TestApplicationTests{
	
	private MockMvc mockMvc;
	
	@Autowired
	private PanierController panierController;
	
	
	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(panierController).build();
	}
	
	/**
	 * teste la présentation du contenu du panier
	 * @throws Exception
	 */
	@Test
	public void testAfficherContenuPanierController() throws Exception {
		
		this.mockMvc.perform(MockMvcRequestBuilders.get("/api/panier/afficher-contenu"))
				.andExpect(MockMvcResultMatchers.status().isOk());

	}
	
	/**
	 * Teste Ajouter le produit au panier
	 * @param item
	 * @return
	 */
	@Test
	public void testAjouterProduitPanierController() throws Exception {
		
		ProduitItem produitItem = new ProduitItem(1L, 2);
		String jsonProduitItem  = new ObjectMapper().writeValueAsString(produitItem);

		final MockHttpSession mockHttpSession = new MockHttpSession();
		
		this.mockMvc.perform(MockMvcRequestBuilders.post("/api/panier/ajouter-produit").contentType(MediaType.APPLICATION_JSON).content(jsonProduitItem).session(mockHttpSession))
				.andExpect(MockMvcResultMatchers.status().isOk());
		
		@SuppressWarnings("unchecked")
		PanierItem panierItem = ((List<PanierItem>)mockHttpSession.getAttribute(PanierService.PANIER_UTILISATEUR)).get(0);
		
		Assert.assertEquals("Le produit ajouté n'a pas été trouvé dans la session!", produitItem.getIdProduit(), panierItem.getProduit().getId());

	}
	
	/**
	 * Teste Ajouter e aprés enlever le produit au panier
	 * @param item
	 * @return
	 */
	@Test
	public void testEnleverProduitPanierController() throws Exception {
		
		ProduitItem produitItem = new ProduitItem(1L, 2);
		String jsonProduitItem  = new ObjectMapper().writeValueAsString(produitItem);

		final MockHttpSession mockHttpSession = new MockHttpSession();
		
		this.mockMvc.perform(MockMvcRequestBuilders.post("/api/panier/ajouter-produit").contentType(MediaType.APPLICATION_JSON).content(jsonProduitItem).session(mockHttpSession))
				.andExpect(MockMvcResultMatchers.status().isOk());
		
		@SuppressWarnings("unchecked")
		PanierItem panierItem = ((List<PanierItem>)mockHttpSession.getAttribute(PanierService.PANIER_UTILISATEUR)).get(0);
		
		Assert.assertEquals("Le produit ajouté n'a pas été trouvé dans la session!", produitItem.getIdProduit(), panierItem.getProduit().getId());
		
		this.mockMvc.perform(MockMvcRequestBuilders.delete("/api/panier/enlever-produit").contentType(MediaType.APPLICATION_JSON).content(jsonProduitItem).session(mockHttpSession))
		.andExpect(MockMvcResultMatchers.status().isOk());
		
		
		@SuppressWarnings("unchecked")
		List<PanierItem> listeProduit = (List<PanierItem>) mockHttpSession.getAttribute(PanierService.PANIER_UTILISATEUR);
		
		Assert.assertEquals("Le produit enlever n'a pas été trouvé dans la session!", listeProduit.size(), 0);

	}
	
	

}
