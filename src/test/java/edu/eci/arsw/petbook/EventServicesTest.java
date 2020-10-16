package edu.eci.arsw.petbook;

import edu.eci.arsw.petbook.model.Event;
import edu.eci.arsw.petbook.model.Goal;
import edu.eci.arsw.petbook.model.User;
import edu.eci.arsw.petbook.services.IEventServices;
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
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:db-test.properties")
@Sql("/data.sql")
@Rollback
public class EventServicesTest extends TestCase {

    @Autowired
    private IEventServices eventServices;

    @Autowired
    private IUserServices userServices;

    @Transactional
    @Test
    public void shouldAddEvent() {
        User host =  new User("userTest1", "passTest1", "Veterinary", "userTest1@gmail.com", new Long("3214556789"), "information test", new Date(100, 10, 3));
        Event event = new Event("Event test", false, "Address test", new Date(120, 12, 3), new Time(10,0,0), "Information test", host.getId());
        try {
            userServices.addUser(host);
            eventServices.addEvent(event);
            assertEquals(eventServices.getEventXId(event.getId()), event);
        } catch (PetbookServicesException e) {
            fail("Lanzó excepción");
        }
    }

    @Transactional
    @Test
    public void shouldGetAllEvents() {
        User host =  new User("userTest1", "passTest1", "Veterinary", "userTest1@gmail.com", new Long("3214556789"), "information test", new Date(100, 10, 3));
        Event event = new Event("Event test1", false, "Address test", new Date(120, 12, 3), new Time(10,0,0), "Information test", host.getId());
        Event event2 = new Event("Event test2", false, "Address test2", new Date(120, 12, 4), new Time(12,0,0), "Information test2", host.getId());
        Event event3 = new Event("Event test3", false, "Address test3", new Date(120, 12, 5), new Time(13,0,0), "Information test3", host.getId());
        try {
            userServices.addUser(host);
            eventServices.addEvent(event);
            eventServices.addEvent(event2);
            eventServices.addEvent(event3);
            List<Event> events = new ArrayList<>();
            events.add(event);events.add(event2);events.add(event3);
            assertEquals(events, eventServices.getAllEvents());
        } catch (PetbookServicesException e) {
            fail("Lanzó excepción");
        }
    }

    @Transactional
    @Test
    public void shouldAddGoals() {
        User host =  new User("userTest1", "passTest1", "Refuge", "userTest1@gmail.com", new Long("3214556789"), "information test", new Date(100, 10, 3));
        Event event = new Event("Event test", true, "Address test", new Date(120, 12, 3), new Time(10,0,0), "Information test", host.getId());
        Goal goal = new Goal(event.getId(), "prize test", false, 30000);
        try {
            userServices.addUser(host);
            eventServices.addEvent(event);
            eventServices.addGoal(goal);
            assertEquals(eventServices.getGoalsXId(goal.getId()), goal);
        } catch (PetbookServicesException e) {
            fail("Lanzó excepción");
        }
    }

    @Transactional
    @Test
    public void shouldGetAllGoals() {
        User host =  new User("userTest1", "passTest1", "Refuge", "userTest1@gmail.com", new Long("3214556789"), "information test", new Date(100, 10, 3));
        Event event = new Event("Event test", true, "Address test", new Date(120, 12, 3), new Time(10,0,0), "Information test", host.getId());
        Goal goal1 = new Goal(event.getId(), "prize test1", false, 30000);
        Goal goal2 = new Goal(event.getId(), "prize test2", false, 40000);
        Goal goal3 = new Goal(event.getId(), "prize test3", false, 50000);
        try {
            eventServices.addGoal(goal1);
            eventServices.addGoal(goal2);
            eventServices.addGoal(goal3);
            List<Goal> goals = new ArrayList<>();
            goals.add(goal1); goals.add(goal2); goals.add(goal3);
            assertEquals(eventServices.getAllGoals(event.getId()), goals);
        } catch (PetbookServicesException e) {
            fail("Lanzó excepción");
        }
    }

