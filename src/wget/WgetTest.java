package wget;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class WgetTest {
	private String input;
	private boolean expected;
	
	public WgetTest(String input,boolean expected){  
        this.input = input;
        this.expected =  expected;     
    }

	@Parameters
	@SuppressWarnings("unchecked")
    public static Collection prepareData(){  
        Object[][] object = {{"",false},{"http://www.baidu.com",true},{"www.baidu.com",false},{"http://",false},{"http://dow3.pc6.com/gm/EditPlus3_ha.zip",true}};  
        return Arrays.asList(object);  
    }

	@Test
	public void testSaveFile() {
		Wget wget = new Wget();
		boolean result = wget.saveFile(input);
		Assert.assertEquals(expected, result);
	}

}
