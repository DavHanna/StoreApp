package storeApp.action;


import java.sql.Timestamp;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import storeApp.User.User;
import storeApp.product.Product;
import storeApp.store.Store;

@Entity
public class Action {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	public int id;
	@ManyToOne
    @JoinColumn(name = "user_id")
	public User user;
	@ManyToOne
    @JoinColumn(name = "store_id")
	public Store store;
	@ManyToOne
    @JoinColumn(name = "product_id")
	public Product product;
	public String description;
	
	public Timestamp timestamp;
	
	public Action() {}
	
	public Action(User user, Store store, Product product, String description)
	{
		this.user = user;
		this.store = store;
		this.product = product;
		this.description = description;
		this.timestamp = new Timestamp(System.currentTimeMillis());
	}
}
