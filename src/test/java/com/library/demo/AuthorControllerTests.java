package com.library.demo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.library.demo.exception.InformationExistException;
import com.library.demo.model.Author;
import com.library.demo.repository.AuthorRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
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

	Author Info_1 = new Author(1L,"Author1", "description");
	Author Info_2 = new Author(2L,"Author2", "description");
	Author Info_3 = new Author(1L,"Author3", "description");
	Author Info_4 = new Author(2L,"Author4", "description");

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

	@Test
	void testGetAuthors() throws Exception {
		// Arrange
		List<Author> authors = new ArrayList<>();
		authors.add(new Author(1L, "John Smith", "description"));
		authors.add(new Author(2L, "Jane Doe", "description2"));
		when(authorRepo.findAll()).thenReturn(authors);
		// Act
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/author/"))

				.andExpect(status().isOk())
				.andReturn();
		// Assert
		List<Author> actualAuthors = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), objectMapper.getTypeFactory().constructCollectionType(List.class, Author.class));
		assertEquals(authors, actualAuthors);
	}

	@Test
	void updateAuthorSuccessTest() throws Exception {
		Long authorId = 1L;
		String authorName = "John Doe";
		String authorDescription = "Test description";
		Author author = new Author(authorId, authorName, authorDescription);
		String requestBody = "{\"name\":\"" + authorName + "\",\"description\":\"" + authorDescription + "\"}";
		when(authorRepo.findById(authorId)).thenReturn(Optional.of(author));
		when(author.getName()).thenReturn(authorName);
		when(authorRepo.save(any(Author.class))).thenReturn(author);
		mockMvc.perform(MockMvcRequestBuilders.put("/api/author/{authorId}/", authorId)
						.contentType(MediaType.APPLICATION_JSON)
						.content(requestBody))
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.name").value(authorName))
				.andExpect(MockMvcResultMatchers.jsonPath("$.description").value(authorDescription));
	}

	@Test
	void updateAuthorInformationExistExceptionTest() throws Exception {
		Long authorId = 1L;
		String authorName = "John Doe";
		String authorDescription = "Test description";
		Author author = new Author(authorId, authorName, authorDescription);

		String requestBody = "{\"name\":\"" + authorName + "\",\"description\":\"" + authorDescription + "\"}";

		when(authorRepo.findById(authorId)).thenReturn(Optional.of(author));
		when(author.getName()).thenReturn(authorName);

		Exception exception = mockMvc.perform(MockMvcRequestBuilders.put("/api/author/{authorId}/", authorId)
						.contentType(MediaType.APPLICATION_JSON)
						.content(requestBody))
				.andExpect(status().isConflict())
				.andReturn().getResolvedException();

		assert (exception instanceof InformationExistException);
		assert (exception.getMessage().equals("Author " + authorName + "already exists."));
	}

	@Test
	void updateAuthorNotFoundExceptionTest() throws Exception {
		Long authorId = 1L;
		String authorName = "John Doe";
		String authorDescription = "Test description";


		String requestBody = "{\"name\":\"" + authorName + "\",\"description\":\"" + authorDescription + "\"}";

		when(authorRepo.findById(authorId)).thenReturn(Optional.empty());

		Exception exception = mockMvc.perform(MockMvcRequestBuilders.put("/api/author/{authorId}/", authorId)
						.contentType(MediaType.APPLICATION_JSON)
						.content(requestBody))
				.andExpect(status().isNotFound())
				.andReturn().getResolvedException();

		assert (exception instanceof InformationExistException);
		assert (exception.getMessage().equals("Author with id " + authorId + " not found"));
	}


	@Test
	void deleteAuthor_notFound() throws Exception {
		Long authorId = 1L;

		when(authorRepo.findById(anyLong())).thenReturn(Optional.empty());

		mockMvc.perform(MockMvcRequestBuilders.delete("/api/author/{authorId}", authorId)
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isNotFound())
				.andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Author with id " + authorId + " not found"));
		verify(authorRepo, never()).delete(any(Author.class));
	}

	@Test
	void deleteAuthor_informationExistException() throws Exception {
		Long authorId = 1L;
		Author authorToDelete = new Author();
		authorToDelete.setId(authorId);

		when(authorRepo.findById(authorId)).thenReturn(Optional.of(authorToDelete));
		doThrow(InformationExistException.class).when(authorRepo).delete(authorToDelete);

		mockMvc.perform(MockMvcRequestBuilders.delete("/api/author/{authorId}", authorId)
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isBadRequest())
				.andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Author with id " + authorId + " cannot be deleted"));

		verify(authorRepo, times(1)).delete(authorToDelete);
	}
}