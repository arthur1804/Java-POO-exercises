package aplicacao;

public class pedido {
	private int horaCompra;
	private String ender;
	private static float preco;
	private int qntd;
	private float total;
	private int horaEntregue;
	private String formaPgmt;
	private String Status;
	private int codigo;
	private static int ultimoCodigo;
	
	public pedido() {
		preco = 60;
	}
	
	public int gethoraCompra() {
		return horaCompra;
	}
	
	public void sethoraCompra(int horaCompra) {
		this.horaCompra = horaCompra;
	}
	
	public String getender() {
		return ender;
	}
	
	public void setender(String ender) {
		this.ender = ender;
	}
	
	public int getqntd() {
		return qntd;
	}
	
	public void setqntd(int qntd) {
		this.qntd = qntd;
	}
	
	public float gettotal() {
		return total;
	}
	
	public void settotal(float total) {
		this.total = total;
	}
	
	public int gethoraEntregue() {
		return horaEntregue;
	}
	
	
	public void setformaPgmt(String formaPgmt) {
		this.formaPgmt = formaPgmt;
	}
	
	public String getStatus() {
		return Status;
	}
	
	public void setStatus(String Status) {
		this.Status = Status;
	}
	
	public int getcodigo() {
		return codigo;
	}
	
}
