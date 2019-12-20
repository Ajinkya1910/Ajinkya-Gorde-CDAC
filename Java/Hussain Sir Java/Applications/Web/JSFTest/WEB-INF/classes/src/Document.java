package edu.met.tourism;

import java.io.*;
import java.util.*;

public class Document<T> extends ArrayList<T>{

	private transient String file;

	@SuppressWarnings("unchecked")
	public static<T extends Serializable> Document<T> open(Class<T> type, String file){
		file = System.getProperty("user.home") + "/Documents/" + file;
		try{
			File f = new File(file);
			Document<T> list;
			if(f.exists()){
				try(ObjectInputStream source = new ObjectInputStream(new FileInputStream(file))){
					list = (Document<T>)source.readObject();
				}
			}else{
				list = new Document<T>();
			}
			list.file = file;
			return list;
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

	public T find(java.util.function.Predicate<T> check){
		for(T entry : this)
			if(check.test(entry)) return entry;
		return null;
	}

	public void save(){
		try{
			try(ObjectOutputStream target = new ObjectOutputStream(new FileOutputStream(file))){
				target.writeObject(this);
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		
	}

}

