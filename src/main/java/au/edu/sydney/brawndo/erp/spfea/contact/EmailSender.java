package au.edu.sydney.brawndo.erp.spfea.contact;

import au.edu.sydney.brawndo.erp.auth.AuthToken;
import au.edu.sydney.brawndo.erp.contact.Email;
import au.edu.sydney.brawndo.erp.ordering.Customer;

public class EmailSender implements InvoiceSender{
    @Override
    public void sendInvoice(AuthToken token, Customer customer, String data) {
        String email = customer.getEmailAddress();
        if (email != null) {
            Email.sendInvoice(token, customer.getfName(), customer.getlName(), data, email);
        }
    }
}
