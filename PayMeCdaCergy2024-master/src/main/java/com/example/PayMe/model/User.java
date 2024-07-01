package com.example.PayMe.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private float balance;
	
	private String iban;
	
	private String email;
	
	private String pwd;
	
	@ManyToMany
	private List<User> listContacts;
	
	@OneToMany(mappedBy ="sender")
	private List<Transaction> listeTransaction;
	
	@OneToMany(mappedBy ="user")
	private List<Virement> listeVirement;
	
	public void changeAmount(float toAdd) {
		this.balance += toAdd;
	}

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

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public List<User> getListContacts() {
		return listContacts;
	}

	public void setListContacts(List<User> listContacts) {
		this.listContacts = listContacts;
	}

	public List<Transaction> getListeTransaction() {
		return listeTransaction;
	}

	public void setListeTransaction(List<Transaction> listeTransaction) {
		this.listeTransaction = listeTransaction;
	}

	public List<Virement> getListeVirement() {
		return listeVirement;
	}

	public void setListeVirement(List<Virement> listeVirement) {
		this.listeVirement = listeVirement;
	}
	
	
	
}
