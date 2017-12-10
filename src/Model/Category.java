package Model;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Bianca on 2/11/2017.
 */
//Class description :
//The category defines a set of items that can be put the same area of use. It helps to clarify queries.
public class Category {
    //public parameters

    // private parameters
    private String name;
    private String description;
    private ArrayList<Category> subCategories;
    private Image image;

    //public methods
    public Category(){

    }
    public Category(String pName, String pDescription){
        this.name = pName;
        this.description = pDescription;
    }
    public Category(String pName, String pDescription, Image pImage){
        this.name = pName;
        this.description = pDescription;
        this.image = pImage;
    }
    public Category(String pName, String pDescription,Image image, ArrayList<Category> pSubCategories){
        this.name = pName;
        this.description = pDescription;
        this.image = image;
        this.subCategories = pSubCategories;
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
    public void setImage(Image pImage){
        this.image = pImage;
    }
    public Image getImage(){
        return this.image;
    }
    public void setSubCategories(ArrayList<Category> pSubCategories){
        this.subCategories = pSubCategories;
    }
    public ArrayList<Category> getSubCategories(){
        return this.subCategories;
    }
    //private methods



}
