package com.beans;

public class Product {
	private int id;
	private String name;
	private int sort;//类别
	private float price; //促销价
	private float oneprice; // 原价
	private String img; //images
	private String date;
	private int sale;  //售出
	private String face; //材质
	private String body; //扇骨材质
	private float length; //扇骨长度
	private int quantity; //扇骨数量
	private String source; //Picture/source
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getOneprice() {
		return oneprice;
	}
	public void setOneprice(float oneprice) {
		this.oneprice = oneprice;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getSale() {
		return sale;
	}
	public void setSale(int sale) {
		this.sale = sale;
	}
	public String getFace() {
		return face;
	}
	public void setFace(String face) {
		this.face = face;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public float getLength() {
		return length;
	}
	public void setLength(float length) {
		this.length = length;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	
	
}
