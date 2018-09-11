package com.java.java_8_in_action.chapter8_of_action_java_8.strategy_model;

import java.util.Date;

/**
 * Created by cdc on 2018/5/2.
 */
public class Validator {
    private final ValidationStrategy strategy;

    public Validator(ValidationStrategy validationStrategy) {
        this.strategy = validationStrategy;
    }

    public boolean validate(String s) {
        return strategy.execute(s);
    }

    public static void main(String[] args) {
        Validator numbericValidator = new Validator(new IsNumberic());
        boolean b1 = numbericValidator.validate("aaaa");
        Validator lowerCaseValidator = new Validator(new IsAllLowerCase());
        boolean b2 = lowerCaseValidator.validate("bbbb");

        System.out.println("is number:" + b1);
        System.out.println("is all lowerCase:" + b2);

        //是 lambda
        Validator numbericValidatorLam = new Validator((String s) -> s.matches("[a-z]+"));
        boolean b3 = numbericValidatorLam.validate("aaaa");

        Validator lowerCaseValidatorLam = new Validator((String s) -> s.matches("\\d+"));
        boolean b4 = lowerCaseValidatorLam.validate("bbbb");

        System.out.println("b3:" + b3);
        System.out.println("b4:" + b4);

        int NCpu = Runtime.getRuntime().availableProcessors();
        System.out.println(NCpu);

        System.out.println("===========");

        Date date = new Date();
        System.out.println(date);
    }
}

