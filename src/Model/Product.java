package Model;

/**
 * Created by Bianca on 2/11/2017.
 */
//Class description :
//The product defines an item that can be sold and exposed on the website.
public class Product implements Cloneable{
    //public parameters

    // private parameters
    private String name;
    private String description;
    private String photoPath;
    private double price;
    private int stock;
    private String category;

    //public methods
    public Product(){

    }
    public Product(String pName, String pDescription){
        this.name = pName;
        this.description = pDescription;
    }
    public Product(String pName, String pDescription, String photoP, double pPrice, int pStock, String category){
        this.name = pName;
        this.description = pDescription;
        if(  pPrice < 0 || pStock < 0) {
            // for now we don't do anything (this should be check in the controller package and not in the model package IMO)
            System.out.println("Wrong assignement");
        }
        this.photoPath = photoP;
        this.price = pPrice;
        this.stock = pStock;
        this.category = category;
    }
    public Product clone(){

        Object o = null;
        try{
            o = super.clone();
        }
        catch(CloneNotSupportedException e){}
        return (Product) o;
    }
    //getters and setters
    public void setName(String pName){
        this.name = pName;
    }
    public String getName(){
        return this.name;
    }
    public void setDescription(String pDescription){
        this.description = pDescription;
    }
    public String getDescription(){
        return this.description;
    }
   
    public String  getPhotoPath(){
        return this.photoPath;
    }
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	public void setPrice(double pPrice){
        this.price = pPrice;
    }
    public double  getPrice(){
        return this.price;
    }
    public void setStock(int pStock){
        this.stock = pStock;
    }
    public int getStock(){
        return this.stock;
    }
    /*public void setCategory(Category pType){
        this.typeOfProduct = pType;
    }*/
    public String getCategory(){
        return this.category;
    }

    //private methods



}