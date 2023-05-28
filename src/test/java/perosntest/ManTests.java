package perosntest;

import com.rd.person.Man;
import com.rd.person.Person;
import com.rd.person.Woman;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ManTests {

    private Man man;
    private Woman woman;



    @BeforeMethod(alwaysRun = true)

    public void createMan(){
        man = new Man("Klark", "Huge", 66, null,  null, false, false);

    }

    @BeforeMethod(alwaysRun = true)

    public void createWoman(){


        woman = new Woman("Kate", "Dase", 42);
    }


    @Test

    public  void testisRetired(){

        Assert.assertTrue(man.isRetired(), "You are not of retirement age");

    }

    @Test(priority = 5)
    public void testRegisterPartnership(){

        man.registerPartnership(woman);
        Assert.assertTrue(man.isPartnerChanged(),  "Partnership was not registered");
        Assert.assertEquals(man.getPartner().getFirstName(), woman.getFirstName());
        System.out.println(man.getPartner().getFirstName());

    }

    @Test(priority = 10)
    public void testDeregisterPartnership(){
        man.deregisterPartnership(true);
        Assert.assertFalse(man.isRegisterPartnership());


    }

    @Test(groups = {"ParametersTests"})


    public void testManLastName(){

        Assert.assertEquals( man.getLastName(), "Huge",  "Lastname is not correct");
    }

    @Test(groups = {"ParametersTests"})

    public void testManFirstName(){

        Assert.assertEquals(man.getFirstName(), "Klark", "Firstname is not correct" );

    }

    @Test(groups = {"ParametersTests"})


    public void testManAge(){
        Assert.assertEquals(man.getAge(), 66, "Age is not correct");


    }

    @Test(groups = {"ParametersTests"})
    public void testHasPartner() {

        if (man.isRegisterPartnership() == false) {

            Assert.assertEquals(man.getPartner(), null);
        }else {
            Assert.assertEquals(man.getPartner().getFirstName(), woman.getFirstName());
        }
    }


    @Test

    public void isRegisterPartnership(){
        man.registerPartnership(woman);
        Assert.assertTrue(man.isRegisterPartnership(), "You are not married");
    }







}

