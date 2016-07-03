package com.example.batch.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "item")
@Entity
public class Accessory implements Serializable {

	private static final long serialVersionUID = 1816606012461212301L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long no;

	@Column(nullable = false, columnDefinition = "nvarchar(200)")
	private String id;

	@Column(nullable = false)
	private String date;

	@Column(name = "image_url", nullable = true, columnDefinition = "nvarchar(400)")
	private String image;

	@Column(nullable = true, columnDefinition = "nvarchar(100)")
	private String name;

	@Column(nullable = true, columnDefinition = "nvarchar(10)")
	private String level;

	@Column(name = "level_desc", nullable = true, columnDefinition = "nvarchar(500)")
	private String levelDesc;

	@Column(name = "[public]", nullable = true, columnDefinition = "nvarchar(20)")
	private String isPublic;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@PrePersist
	public void prePersist() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		Date nowDate = new Date();
		this.date = dateFormat.format(nowDate);
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getLevelDesc() {
		return levelDesc;
	}

	@XmlElement(name = "level_desc")
	public void setLevelDesc(String levelDesc) {
		this.levelDesc = levelDesc;
	}

	public String getIsPublic() {
		return isPublic;
	}

	@XmlElement(name = "public")
	public void setIsPublic(String isPublic) {
		this.isPublic = isPublic;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
