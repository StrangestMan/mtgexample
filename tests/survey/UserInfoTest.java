package survey;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserInfoTest {
    private final String NAME = "Minetheground";
    private final double AGE = 18.3;
    private final String EMAIL = "do-not-reply@example.com";

    @Test void properThrows() {
        // Should throw when:
            // Null name
            // Empty name
            // Age <= 13
            // Null email
            // Empty email

        assertDoesNotThrow(() -> {
            new UserInfo(NAME, AGE, EMAIL);
        });

        assertThrows(IllegalArgumentException.class, () -> new UserInfo(null, AGE, EMAIL));
        assertThrows(IllegalArgumentException.class, () -> new UserInfo("", AGE, EMAIL));

        assertThrows(IllegalArgumentException.class, () -> new UserInfo(NAME, 12, EMAIL));
        assertThrows(IllegalArgumentException.class, () -> new UserInfo(NAME, 13, EMAIL));
        assertDoesNotThrow( () -> new UserInfo(NAME, 14, EMAIL));

        assertThrows(IllegalArgumentException.class, () -> new UserInfo(NAME, AGE, null));
        assertThrows(IllegalArgumentException.class, () -> new UserInfo(NAME, AGE, ""));
    }

    @Test void getters() {
        IUserProfile ui = new UserInfo(NAME, AGE, EMAIL);
        assertEquals(NAME, ui.getName());
        assertEquals(AGE, ui.getAge());
        assertEquals(EMAIL, ui.getEmail());
    }

    @Test void toStringTest() {
        IUserProfile ui = new UserInfo(NAME, AGE, EMAIL);
        assertEquals("Username: " + NAME + "\t" + "Age: " + AGE + "\n" + "Email: " + EMAIL, ui.toString());
    }
}