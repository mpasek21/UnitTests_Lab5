package Zadanie_2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UserTest {

    @Test
    void userNameOrLastNameIsPawel() {
        User user = new User("Paweł", "Kowalski");

        assertAll("User name or last name is Paweł",
                () -> assertEquals("Paweł", user.getFirstName(), "First name should be Paweł"),
                () -> assertEquals("Kowalski", user.getLastName(), "Last name should be Paweł")
        );
    }
}
