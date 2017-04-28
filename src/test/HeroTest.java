import org.junit.*;
import static org.junit.Assert.*;

// test to show if user can create an instance of the Class Hero

public class HeroTest {

  public Hero(String description) {

    @Test
    public void Hero_instantiatesCorrectly_true() {
      Hero myHero = new Hero("engage");
      assertEquals(true, myHero instanceof Hero);
    }

    @Test
    public void Hero_instantiatesWithName_String() {
      Hero myHero = new Hero("steve")
      assertEquals("steve", myHero.getName());
    }
  }

}
