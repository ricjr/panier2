package com.nexio.ricardo.test;

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
import com.nexio.ricardo.controller.UtilisateurController;
import com.nexio.ricardo.model.entity.Utilisateur;
import com.nexio.ricardo.service.UtilisateurService;


public class UtilisateurControllerTest extends TestApplicationTests{
	
	private MockMvc mockMvc;
	
	@Autowired
	private UtilisateurController utilisateurController;
	
	
	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(utilisateurController).build();
	}
	
	/**
	 * Testez une connexion avec un compte d'utilisateur.
	 * @throws Exception
	 */
	@Test
	public void testConnecterUtilisateurController() throws Exception {
		
		String jsonUtilisateur  = new ObjectMapper().writeValueAsString(new Utilisateur("ricardo", "123456"));

		final MockHttpSession mockHttpSession = new MockHttpSession();
		
		this.mockMvc.perform(MockMvcRequestBuilders.post("/api/utilisateur/connecter").contentType(MediaType.APPLICATION_JSON).content(jsonUtilisateur).session(mockHttpSession))
				.andExpect(MockMvcResultMatchers.status().isOk());
		
		Assert.assertNotNull("Session utilisateur non créée!", mockHttpSession.getAttribute(UtilisateurService.UTILISATEUR));
		
		
	}
	
	/**
	 * Testez une connexion, puis déconnectez un compte d'utilisateur.
	 * @throws Exception
	 */
	@Test
	public void testDeconnecterUtilisateurController() throws Exception {
		
		String jsonUtilisateur  = new ObjectMapper().writeValueAsString(new Utilisateur("ricardo", "123456"));

		final MockHttpSession mockHttpSession = new MockHttpSession();
		
		this.mockMvc.perform(MockMvcRequestBuilders.post("/api/utilisateur/connecter").contentType(MediaType.APPLICATION_JSON).content(jsonUtilisateur).session(mockHttpSession))
				.andExpect(MockMvcResultMatchers.status().isOk());
		
		Assert.assertNotNull("Session utilisateur non créée!", mockHttpSession.getAttribute(UtilisateurService.UTILISATEUR));
		
		this.mockMvc.perform(MockMvcRequestBuilders.post("/api/utilisateur/deconnecter").session(mockHttpSession))
				.andExpect(MockMvcResultMatchers.status().isOk());
		
		Assert.assertNull("Session utilisateur non déconnecté!", mockHttpSession.getAttribute(UtilisateurService.UTILISATEUR));
	}

}
