package es.urjc.code.cqrs.domain.dto;

public class FullCartExpenditureDTO {

	private Long id;
	private double expenditure;
	
	public FullCartExpenditureDTO() {
		super();
	}

	public FullCartExpenditureDTO(Long id, double expenditure) {
		super();
		this.id = id;
		this.expenditure = expenditure;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getExpenditure() {
		return expenditure;
	}

	public void setExpenditure(double expenditure) {
		this.expenditure = expenditure;
	}	
	
}
