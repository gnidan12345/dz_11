package perosntest;

import com.rd.person.Man;
import com.rd.person.Woman;
import org.testng.Assert;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WomanTests {
    private Woman woman;
    private Man man;

    @BeforeMethod(alwaysRun = true)
    public void createWoman(){
        woman = new Woman("Kate", "Dase", 25, null, "Btick", false, false);    }


    @BeforeMethod(alwaysRun = true)
    public void createMan(){
        man = new Man("Klark", "Huge", 35, null,  null, false, false);
    }


    @Test

    public  void testisRetired(){

        Assert.assertTrue(woman.isRetired(), "You are not of retirement age");
    }

    @Test(priority = 5)
    public void testRegisterPartnership(){

        woman.registerPartnership(man);
        Assert.assertTrue(woman.isPartnerChanged(),  "Partnership was not registered");
        Assert.assertEquals(woman.getPartner().getFirstName(), man.getFirstName());
        Assert.assertNotEquals(woman.getLastName(), woman.getPreviousLastName());

    }

    @Test(priority = 10)
    public void testDeregisterPartnership(){
        woman.deregisterPartnership(true);
        Assert.assertFalse(woman.isRegisterPartnership());
        Assert.assertEquals(woman.getPreviousLastName(), "Btick");



    }

    @Test(groups = {"ParametersTests"})


    public void testWomanLastName(){
        Assert.assertEquals( woman.getLastName(), "Dase",  "Lastname is not correct");
    }

    @Test(groups = {"ParametersTests"})

    public void testWomanFirstName(){
        Assert.assertEquals(woman.getFirstName(), "Kate", "Firstname is not correct" );

    }

    @Test(groups = {"ParametersTests"})


    public void testWomanAge(){
        Assert.assertEquals(woman.getAge(), 25, "Age is not correct");


    }

    @Test(groups = {"ParametersTests"})
    public void testWomanHasPartner() {
        woman.registerPartnership(man);

        if (woman.isRegisterPartnership() == false) {


            Assert.assertEquals(woman.getPartner(), null);


        }else {
            Assert.assertEquals(woman.getPartner().getFirstName(), man.getFirstName());


        }
    }


    @Test

    public void isRegisterPartnership(){
        woman.registerPartnership(man);
        Assert.assertTrue(woman.isRegisterPartnership(), "Partnership is not valid");
    }



}
