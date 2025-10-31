package hello.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CustomerDiffblueTest {
  /**
   * Test {@link Customer#Customer(long, String, String)}.
   *
   * <p>Method under test: {@link Customer#Customer(long, String, String)}
   */
  @Test
  @DisplayName("Test new Customer(long, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Customer.<init>(long, String, String)"})
  void testNewCustomer() {
    // Arrange and Act
    Customer actualCustomer = new Customer(1L, "Jane", "Doe");

    // Assert
    assertEquals("Doe", actualCustomer.getLastName());
    assertEquals("Jane", actualCustomer.getFirstName());
    assertEquals(1L, actualCustomer.getId());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Customer#setFirstName(String)}
   *   <li>{@link Customer#setId(long)}
   *   <li>{@link Customer#setLastName(String)}
   *   <li>{@link Customer#toString()}
   *   <li>{@link Customer#getFirstName()}
   *   <li>{@link Customer#getId()}
   *   <li>{@link Customer#getLastName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String Customer.getFirstName()",
    "long Customer.getId()",
    "String Customer.getLastName()",
    "void Customer.setFirstName(String)",
    "void Customer.setId(long)",
    "void Customer.setLastName(String)",
    "String Customer.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Customer customer = new Customer(1L, "Jane", "Doe");

    // Act
    customer.setFirstName("Jane");
    customer.setId(1L);
    customer.setLastName("Doe");
    String actualToStringResult = customer.toString();
    String actualFirstName = customer.getFirstName();
    long actualId = customer.getId();

    // Assert
    assertEquals("Customer{id=1, firstName='Jane', lastName='Doe'}", actualToStringResult);
    assertEquals("Doe", customer.getLastName());
    assertEquals("Jane", actualFirstName);
    assertEquals(1L, actualId);
  }
}
