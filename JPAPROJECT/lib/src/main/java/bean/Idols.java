package bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Idols {
	@Id
	private int id;
	private String name;
	private String stagename;
	private String popularsolo;
	
	public Idols(){}

	public Idols(int id, String name, String stagename, String popularsolo) {
		super();
		this.id = id;
		this.name = name;
		this.stagename = stagename;
		this.popularsolo = popularsolo;
	}

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

	public String getStagename() {
		return stagename;
	}

	public void setStagename(String stagename) {
		this.stagename = stagename;
	}

	public String getPopularsolo() {
		return popularsolo;
	}

	public void setPopularsolo(String popularsolo) {
		this.popularsolo = popularsolo;
	}

	@Override
	public String toString() {
		return "Idols [id=" + id + ", name=" + name + ", stagename=" + stagename + ", popularsolo=" + popularsolo + "]";
	}

}
