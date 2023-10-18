package com.pojo;

public class InterventionPoint {
	private String Intervention_point;
	private String imgageurl;
	private String intensity;
	private String num;
	private String Intervention_point_image;
	public String getIntervention_point() {
		return Intervention_point;
	}
	public void setIntervention_point(String intervention_point) {
		Intervention_point = intervention_point;
	}
	public String getImgageurl() {
		return imgageurl;
	}
	public void setImgageurl(String imgageurl) {
		this.imgageurl = imgageurl;
	}
	public String getIntensity() {
		return intensity;
	}
	public void setIntensity(String intensity) {
		this.intensity = intensity;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getIntervention_point_image() {
		return Intervention_point_image;
	}
	public void setIntervention_point_image(String intervention_point_image) {
		Intervention_point_image = intervention_point_image;
	}


	@Override
	public String toString() {
		return "InterventionPoint{" +
				"Intervention_point=" + Intervention_point +
				", imgageurl='" + imgageurl + '\'' +
				", intensity=" + intensity +
				", num=" + num +
				", Intervention_point_image='" + Intervention_point_image + '\'' +
				'}';
	}

	


}
