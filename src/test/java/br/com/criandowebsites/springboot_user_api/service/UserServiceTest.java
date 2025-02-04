package br.com.criandowebsites.springboot_user_api.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import br.com.criandowebsites.springboot_user_api.dto.UserDTO;
import br.com.criandowebsites.springboot_user_api.model.User;
import br.com.criandowebsites.springboot_user_api.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
	
	@Mock
	private UserRepository userRepository;
	
	@InjectMocks
	private UserService userService;
	
	@BeforeEach
	void setup() {
//		userService = new UserService(userRepository);
	}
	
	@Test
	void shouldCreateUserSuccessfully() {
		UserDTO userDTO = new UserDTO("Paulo Cesar Mello", "pcfmello@gmail.com");
		
		User user = new User();
		user.setName(userDTO.name());
		user.setEmail(userDTO.email());
		
		when(userRepository.save(any(User.class))).thenReturn(user);
		
		User createdUser = userService.createUser(userDTO);
		
		assertNotNull(createdUser);
		assertEquals(user.getName(), createdUser.getName());
		assertEquals(user.getEmail(), createdUser.getEmail());
	}
	
	@Test
	void shouldReturnAllUsers() {
		User user1 = new User();
		user1.setName("Paulo Cesar Mello");
		user1.setEmail("pcfmello@gmail.com");
		
		User user2 = new User();
		user2.setName("Camila de Oliveira");
		user2.setEmail("camilaoliveira@gmail.com");
		
		when(userRepository.findAll()).thenReturn(List.of(user1, user2));
				
		List<User> users = userService.getAllUsers();
		
		assertNotNull(users);
		assertEquals(2, users.size());
		assertEquals(user1.getName(), users.get(0).getName());
		assertEquals(user2.getName(), users.get(1).getName());
	}

}
