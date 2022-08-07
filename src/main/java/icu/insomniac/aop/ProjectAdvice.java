package icu.insomniac.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ProjectAdvice {
    @Pointcut("execution(* icu.insomniac.service.*Service.*(..))")
    private void servicePt(){}

    @Around("servicePt()")
    public void executeThousandTimes(ProceedingJoinPoint pjp) throws Throwable {
        Signature signature = pjp.getSignature();
        Long start = System.currentTimeMillis();
        for (int i = 0; i<1000; i++){
            System.out.println(pjp.proceed());
        }
        Long end = System.currentTimeMillis();
        System.out.println(signature.getDeclaringTypeName());
        System.out.println(signature.getName());
        System.out.println("Time to execute 1000 times: "+(end-start)+"ms");
    }
}
