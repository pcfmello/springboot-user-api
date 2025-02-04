package br.com.criandowebsites.springboot_user_api.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import br.com.criandowebsites.springboot_user_api.service.UserService;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {
	
	private MockMvc mockMvc;
	
	@Mock
	private UserService userService;
	
	@InjectMocks
	private UserController userController;
	
	@BeforeEach
	void setup() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
	}
	
	@Test
	void shouldReturnIsCreatedStatusWhenUserDataIsValid() throws Exception {
		String userData = """
				
				{
					"name": "Paulo Cesar Mello",
					"email": "pcfmello@gmail.com"
				}
				
		""";
		
		mockMvc.perform(post("/users")
				.contentType(MediaType.APPLICATION_JSON)
				.content(userData))
				.andExpect(status().isCreated());
	}
	
	@Test
	void shouldReturnBadRequestWhenUserDataIsInvalid() throws Exception {
		String invalidUserData = """
				
				{
					"name": "",
					"email": "pcfmello@gmail.com"
				}
				
		""";
		
		mockMvc.perform(post("/users")
				.contentType(MediaType.APPLICATION_JSON)
				.content(invalidUserData))
				.andExpect(status().isBadRequest());
	}
	
	
}
