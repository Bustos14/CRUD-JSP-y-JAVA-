package modelo.javabeans;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Evento implements Serializable {

	private static final long serialVersionUID = 1L;

	private int idEvento;
	private String nombre;
	private String descripcion;
	private Date fechaInicio;
	private int duracion;
	private String direccion;
	private String estado;
	private boolean destacado;
	private int aforoMax;
	private int asistMin;
	private double precioDec;
	private Tipo tipo;

	public Evento() {
		// TODO Auto-generated constructor stub
	}

	public Evento(int idEvento, String nombre, String descripcion, Date fechaInicio, int duracion, String direccion,
			String estado, boolean destacado, int aforoMax, int asistMin, double precioDec, Tipo tipo) {
		super();
		this.idEvento = idEvento;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.duracion = duracion;
		this.direccion = direccion;
		this.estado = estado;
		this.destacado = destacado;
		this.aforoMax = aforoMax;
		this.asistMin = asistMin;
		this.precioDec = precioDec;
		this.tipo = tipo;
	}

	public int getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public boolean getDestacado() {
		return destacado;
	}

	public void setDestacado(boolean destacado) {
		this.destacado = destacado;
	}

	public int getAforoMax() {
		return aforoMax;
	}

	public void setAforoMax(int aforoMax) {
		this.aforoMax = aforoMax;
	}

	public int getAsistMin() {
		return asistMin;
	}

	public void setAsistMin(int asistMin) {
		this.asistMin = asistMin;
	}

	public double getPrecioDec() {
		return precioDec;
	}

	public void setPrecioDec(double precioDec) {
		this.precioDec = precioDec;
	}

	public Tipo getIdTipo() {
		return tipo;
	}

	public void setIdTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idEvento);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Evento))
			return false;
		Evento other = (Evento) obj;
		return idEvento == other.idEvento;
	}

	@Override
	public String toString() {
		return "Evento [idEvento=" + idEvento + ", nombre=" + nombre + ", descripcion=" + descripcion + ", fechaInicio="
				+ fechaInicio + ", duracion=" + duracion + ", direccion=" + direccion + ", estado=" + estado
				+ ", destacado=" + destacado + ", aforoMax=" + aforoMax + ", asistMin=" + asistMin + ", precioDec="
				+ precioDec + ", idTipo=" + tipo.getIdTipo() + "]";
	}


}
