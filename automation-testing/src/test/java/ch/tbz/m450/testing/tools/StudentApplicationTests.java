package ch.tbz.m450.testing.tools;

import ch.tbz.m450.testing.tools.controller.StudentController;
import ch.tbz.m450.testing.tools.repository.StudentRepository;
import ch.tbz.m450.testing.tools.repository.entities.Student;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(StudentController.class) // Nur den Controller testen
class StudentControllerTest {

	@Autowired
	private MockMvc mockMvc; // Simuliert HTTP-Anfragen

	@MockBean
	private StudentRepository studentRepository; // Mock des Repositories

	@Test
	void testGetStudents() throws Exception {
		// Beispiel-Daten mocken
		Student student1 = new Student("TestUser1", "test1@tbz.ch");
		Student student2 = new Student("TestUser2", "test2@tbz.ch");

		when(studentRepository.findAll()).thenReturn(Arrays.asList(student1, student2));

		// Test: GET /students
		mockMvc.perform(get("/students")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[0].name").value("TestUser1"))
				.andExpect(jsonPath("$[0].email").value("test1@tbz.ch"))
				.andExpect(jsonPath("$[1].name").value("TestUser2"))
				.andExpect(jsonPath("$[1].email").value("test2@tbz.ch"));

		verify(studentRepository, times(1)).findAll();
	}

	@Test
	void testAddStudent() throws Exception {
		// JSON-String des neuen Studenten
		String newStudentJson = """
            {
                "name": "NewUser",
                "email": "newuser@tbz.ch"
            }
        """;

		// Test: POST /students
		mockMvc.perform(post("/students")
						.contentType(MediaType.APPLICATION_JSON)
						.content(newStudentJson))
				.andExpect(status().isOk());

		// Verifiziere, dass das Repository `save` aufgerufen wurde
		verify(studentRepository, times(1)).save(Mockito.any(Student.class));
	}
}


