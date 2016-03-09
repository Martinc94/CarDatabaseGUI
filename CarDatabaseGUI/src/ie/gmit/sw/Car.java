package ie.gmit.sw;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Car {
	private int id;
	private String reg;
	private String make;
	private String model;
	private String colour;
	private Double price;
	private String description;
	private File picture;
	
	public Car(int id, String reg, String make, String model, String colour, Double price, String description,File picture) {
		//Constructor for Existing Car
		this.id = id;
		this.reg = reg;
		this.make = make;
		this.model = model;
		this.colour = colour;
		this.price = price;
		this.description = description;
		this.picture = picture;
		
	}
	
	public Car(String make, String model,String reg, String colour, Double price, String description,File picture) {
		//Constructor for new Car
		//for new car 0 gets assigned a new id in database
		this.id = 0;
		this.reg = reg;
		this.make = make;
		this.model = model;
		this.colour = colour;
		this.price = price;
		this.description = description;
		this.picture = picture;
		
		//addToDB();
		
	}
	
	public Car(String make, String model,String reg, String colour, Double price, String description) {
		//for new car 0 gets assigned a new id in database
		////Constructor for new car for no picture
		this.id = 0;
		this.reg = reg;
		this.make = make;
		this.model = model;
		this.colour = colour;
		this.price = price;
		this.description = description;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getReg() {
		return reg;
	}

	public void setReg(String reg) {
		this.reg = reg;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public File getPicture() {
		return picture;
	}

	public void setPicture(File picture) {
		this.picture = picture;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", reg=" + reg + ", make=" + make + ", model=" + model + ", colour=" + colour
				+ ", price=" + price + ", description=" + description + ", picture=" + picture + "]";
	}
	
	/*public boolean addedToDB(String make,String model,String reg,String colour,String price,String description) {
		boolean added;
		added=addToDB(make, model, reg, colour, price, description);
		return added;
	}*/
	
	public boolean addToDB(String make,String model,String reg,String colour,String price,String description) {
		boolean added=true;
		Driver d = new Driver();
		Connection conn;
		try {
			conn = d.getConn();
			
			Statement stmt = conn.createStatement();	
			
			String sql = "Insert into car (id,reg,make,model,colour,price,description,picture) "+						
					"values ('"+id+ "','"+ reg+"','"+ make+"','"+ model+"','"+ colour+"','"+ price+"','"+ description+"',"+ picture+")";
			
			stmt.executeUpdate(sql);
			//System.out.println(sql);
			
			//System.out.println("Insert complete.");	
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error Inserting to database Try Again.");
			added=false;
		}
		return added;

	}

}
