package py.edu.facitec.hibernatespringtaller.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.jdbc.datasource.UserCredentialsDataSourceAdapter;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity//indica crear tabla
public class Pedido {
	
	@Id//si o si 
	@GeneratedValue
	private Long id;
	private Date fechaToma;
	private Date fechaEntrega;
	private double total;
	
	@ManyToOne
	private Cliente cliente;
	@JsonManagedReference
	@OneToMany(mappedBy="pedido")
	private List<ItemPedido> itemPedidos;
	
	@ManyToOne
	private Usuario	 usuario;
	
	
	
	public Pedido() {
	
	cliente=new Cliente();
	//Por composición
	itemPedidos=new ArrayList<>();
	
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFechaToma() {
		return fechaToma;
	}

	public void setFechaToma(Date fechaToma) {
		this.fechaToma = fechaToma;
	}

	public Date getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public List<ItemPedido> getItemPedidos() {
		return itemPedidos;
	}

	public void setItemPedidos(List<ItemPedido> itemPedidos) {
		this.itemPedidos = itemPedidos;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", fechaToma=" + fechaToma + ", fechaEntrega=" + fechaEntrega + ", total=" + total
				+ ", cliente=" + cliente + ", itemPedidos=" + itemPedidos + ", usuario=" + usuario + "]";
	}

	
	
	
	

}
