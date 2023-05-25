# Assignment 2: Design Patterns

## Solutions to the Key Issues

### RAM Issue

#### Flyweight Pattern

- Flyweight Factory: ProductDataFactory
- Flyweight: ProductData
- Client: ProductImpl

##### Solution Summary

- ProductImpl has been modified to store a reference in its constructor to a shared Flyweight object instead of maintaining lots of arrays
  for each product.

- A Flyweight factory is created which is responsible for creating and managing the shared Flyweight objects.
This class should ensure that only one instance of each unique Flyweight object is created and shared among the Product objects.

##### Solution Benefit

- The Flyweight Pattern can reduce the number of object with repetitive data by allowing sharing of data among multiple objects, 
  thus save memory. 
- By reducing memory usage, the Flyweight Pattern can improve the overall performance of the application, as it reduces 
  the time required for object creation and garbage collection. 

### Too Many Orders

#### Alternative Solution (400 words max)

##### Solution Summary

The solution summary goes here, you should describe what changes you have made to the codebase, be specific to the classes and methods you changed and how.

##### Solution Benefit

How did you solution solve the problem, be brief.

### Bulky Contact Method
#### Strategy Pattern

- Strategy: InvoiceSender
- Concrete Strategies: 
  - CarrierPigeonSender 
  - EmailSender 
  - InvoiceSender 
  - MailSender 
  - MerchandiserSender 
  - PhoneCallSender 
  - SMSSender
- Context: ContactHandler
- Client: SPFEAFacade

##### Solution Summary

- In ContactHandler, the switch for different contact methods has been removed. Instead, I have added a static map storing 
  contact methods and their corresponding sender objects. Then sendInvoice() only needs to call 
  sender.sendInvoice(token, customer, data) to let the senders handle the contacting logic. 
- I have added an InvoiceSender Interface that has simply the one method: sendInvoice(token, customer, data). 
  If more methods of contacting is required, one will only need to overide InvoiceSender and implement its own contacting logic. 
  As demonstrated with the list of sender objects. 
##### Solution Benefit

- By applying the Strategy pattern, the logic for each contact method within its respective InvoiceSender implementation is encapsulated. 
  The ContactHandler class no longer needs to handle the details of each method, 
  it simply iterates over the list of InvoiceSender objects and invokes the sendInvoice method, which is implemented differently for each strategy.
  This allows easily addition or modification contact methods without having to modify the ContactHandler class itself.

### System Lag

#### Lazy Load

##### Solution Summary

- SPFEAFacade's getCustomer(): changed "return new CustomerImpl(token, id);" to "return new CustomerProxy(token, id);"
- The CustomerProxy class acts as a proxy for the customer object and only loads the actual customer object when a method is called on the proxy.
- The CustomerImpl class represents the actual customer object and loads all the customer data from the database when instantiated.

##### Solution Benefit

- The proxy ensures that the customer data is loaded from the database only when needed, thus providing lazy loading behavior
  that minimizing the initial loading time and improving performance.

### Hard to Compare Products

#### Value Object

##### Solution Summary

- Override the .equals() and .hashcode() method in ProductData class. 
##### Solution Benefit

- The methods provide a simpler, value-based equality comparison instead of manually comparing each individual field

### Slow Order Creation


## Notes About the Submission


TestDataBase.simulateSlowDatabase()