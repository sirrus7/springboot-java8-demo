package hello.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDateTime;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SimpleTimeClientDiffblueTest {
  /**
   * Test {@link SimpleTimeClient#setTime(int, int, int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then {@link SimpleTimeClient} (default constructor) LocalDateTime toLocalTime toString is
   *       {@code 01:01:01}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleTimeClient#setTime(int, int, int)}
   */
  @Test
  @DisplayName(
      "Test setTime(int, int, int); when one; then SimpleTimeClient (default constructor) LocalDateTime toLocalTime toString is '01:01:01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleTimeClient.setTime(int, int, int)"})
  void testSetTime_whenOne_thenSimpleTimeClientLocalDateTimeToLocalTimeToStringIs010101() {
    // Arrange
    SimpleTimeClient simpleTimeClient = new SimpleTimeClient();

    // Act
    simpleTimeClient.setTime(1, 1, 1);

    // Assert
    assertEquals("01:01:01", simpleTimeClient.getLocalDateTime().toLocalTime().toString());
  }

  /**
   * Test {@link SimpleTimeClient#setDate(int, int, int)}.
   *
   * <ul>
   *   <li>Then {@link SimpleTimeClient} (default constructor) LocalDateTime toLocalDate toString is
   *       {@code 0001-01-01}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleTimeClient#setDate(int, int, int)}
   */
  @Test
  @DisplayName(
      "Test setDate(int, int, int); then SimpleTimeClient (default constructor) LocalDateTime toLocalDate toString is '0001-01-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleTimeClient.setDate(int, int, int)"})
  void testSetDate_thenSimpleTimeClientLocalDateTimeToLocalDateToStringIs00010101() {
    // Arrange
    SimpleTimeClient simpleTimeClient = new SimpleTimeClient();

    // Act
    simpleTimeClient.setDate(1, 1, 1);

    // Assert
    assertEquals("0001-01-01", simpleTimeClient.getLocalDateTime().toLocalDate().toString());
  }

  /**
   * Test {@link SimpleTimeClient#setDateAndTime(int, int, int, int, int, int)}.
   *
   * <p>Method under test: {@link SimpleTimeClient#setDateAndTime(int, int, int, int, int, int)}
   */
  @Test
  @DisplayName("Test setDateAndTime(int, int, int, int, int, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleTimeClient.setDateAndTime(int, int, int, int, int, int)"})
  void testSetDateAndTime() {
    // Arrange
    SimpleTimeClient simpleTimeClient = new SimpleTimeClient();

    // Act
    simpleTimeClient.setDateAndTime(1, 1, 1, 1, 1, 1);

    // Assert
    LocalDateTime localDateTime = simpleTimeClient.getLocalDateTime();
    assertEquals("0001-01-01", localDateTime.toLocalDate().toString());
    assertEquals("01:01:01", localDateTime.toLocalTime().toString());
  }
}
