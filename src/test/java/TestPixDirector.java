import com.starkinfra.PixDirector;
import com.starkinfra.Settings;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;


public class TestPixDirector {

    @Test
    public void testCreate() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> data = new HashMap<>();
        data.put("name","Eddard Stark");
        data.put("taxId","012.345.678-90");
        data.put("phone","+55-11998989898");
        data.put("email","eddard@starkbank.com");
        data.put("password","12345678");
        data.put("teamEmail","starkfamily@starkbank.com");
        data.put("teamPhones", new String[] {"+55-11997979797", "+55-11996969696"});
        PixDirector director = PixDirector.create(new PixDirector(data));

        System.out.println(director);
        Assert.assertEquals(director.name, "Eddard Stark");
        Assert.assertEquals(director.taxId, "012.345.678-90");
    }
}