    @Transactional
    @Test
    public void shouldGetEventById() {
        User host =  new User("userTest1", "passTest1", "Veterinary", "userTest1@gmail.com", new Long("3214556789"), "information test", new Date(100, 10, 3));
        Event event = new Event("Event test", false, "Address test", new Date(120, 12, 3), new Time(10,0,0), "Information test", host.getId());
        Event event2 = new Event("Event test2", false, "Address test2", new Date(120, 12, 3), new Time(14,0,0), "Information test2", host.getId());
        try {
            userServices.addUser(host);
            eventServices.addEvent(event);
            eventServices.addEvent(event2);
            assertEquals(eventServices.getEventXId(event.getId()), event);
            assertEquals(eventServices.getEventXId(event2.getId()), event2);
        } catch (PetbookServicesException e) {
            fail("Lanzó excepción");
        }
    }

    @Transactional
    @Test
    public void shouldGetEventsByDate() {
        User host =  new User("userTest", "passTest", "Veterinary", "userTest@gmail.com", new Long("3214554589"), "information test", new Date(100, 10, 4));
        Event event1 = new Event("Event test1", false, "Address test1", new Date(120, 12, 3), new Time(10,0,0), "Information test1", host.getId());
        Event event2 = new Event("Event test2", false, "Address test2", new Date(120, 12, 3), new Time(11,0,0), "Information test2", host.getId());
        Event event3 = new Event("Event test3", false, "Address test3", new Date(120, 12, 5), new Time(12,0,0), "Information test3", host.getId());
        try {
            eventServices.addEvent(event1);
            eventServices.addEvent(event2);
            eventServices.addEvent(event3);
            List<Event> events = new ArrayList<>();
            events.add(event1);
            events.add(event2);
            assertEquals(events, eventServices.getEventsXDate(new Date(120, 12, 3)));
        } catch (PetbookServicesException e) {
            e.printStackTrace();
        }
    }

    @Transactional
    @Test
    public void shouldGetEventsWithDonationType() {
        User host =  new User("userTest", "passTest", "Refuge", "userTest@gmail.com", new Long("3214554589"), "information test", new Date(100, 10, 4));
        Event event1 = new Event("Event test1", false, "Address test1", new Date(120, 12, 3), new Time(10,0,0), "Information test1", host.getId());
        Event event2 = new Event("Event test2", true, "Address test2", new Date(120, 12, 3), new Time(11,0,0), "Information test2", host.getId());
        Event event3 = new Event("Event test3", true, "Address test3", new Date(120, 12, 5), new Time(12,0,0), "Information test3", host.getId());
        try {
            eventServices.addEvent(event1);
            eventServices.addEvent(event2);
            eventServices.addEvent(event3);
            List<Event> events = new ArrayList<>();
            events.add(event2);
            events.add(event3);
            assertEquals(events, eventServices.getEventsTypeDonaton());
        } catch (PetbookServicesException e) {
            e.printStackTrace();
        }
    }

    @Transactional
    @Test
    public void shouldRemoveEventById() {
        User host =  new User("userTest", "passTest", "Refuge", "userTest@gmail.com", new Long("3214554589"), "information test", new Date(100, 10, 4));
        Event event1 = new Event("Event test1", false, "Address test1", new Date(120, 12, 3), new Time(10,0,0), "Information test1", host.getId());
        Event event2 = new Event("Event test2", true, "Address test2", new Date(120, 12, 3), new Time(11,0,0), "Information test2", host.getId());
        Event event3 = new Event("Event test3", true, "Address test3", new Date(120, 12, 5), new Time(12,0,0), "Information test3", host.getId());
        try {
            eventServices.addEvent(event1);
            eventServices.addEvent(event2);
            eventServices.addEvent(event3);
            List<Event> events = new ArrayList<>();
            events.add(event1);
            events.add(event2);
            events.add(event3);
            assertEquals(events, eventServices.getAllEvents());
            events.remove(event2);
            eventServices.removeEventXId(event2.getId());
            assertEquals(eventServices.getAllEvents(), events);
        } catch (PetbookServicesException e) {
            e.printStackTrace();
        }
    }

