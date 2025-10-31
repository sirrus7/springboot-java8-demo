package hello.controller;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.json.JsonMapper;
import hello.model.Topic;
import hello.service.TopicService;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringJUnitConfig(classes = {TopicController.class})
class TopicControllerDiffblueTest {
  @Autowired private TopicController topicController;

  @MockBean private TopicService topicService;

  /**
   * Test {@link TopicController#getAllTopics()}.
   *
   * <p>Method under test: {@link TopicController#getAllTopics()}
   */
  @Test
  @DisplayName("Test getAllTopics()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List TopicController.getAllTopics()"})
  void testGetAllTopics() throws Exception {
    // Arrange
    when(topicService.getAllTopics()).thenReturn(new ArrayList<>());

    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/topic");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(topicController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(content().string("[]"));
  }

  /**
   * Test {@link TopicController#getTopicWithID(String)}.
   *
   * <p>Method under test: {@link TopicController#getTopicWithID(String)}
   */
  @Test
  @DisplayName("Test getTopicWithID(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Topic TopicController.getTopicWithID(String)"})
  void testGetTopicWithID() throws Exception {
    // Arrange
    Topic topic =
        new Topic("42", "Hello from the Dreaming Spires", "Hello from the Dreaming Spires");
    when(topicService.getTopicWithId(Mockito.<String>any())).thenReturn(topic);

    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/topic/{id}", "42");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(topicController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(
            content()
                .string(
                    "{\"id\":\"42\",\"subjectName\":\"Hello from the Dreaming Spires\",\"subjectDescription\":\"Hello from the Dreaming"
                        + " Spires\"}"));
  }

  /**
   * Test {@link TopicController#addTopic(Topic)}.
   *
   * <p>Method under test: {@link TopicController#addTopic(Topic)}
   */
  @Test
  @DisplayName("Test addTopic(Topic)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TopicController.addTopic(Topic)"})
  void testAddTopic() throws Exception {
    // Arrange
    doNothing().when(topicService).addTopic(Mockito.<Topic>any());

    Topic topic = new Topic();
    topic.setId("42");
    topic.setSubjectDescription("Hello from the Dreaming Spires");
    topic.setSubjectName("Hello from the Dreaming Spires");

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.post("/topic")
            .contentType(MediaType.APPLICATION_JSON)
            .content(JsonMapper.builder().findAndAddModules().build().writeValueAsString(topic));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(topicController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk());
  }

  /**
   * Test {@link TopicController#updateTopic(String, Topic)}.
   *
   * <p>Method under test: {@link TopicController#updateTopic(String, Topic)}
   */
  @Test
  @DisplayName("Test updateTopic(String, Topic)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TopicController.updateTopic(String, Topic)"})
  void testUpdateTopic() throws Exception {
    // Arrange
    doNothing().when(topicService).updateTopic(Mockito.<String>any(), Mockito.<Topic>any());

    Topic topic = new Topic();
    topic.setId("42");
    topic.setSubjectDescription("Hello from the Dreaming Spires");
    topic.setSubjectName("Hello from the Dreaming Spires");

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.put("/topic/{id}", "42")
            .contentType(MediaType.APPLICATION_JSON)
            .content(JsonMapper.builder().findAndAddModules().build().writeValueAsString(topic));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(topicController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk());
  }

  /**
   * Test {@link TopicController#deleteTopic(String)}.
   *
   * <p>Method under test: {@link TopicController#deleteTopic(String)}
   */
  @Test
  @DisplayName("Test deleteTopic(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TopicController.deleteTopic(String)"})
  void testDeleteTopic() throws Exception {
    // Arrange
    doNothing().when(topicService).deleteTopic(Mockito.<String>any());

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.delete("/topic/{id}", "42");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(topicController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk());
  }

  /**
   * Test {@link TopicController#filterMinimumLengthForId(Integer)}.
   *
   * <p>Method under test: {@link TopicController#filterMinimumLengthForId(Integer)}
   */
  @Test
  @DisplayName("Test filterMinimumLengthForId(Integer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List TopicController.filterMinimumLengthForId(Integer)"})
  void testFilterMinimumLengthForId() throws Exception {
    // Arrange
    when(topicService.filterMinimumLengthForId(Mockito.<Integer>any()))
        .thenReturn(new ArrayList<>());

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/topic/minimum/length/{minLength}", 3);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(topicController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(content().string("[]"));
  }

  /**
   * Test {@link TopicController#sortTopicsWithID()}.
   *
   * <p>Method under test: {@link TopicController#sortTopicsWithID()}
   */
  @Test
  @DisplayName("Test sortTopicsWithID()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List TopicController.sortTopicsWithID()"})
  void testSortTopicsWithID() throws Exception {
    // Arrange
    when(topicService.sortTopicsWithID()).thenReturn(new ArrayList<>());

    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/topic/sort");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(topicController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(content().string("[]"));
  }
}
