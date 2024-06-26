package au.edu.sydney.brawndo.erp.spfea;

import au.edu.sydney.brawndo.erp.auth.AuthToken;
import au.edu.sydney.brawndo.erp.ordering.Customer;

// The class load and delegate operations to the actual customer objects when information is not yet loaded.
public class CustomerProxy implements Customer {
    private int id;
    private CustomerImpl customer;
    private AuthToken authToken;

    public CustomerProxy(AuthToken authToken, int id) {
        this.authToken = authToken;
        this.id = id;
    }

    /**
     * Loads the actual customer object when a method is called on the proxy for the information.
     */
    private void ensureCustomerLoaded() {
        if (customer == null) {
            customer = new CustomerImpl(this.authToken, id);
        }
    }

    public int getId() {
        ensureCustomerLoaded();
        return customer.getId();
    }

    @Override
    public String getfName() {
        ensureCustomerLoaded();
        return customer.getfName();
    }

    @Override
    public String getlName() {
        ensureCustomerLoaded();
        return customer.getlName();
    }

    @Override
    public String getPhoneNumber() {
        ensureCustomerLoaded();
        return customer.getPhoneNumber();
    }

    @Override
    public String getEmailAddress() {
        ensureCustomerLoaded();
        return customer.getEmailAddress();
    }

    @Override
    public String getAddress() {
        ensureCustomerLoaded();
        return customer.getAddress();
    }

    @Override
    public String getSuburb() {
        ensureCustomerLoaded();
        return customer.getSuburb();
    }

    @Override
    public String getState() {
        ensureCustomerLoaded();
        return customer.getState();
    }

    @Override
    public String getPostCode() {
        ensureCustomerLoaded();
        return customer.getPostCode();
    }

    @Override
    public String getMerchandiser() {
        ensureCustomerLoaded();
        return customer.getMerchandiser();
    }

    @Override
    public String getBusinessName() {
        ensureCustomerLoaded();
        return customer.getBusinessName();
    }

    @Override
    public String getPigeonCoopID() {
        ensureCustomerLoaded();
        return customer.getPigeonCoopID();
    }
}
