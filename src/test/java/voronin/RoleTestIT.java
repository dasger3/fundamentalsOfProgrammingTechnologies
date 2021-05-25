package voronin;

import org.junit.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import voronin.context.Application;
import voronin.controller.ManagerController;
import voronin.controller.RoleController;
import voronin.dto.RoleResponseRoleTransfer;
import voronin.exception.ObjectNotFoundException;
import voronin.model.RoleUser;

import java.util.LinkedList;
import java.util.List;


public class RoleTestIT {

    RoleController roleController;
    List<RoleUser> expected = new LinkedList<>();
    Long savedID = null;
    @Before
    public void setUp () {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Application.class);

        roleController = context.getBean(RoleController.class);

        expected = roleController.findAllRoles().getBody();
    }
    @Test
    public void findAllRoles_isFindCorrect_true () {
        //GIVEN
        List<RoleUser> expected1 = new LinkedList<>();
        expected1.add(new RoleUser(1L, "admin", 3));
        expected1.add(new RoleUser(2L, "editor", 2));
        expected1.add(new RoleUser(3L, "user", 1));
        //WHEN
        List<RoleUser> actual = roleController.findAllRoles().getBody();
        //THEN
        Assert.assertEquals(expected1,actual);
    }
    @Test
    public void findRoleByID_isFindCorrect_true () {
        //GIVEN
        RoleUser expected = new RoleUser(2L, "editor", 2);
        //WHEN
        RoleUser actual = roleController.findRoleById(2L).getBody();
        //THEN
        Assert.assertEquals(expected,actual);
    }
    @Test(expected = ObjectNotFoundException.class)
    public void findRoleByID_whenIdIsInvalid_true () {
        //GIVEN
        //WHEN
        roleController.findRoleById(100L);
        //THEN
    }
    @Test
    public void saveRole_isSaveCorrect_true () {
        //GIVEN
        RoleUser test = new RoleUser("test", 10);
        //WHEN
        RoleUser actual = roleController.saveRole(test);
        savedID = actual.getIdRole();
        test.setIdRole(savedID);
        //THEN
        Assert.assertEquals(test,actual);
    }
    @Test
    public void updateRole_isUpdateCorrect_true () {
        //GIVEN
        RoleUser test = new RoleUser("test", 10);
        roleController.saveRole(test);
        List<RoleUser> actual = roleController.findAllRoles().getBody();
        savedID = actual.get(actual.size()-1).getIdRole();

        RoleUser test1 = new RoleUser("testUPDATE", 10);
        expected.add(test1);
        //WHEN
        actual = roleController.updateRole(savedID,test1).getBody();
        //THEN
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void deleteRole_isDeleteCorrect_true () {
        //GIVEN
        RoleUser test = new RoleUser("test", 10);
        roleController.saveRole(test);
        List<RoleUser> actual = roleController.findAllRoles().getBody();
        savedID = actual.get(actual.size()-1).getIdRole();
        //WHEN
        actual = roleController.deleteRole(savedID).getBody();
        savedID = null;
        //THEN
        Assert.assertEquals(expected,actual);
    }
    @After
    public void tearDown () {
        if (savedID!=null)
        roleController.deleteRole(savedID);
    }
}