package survey;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserInfoTest {
    private final String NAME = "Minetheground";
    private final double AGE = 18.3;
    private final String EMAIL = "do-not-reply@example.com";

    private final String SECOND_NAME = "GroundTheMine";
    private final double SECOND_AGE = 90.999;
    private final String SECOND_EMAIL = "please-reply@example.com";

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

    @Test void setters() {
        IUserProfile ui = new UserInfo(NAME, AGE, EMAIL);
        assertEquals(NAME, ui.getName());
        assertEquals(AGE, ui.getAge());
        assertEquals(EMAIL, ui.getEmail());

        // Setters should throw on the same conditions as init
        assertThrows(IllegalArgumentException.class, () -> ui.setEmail(null));
        assertThrows(IllegalArgumentException.class, () -> ui.setEmail(""));

        assertThrows(IllegalArgumentException.class, () -> ui.setAge(12));
        assertThrows(IllegalArgumentException.class, () -> ui.setAge(13));
        assertDoesNotThrow( () -> ui.setAge(14));

        assertThrows(IllegalArgumentException.class, () -> ui.setEmail(null));
        assertThrows(IllegalArgumentException.class, () -> ui.setEmail(""));

        
        // Check to see that the setters are working properly
        ui.setName(SECOND_NAME);
        assertEquals(SECOND_NAME, ui.getName());

        ui.setAge(SECOND_AGE);
        assertEquals(SECOND_AGE, ui.getAge());

        ui.setEmail(SECOND_EMAIL);
        assertEquals(SECOND_EMAIL, ui.getEmail());
    }

    @Test void toStringTest() {
        IUserProfile ui = new UserInfo(NAME, AGE, EMAIL);
        assertEquals("Username: " + NAME + "\t" + "Age: " + AGE + "\n" + "Email: " + EMAIL, ui.toString());
    }
}