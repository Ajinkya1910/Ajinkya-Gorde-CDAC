package com.met.training.test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.met.training.JavaTrainer;
import com.met.training.TrainingCompany;
import com.met.training.TrainingWorkshop;
import com.met.training.Workshop;

public class TrainingTest {

	public static void main(String[] args) {
		
		try(AbstractApplicationContext context = new ClassPathXmlApplicationContext("training.xml")){
			
			
			/*
			 * JavaTrainer javaTrainer = context.getBean("javaTrainer1", JavaTrainer.class);
			 * System.out.println("To String: " + javaTrainer); javaTrainer.train();
			 */
			
			/*
			 * TrainingCompany trainingCompany = context.getBean("metSolutions",
			 * TrainingCompany.class); System.out.println("TO String: " + trainingCompany);
			 * trainingCompany.conductTraining();
			 */
			
			Workshop workshop = context.getBean("trainingWorkshop", Workshop.class);
			System.out.println("To String: " + workshop);
			workshop.conductWorkshop();
			
		}
		
	}
	
}
