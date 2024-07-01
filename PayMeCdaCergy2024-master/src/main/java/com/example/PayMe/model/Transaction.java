package com.example.PayMe.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="receiver_id")
	private User receiver;
	
	@ManyToOne
	@JoinColumn(name="sender_id")
	private User sender;
	
	private Date date;
	
	private float amount;
	
	private String label;
}
