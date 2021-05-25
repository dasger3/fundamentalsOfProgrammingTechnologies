package voronin;

import org.junit.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import voronin.context.Application;
import voronin.controller.ManagerController;
import voronin.exception.ObjectNotFoundException;
import voronin.model.Manager;

import java.util.LinkedList;
import java.util.List;


public class ManagerTestIT {

    AnnotationConfigApplicationContext context;
    ManagerController managerController;
    List<Manager> expected = new LinkedList<>();
    Long savedID = null;

    @Before
    public void setUp () {
        context = new AnnotationConfigApplicationContext(Application.class);

        managerController = context.getBean(ManagerController.class);

        expected = managerController.findAllManager().getBody();
    }
    @Test
    public void findAllManagers_isFindCorrect_true () {
        //GIVEN
        List<Manager> expected1 = new LinkedList<>();
        expected1.add(new Manager(1L, "Alexsey", "Voronin", "mayor"));
        expected1.add(new Manager(2L, "Dmitriy", "Derkov", "head"));
        expected1.add(new Manager(3L, "Andrew", "Glamazda", "head"));
        expected1.add(new Manager(4L, "Kirill", "Demchenko", "mayor"));
        expected1.add(new Manager(5L, "Dasha", "Volos", "head"));
        expected1.add(new Manager(6L, "Karolina", "Kuznetsova", "mayor"));
        expected1.add(new Manager(7L, "Artem", "Cheban", "head"));
        expected1.add(new Manager(8L, "Grigoriy", "Glamazda", "head"));
        expected1.add(new Manager(9L, "Alexsandr", "Ivashyna", "mayor"));
        expected1.add(new Manager(10L, "Polina", "Lyashenko", "head"));
        expected1.add(new Manager(11L, "Nikolay",   "Voronin", "head"));
        //WHEN
        List<Manager> actual = managerController.findAllManager().getBody();
        //THEN
        Assert.assertEquals(expected1,actual);
    }
    @Test
    public void findManagerByID_isFindCorrect_true () {
        //GIVEN
        //WHEN
        Manager actual = managerController.findManagerById(1L).getBody();
        //THEN
        Assert.assertEquals(expected.get(0),actual);
    }
    @Test(expected = ObjectNotFoundException.class)
    public void findManagerByID_whenIdIsInvalid_true () {
        //GIVEN
        //WHEN
        managerController.findManagerById(100L);
        //THEN
    }
    @Test
    public void findManagerByName_isFindCorrect_true () {
        //GIVEN
        List<Manager> expected1 = new LinkedList<>();
        expected1.add(expected.get(0));
        //WHEN
        List<Manager> actual = managerController.findManagerByName("Alexsey").getBody();
        //THEN
        Assert.assertEquals(expected1,actual);
    }
    @Test(expected = ObjectNotFoundException.class)
    public void findManagerByName_whenNameIsInvalid_true () {
        //GIVEN
        //WHEN
        managerController.findManagerByName("ErrorName");
        //THEN
    }
    @Test
    public void saveManager_isSaveCorrect_true () {
        //GIVEN
        Manager test = new Manager("testName", "testSurname", "testPosition");
        expected.add(test);
        //WHEN
        managerController.saveManager(test);
        List<Manager> actual = managerController.findAllManager().getBody();
        savedID = actual.get(actual.size()-1).getManagerId();
        expected.get(expected.size()-1).setManagerId(savedID);
        //THEN
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void updateManager_isUpdateCorrect_true () {
        //GIVEN
        Manager test = new Manager("testName", "testSurname","testposition");
        managerController.saveManager(test);
        List<Manager> actual = managerController.findAllManager().getBody();
        savedID = actual.get(actual.size()-1).getManagerId();

        Manager test1 = new Manager("testUPDATENAME", "testUPDATESURNAME", "testpositionUPDATE");
        expected.add(test1);
        //WHEN
        actual = managerController.updateManager(savedID,test1).getBody();
        //THEN
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void deleteManager_isDeleteCorrect_true () {
        //GIVEN
        Manager test = new Manager("testName", "testSurname","testPosition");
        managerController.saveManager(test);
        List<Manager> actual = managerController.findAllManager().getBody();
        savedID = actual.get(actual.size()-1).getManagerId();
        //WHEN
        actual = managerController.deleteManager(savedID).getBody();
        savedID = null;
        //THEN
        Assert.assertEquals(expected,actual);
    }
    @After
    public void tearDown () {
        if (savedID!=null)
            managerController.deleteManager(savedID);
    }
}