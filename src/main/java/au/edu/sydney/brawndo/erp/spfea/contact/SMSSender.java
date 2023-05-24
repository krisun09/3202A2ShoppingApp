package au.edu.sydney.brawndo.erp.spfea.contact;

import au.edu.sydney.brawndo.erp.auth.AuthToken;
import au.edu.sydney.brawndo.erp.contact.SMS;
import au.edu.sydney.brawndo.erp.ordering.Customer;

public class SMSSender implements InvoiceSender{
    @Override
    public void sendInvoice(AuthToken token, Customer customer, String data) {
        String smsPhone = customer.getPhoneNumber();
        if (smsPhone != null) {
            SMS.sendInvoice(token, customer.getfName(), customer.getlName(), data, smsPhone);
        }
    }
}
