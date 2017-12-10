package Model;

import Graphics.CreditCard;

/**
 * Created by Bianca on 2/11/2017.
 */
public class User implements Cloneable{
    private String name;
    private String mail;
    private int dni;
    private String cellphone;
    private String password;
    private String pais;
    private String provincia;
    private String localidad;
    private String calle;
    private int altura;
    private int cp;
    private ShoppingCart cart;
    

    

    public User(String name, String mail, int dni, String cellphone, String password, String pais, String provincia,
			String localidad, String calle, int altura, int cp) {
		super();
		this.name = name;
		this.mail = mail;
		this.dni = dni;
		this.cellphone = cellphone;
		this.password = password;
		this.pais = pais;
		this.provincia = provincia;
		this.localidad = localidad;
		this.calle = calle;
		this.altura = altura;
		this.cp = cp;
		cart = new ShoppingCart();
	}
	
    

    public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getCellphone() {
		return cellphone;
	}



	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}



	public String getPais() {
		return pais;
	}



	public void setPais(String pais) {
		this.pais = pais;
	}



	public String getProvincia() {
		return provincia;
	}



	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}



	public String getLocalidad() {
		return localidad;
	}



	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}



	public String getCalle() {
		return calle;
	}



	public void setCalle(String calle) {
		this.calle = calle;
	}



	public int getAltura() {
		return altura;
	}



	public void setAltura(int altura) {
		this.altura = altura;
	}



	public int getCp() {
		return cp;
	}



	public void setCp(int cp) {
		this.cp = cp;
	}



	public String getMail() {
		return mail;
	}



	public int getDni() {
		return dni;
	}



	public String getPassword() {
		return password;
	}



	public void logOut(){
        System.out.println("Logged out");
        //cerrar ventana de usuario
    }

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + dni;
		result = prime * result + ((mail == null) ? 0 : mail.hashCode());
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
		User other = (User) obj;
		if (dni != other.dni)
			return false;
		if (mail == null) {
			if (other.mail != null)
				return false;
		} else if (!mail.equals(other.mail))
			return false;
		return true;
	}


	public User clone(){

		Object o = null;
		try{
			o = super.clone();
		}
		catch(CloneNotSupportedException e){}
		return (User) o;
	}



	public boolean addProductToCart(Product product, int quantity){
        if (cart.getProducts().containsKey(product)) {
            if (cart.getProducts().get(product) < quantity) {
                cart.getProducts().put(product, quantity);
                return true;
            }
            else
                return false;
        }
        cart.getProducts().put(product, quantity);
        return true;
    }

    public boolean payCart(CreditCard creditCard, double ammount){
        if (creditCard.hasEnoughBalance(ammount)) {
            creditCard.setBalance(creditCard.getBalance() - ammount);
            return true;
        }
            return false;
    }
    
    
    
  


    
}
