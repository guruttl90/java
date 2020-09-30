package com.java.practice.designpatterns.creationaldesignpattern;

//Factory Method Pattern is also known as Virtual Constructor.
public class FactoryPattern {
	public static void main(String[] args) {
		GetPlanFactory planFactory = new GetPlanFactory();
		Integer units;
		ElectricityPlan electricityPlan1 = planFactory.getPlan(PlanType.COMMERCIALPLAN);
		units = 90;
		electricityPlan1.getRate();
		electricityPlan1.calculateBill(units);		
		System.out.print("Bill amount for "+PlanType.COMMERCIALPLAN+" of  "+units+" units is: ");
		 
		ElectricityPlan electricityPlan2 = planFactory.getPlan(PlanType.DOMESTICPLAN);
		units = 90;
		electricityPlan2.getRate();
		electricityPlan2.calculateBill(units);
		
		System.out.print("Bill amount for "+PlanType.DOMESTICPLAN+" of  "+units+" units is: ");
		
		ElectricityPlan electricityPlan3 = planFactory.getPlan(PlanType.INSTITUTIONALPLAN);
		units = 90;
		electricityPlan3.getRate();
		electricityPlan3.calculateBill(units);		
		System.out.print("Bill amount for "+PlanType.INSTITUTIONALPLAN+" of  "+units+" units is: ");
		
	}	
}


abstract class ElectricityPlan{
	protected float rate;
	abstract void getRate();
	public void calculateBill(int units) {
		System.out.println(" Bill Amount = "+rate*units);		
	}
}
class DomesticPlan extends ElectricityPlan{
	void getRate() {		
		rate = 3.50f;
	}		
}
class CommercialPlan  extends ElectricityPlan{
	@Override
	void getRate() {
		rate = 7.50f;
	}
}
class InstitutionPlan extends ElectricityPlan{
	@Override
	void getRate() {
		rate = 5.50f;
	}	
}

enum PlanType 
{ 
	DOMESTICPLAN, COMMERCIALPLAN, INSTITUTIONALPLAN; 
} 

class GetPlanFactory{	
	public ElectricityPlan electricityPlan = null;
	
	public ElectricityPlan getPlan(PlanType planType) {
		
		if(planType == PlanType.DOMESTICPLAN) {
			return new DomesticPlan();
		}
		
		if(planType == PlanType.COMMERCIALPLAN) {
			return new CommercialPlan();
		}
		
		if(planType == PlanType.INSTITUTIONALPLAN) {
			return new InstitutionPlan();
		}
				
		return electricityPlan;				
	}
	
	
}
