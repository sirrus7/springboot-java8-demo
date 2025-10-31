package hello.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class GreetingDiffblueTest {
  /**
   * Test {@link Greeting#Greeting(long, String)}.
   *
   * <p>Method under test: {@link Greeting#Greeting(long, String)}
   */
  @Test
  @DisplayName("Test new Greeting(long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Greeting.<init>(long, String)"})
  void testNewGreeting() {
    // Arrange and Act
    Greeting actualGreeting = new Greeting(1L, "Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualGreeting.getContent());
    assertEquals(1L, actualGreeting.getId());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Greeting#getContent()}
   *   <li>{@link Greeting#getId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Greeting.getContent()", "long Greeting.getId()"})
  void testGettersAndSetters() {
    // Arrange
    Greeting greeting = new Greeting(1L, "Not all who wander are lost");

    // Act
    String actualContent = greeting.getContent();

    // Assert
    assertEquals("Not all who wander are lost", actualContent);
    assertEquals(1L, greeting.getId());
  }
}
