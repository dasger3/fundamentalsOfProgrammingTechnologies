package voronin;

import org.junit.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import voronin.context.Application;
import voronin.controller.ATUController;
import voronin.controller.ManagerController;
import voronin.exception.ObjectNotFoundException;
import voronin.model.AdministrativeTerritorialUnit;
import voronin.model.TypeOfATU;
import voronin.model.User;
import voronin.repository.ManagerRepository;
import voronin.repository.RoleRepository;

import java.util.LinkedList;
import java.util.List;


public class ATUTestIT {

    AnnotationConfigApplicationContext context;
    ATUController ATUController;
    ManagerController managerController;
    List<AdministrativeTerritorialUnit> expected = new LinkedList<>();
    Long savedID = null;

    @Before
    public void setUp () {
        context = new AnnotationConfigApplicationContext(Application.class);

        ATUController = context.getBean(ATUController.class);
        managerController = context.getBean(ManagerController.class);

        expected = ATUController.findAllATU();
    }
    @Test
    public void findAllATUs_isFindCorrect_true () {
        //GIVEN
        List<AdministrativeTerritorialUnit> expected1 = new LinkedList<>();
        expected1.add(new AdministrativeTerritorialUnit(1L, null,        null,  TypeOfATU.REGION, "Kyivska", 4141, 123, managerController.findManagerById(1L)));
        expected1.add(new AdministrativeTerritorialUnit(2L,  expected1.get(0), null,  TypeOfATU.CITY, "Kyiv", 876, 636363, managerController.findManagerById(2L)));
        expected1.add(new AdministrativeTerritorialUnit(3L,  expected1.get(0), null,  TypeOfATU.CITY, "Poltava", 5346, 234, managerController.findManagerById(3L)));
        expected1.add(new AdministrativeTerritorialUnit(4L,  expected1.get(0), null,  TypeOfATU.VILLAGE, "Veliky Vuyki", 876, 441, managerController.findManagerById(4L)));
        expected1.add(new AdministrativeTerritorialUnit(5L,  expected1.get(0), null,  TypeOfATU.VILLAGE, "Sinelniko", 234, 12, managerController.findManagerById(5L)));
        expected1.add(new AdministrativeTerritorialUnit(6L,  expected1.get(1), null,  TypeOfATU.DISTRICT, "Center", 23, 234, managerController.findManagerById(6L)));
        expected1.add(new AdministrativeTerritorialUnit(7L,  expected1.get(1), null,  TypeOfATU.DISTRICT, "South", 12, 414, managerController.findManagerById(7L)));
        expected1.add(new AdministrativeTerritorialUnit(8L,  expected1.get(2), null,  TypeOfATU.DISTRICT, "West", 626, 53, managerController.findManagerById(8L)));
        expected1.add(new AdministrativeTerritorialUnit(9L,  expected1.get(2), null,  TypeOfATU.DISTRICT, "Babuskin", 23, 121, managerController.findManagerById(9L)));
        expected1.add(new AdministrativeTerritorialUnit(10L, expected1.get(2), null,  TypeOfATU.DISTRICT, "Idustrial", 12, 121, managerController.findManagerById(10L)));
        expected1.get(0).setCenter_id(expected1.get(1));
        expected1.get(1).setCenter_id(expected1.get(3));
        expected1.get(2).setCenter_id(expected1.get(9));
        //WHEN
        List<AdministrativeTerritorialUnit> actual = ATUController.findAllATU();
        //THEN
        Assert.assertEquals(expected1,actual);
    }
    @Test
    public void findATUByID_isFindCorrect_true () {
        //GIVEN
        //WHEN
        AdministrativeTerritorialUnit actual = ATUController.findATUById(2L);
        //THEN
        Assert.assertEquals(expected.get(1),actual);
    }
    @Test(expected = ObjectNotFoundException.class)
    public void findATUByID_whenIdIsInvalid_true () {
        //GIVEN
        //WHEN
        ATUController.findATUById(100L);
        //THEN
    }
    @Test
    public void findATUByName_isFindCorrect_true () {
        //GIVEN
        //WHEN
        AdministrativeTerritorialUnit actual = ATUController.findATUByTitle("Kyivska");
        //THEN
        Assert.assertEquals(expected.get(0),actual);
    }
    @Test(expected = ObjectNotFoundException.class)
    public void findATUByName_whenNameIsInvalid_true () {
        //GIVEN
        //WHEN
        ATUController.findATUByTitle("ErrorName");
        //THEN
    }
    @Test
    public void saveATU_isSaveCorrect_true () {
        //GIVEN
        AdministrativeTerritorialUnit test = new AdministrativeTerritorialUnit(TypeOfATU.CITY,"testTitle", 123, 4141);
        expected.add(test);
        //WHEN
        ATUController.saveATU(test);
        List<AdministrativeTerritorialUnit> actual = ATUController.findAllATU();
        savedID = actual.get(actual.size()-1).getAtuId();
        expected.get(expected.size()-1).setAtuId(savedID);
        //THEN
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void updateATU_isUpdateCorrect_true () {
        //GIVEN
        AdministrativeTerritorialUnit test = new AdministrativeTerritorialUnit(TypeOfATU.CITY,"testName", 1,2);
        ATUController.saveATU(test);
        List<AdministrativeTerritorialUnit> actual = ATUController.findAllATU();
        savedID = actual.get(actual.size()-1).getAtuId();

        AdministrativeTerritorialUnit test1 = new AdministrativeTerritorialUnit(TypeOfATU.CITY,"testUPDATENAME", 2, 4);
        expected.add(test1);
        //WHEN
        actual = ATUController.updateATU(savedID,test1);
        //THEN
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void deleteATU_isDeleteCorrect_true () {
        //GIVEN
        AdministrativeTerritorialUnit test = new AdministrativeTerritorialUnit(TypeOfATU.CITY,"testName", 1,2);
        ATUController.saveATU(test);
        List<AdministrativeTerritorialUnit> actual = ATUController.findAllATU();
        savedID = actual.get(actual.size()-1).getAtuId();
        //WHEN
        actual = ATUController.deleteATU(savedID);
        savedID = null;
        //THEN
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void addParent_isAddCorrect_true () {
        //GIVEN
        AdministrativeTerritorialUnit expectedAtu = new AdministrativeTerritorialUnit(TypeOfATU.CITY,"testName", 1,2);
        ATUController.saveATU(expectedAtu);

        List<AdministrativeTerritorialUnit> actual = ATUController.findAllATU();
        savedID = actual.get(actual.size()-1).getAtuId();
        //WHEN
        ATUController.addParentATU(savedID,1L);
        expectedAtu.setParent(ATUController.findATUById(1L));
        //THEN
        Assert.assertEquals(expectedAtu,ATUController.findATUById(savedID));
    }
    @Test
    public void addCenter_isAddCorrect_true () {
        //GIVEN
        AdministrativeTerritorialUnit expectedAtu = new AdministrativeTerritorialUnit(TypeOfATU.CITY,"testName", 1,2);
        ATUController.saveATU(expectedAtu);

        List<AdministrativeTerritorialUnit> actual = ATUController.findAllATU();
        savedID = actual.get(actual.size()-1).getAtuId();
        //WHEN
        ATUController.addCenterATU(savedID,1L);
        expectedAtu.setCenter_id(ATUController.findATUById(1L));
        //THEN
        Assert.assertEquals(expectedAtu,ATUController.findATUById(savedID));
    }
    @Test
    public void addManager_isAddCorrect_true () {
        //GIVEN
        ManagerRepository managerRepository = context.getBean(ManagerRepository.class);
        AdministrativeTerritorialUnit expectedAtu = new AdministrativeTerritorialUnit(TypeOfATU.CITY,"testName", 1,2);
        ATUController.saveATU(expectedAtu);

        List<AdministrativeTerritorialUnit> actual = ATUController.findAllATU();
        savedID = actual.get(actual.size()-1).getAtuId();
        //WHEN
        ATUController.addManagerToATU(savedID,11L);
        expectedAtu.setManager(managerRepository.findById(11L).orElseThrow());
        //THEN
        Assert.assertEquals(expectedAtu,ATUController.findATUById(savedID));
    }
    @After
    public void tearDown () {
        if (savedID!=null)
            ATUController.deleteATU(savedID);
    }
}