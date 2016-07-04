package com.example.batch.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "weaponBackup")
public class WeaponBackup implements Serializable {

	private static final long serialVersionUID = -2456048009186862543L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long no;

	private int id;
	private String name;

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
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

	@Override
	public String toString() {
		return "WeaponBackup [id=" + id + ", name=" + name + "]";
	}

}
