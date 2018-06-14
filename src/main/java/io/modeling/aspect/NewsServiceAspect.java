package io.modeling.aspect;

import io.modeling.models.FunctionCallModel;
import io.modeling.services.FunctionCallService;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class NewsServiceAspect {
	@Autowired
	FunctionCallService functionCallService;
	@Before("execution(* io.modeling.controllers.*.*(..)) ||"
			+ "execution(* io.modeling.models.*.*(..)) ||"
			+ "execution(* io.modeling.services.News*.*(..))")
	public void sth(JoinPoint thisJoinPoint) throws Throwable{
		String className = thisJoinPoint.getThis().getClass().getSimpleName();
		className = className.substring(0, className.indexOf('$'));
		String functionName = thisJoinPoint.getSignature().getName();
		System.out.println(className + "." + functionName);
		FunctionCallModel model = functionCallService.getCallByClassNameAndFunctionName(className, functionName);
		if(className.isEmpty())
			return;
		if(model == null){
			model = new FunctionCallModel(0,className, functionName, 1);
			functionCallService.addFunctionCall(model);
		}
		else{
			model.incrementCall();
			functionCallService.updateFunctionCall(model);
		}
	}
}
