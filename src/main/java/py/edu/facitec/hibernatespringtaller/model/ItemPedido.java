package py.edu.facitec.hibernatespringtaller.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class ItemPedido {
	
	@Id
	@GeneratedValue
	private Long id;
	private int cantidadProducto;
	private double subTotal;
	//Muchos a Uno    /donde esta 1 *
	//asociacion bidireccional en json
	@JsonBackReference
	@ManyToOne
	private Pedido pedido;
	
	@ManyToOne
	private Producto producto;
	
	
	public ItemPedido() {
		// TODO Auto-generated constructor stub
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public int getCantidadProducto() {
		return cantidadProducto;
	}


	public void setCantidadProducto(int cantidadProducto) {
		this.cantidadProducto = cantidadProducto;
	}


	public double getSubTotal() {
		return subTotal;
	}


	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}


	public Pedido getPedido() {
		return pedido;
	}


	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}


	public Producto getProducto() {
		return producto;
	}


	public void setProducto(Producto producto) {
		this.producto = producto;
	}


	@Override
	public String toString() {
		return "ItemPedido [id=" + id + ", cantidadProducto=" + cantidadProducto + ", subTotal=" + subTotal
				+ ", pedido=" + pedido + ", producto=" + producto + "]";
	}
	
	
	

}
