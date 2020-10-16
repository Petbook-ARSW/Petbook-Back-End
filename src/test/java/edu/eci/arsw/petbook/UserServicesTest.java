package edu.eci.arsw.petbook;

import edu.eci.arsw.petbook.model.User;
import edu.eci.arsw.petbook.services.IUserServices;
import edu.eci.arsw.petbook.services.PetbookServicesException;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:db-test.properties")
@Sql("/data.sql")
@Rollback
public class UserServicesTest extends TestCase {

    @Autowired
    private IUserServices userServices;

    @Transactional
    @Test
    public void shouldGetUserByUserName() {
        User user = new User("userTest", "passTest", "Person", "userTest@gmail.com", new Long("3214556789"), "information test", new Date(100, 10, 3));
        User user2 = new User("userTest2", "passTest", "Person", "userTest2@gmail.com", new Long("3214556789"), "information test", new Date(100, 10, 3));
        User user3 = new User("userTest3", "passTest", "Person", "userTest3@gmail.com", new Long("3214556789"), "information test", new Date(100, 10, 3));
        try {
            userServices.addUser(user);
            userServices.addUser(user2);
            userServices.addUser(user3);

            assertEquals(userServices.getUserByNameUser("userTest").getUserName(), user.getUserName());
            assertEquals(userServices.getUserByNameUser("userTest2").getUserName(), user2.getUserName());
            assertEquals(userServices.getUserByNameUser("userTest3").getUserName(), user3.getUserName());

        } catch (PetbookServicesException e) {
            fail("Lanzó excepción");
        }
    }

    @Transactional
    @Test
    public void shouldAddUser() {
        User user = new User("userTest", "passTest", "Person", "userTest@gmail.com", new Long("3214556789"), "information test", new Date(100, 10, 3));
        try {
            userServices.addUser(user);
            assertEquals(userServices.getUserByNameUser("userTest"), user);
        } catch (PetbookServicesException e) {
            fail("Lanzó excepción");
        }
    }

    @Transactional
    @Test
    public void shouldGetAllUsers() {
        User user1 = new User("userTest1", "passTest1", "Person", "userTest1@gmail.com", new Long("3214556789"), "information test", new Date(100, 10, 3));
        User user2 = new User("userTest2", "passTest2", "Person", "userTest2@gmail.com", new Long("3214556789"), "information test", new Date(100, 10, 3));
        User user3 = new User("userTest3", "passTest3", "Person", "userTest3@gmail.com", new Long("3214556789"), "information test", new Date(100, 10, 3));
        try {
            userServices.addUser(user1);
            userServices.addUser(user2);
            userServices.addUser(user3);

            List<User> users = new ArrayList<>();
            users.add(user1); users.add(user2); users.add(user3);

            assertEquals(userServices.getAllUsers(), users);
        } catch (PetbookServicesException e) {
            fail("Lanzó excepción");
        }
    }

    @Transactional
    @Test
    public void shouldUpdateUser() {
        User user = new User("userTest1", "passTest1", "Refuge", "userTest1@gmail.com", new Long("3214556789"), "information test", new Date(100, 10, 3));
        try {
            userServices.addUser(user);
            int id = user.getId();
            String newPass = "newPass";
            String newInfo = "newInfo";
            String newMail = "newMail@gmail.com";
            Long newPhone = new Long("3214556799");

            User user2 = userServices.getUserByNameUser("userTest1");

            user2.setInformation(newInfo);
            user2.setMail(newMail);
            user2.setNumberPhone(newPhone);
            user2.setPasword(newPass);

            userServices.ediitUser(user2);

            assertEquals(newInfo, userServices.getUserByNameUser("userTest1").getInformation());
            assertEquals(newPhone, userServices.getUserByNameUser("userTest1").getNumberPhone());
            assertEquals(newMail, userServices.getUserByNameUser("userTest1").getMail());
            assertEquals(newPass, userServices.getUserByNameUser("userTest1").getPasword());

        } catch (PetbookServicesException e) {
            fail("Lanzó excepción");
        }
    }

}