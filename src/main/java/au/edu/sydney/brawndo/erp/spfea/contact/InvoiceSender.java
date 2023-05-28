package au.edu.sydney.brawndo.erp.spfea.contact;

import au.edu.sydney.brawndo.erp.auth.AuthToken;
import au.edu.sydney.brawndo.erp.ordering.Customer;

/**
 * Represents the strategy for sending invoices
 */
public interface InvoiceSender {
    /**
     * Sends a message to a customer
     * @param token token
     * @param customer the destination customer
     * @param data the content of the message
     */
    void sendInvoice(AuthToken token, Customer customer, String data);
}

