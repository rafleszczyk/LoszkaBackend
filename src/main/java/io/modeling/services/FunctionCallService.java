package io.modeling.services;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.modeling.models.FunctionCallModel;

@Service
public class FunctionCallService {
	@Autowired
	private FunctionCallRepository functionCallRepository; 
	public List<FunctionCallModel> findAllFunctionCalls() {
		return functionCallRepository.findAll().stream().collect(Collectors.toList());
	}
	
	public List<FunctionCallModel> getCallsByName(String name){
		try{
		return findAllFunctionCalls().
			   stream().
			   filter(function -> function
								.getClassName()
								.toLowerCase()
								.contains(name.toLowerCase()) ||
								function
								.getFunctionName()
								.toLowerCase()
								.contains(name.toLowerCase())).
			   collect(Collectors.toList());
		}catch(Exception e){
			return new ArrayList<FunctionCallModel>();
		}
	}
	public FunctionCallModel getFunctionCall(int id) { 
		return functionCallRepository.findById(id).orElse(null);
	}
	
	public FunctionCallModel getCallByClassNameAndFunctionName(String className, String functionName){
		try{
			return findAllFunctionCalls().
					   stream().
					   filter(function -> function
										.getClassName()
										.equals(className) &&
										function
										.getFunctionName()
										.equals(functionName)).
					   collect(Collectors.toList()).get(0);
		}catch(Exception E){
			return null;
		}
	}
	
	public void addFunctionCall(FunctionCallModel model) { 
		functionCallRepository.save(model);
	}
	
	public void updateFunctionCall(FunctionCallModel model) {
		functionCallRepository.save(model);
	}
}
