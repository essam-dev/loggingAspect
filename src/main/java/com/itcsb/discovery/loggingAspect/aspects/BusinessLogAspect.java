package com.itcsb.discovery.loggingAspect.aspects;

import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.itcsb.discovery.loggingAspect.annotations.BusinessLog;

@Aspect
@Component
public class BusinessLogAspect {

	public static final String LOG_SEPARATOR = " - ";

	@Around("@annotation(com.itcsb.discovery.loggingAspect.annotations.BusinessLog)")
	public Object Log(ProceedingJoinPoint joinPoint) throws Throwable {
		StringBuffer logBuffer = new StringBuffer();
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		BusinessLog businessLog = method.getAnnotation(BusinessLog.class);

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();

		logBuffer.append(dateFormat.format(date)).append(LOG_SEPARATOR);

		switch (businessLog.LogAction()) {
		case CCS:
			logBuffer.append("Commande Client créée");
			break;
		case CCC:
			logBuffer.append("Commande Client supprimée");
			break;
		case BVS:
			logBuffer.append("Bulletin Vente créé");
			break;
		case BVC:
			logBuffer.append("Bulletin Vente supprimé");
			break;
		case DS:
			logBuffer.append("Devis créé");
			break;
		case DC:
			logBuffer.append("Devis supprimé");
			break;
		case EMPTY:
			logBuffer.append("Business action non définie");
			break;
		default:
			logBuffer.append("Aucune Action définie");
			break;
		}

		System.out.println(logBuffer.toString());

		return joinPoint.proceed();
	}

}
