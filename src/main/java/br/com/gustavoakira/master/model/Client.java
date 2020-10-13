package br.com.gustavoakira.master.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	@Temporal(value = TemporalType.DATE)
	@DateTimeFormat(iso=ISO.DATE,pattern = "dd/MM/yyyy")
	private Date dateOfEnroll;
	
	@OneToMany(mappedBy = "client",orphanRemoval = true,cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Telephone> telephone;
	
	@OneToMany(mappedBy = "client",orphanRemoval = true,cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Party> party;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateOfEnroll() {
		return dateOfEnroll;
	}

	public void setDateOfEnroll(Date dateOfEnroll) {
		this.dateOfEnroll = dateOfEnroll;
	}

	public List<Telephone> getTelephone() {
		return telephone;
	}

	public void setTelephone(List<Telephone> telephone) {
		this.telephone = telephone;
	}
	

	public List<Party> getParty() {
		return party;
	}

	public void setParty(List<Party> party) {
		this.party = party;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", dateOfEnroll=" + dateOfEnroll + ", telephone=" + telephone
				+ "]";
	}
	
	
}
