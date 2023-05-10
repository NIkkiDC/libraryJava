package com.library.demo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.library.demo.exception.InformationExistException;
import com.library.demo.model.Author;
import com.library.demo.repository.AuthorRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class AuthorControllerTest {

	@Autowired
	@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
	private MockMvc mockMvc;

	@Autowired
	@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
	private ObjectMapper objectMapper;

	@Mock
	private AuthorRepo authorRepo;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testCreateAuthor() throws Exception {
		// Arrange
		Author author = new Author(1L, "John Smith", "description");
		when(authorRepo.findByName(author.getName())).thenReturn(null);
		when(authorRepo.save(any(Author.class))).thenReturn(author);

		// Act
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/api/author/")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(author)))
				.andExpect(status().isOk())
				.andReturn();

		// Assert
		Author actualAuthor = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), Author.class);
		assertEquals(author, actualAuthor);
	}

	@Test
	void testCreateAuthorWithExistingName() throws Exception {
		// Arrange
		Author author = new Author(1L, "John Smith", "description");
		when(authorRepo.findByName(author.getName())).thenReturn(author);

		// Act and Assert
		mockMvc.perform(MockMvcRequestBuilders.post("/api/author/")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(author)))
				.andExpect(status().isConflict())
				.andExpect(result -> assertTrue(result.getResolvedException() instanceof InformationExistException))
				.andExpect(result -> assertEquals("Author with this name exist already", result.getResolvedException().getMessage()));
	}
	@Test
	void testGetAuthor() throws Exception {
		// Arrange
		Author author = new Author(1L, "John Smith", "description");
		when(authorRepo.findById(author.getId())).thenReturn(Optional.of(author));

		// Act
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/author/{authorId}/", author.getId()))
				.andExpect(status().isOk())
				.andReturn();

		// Assert
		Author actualAuthor = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), Author.class);
		assertEquals(author, actualAuthor);
	}
}
