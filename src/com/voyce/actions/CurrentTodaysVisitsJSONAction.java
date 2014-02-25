package com.voyce.actions;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.voyce.model.VisitsModel;

public class CurrentTodaysVisitsJSONAction extends ActionSupport {
	
	private static final long serialVersionUID = -5537164324114858159L;
	
	private List<VisitsModel> visitDataModel;
	  
	public String execute() {
		VisitsModel model = new VisitsModel();
		model.setTableNumber("123");
		model.setCustomerName("DemoCustomerss");
		
		
		VisitsModel model1 = new VisitsModel();
		model1.setTableNumber("1234");
		model1.setCustomerName("DemoC44ustomer");
		
		
		
		ArrayList<VisitsModel> mo = new ArrayList<VisitsModel>();
		mo.add(model);
		mo.add(model1);
		setVisitDataModel(mo);
        return Action.SUCCESS;
    }
	
	public List<VisitsModel> getVisitDataModel() {
		return visitDataModel;
	}
	
	public void setVisitDataModel(List<VisitsModel> visitDataModel) {
	   this.visitDataModel = visitDataModel;
	}
	
}