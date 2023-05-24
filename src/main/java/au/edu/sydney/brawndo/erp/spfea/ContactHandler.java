package au.edu.sydney.brawndo.erp.spfea;

import au.edu.sydney.brawndo.erp.auth.AuthToken;
import au.edu.sydney.brawndo.erp.ordering.Customer;
import au.edu.sydney.brawndo.erp.spfea.*;
import au.edu.sydney.brawndo.erp.spfea.contact.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContactHandler {

    private static final Map<ContactMethod, InvoiceSender> senderMap = new HashMap<>();

    static {
        senderMap.put(ContactMethod.SMS, new SMSSender());
        senderMap.put(ContactMethod.MAIL, new MailSender());
        senderMap.put(ContactMethod.EMAIL, new EmailSender());
        senderMap.put(ContactMethod.PHONECALL, new PhoneCallSender());
        senderMap.put(ContactMethod.MERCHANDISER, new MerchandiserSender());
        senderMap.put(ContactMethod.CARRIER_PIGEON, new CarrierPigeonSender());
    }

    public static boolean sendInvoice(AuthToken token, Customer customer, List<ContactMethod> priority, String data) {
        for (ContactMethod method : priority) {
            InvoiceSender sender = senderMap.get(method);
            if (sender != null) {
                sender.sendInvoice(token, customer, data);
                return true;
            }
//            switch (method) {
//                case SMS:
//                    String smsPhone = customer.getPhoneNumber();
//                    if (null != smsPhone) {
//                        SMS.sendInvoice(token, customer.getfName(), customer.getlName(), data, smsPhone);
//                        return true;
//                    }
//                    break;
//                case MAIL:
//                    String address = customer.getAddress();
//                    String suburb = customer.getSuburb();
//                    String state = customer.getState();
//                    String postcode = customer.getPostCode();
//                    if (null != address && null != suburb &&
//                        null != state && null != postcode) {
//                        Mail.sendInvoice(token, customer.getfName(), customer.getlName(), data, address, suburb, state, postcode);
//                        return true;
//                    }
//                    break;
//                case EMAIL:
//                    String email = customer.getEmailAddress();
//                    if (null != email) {
//                        Email.sendInvoice(token, customer.getfName(), customer.getlName(), data, email);
//                        return true;
//                    }
//                    break;
//                case PHONECALL:
//                    String phone = customer.getPhoneNumber();
//                    if (null != phone) {
//                        PhoneCall.sendInvoice(token, customer.getfName(), customer.getlName(), data, phone);
//                        return true;
//                    }
//                    break;
//                case MERCHANDISER:
//                    String merchandiser = customer.getMerchandiser();
//                    String businessName = customer.getBusinessName();
//                    if (null != merchandiser && null != businessName) {
//                        Merchandiser.sendInvoice(token, customer.getfName(), customer.getlName(), data, merchandiser,businessName);
//                        return true;
//                    }
//                    break;
//                case CARRIER_PIGEON:
//                    String pigeonCoopID = customer.getPigeonCoopID();
//                    if (null != pigeonCoopID) {
//                        CarrierPigeon.sendInvoice(token, customer.getfName(), customer.getlName(), data, pigeonCoopID);
//                        return true;
//                    }
//                    break;
//                default:
//                    return false;
//            }
        }
        return false;
    }

    public static List<String> getKnownMethods() {
        return Arrays.asList(
                "Carrier Pigeon",
                "Email",
                "Mail",
                "Merchandiser",
                "Phone call",
                "SMS"
        );
    }
}
