package au.edu.sydney.brawndo.erp.spfea.contact;

import au.edu.sydney.brawndo.erp.auth.AuthToken;
import au.edu.sydney.brawndo.erp.contact.Merchandiser;
import au.edu.sydney.brawndo.erp.ordering.Customer;

public class MerchandiserSender implements InvoiceSender{
    @Override
    public void sendInvoice(AuthToken token, Customer customer, String data) {
        String merchandiser = customer.getMerchandiser();
        String businessName = customer.getBusinessName();
        if (merchandiser != null && businessName != null) {
            Merchandiser.sendInvoice(token, customer.getfName(), customer.getlName(), data, merchandiser, businessName);
        }
    }
}
