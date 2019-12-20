package com.met.training;

public class TrainingWorkshop implements Workshop{

	private TrainingCompany trainingCompany;

	public TrainingWorkshop(TrainingCompany trainingCompany) {
		this();
		this.trainingCompany = trainingCompany;
	}

	public TrainingWorkshop() {
		super();
		System.out.println("TrainingWorkshop instance created..");
	}

	public TrainingCompany getTrainingCompany() {
		return trainingCompany;
	}

	public void setTrainingCompany(TrainingCompany trainingCompany) {
		this.trainingCompany = trainingCompany;
	}

	@Override
	public void conductWorkshop() {
		System.out.println("inside Conduct Workshop method");
		trainingCompany.conductTraining();
		
	};
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "TrainingWorkshop is going on";
	}
	
}
