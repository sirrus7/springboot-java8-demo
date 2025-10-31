package hello.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TopicDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Topic#Topic()}
   *   <li>{@link Topic#setId(String)}
   *   <li>{@link Topic#setSubjectDescription(String)}
   *   <li>{@link Topic#setSubjectName(String)}
   *   <li>{@link Topic#getId()}
   *   <li>{@link Topic#getSubjectDescription()}
   *   <li>{@link Topic#getSubjectName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Topic.<init>()",
    "void Topic.<init>(String, String, String)",
    "String Topic.getId()",
    "String Topic.getSubjectDescription()",
    "String Topic.getSubjectName()",
    "void Topic.setId(String)",
    "void Topic.setSubjectDescription(String)",
    "void Topic.setSubjectName(String)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    Topic actualTopic = new Topic();
    actualTopic.setId("42");
    actualTopic.setSubjectDescription("Hello from the Dreaming Spires");
    actualTopic.setSubjectName("Hello from the Dreaming Spires");
    String actualId = actualTopic.getId();
    String actualSubjectDescription = actualTopic.getSubjectDescription();

    // Assert
    assertEquals("42", actualId);
    assertEquals("Hello from the Dreaming Spires", actualSubjectDescription);
    assertEquals("Hello from the Dreaming Spires", actualTopic.getSubjectName());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Topic#Topic(String, String, String)}
   *   <li>{@link Topic#setId(String)}
   *   <li>{@link Topic#setSubjectDescription(String)}
   *   <li>{@link Topic#setSubjectName(String)}
   *   <li>{@link Topic#getId()}
   *   <li>{@link Topic#getSubjectDescription()}
   *   <li>{@link Topic#getSubjectName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Topic.<init>()",
    "void Topic.<init>(String, String, String)",
    "String Topic.getId()",
    "String Topic.getSubjectDescription()",
    "String Topic.getSubjectName()",
    "void Topic.setId(String)",
    "void Topic.setSubjectDescription(String)",
    "void Topic.setSubjectName(String)"
  })
  void testGettersAndSetters_when42() {
    // Arrange and Act
    Topic actualTopic =
        new Topic("42", "Hello from the Dreaming Spires", "Hello from the Dreaming Spires");
    actualTopic.setId("42");
    actualTopic.setSubjectDescription("Hello from the Dreaming Spires");
    actualTopic.setSubjectName("Hello from the Dreaming Spires");
    String actualId = actualTopic.getId();
    String actualSubjectDescription = actualTopic.getSubjectDescription();

    // Assert
    assertEquals("42", actualId);
    assertEquals("Hello from the Dreaming Spires", actualSubjectDescription);
    assertEquals("Hello from the Dreaming Spires", actualTopic.getSubjectName());
  }
}
