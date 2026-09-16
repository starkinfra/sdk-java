import org.junit.Test;
import org.junit.Assert;

import com.starkinfra.Settings;
import com.starkinfra.CreditNote;
import com.starkinfra.CreditSigner;
import com.starkcore.error.InputErrors;

import java.util.List;

import static org.junit.Assert.assertThrows;

public class TestCreditSigner {

    @Test
    public void testResendToken() throws Exception {
        Settings.user = utils.User.defaultProject();

        List<CreditNote> notes = CreditNote.create(TestCreditNote.exampleWithObject());
        CreditNote note = notes.get(0);
        Assert.assertTrue(note.signers.size() > 0);

        String signerId = null;
        for (CreditSigner signer : note.signers) {
            if (!signer.name.toLowerCase().trim().startsWith("stark")) {
                signerId = signer.id;
                break;
            }
        }
        if (signerId == null) {
            Assert.fail("No signer found");
        }

        CreditSigner signer = CreditSigner.resendToken(signerId);
        Assert.assertEquals(signerId, signer.id);
    }

    @Test
    public void testResendTokenNotFound() throws Exception {
        Settings.user = utils.User.defaultProject();

        assertThrows(InputErrors.class, () -> {
            CreditSigner.resendToken("000");
        });
    }
}
