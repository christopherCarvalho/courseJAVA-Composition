package entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {
	
	private String name;
	private WorkerLevel workerLevel;
	private Double baseSalary;
	
	private Department department;
	private List<HourContract> contracts = new ArrayList();
	
	public Worker() {
		
	}

	public Worker(String name, WorkerLevel workerLevel, Double baseSalary, Department department) {
		this.name = name;
		this.workerLevel = workerLevel;
		this.baseSalary = baseSalary;
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getWorkerLevel() {
		return workerLevel;
	}

	public void setWorkerLevel(WorkerLevel workerLevel) {
		this.workerLevel = workerLevel;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<HourContract> getContracts() {
		return contracts;
	}
	
	public void addContract(HourContract contract)
	{
		contracts.add(contract);
	}
	public void removeContract(HourContract contract)
	{
		contracts.remove(contract);
	}
	
	public double income (int year, int month)
	{
		double sum = baseSalary;
		LocalDate date = LocalDate.now();
		for (HourContract c : contracts)
		{
			int c_year  = date.getYear();
			int c_month = date.getMonthValue();
			if(year == c_year && month == c_month)
			{
				sum+=c.totalValue();
			}
		}
		return sum;
	}
	
}
