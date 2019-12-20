package edu.met.tourism;

import java.util.*;

public class Visitor implements java.io.Serializable{

	String name;
	int frequency;
	Date recent;

	public Visitor(String id){
		name = id;
		frequency = 1;
		recent = new Date();
	}

	public Visitor(){
		this(null);
	}

	public final String getName(){return name;}
	public final void setName(String value){name = value;}

	public final int getFrequency(){return frequency;}
	public final void setFrequency(int value){frequency = value;}

	public final Date getRecent(){return recent;}
	public final void setRecent(Date value){recent = value;}

	public void revisit(){
		frequency += 1;
		recent = new Date();
	}

}

