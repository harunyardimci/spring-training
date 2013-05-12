package com.gg.petclinic.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * User: { "id": "hyardimci", "email":nosqlsolutions@gmail.com"}
 * Date: 5/12/13
 * Time: 1:46 PM
 */
@Aspect
public class PetClinicTrackerAspect {

    @Around("execution (* com.gg..service.*.*(..))")
    public Object trace(ProceedingJoinPoint pjp) throws Throwable  {

        try {
            System.out.println("Before AOP :" + pjp.getSignature().getDeclaringTypeName());

            return pjp.proceed();
        }
        finally {
            System.out.println("After AOP:" + pjp.getSignature());
        }
    }


    @Around("bean(*Service)")
    public Object trace2(ProceedingJoinPoint pjp) throws Throwable  {

        try {
            System.out.println("Before AOP with XML :" + pjp.getSignature().getDeclaringTypeName());

            return pjp.proceed();
        }
        finally {
            System.out.println("After AOP with XML :" + pjp.getSignature());
        }
    }

}
