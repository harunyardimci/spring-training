package com.gg.petclinic.tests;

import com.gg.petclinic.model.Vet;
import com.gg.petclinic.service.PetClinicService;
import com.gg.petclinic.service.PetClinicServiceImpl;
import org.junit.Test;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * Created with IntelliJ IDEA.
 * User: { "id": "hyardimci", "email":nosqlsolutions@gmail.com"}
 * Date: 5/10/13
 * Time: 11:16 AM
 */
public class SpelTests {

    @Test
    public void testSpel() {
        Vet vet = new Vet();
        vet.setFirstName("HaHaH");

        System.out.println("before :" + vet);

        ExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression("firstName");

        StandardEvaluationContext context = new StandardEvaluationContext(vet);

        String firstName = (String) expression.getValue(context);

        Expression expression2 = parser.parseExpression("lastName");

        expression2.setValue(context, "ohoyhohoy");



        System.out.println(firstName);
        System.out.println("after :" + vet);

        Expression expression3 = parser.parseExpression("new com.gg.petclinic.model.Vet()");
        System.out.println("new Vet : " + expression3.getValue());
    }
}
