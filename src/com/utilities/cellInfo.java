package com.utilities;

public class cellInfo {
	
	public cellInfo(String qs,double d,double e, int i){
		setQuestion(qs);
		setLevel(d);
		setCount(e);
		setRowNumber(i);
		
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public double getLevel() {
		return level;
	}
	public void setLevel(double d) {
		this.level = d;
	}
	public double getCount() {
		return count;
	}
	public void setCount(double e) {
		this.count = e;
	}
	private String question;
	private double level;
	private double count;
	private int rowNumber;
	
	public String toString(){
		return question+": "+level+": "+count;
	}
	public int getRowNumber() {
		return rowNumber;
	}
	public void setRowNumber(int rowNumber) {
		this.rowNumber = rowNumber;
	}

}
