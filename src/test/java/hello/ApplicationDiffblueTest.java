package hello;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import hello.model.Quote;
import hello.model.Value;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

class ApplicationDiffblueTest {
  /**
   * Test {@link Application#restTemplate(RestTemplateBuilder)}.
   *
   * <p>Method under test: {@link Application#restTemplate(RestTemplateBuilder)}
   */
  @Test
  @DisplayName("Test restTemplate(RestTemplateBuilder)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RestTemplate Application.restTemplate(RestTemplateBuilder)"})
  void testRestTemplate() {
    // Arrange
    Application application = new Application();

    RestTemplateBuilder builder = mock(RestTemplateBuilder.class);
    when(builder.build()).thenReturn(mock(RestTemplate.class));

    // Act
    application.restTemplate(builder);

    // Assert
    verify(builder).build();
  }

  /**
   * Test {@link Application#run(RestTemplate)} with {@code restTemplate}.
   *
   * <ul>
   *   <li>Given {@link Value} (default constructor) Id is one.
   *   <li>Then array of {@link String} with {@code Args}.
   * </ul>
   *
   * <p>Method under test: {@link Application#run(RestTemplate)}
   */
  @Test
  @DisplayName(
      "Test run(RestTemplate) with 'restTemplate'; given Value (default constructor) Id is one; then array of String with 'Args'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.springframework.boot.CommandLineRunner Application.run(RestTemplate)"})
  void testRunWithRestTemplate_givenValueIdIsOne_thenArrayOfStringWithArgs() throws Exception {
    // Arrange
    Application application = new Application();

    Value value = new Value();
    value.setId(1L);
    value.setQuote("Quote");

    Quote quote = new Quote();
    quote.setType("Type");
    quote.setValue(value);

    RestTemplate restTemplate = mock(RestTemplate.class);
    when(restTemplate.getForObject(Mockito.<String>any(), eq(Quote.class), isA(Object[].class)))
        .thenReturn(quote);
    String[] args = new String[] {"Args"};

    // Act
    application.run(restTemplate).run(args);

    // Assert that nothing has changed
    verify(restTemplate)
        .getForObject(
            eq("http://gturnquist-quoters.cfapps.io/api/random"),
            isA(Class.class),
            isA(Object[].class));
    assertArrayEquals(new String[] {"Args"}, args);
  }

  /**
   * Test {@link Application#run(RestTemplate)} with {@code restTemplate}.
   *
   * <ul>
   *   <li>When {@link RestTemplate}.
   *   <li>Then {@link Application} (default constructor) {@link Application#jdbcTemplate} is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link Application#run(RestTemplate)}
   */
  @Test
  @DisplayName(
      "Test run(RestTemplate) with 'restTemplate'; when RestTemplate; then Application (default constructor) jdbcTemplate is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.springframework.boot.CommandLineRunner Application.run(RestTemplate)"})
  void testRunWithRestTemplate_whenRestTemplate_thenApplicationJdbcTemplateIsNull()
      throws Exception {
    // Arrange
    Application application = new Application();

    // Act
    application.run(mock(RestTemplate.class));

    // Assert that nothing has changed
    assertNull(application.jdbcTemplate);
  }
}
