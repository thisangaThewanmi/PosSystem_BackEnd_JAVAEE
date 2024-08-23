package lk.ijse.bo;

import lk.ijse.bo.impl.ItemBoImpl;

public class BoFactory {

    private static BoFactory boFactory ; //The Singleton pattern is used here to ensure that the BoFactory is globally accessible and only one instance exists throughout the application's lifecycle.


    private BoFactory() {

    } //In method so tht the constructor cannot be called from the outside

    public static BoFactory getBoFactory() {
        return (boFactory == null) ? boFactory = new BoFactory() : boFactory;
    } // ussing singleton ensuring only 1 object is created

        public enum BOTypes{
            CUSTOMER,ITEM;
        } //Enums are used here to represent the different types of business objects that the BoFactory can create. It makes the code more readable and type-safe, reducing the risk of errors like passing incorrect or invalid types.


    //The getBo method implements the Factory Method pattern, which encapsulates the logic for creating different types of business objects. This approach centralizes object creation, making the code easier to maintain and extend.
    // For example, if a new business object type needs to be added, you can simply extend the BOTypes enum and add a new case in the switch statement.
        public SuperBo getBo(BOTypes boTypes){
        switch (boTypes){
            case CUSTOMER:
                return new CustomerBoImpl();
                case ITEM:
                    return  new ItemBoImpl();
            default:
                return null;

        }
    }

}


//Summary of Patterns Used:
//Singleton Pattern: Ensures that only one instance of BoFactory exists, providing a global point of access to it.
//Factory Method Pattern: Encapsulates the object creation logic for various business object types, improving maintainability and flexibility.
//Enum: Provides a type-safe way to represent the different types of business objects that can be created.


//Why These Patterns?
//Singleton: Ensures consistency in the use of the factory across the application and saves memory by avoiding multiple instances.
//Factory Method: Decouples the client code from the actual instantiation logic, allowing for easier modifications and extensions.
//Enum: Improves code readability and reduces the chances of errors when dealing with different types of business objects.


