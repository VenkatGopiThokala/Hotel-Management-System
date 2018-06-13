package com.h2database.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rooms")
public class Room implements Serializable {
	
	private static final long serialVersionUID = -3009157732242341606L;
	@Id
	@Column(name = "id")
    private long id;
	
    @Column(name = "type")
    private String type;
    
    @Column(name = "count")
    private String count;
    
    @Column(name = "price")
    private String price;
    
    @Column(name = "image1")
    private String image1;
    
    @Column(name = "image2")
    private String image2;
    
    @Column(name = "image3")
    private String image3;
    
    @Column(name = "image4")
    private String image4;
    
    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getImage1() {
		return image1;
	}

	public void setImage1(String image1) {
		this.image1 = image1;
	}

	public String getImage2() {
		return image2;
	}

	public void setImage2(String image2) {
		this.image2 = image2;
	}

	public String getImage3() {
		return image3;
	}

	public void setImage3(String image3) {
		this.image3 = image3;
	}

	public String getImage4() {
		return image4;
	}

	public void setImage4(String image4) {
		this.image4 = image4;
	}
	
	public Room() {
		
	}
	
	public Room(String type, String count, String price, String image1, String image2, String image3, String image4) {
		this.type = type;
		this.count = count;
		this.price = price;
		this.image1 = image1;
		this.image2 = image2;
		this.image3 = image3;
		this.image4 = image4;
	}

	public Room(long id, String type, String count, String price, String image1, String image2, String image3,
			String image4) {
		this.id = id;
		this.type = type;
		this.count = count;
		this.price = price;
		this.image1 = image1;
		this.image2 = image2;
		this.image3 = image3;
		this.image4 = image4;
	}

	@Override
    public String toString() {
        return String.format("Room[id=%d, type='%s', count='%s', price='%s', image1='%s', image2='%s', image3='%s', image4='%s']",
        		id, type, count, price, image1, image2, image3, image4);
    }

}
