package io.modeling.controllers;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.logging.LoggingApplicationListener;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.modeling.models.FunctionCallModel;
import io.modeling.services.FunctionCallService;


@RestController
public class FunctionCallController {
	
	@Autowired
	public FunctionCallService functionCallService;
	
	@CrossOrigin("*")
	@RequestMapping("/statistics/functions")
	public ResponseEntity getAllByName(@RequestParam("name")String name) {

		List<FunctionCallModel> machedFunctions = functionCallService
												.getCallsByName(name);
		return ResponseEntity.status(HttpStatus.OK).body(machedFunctions);
	}
}