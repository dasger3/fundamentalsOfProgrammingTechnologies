package voronin;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import voronin.context.Application;
import voronin.controller.ManagerController;
import voronin.controller.RoleController;
import voronin.exception.ObjectNotFoundException;
import voronin.model.RoleUser;

import java.util.LinkedList;
import java.util.List;


public class RoleTestIT {

    RoleController roleController;
    List<RoleUser> expected = new LinkedList<>();
    @Before
    public void setUp () {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Application.class);

        roleController = context.getBean(RoleController.class);

        expected.add(new RoleUser(1L, "admin", 3));
        expected.add(new RoleUser(2L, "editor", 2));
        expected.add(new RoleUser(3L, "user", 1));
    }
    @Test
    public void findAllRoles_isFindCorrect_true () {
        //GIVEN
        //WHEN
        List<RoleUser> actual = roleController.findAllRoles();
        //THEN
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void findRoleByID_isFindCorrect_true () {
        //GIVEN
        RoleUser expected = new RoleUser(2L, "editor", 2);
        //WHEN
        RoleUser actual = roleController.findRoleById(2L);
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
        RoleUser test = new RoleUser(4L, "test", 10);
        expected.add(test);
        //WHEN
        roleController.saveRole(test);
        List<RoleUser> actual = roleController.findAllRoles();
        //THEN
        Assert.assertEquals(expected,actual);
        //roleController.deleteRole();
    }
    @Test
    public void updateRole_isSaveCorrect_true () {
        //GIVEN
        RoleUser test = new RoleUser(4L,"testUpdate", 10);
        expected.add(test);
        //WHEN
        roleController.updateRole(test.getIdRole(), test);
        List<RoleUser> actual = roleController.findAllRoles();
        //THEN
        Assert.assertEquals(expected,actual);
    }
    @After
    public void tearDown () {
        //roleController.deleteRole(4L);
    }
}