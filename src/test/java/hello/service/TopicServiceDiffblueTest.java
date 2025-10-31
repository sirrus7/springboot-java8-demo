package hello.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import hello.model.Topic;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(classes = {TopicService.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
class TopicServiceDiffblueTest {
  @Autowired private TopicService topicService;

  /**
   * Test {@link TopicService#getAllTopics()}.
   *
   * <p>Method under test: {@link TopicService#getAllTopics()}
   */
  @Test
  @DisplayName("Test getAllTopics()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List TopicService.getAllTopics()"})
  void testGetAllTopics() {
    // Arrange and Act
    List<Topic> actualAllTopics = new TopicService().getAllTopics();

    // Assert
    assertEquals(3, actualAllTopics.size());
    Topic getResult = actualAllTopics.get(1);
    assertEquals("Core Java", getResult.getSubjectName());
    assertEquals("Java Description", getResult.getSubjectDescription());
    Topic getResult2 = actualAllTopics.getFirst();
    assertEquals("Spring Framework Description", getResult2.getSubjectDescription());
    assertEquals("Spring Framework", getResult2.getSubjectName());
    assertEquals("java", getResult.getId());
    Topic getResult3 = actualAllTopics.get(2);
    assertEquals("javascript Framework Description", getResult3.getSubjectDescription());
    assertEquals("javascript Framework", getResult3.getSubjectName());
    assertEquals("javascript", getResult3.getId());
    assertEquals("spring", getResult2.getId());
  }

  /**
   * Test {@link TopicService#getTopicWithId(String)}.
   *
   * <ul>
   *   <li>Then return SubjectDescription is {@code Spring Framework Description}.
   * </ul>
   *
   * <p>Method under test: {@link TopicService#getTopicWithId(String)}
   */
  @Test
  @DisplayName(
      "Test getTopicWithId(String); then return SubjectDescription is 'Spring Framework Description'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Topic TopicService.getTopicWithId(String)"})
  void testGetTopicWithId_thenReturnSubjectDescriptionIsSpringFrameworkDescription() {
    // Arrange and Act
    Topic actualTopicWithId = topicService.getTopicWithId("spring");

    // Assert
    assertEquals("Spring Framework Description", actualTopicWithId.getSubjectDescription());
    assertEquals("Spring Framework", actualTopicWithId.getSubjectName());
    assertEquals("spring", actualTopicWithId.getId());
  }

  /**
   * Test {@link TopicService#getTopicWithId(String)}.
   *
   * <ul>
   *   <li>When {@code java}.
   *   <li>Then return SubjectName is {@code Core Java}.
   * </ul>
   *
   * <p>Method under test: {@link TopicService#getTopicWithId(String)}
   */
  @Test
  @DisplayName("Test getTopicWithId(String); when 'java'; then return SubjectName is 'Core Java'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Topic TopicService.getTopicWithId(String)"})
  void testGetTopicWithId_whenJava_thenReturnSubjectNameIsCoreJava() {
    // Arrange and Act
    Topic actualTopicWithId = topicService.getTopicWithId("java");

    // Assert
    assertEquals("Core Java", actualTopicWithId.getSubjectName());
    assertEquals("Java Description", actualTopicWithId.getSubjectDescription());
    assertEquals("java", actualTopicWithId.getId());
  }

  /**
   * Test {@link TopicService#addTopic(Topic)}.
   *
   * <p>Method under test: {@link TopicService#addTopic(Topic)}
   */
  @Test
  @DisplayName("Test addTopic(Topic)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TopicService.addTopic(Topic)"})
  void testAddTopic() {
    // Arrange
    Topic topic =
        new Topic("42", "Hello from the Dreaming Spires", "Hello from the Dreaming Spires");

    // Act
    topicService.addTopic(topic);

    // Assert
    List<Topic> allTopics = topicService.getAllTopics();
    assertEquals(4, allTopics.size());
    assertSame(topic, allTopics.get(3));
  }

  /**
   * Test {@link TopicService#updateTopic(String, Topic)}.
   *
   * <ul>
   *   <li>When {@code spring}.
   *   <li>Then {@link TopicService} AllTopics size is three.
   * </ul>
   *
   * <p>Method under test: {@link TopicService#updateTopic(String, Topic)}
   */
  @Test
  @DisplayName(
      "Test updateTopic(String, Topic); when 'spring'; then TopicService AllTopics size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TopicService.updateTopic(String, Topic)"})
  void testUpdateTopic_whenSpring_thenTopicServiceAllTopicsSizeIsThree() {
    // Arrange
    Topic topic =
        new Topic("42", "Hello from the Dreaming Spires", "Hello from the Dreaming Spires");

    // Act
    topicService.updateTopic("spring", topic);

    // Assert
    List<Topic> allTopics = topicService.getAllTopics();
    assertEquals(3, allTopics.size());
    assertSame(topic, allTopics.getFirst());
  }

  /**
   * Test {@link TopicService#deleteTopic(String)}.
   *
   * <p>Method under test: {@link TopicService#deleteTopic(String)}
   */
  @Test
  @DisplayName("Test deleteTopic(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TopicService.deleteTopic(String)"})
  void testDeleteTopic() {
    // Arrange
    TopicService topicService = new TopicService();
    Topic topic =
        new Topic("42", "Hello from the Dreaming Spires", "Hello from the Dreaming Spires");
    topicService.addTopic(topic);

    // Act
    topicService.deleteTopic("42");

    // Assert
    assertEquals(3, topicService.getAllTopics().size());
  }

  /**
   * Test {@link TopicService#deleteTopic(String)}.
   *
   * <ul>
   *   <li>Given {@link TopicService} (default constructor).
   *   <li>Then {@link TopicService} (default constructor) AllTopics size is three.
   * </ul>
   *
   * <p>Method under test: {@link TopicService#deleteTopic(String)}
   */
  @Test
  @DisplayName(
      "Test deleteTopic(String); given TopicService (default constructor); then TopicService (default constructor) AllTopics size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TopicService.deleteTopic(String)"})
  void testDeleteTopic_givenTopicService_thenTopicServiceAllTopicsSizeIsThree() {
    // Arrange
    TopicService topicService = new TopicService();

    // Act
    topicService.deleteTopic("42");

    // Assert that nothing has changed
    assertEquals(3, topicService.getAllTopics().size());
  }

  /**
   * Test {@link TopicService#filterMinimumLengthForId(Integer)}.
   *
   * <ul>
   *   <li>When six.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link TopicService#filterMinimumLengthForId(Integer)}
   */
  @Test
  @DisplayName("Test filterMinimumLengthForId(Integer); when six; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List TopicService.filterMinimumLengthForId(Integer)"})
  void testFilterMinimumLengthForId_whenSix_thenReturnSizeIsOne() {
    // Arrange and Act
    List<Topic> actualFilterMinimumLengthForIdResult = topicService.filterMinimumLengthForId(6);

    // Assert
    assertEquals(1, actualFilterMinimumLengthForIdResult.size());
    Topic getResult = actualFilterMinimumLengthForIdResult.getFirst();
    assertEquals("javascript Framework Description", getResult.getSubjectDescription());
    assertEquals("javascript Framework", getResult.getSubjectName());
    assertEquals("javascript", getResult.getId());
  }

  /**
   * Test {@link TopicService#filterMinimumLengthForId(Integer)}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return size is three.
   * </ul>
   *
   * <p>Method under test: {@link TopicService#filterMinimumLengthForId(Integer)}
   */
  @Test
  @DisplayName("Test filterMinimumLengthForId(Integer); when three; then return size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List TopicService.filterMinimumLengthForId(Integer)"})
  void testFilterMinimumLengthForId_whenThree_thenReturnSizeIsThree() {
    // Arrange and Act
    List<Topic> actualFilterMinimumLengthForIdResult = topicService.filterMinimumLengthForId(3);

    // Assert
    assertEquals(3, actualFilterMinimumLengthForIdResult.size());
    Topic getResult = actualFilterMinimumLengthForIdResult.get(1);
    assertEquals("Core Java", getResult.getSubjectName());
    assertEquals("Java Description", getResult.getSubjectDescription());
    Topic getResult2 = actualFilterMinimumLengthForIdResult.getFirst();
    assertEquals("Spring Framework Description", getResult2.getSubjectDescription());
    assertEquals("Spring Framework", getResult2.getSubjectName());
    assertEquals("java", getResult.getId());
    Topic getResult3 = actualFilterMinimumLengthForIdResult.get(2);
    assertEquals("javascript Framework Description", getResult3.getSubjectDescription());
    assertEquals("javascript Framework", getResult3.getSubjectName());
    assertEquals("javascript", getResult3.getId());
    assertEquals("spring", getResult2.getId());
  }

  /**
   * Test {@link TopicService#sortTopicsWithID()}.
   *
   * <p>Method under test: {@link TopicService#sortTopicsWithID()}
   */
  @Test
  @DisplayName("Test sortTopicsWithID()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List TopicService.sortTopicsWithID()"})
  void testSortTopicsWithID() {
    // Arrange and Act
    List<Topic> actualSortTopicsWithIDResult = topicService.sortTopicsWithID();

    // Assert
    assertEquals(3, actualSortTopicsWithIDResult.size());
    Topic getResult = actualSortTopicsWithIDResult.getFirst();
    assertEquals("Core Java", getResult.getSubjectName());
    assertEquals("Java Description", getResult.getSubjectDescription());
    Topic getResult2 = actualSortTopicsWithIDResult.get(2);
    assertEquals("Spring Framework Description", getResult2.getSubjectDescription());
    assertEquals("Spring Framework", getResult2.getSubjectName());
    assertEquals("java", getResult.getId());
    Topic getResult3 = actualSortTopicsWithIDResult.get(1);
    assertEquals("javascript Framework Description", getResult3.getSubjectDescription());
    assertEquals("javascript Framework", getResult3.getSubjectName());
    assertEquals("javascript", getResult3.getId());
    assertEquals("spring", getResult2.getId());
  }

  /**
   * Test {@link TopicService#returnAllTopicIDWithStringSlicing()}.
   *
   * <p>Method under test: {@link TopicService#returnAllTopicIDWithStringSlicing()}
   */
  @Test
  @DisplayName("Test returnAllTopicIDWithStringSlicing()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TopicService.returnAllTopicIDWithStringSlicing()"})
  void testReturnAllTopicIDWithStringSlicing() {
    // Arrange, Act and Assert
    assertEquals("spring:java:javascript", topicService.returnAllTopicIDWithStringSlicing());
  }

  /**
   * Test {@link TopicService#makeDistinctAndSortCharacters(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link TopicService#makeDistinctAndSortCharacters(String)}
   */
  @Test
  @DisplayName(
      "Test makeDistinctAndSortCharacters(String); when empty string; then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TopicService.makeDistinctAndSortCharacters(String)"})
  void testMakeDistinctAndSortCharacters_whenEmptyString_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", topicService.makeDistinctAndSortCharacters(""));
  }

  /**
   * Test {@link TopicService#makeDistinctAndSortCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code Join}.
   *   <li>Then return {@code Jino}.
   * </ul>
   *
   * <p>Method under test: {@link TopicService#makeDistinctAndSortCharacters(String)}
   */
  @Test
  @DisplayName("Test makeDistinctAndSortCharacters(String); when 'Join'; then return 'Jino'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TopicService.makeDistinctAndSortCharacters(String)"})
  void testMakeDistinctAndSortCharacters_whenJoin_thenReturnJino() {
    // Arrange, Act and Assert
    assertEquals("Jino", topicService.makeDistinctAndSortCharacters("Join"));
  }

  /**
   * Test {@link TopicService#splitAllIdWithColonSelectIDWithJavaKeywordThenSortThenJoin(String)}.
   *
   * <ul>
   *   <li>When {@code :}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TopicService#splitAllIdWithColonSelectIDWithJavaKeywordThenSortThenJoin(String)}
   */
  @Test
  @DisplayName("Test splitAllIdWithColonSelectIDWithJavaKeywordThenSortThenJoin(String); when ':'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String TopicService.splitAllIdWithColonSelectIDWithJavaKeywordThenSortThenJoin(String)"
  })
  void testSplitAllIdWithColonSelectIDWithJavaKeywordThenSortThenJoin_whenColon() {
    // Arrange, Act and Assert
    assertEquals("", topicService.splitAllIdWithColonSelectIDWithJavaKeywordThenSortThenJoin(":"));
  }

  /**
   * Test {@link TopicService#splitAllIdWithColonSelectIDWithJavaKeywordThenSortThenJoin(String)}.
   *
   * <ul>
   *   <li>When {@code java}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TopicService#splitAllIdWithColonSelectIDWithJavaKeywordThenSortThenJoin(String)}
   */
  @Test
  @DisplayName(
      "Test splitAllIdWithColonSelectIDWithJavaKeywordThenSortThenJoin(String); when 'java'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String TopicService.splitAllIdWithColonSelectIDWithJavaKeywordThenSortThenJoin(String)"
  })
  void testSplitAllIdWithColonSelectIDWithJavaKeywordThenSortThenJoin_whenJava() {
    // Arrange, Act and Assert
    assertEquals(
        "java", topicService.splitAllIdWithColonSelectIDWithJavaKeywordThenSortThenJoin("java"));
  }

  /**
   * Test {@link TopicService#splitAllIdWithColonSelectIDWithJavaKeywordThenSortThenJoin(String)}.
   *
   * <ul>
   *   <li>When {@code :java}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TopicService#splitAllIdWithColonSelectIDWithJavaKeywordThenSortThenJoin(String)}
   */
  @Test
  @DisplayName(
      "Test splitAllIdWithColonSelectIDWithJavaKeywordThenSortThenJoin(String); when ':java'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String TopicService.splitAllIdWithColonSelectIDWithJavaKeywordThenSortThenJoin(String)"
  })
  void testSplitAllIdWithColonSelectIDWithJavaKeywordThenSortThenJoin_whenJava2() {
    // Arrange, Act and Assert
    assertEquals(
        "java", topicService.splitAllIdWithColonSelectIDWithJavaKeywordThenSortThenJoin(":java"));
  }

  /**
   * Test {@link TopicService#splitAllIdWithColonSelectIDWithJavaKeywordThenSortThenJoin(String)}.
   *
   * <ul>
   *   <li>When {@code Join}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TopicService#splitAllIdWithColonSelectIDWithJavaKeywordThenSortThenJoin(String)}
   */
  @Test
  @DisplayName(
      "Test splitAllIdWithColonSelectIDWithJavaKeywordThenSortThenJoin(String); when 'Join'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String TopicService.splitAllIdWithColonSelectIDWithJavaKeywordThenSortThenJoin(String)"
  })
  void testSplitAllIdWithColonSelectIDWithJavaKeywordThenSortThenJoin_whenJoin() {
    // Arrange, Act and Assert
    assertEquals(
        "", topicService.splitAllIdWithColonSelectIDWithJavaKeywordThenSortThenJoin("Join"));
  }

  /**
   * Test {@link TopicService#findIdHavingCharacter()}.
   *
   * <p>Method under test: {@link TopicService#findIdHavingCharacter()}
   */
  @Test
  @DisplayName("Test findIdHavingCharacter()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TopicService.findIdHavingCharacter()"})
  void testFindIdHavingCharacter() {
    // Arrange, Act and Assert
    assertEquals("[spring]", topicService.findIdHavingCharacter());
  }

  /**
   * Test {@link TopicService#findAllFilesInPathAndSort()}.
   *
   * <p>Method under test: {@link TopicService#findAllFilesInPathAndSort()}
   */
  @Test
  @DisplayName("Test findAllFilesInPathAndSort()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TopicService.findAllFilesInPathAndSort()"})
  void testFindAllFilesInPathAndSort() {
    // Arrange, Act and Assert
    assertEquals(
        "README.md; application.properties; build.gradle; gradle; gradlew; gradlew.bat; gs-spring-boot.iml;"
            + " mvnw; mvnw.cmd; pom.xml; src; target; temp.txt",
        topicService.findAllFilesInPathAndSort());
  }

  /**
   * Test {@link TopicService#findParticularFileInPathAndSort()}.
   *
   * <p>Method under test: {@link TopicService#findParticularFileInPathAndSort()}
   */
  @Test
  @DisplayName("Test findParticularFileInPathAndSort()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TopicService.findParticularFileInPathAndSort()"})
  void testFindParticularFileInPathAndSort() {
    // Arrange, Act and Assert
    assertEquals(
        "gradle; gradle/wrapper; gradle/wrapper/gradle-wrapper.jar; gradle/wrapper/gradle-wrapper.properties;"
            + " gradlew; gradlew.bat",
        topicService.findParticularFileInPathAndSort());
  }

  /**
   * Test {@link TopicService#findParticularFileInPathAndSortWithWalkFunction()}.
   *
   * <p>Method under test: {@link TopicService#findParticularFileInPathAndSortWithWalkFunction()}
   */
  @Test
  @DisplayName("Test findParticularFileInPathAndSortWithWalkFunction()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TopicService.findParticularFileInPathAndSortWithWalkFunction()"})
  void testFindParticularFileInPathAndSortWithWalkFunction() {
    // Arrange, Act and Assert
    assertEquals(
        "gradle; gradle/wrapper; gradle/wrapper/gradle-wrapper.jar; gradle/wrapper/gradle-wrapper.properties;"
            + " gradlew; gradlew.bat",
        topicService.findParticularFileInPathAndSortWithWalkFunction());
  }

  /**
   * Test {@link TopicService#readFileWithStreamFunction()}.
   *
   * <p>Method under test: {@link TopicService#readFileWithStreamFunction()}
   */
  @Test
  @DisplayName("Test readFileWithStreamFunction()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TopicService.readFileWithStreamFunction()"})
  void testReadFileWithStreamFunction() {
    // Arrange, Act and Assert
    assertEquals(" Hello, this, is, Rehman", topicService.readFileWithStreamFunction());
  }
}
