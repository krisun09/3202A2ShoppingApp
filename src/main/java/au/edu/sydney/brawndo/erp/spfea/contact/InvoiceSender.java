package au.edu.sydney.brawndo.erp.spfea.contact;

import au.edu.sydney.brawndo.erp.auth.AuthToken;
import au.edu.sydney.brawndo.erp.ordering.Customer;

public interface InvoiceSender {
    void sendInvoice(AuthToken token, Customer customer, String data);
}

