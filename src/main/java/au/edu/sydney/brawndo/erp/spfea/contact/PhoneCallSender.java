package au.edu.sydney.brawndo.erp.spfea.contact;

import au.edu.sydney.brawndo.erp.auth.AuthToken;
import au.edu.sydney.brawndo.erp.contact.PhoneCall;
import au.edu.sydney.brawndo.erp.ordering.Customer;

public class PhoneCallSender implements InvoiceSender{
    @Override
    public void sendInvoice(AuthToken token, Customer customer, String data) {
        String phone = customer.getPhoneNumber();
        if (phone != null) {
            PhoneCall.sendInvoice(token, customer.getfName(), customer.getlName(), data, phone);
        }
    }
}
