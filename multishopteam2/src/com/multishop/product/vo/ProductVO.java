package com.multishop.product.vo;

public class ProductVO {
	
	private Long Product_no;
	private String Product_name;
	private String Product_content;
	private String Delivery_charge;
	private String Price;
	
	
	//getter & setter
	public Long getProduct_no() {
		return Product_no;
	}
	public void setProduct_no(Long product_no) {
		Product_no = product_no;
	}
	public String getProduct_name() {
		return Product_name;
	}
	public void setProduct_name(String product_name) {
		Product_name = product_name;
	}
	public String getProduct_content() {
		return Product_content;
	}
	public void setProduct_content(String product_content) {
		Product_content = product_content;
	}
	public String getDelivery_charge() {
		return Delivery_charge;
	}
	public void setDelivery_charge(String delivery_charge) {
		Delivery_charge = delivery_charge;
	}
	public String getPrice() {
		return Price;
	}
	public void setPrice(String price) {
		Price = price;
	}
	
	
	//to String()
	@Override
	public String toString() {
		return "ProductVO [Product_no=" + Product_no + ", Product_name=" + Product_name + ", Product_content="
				+ Product_content + ", Delivery_charge=" + Delivery_charge + ", Price=" + Price + "]";
	}
	
	
}
