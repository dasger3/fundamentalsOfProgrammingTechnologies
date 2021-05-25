package voronin;

import org.junit.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import voronin.context.Application;
import voronin.controller.UserController;
import voronin.exception.ObjectNotFoundException;
import voronin.model.RoleUser;
import voronin.model.User;
import voronin.repository.RoleRepository;
import voronin.service.RoleService;
import voronin.service.implementation.RoleServiceImpl;

import java.util.LinkedList;
import java.util.List;


public class UserTestIT {

    AnnotationConfigApplicationContext context;

    UserController userController;
    RoleRepository roleRepository;

    List<User> expected = new LinkedList<>();
    Long savedID = null;

    @Before
    public void setUp () {
        context = new AnnotationConfigApplicationContext(Application.class);

        userController = context.getBean(UserController.class);

        expected = userController.findAllUsers().getBody();
    }
    @Test
    public void findAllUsers_isFindCorrect_true () {
        //GIVEN
        roleRepository = context.getBean(RoleRepository.class);
        List<User> expected1 = new LinkedList<>();
        expected1.add(new User(1L, "Admin","Admin", roleRepository.findById(1L).orElseThrow()));
        //WHEN
        List<User> actual = userController.findAllUsers().getBody();
        //THEN
        Assert.assertEquals(expected1,actual);
    }
    @Test
    public void findUserByID_isFindCorrect_true () {
        //GIVEN
        //WHEN
        User actual = userController.findUserById(1L).getBody();
        //THEN
        Assert.assertEquals(expected.get(0),actual);
    }
    @Test(expected = ObjectNotFoundException.class)
    public void findUserByID_whenIdIsInvalid_true () {
        //GIVEN
        //WHEN
        userController.findUserById(100L);
        //THEN
    }
    @Test
    public void saveUser_isSaveCorrect_true () {
        //GIVEN
        User test = new User("testName", "testSurname");
        expected.add(test);
        //WHEN
        userController.saveUser(test);
        List<User> actual = userController.findAllUsers().getBody();
        savedID = actual.get(actual.size()-1).getId();
        expected.get(expected.size()-1).setId(savedID);
        //THEN
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void updateUser_isUpdateCorrect_true () {
        //GIVEN
        User test = new User("testName", "testSurname");
        userController.saveUser(test);
        List<User> actual = userController.findAllUsers().getBody();
        savedID = actual.get(actual.size()-1).getId();

        User test1 = new User("testUPDATENAME", "testUPDATESURNAME");
        expected.add(test1);
        //WHEN
        actual = userController.updateUser(savedID,test1).getBody();
        //THEN
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void deleteUser_isDeleteCorrect_true () {
        //GIVEN
        User test = new User("testName", "testSurname");
        userController.saveUser(test);
        List<User> actual = userController.findAllUsers().getBody();
        savedID = actual.get(actual.size()-1).getId();
        //WHEN
        actual = userController.deleteUser(savedID).getBody();
        savedID = null;
        //THEN
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void addRoleID_isAddCorrect_true () {
        //GIVEN
        roleRepository = context.getBean(RoleRepository.class);
        User expectedUser = new User("testName", "testSurname");
        userController.saveUser(expectedUser);

        List<User> actual = userController.findAllUsers().getBody();
        savedID = actual.get(actual.size()-1).getId();
        //WHEN
        userController.addRoleId(savedID,1L);
        expectedUser.setRole(roleRepository.findById(1L).orElseThrow());
        //THEN
        Assert.assertEquals(expectedUser,userController.findUserById(savedID).getBody());
    }

    @After
    public void tearDown () {
        if (savedID!=null)
            userController.deleteUser(savedID);
    }
}