    @Transactional
    @Test
    public void shouldUpdateEvent() {
        User host =  new User("userTest", "passTest", "Refuge", "userTest@gmail.com", new Long("3214554589"), "information test", new Date(100, 10, 4));
        Event event1 = new Event("Event test1", true, "Address test1", new Date(120, 12, 3), new Time(10,0,0), "Information test1", host.getId());
        Event event2 = new Event("Event test1", true, "Address updated", new Date(120, 12, 4), new Time(11,0,0), "Information updated", host.getId());
        try {
            eventServices.addEvent(event1);
            event2.setId(event1.getId());
            eventServices.updateEvent(event2);
            assertEquals(eventServices.getEventXId(event1.getId()).getDate(), event2.getDate());
            assertEquals(eventServices.getEventXId(event1.getId()).getAddress(), event2.getAddress());
        } catch (PetbookServicesException e) {
            e.printStackTrace();
        }
    }

    @Transactional
    @Test
    public void shouldGetGoalById() {
        User host =  new User("userTest1", "passTest1", "Refuge", "userTest1@gmail.com", new Long("3214556789"), "information test", new Date(100, 10, 3));
        Event event = new Event("Event test", true, "Address test", new Date(120, 12, 3), new Time(10,0,0), "Information test", host.getId());
        Goal goal1 = new Goal(event.getId(), "prize test1", false, 30000);
        Goal goal2 = new Goal(event.getId(), "prize test2", false, 40000);
        Goal goal3 = new Goal(event.getId(), "prize test3", false, 50000);
        try {
            eventServices.addGoal(goal1);
            eventServices.addGoal(goal2);
            eventServices.addGoal(goal3);
            assertEquals(goal1, eventServices.getGoalsXId(goal1.getId()));
            assertEquals(goal2, eventServices.getGoalsXId(goal2.getId()));
            assertEquals(goal3, eventServices.getGoalsXId(goal3.getId()));
        } catch (PetbookServicesException e) {
            fail("Lanzó excepción");
        }
    }

    @Transactional
    @Test
    public void shouldRemoveGoalById() {
        User host =  new User("userTest1", "passTest1", "Refuge", "userTest1@gmail.com", new Long("3214556789"), "information test", new Date(100, 10, 3));
        Event event = new Event("Event test", true, "Address test", new Date(120, 12, 3), new Time(10,0,0), "Information test", host.getId());
        Goal goal1 = new Goal(event.getId(), "prize test1", false, 30000);
        Goal goal2 = new Goal(event.getId(), "prize test2", false, 40000);
        Goal goal3 = new Goal(event.getId(), "prize test3", false, 50000);
        try {
            eventServices.addGoal(goal1);
            eventServices.addGoal(goal2);
            eventServices.addGoal(goal3);

            List<Goal> goals = new ArrayList<>();
            goals.add(goal1); goals.add(goal2); goals.add(goal3);

            assertEquals(eventServices.getAllGoals(event.getId()), goals);
        } catch (PetbookServicesException e) {
            fail("Lanzó excepción");
        }
    }

    @Transactional
    @Test
    public void shouldUpdateGoal() {
        User host =  new User("userTest1", "passTest1", "Refuge", "userTest1@gmail.com", new Long("3214556789"), "information test", new Date(100, 10, 3));
        Event event = new Event("Event test", true, "Address test", new Date(120, 12, 3), new Time(10,0,0), "Information test", host.getId());
        Goal goal1 = new Goal(event.getId(), "prize test1", false, 30000);
        int newValue = 40000;
        String newPrize = "updated prize";
        try {
            eventServices.addGoal(goal1);
            goal1.setValor(newValue);
            goal1.setPrize(newPrize);
            eventServices.updateGoal(goal1);
            assertEquals(eventServices.getGoalsXId(goal1.getId()).getPrize(), newPrize);
            assertEquals(eventServices.getGoalsXId(goal1.getId()).getValor(), newValue);
        } catch (PetbookServicesException e) {
            fail(e.getMessage());
        }
    }

}