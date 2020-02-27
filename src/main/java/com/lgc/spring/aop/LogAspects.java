package com.lgc.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * @author lgc
 * @aspect 告诉spring 该类是切面类
 * @create 2020-02-27
 **/
@Aspect
public class LogAspects {

    //抽取公共的目标方法
    @Pointcut("execution(public int com.lgc.spring.aop.MathCalculator.*(..))")
    public void pointCut() {

    }

    @Pointcut("@annotation(com.lgc.spring.aop.AopAnnotation)")
    public void annotationPointCut() {

    }

    @Pointcut("args(java.lang.String)")
    public void argsPointCut() {

    }

    /**
     * this 是当前类型的会触发
     */
    @Pointcut("this(com.lgc.spring.aop.BasicService)")
    public void thisPointCut() {

    }
    @Pointcut("target(com.lgc.spring.aop.BasicService)")
    public void targetPointCut() {

    }

    //指定切入位置
    @Before("com.lgc.spring.aop.LogAspects.pointCut()")
    public void logStart(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        System.out.println("" + joinPoint.getSignature().getName() + "运行之前，参数是： " + Arrays.asList(args));
    }

    @After("pointCut()")
    public void logEnd() {
        System.out.println("除法结束。。。参数是{}");
    }

    //本类引用
    @AfterReturning(value = "pointCut()", returning = "result")
    public void logReturn(Object result) {
        System.out.println("返回值：" + result);
        System.out.println("除法返回。。。运行结果{}");
    }

    //其他类引用
    @AfterThrowing(value = "com.lgc.spring.aop.LogAspects.pointCut()", throwing = "e")
    public void logException(Exception e) {
        System.out.println("异常是: " + e);
        System.out.println("除法异常。。。异常信息是{}");
    }

    @Before("annotationPointCut()")
    public void testAnnotation() {
        System.out.println("注解aop");
    }

    @Before("argsPointCut()")
    public void testArgsAop() {
        System.out.println("args aop");
    }
    @After("thisPointCut()")
    public void testThisPointCut(){
        System.out.println("this pointCut");
    }
   @After("targetPointCut()")
    public void testTargetPointCut(){
        System.out.println("target pointCut");
    }

    /**
     * ProceedingJoinPoint extend jsonPoint
     */
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object[] args = proceedingJoinPoint.getArgs();
        //增强了
        proceedingJoinPoint.proceed();
    }

}
