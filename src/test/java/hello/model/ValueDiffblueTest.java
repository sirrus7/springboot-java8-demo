package hello.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ValueDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Value}
   *   <li>{@link Value#setId(Long)}
   *   <li>{@link Value#setQuote(String)}
   *   <li>{@link Value#toString()}
   *   <li>{@link Value#getId()}
   *   <li>{@link Value#getQuote()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Value.<init>()",
    "Long Value.getId()",
    "String Value.getQuote()",
    "void Value.setId(Long)",
    "void Value.setQuote(String)",
    "String Value.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    Value actualValue = new Value();
    actualValue.setId(1L);
    actualValue.setQuote("Quote");
    String actualToStringResult = actualValue.toString();
    Long actualId = actualValue.getId();

    // Assert
    assertEquals("Quote", actualValue.getQuote());
    assertEquals("Value{id=1, quote='Quote'}", actualToStringResult);
    assertEquals(1L, actualId.longValue());
  }
}
