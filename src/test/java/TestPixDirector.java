import org.junit.Test;
import org.junit.Assert;

import com.starkinfra.Settings;
import com.starkinfra.PixDirector;

import java.util.HashMap;


public class TestPixDirector {

    @Test
    public void testCreate() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> data = new HashMap<>();
        data.put("name","Stark Sociedade de Crédito Direto S.A.");
        data.put("taxId","39.908.427/0001-28");
        data.put("phone","+551141164616");
        data.put("email","bacen@starkbank.com");
        data.put("password","12345678");
        data.put("teamEmail","bacen@starkbank.com");
        data.put("teamPhones", new String[] {"+551141164616"});
        PixDirector director = PixDirector.create(new PixDirector(data));

        System.out.println(director);
        Assert.assertEquals(director.name, "Stark Sociedade de Crédito Direto S.A.");
        Assert.assertEquals(director.taxId, "39.908.427/0001-28");
    }
}
