package com.pojo;

import java.io.Serializable;

public class strategy implements Serializable {
	private String strategy_introduction1;
	private String strategy_introduction2;
	private String intervention_strategy;
	private String intervention_target;
	private String strategy_type;

	public String getStrategy_introduction1() {
		return strategy_introduction1;
	}
	public void setStrategy_introduction1(String strategy_introduction1) {
		this.strategy_introduction1 = strategy_introduction1;
	}
	public String getStrategy_introduction2() {
		return strategy_introduction2;
	}
	public void setStrategy_introduction2(String strategy_introduction2) {
		this.strategy_introduction2 = strategy_introduction2;
	}
	public String getIntervention_strategy() {
		return intervention_strategy;
	}
	public void setIntervention_strategy(String intervention_strategy) {
		this.intervention_strategy = intervention_strategy;
	}
	public String getIntervention_target() {
		return intervention_target;
	}
	public void setIntervention_target(String intervention_target) {
		this.intervention_target = intervention_target;
	}
	public String getStrategy_type() {
		return strategy_type;
	}
	public void setStrategy_type(String strategy_type) {
		this.strategy_type = strategy_type;
	}


	@Override
	public String toString() {
		return "strategy{" +
				"strategy_introduction1=" + strategy_introduction1 +
				", strategy_introduction2='" + strategy_introduction2 + '\'' +
				", intervention_strategy=" + intervention_strategy +
				", intervention_target=" + intervention_target +
				", strategy_type='" + strategy_type + '\'' +
				'}';
	}

}
