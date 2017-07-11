package com.spring.aspect;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class LoggingAspect {
   @Before("execution(* *())")
    void displayBefore(){
        System.out.println("Display inside Aspect Called Before method");
    }

    @After("execution(* *())")
    void displayAfter(){
        System.out.println("Display inside Aspect Called After method");
    }

    @AfterThrowing(pointcut = "execution(* *())",throwing = "exception")
    void displayException(Exception exception){
        System.out.println("Exception Encountered");
    }


  /*  @Around("@annotation(Deprecated)")
    void displayBeforeAnnotation(){
        System.out.println("Display inside Aspect Called Before method on Deprecated methods");
    }*/

/*
    @Before("execution(void display())")
      void displayBefore(){
        System.out.println("Display inside Aspect Called  using Execution Before method");
    }

    @After("execution(void display())")
      void displayAfter(){
        System.out.println("Display inside Aspect Called using Execution After method");
    }

    @Before("within(com.spring.component.*))")
    void displayBeforeWithin(){
        System.out.println("Display inside Aspect Called  using Within Before method");
    }

    @After("within(com.spring.component.*))")
    void displayAfterWithin(){
        System.out.println("Display inside Aspect Called  using Within After method");
    }

    @Before("this(com.spring.component.FirstClass))")
    void displayBeforeThis(){
        System.out.println("Display inside Aspect Called  using This Before method");
    }

    @After("within(com.spring.component.FirstClass))")
    void displayAfterThis(){
        System.out.println("Display inside Aspect Called  using This After method");
    }

    @Before("args(Integer)")
    void displayBeforeArgs(){
        System.out.println("Display inside Aspect Called  using Args Before method");
    }

    @After("args(Integer)")
    void displayAfterArgs(){
        System.out.println("Display inside Aspect Called  using Args After method");
    }

    @Before("bean(SecondClass)")
    void displayBeforeBean(){
        System.out.println("Display inside Aspect Called  using Bean Before method");
    }

    @After("bean(SecondClass)")
    void displayAfterBean(){
        System.out.println("Display inside Aspect Called  using Bean After method");
    }*/

/*
@Before("displayPointCut()")
    void displayBefore(){
    System.out.println("Reusing PointCut");

}

@Pointcut("execution(void display())")
void displayPointCut(){}
*/


   /* @Before("execution(void display())")
    void displayBefore(JoinPoint joinPoint) {
        System.out.println("Before advice");
        System.out.println("JoinPoint: "+joinPoint);
        System.out.println("JoinPoint getThis: "+joinPoint.getThis());
        System.out.println("JoinPoint getSignature: "+joinPoint.getSignature());
    }*/
}
