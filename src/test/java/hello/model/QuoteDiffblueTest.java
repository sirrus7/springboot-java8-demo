package hello.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class QuoteDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Quote}
   *   <li>{@link Quote#setType(String)}
   *   <li>{@link Quote#setValue(Value)}
   *   <li>{@link Quote#toString()}
   *   <li>{@link Quote#getType()}
   *   <li>{@link Quote#getValue()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Quote.<init>()",
    "String Quote.getType()",
    "Value Quote.getValue()",
    "void Quote.setType(String)",
    "void Quote.setValue(Value)",
    "String Quote.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    Quote actualQuote = new Quote();
    actualQuote.setType("Type");
    Value value = new Value();
    value.setId(1L);
    value.setQuote("Quote");
    actualQuote.setValue(value);
    String actualToStringResult = actualQuote.toString();
    String actualType = actualQuote.getType();

    // Assert
    assertEquals("Quote{type='Type', value=Value{id=1, quote='Quote'}}", actualToStringResult);
    assertEquals("Type", actualType);
    assertSame(value, actualQuote.getValue());
  }
}
