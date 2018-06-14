package io.modeling.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "FunctionCalls")
public class FunctionCallModel {
	@Id
	@GeneratedValue
	private int id;
	
	@Column
	@NotNull
	private String className;
	
	@Column
	@NotNull
	private String functionName;
	
	@Column
	private int called = 1;
	
	public FunctionCallModel(){
		
	}
	
	public FunctionCallModel(int id, String className, String functionName, int callled){
		this.id = id;
		this.className = className;
		this.functionName = functionName;
		this.called = called;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getFunctionName() {
		return functionName;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	public int getCalled() {
		return called;
	}

	public void setCalled(int called) {
		this.called = called;
	}
	
	public void incrementCall(){
		this.called+=1;
	}
	
}
