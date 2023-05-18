package com.taskmgmt.persistence.model;

import java.time.LocalDate;
import java.util.Objects;

public class Project {
	private Long id;
	private String internalID;
	private String name;
	private LocalDate dateCreated;
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public LocalDate getDateCreated() {
		return dateCreated;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDateCreated(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}
	public Project(Long id, String name, LocalDate dateCreated) {
		super();
		this.id = id;
		this.name = name;
		this.dateCreated = dateCreated;
	}
	
	public Project(Project project) {
		super();
		this.id = project.id;
		this.name = project.name;
		this.dateCreated = project.dateCreated;
	}
	@Override
	public int hashCode() {
		return Objects.hash(dateCreated, id, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Project other = (Project) obj;
		return Objects.equals(dateCreated, other.dateCreated) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name);
	}
	
	@Override
	public String toString() {
		return "Project [id=" + id + ", internalID=" + internalID + ", name=" + name + ", dateCreated=" + dateCreated
				+ "]";
	}
	public String getInternalID() {
		return internalID;
	}
	public void setInternalID(String internalID) {
		this.internalID = internalID;
	}
	
	
	
	
}
