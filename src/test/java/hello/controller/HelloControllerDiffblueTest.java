package hello.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import hello.service.TopicService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringJUnitConfig(classes = {HelloController.class})
class HelloControllerDiffblueTest {
  @Autowired private HelloController helloController;

  @MockBean private TopicService topicService;

  /**
   * Test {@link HelloController#showStringOperation()}.
   *
   * <p>Method under test: {@link HelloController#showStringOperation()}
   */
  @Test
  @DisplayName("Test showStringOperation()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String HelloController.showStringOperation()"})
  void testShowStringOperation() throws Exception {
    // Arrange
    when(topicService.findIdHavingCharacter()).thenReturn("Id Having Character");
    when(topicService.makeDistinctAndSortCharacters(Mockito.<String>any()))
        .thenReturn("Make Distinct And Sort Characters");
    when(topicService.returnAllTopicIDWithStringSlicing())
        .thenReturn("Return All Topic IDWith String Slicing");
    when(topicService.splitAllIdWithColonSelectIDWithJavaKeywordThenSortThenJoin(
            Mockito.<String>any()))
        .thenReturn("Split All Id With Colon Select IDWith Java Keyword Then Sort Then Join");

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/topic/string/operation");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(helloController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("text/plain;charset=ISO-8859-1"))
        .andExpect(
            content()
                .string(
                    "Joining All String ID's with JOIN method: Return All Topic IDWith String Slicing-------------Get all"
                        + " ID characters, select distict and sort with ID=   Make Distinct And Sort Characters-------------Split"
                        + " All Id With Colon,Select ID With \"Java\" Keyword, Then Sort Then Join Split All Id With Colon Select"
                        + " IDWith Java Keyword Then Sort Then Join-------------Return All ID having character 'g' in it:  Id"
                        + " Having Character"));
  }

  /**
   * Test {@link HelloController#showFileOperation()}.
   *
   * <p>Method under test: {@link HelloController#showFileOperation()}
   */
  @Test
  @DisplayName("Test showFileOperation()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String HelloController.showFileOperation()"})
  void testShowFileOperation() throws Exception {
    // Arrange
    when(topicService.findAllFilesInPathAndSort()).thenReturn("All Files In Path And Sort");
    when(topicService.findParticularFileInPathAndSort())
        .thenReturn("Particular File In Path And Sort");
    when(topicService.findParticularFileInPathAndSortWithWalkFunction())
        .thenReturn("Particular File In Path And Sort With Walk Function");
    when(topicService.readFileWithStreamFunction()).thenReturn("File With Stream Function");

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/topic/file/operation");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(helloController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("text/plain;charset=ISO-8859-1"))
        .andExpect(
            content()
                .string(
                    "---------Find all files in path and sort:    All Files In Path And Sort----------Find File in present"
                        + " directory which strats with \"grad\",provided maximum depth=25 and sort : Particular File In Path And"
                        + " Sort----------Find File in present directory which strats with \"grad\",provided maximum depth=25 and"
                        + " sort :  with walk functionParticular File In Path And Sort With Walk Function---------Read \"temp.txt\""
                        + " file with stream functions, having \"print\" witin it:  File With Stream Function"));
  }
}
