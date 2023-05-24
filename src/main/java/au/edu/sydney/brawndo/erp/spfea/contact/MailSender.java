package au.edu.sydney.brawndo.erp.spfea.contact;

import au.edu.sydney.brawndo.erp.auth.AuthToken;
import au.edu.sydney.brawndo.erp.contact.Mail;
import au.edu.sydney.brawndo.erp.ordering.Customer;

public class MailSender implements InvoiceSender{
    @Override
    public void sendInvoice(AuthToken token, Customer customer, String data) {
        String address = customer.getAddress();
        String suburb = customer.getSuburb();
        String state = customer.getState();
        String postcode = customer.getPostCode();
        if (address != null && suburb != null && state != null && postcode != null) {
            Mail.sendInvoice(token, customer.getfName(), customer.getlName(), data, address, suburb, state, postcode);
        }
    }
}
