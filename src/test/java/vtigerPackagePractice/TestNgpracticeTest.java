package vtigerPackagePractice;

import org.testng.Assert;
import org.testng.annotations.Test;
/**
 *  we are checking all flags
 * @author admin
 *
 */
public class TestNgpracticeTest {
@Test
public void create()
{
	Assert.fail();
	System.out.println("create");
}
//@Test(invocationCount = 0,priority = 1)  //disabled if we give IC=0

@Test(dependsOnMethods = "create")
public void modify()
{
	System.out.println("modify");
}
@Test(dependsOnMethods = {"create","modify"})
public void delete()
{
	System.out.println("delete");
}
}
