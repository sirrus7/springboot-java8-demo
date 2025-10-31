package hello.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(MockitoExtension.class)
class GreetingControllerDiffblueTest {
  @InjectMocks private GreetingController greetingController;

  /**
   * Test {@link GreetingController#greeting(String)}.
   *
   * <p>Method under test: {@link GreetingController#greeting(String)}
   */
  @Test
  @DisplayName("Test greeting(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"hello.model.Greeting GreetingController.greeting(String)"})
  void testGreeting() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/").param("name", "foo");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(greetingController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(content().string("{\"id\":1,\"content\":\"Hello, foo!\"}"));
  }
}
