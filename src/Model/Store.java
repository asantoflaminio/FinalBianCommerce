package Model;

import javax.print.attribute.URISyntax;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;

/**
 *  Wrapper careTaker class for the underlying StoreMemento class. Model.Store contains solely the current
 *  instance of the store and the memento to which the system can return were it to fail, in addition
 *  to methods purely to interface with the underlying store.
 *   This careTaker class is in itself a Singleton, for each system will and can only contain one store.
 */
public class Store{

    /**
     * Your run-of-the-mill singleton methods and parameters to avoid instantiation.
     */
    private static final Store INSTANCE = new Store();
    private Store(){}
    public static Store getInstace(){ return INSTANCE;}

    /**
     *  Memento pattern parameters which are to be used as the two separate instances of the store.
     * The importance of these is explained in the SuccessfulSystem and failureInSystem methods.
     */
    private StoreMemento current;
    private StoreMemento memento;

    /**
     * initializes the stores (the memento and the current instance) only if they weren't previously
     * initialized, thus making them pseudo-singletons.
     * @param brandName the name of the brand using the system.
     * @param URI
     * @param logo logo of the brand using the system.
     * @param admin administrator of the store.
     */
    public void initializeStore(String brandName, String URI, Image logo, Admin admin){
        if(current != null) return;
        StoreMemento current = new StoreMemento(brandName,URI, logo, admin);
        StoreMemento memento = current;
    }

    /**
     *  Where to be a failure in the System, the failureInSystem method returns the store
     *  to a previous iteration prior to the error.
     *   The successfulSystem method is to be called only after it is certain that the current
     *  version contains no errors and thus the system can roll back to it in the future.
     */
    public void failureInSystem(){current = memento.copy();}
    public void successfulSystem(){memento = current.copy();}

    public void addProduct(Product p){ current.addProduct(p);}
    public void removeProduct(Product p){current.removeProduct(p);}

    public void addUser(User u){current.addUser(u);}
    public void removeUser(User u){current.removeUser(u);}

    public boolean userExists(User u){return current.userExists(u);}
    public boolean productExists(Product p){return current.productExists(p);}

    private class StoreMemento{

        private String brandName;
        private String URI;
        private Image logo;
        private Admin admin;
        ArrayList<Product> products = new ArrayList<>();
        ArrayList<User> users = new ArrayList<>();


        public StoreMemento(String brandName, String URI, Image logo, Admin admin){
            this.brandName = brandName;
            this.admin = admin;
            this.URI = URI;
            this.logo = logo;
        }

        public void addProduct(Product p){ products.add(p);}
        public void removeProduct(Product p){ products.remove(p);}

        public void addUser(User u){ users.add(u);}
        public void removeUser(User u){ users.remove(u);}

        public boolean userExists(User u){return users.contains(u);}
        public boolean productExists(Product p){return products.contains(p);}

        public StoreMemento copy(){
            StoreMemento ret = new StoreMemento(brandName, URI, logo, admin);
            for(User u: users)
                ret.addUser(u.clone());
            for(Product p: products)
                ret.addProduct(p.clone());
            return ret;
        }
    }
}