package au.edu.sydney.brawndo.erp.spfea.contact;

import au.edu.sydney.brawndo.erp.auth.AuthToken;
import au.edu.sydney.brawndo.erp.contact.CarrierPigeon;
import au.edu.sydney.brawndo.erp.ordering.Customer;

public class CarrierPigeonSender implements InvoiceSender {
    @Override
    public void sendInvoice(AuthToken token, Customer customer, String data) {
        String pigeonCoopID = customer.getPigeonCoopID();
        if (pigeonCoopID != null) {
            CarrierPigeon.sendInvoice(token, customer.getfName(), customer.getlName(), data, pigeonCoopID);
        }
    }
}
