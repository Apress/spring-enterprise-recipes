package com.apress.springenterpriserecipes.spring3.spel;

import static java.lang.System.out;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.ParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class SpelExamplesDemo {
   private static ExpressionParser parser = new SpelExpressionParser();

   public static Map<String, String> mapOfStatesAndCapitals = (Map<String, String>) ArrayUtils
         .toMap(new String[][] { { "CA", "Sacremento" }, { "OR", "Salem" },
               { "NY", "New York" } });
   public static Map<String, Cat> catsByName = (Map<String, Cat>) ArrayUtils
         .toMap(new Object[][] { { "felix", new Cat("felix") },
               { "garfield", new Cat("garfield") }, { "zeus", new Cat("zeus") },
               { "sphinx", new Cat("sphinx") }, { "fido", new Cat("fido") },
               { "fala", new Cat("fala") } });

   static public Map<String, String> getMapOfStatesAndCapitals() {
      return mapOfStatesAndCapitals;
   }

   static public Map<String, Cat> getMapOfCatsByName() {
      return catsByName;
   }

   static <T> T valueOfExpression(String expression, Class<T> clazzT)
         throws Throwable {
      Expression exp = parser.parseExpression(expression);
      T val = exp.getValue(clazzT);
      return val;
   }

   static <T> T valueOfExpression(String expression, Object context, Class<T> clazzT)
         throws Throwable {
      Expression exp = parser.parseExpression(expression);
      StandardEvaluationContext ctx = new StandardEvaluationContext();
      ctx.setRootObject(context);
      T val = exp.getValue(ctx, clazzT);
      return val;
   }

   public static void main(String[] arg) throws Throwable {
      // literal expression evaluation, using Integer
      Integer integer = valueOfExpression("2342", Integer.class);
      out.printf("integer=%s \n", integer.toString());

      // literal expression, (cont'd)
      String string = valueOfExpression("'Hello Spring Enterprise Recipes'",
            String.class);
      out.printf("string=%s \n", string);

      String string3 = valueOfExpression("'ceci n''est pas une String'",
            String.class);
      out.printf("string2=%s \n", string3);

      // Calling constructors
      String string2 = valueOfExpression(
            "new String('Hello Spring Enterprise Recipes, again!')", String.class);
      out.printf("string (via constructor)=%s \n", string2);

      // calling constructors (cont'd)
      Cat cat1 = valueOfExpression(
            "new com.apress.springenterpriserecipes.spring3.spel.Cat('Felix')",
            Cat.class);
      out.printf("cat=%s \n", cat1);

      // class expressions
      // class method invocations
      Number randomValue = valueOfExpression("T(java.lang.Math).random()",
            Number.class);
      out.printf("random value=%s \n", randomValue);
      /**/
      // boolean and relational operators
      Boolean randomNumberGreaterThanHalf = valueOfExpression(
            " T(java.lang.Math).random() > 0.5 ", Boolean.class);
      out.printf("random number is greater than half?=%s \n",
            randomNumberGreaterThanHalf);

      // ternary expressions
      String ternaryResult = valueOfExpression(
            "T(java.lang.Math).random() > 0.5 ? 'She loves me' : 'She loves me not'",
            String.class);
      out.printf("result of ternary expression=%s\n", ternaryResult);

      // method invocation
      String nameUpperCase = valueOfExpression("'felix'.toUpperCase()",
            String.class);
      out.printf("'felix'.toUpperCase()=%s\n", nameUpperCase);

      // accesing arrays
      String secondItemInArray = valueOfExpression(
            "T(java.util.Arrays).asList( 'a','b','c','d')[1]", String.class);
      out.printf("second element in the array=%s\n", secondItemInArray);

      // accessing maps (nb: this does NOT work on Properties,
      // which is why SpEl comes with a systemProperties var!)
      String capitalOfOregon = valueOfExpression(
            "T(com.apress.springenterpriserecipes.spring3.spel.SpelExamplesDemo).MapOfStatesAndCapitals['OR']",
            String.class);
      out.printf("capital of Oregon=%s \n", capitalOfOregon);

      // list selection
      List<Number> numbersLessThan10G = valueOfExpression(
            "T(java.util.Arrays).asList(6,7,8,9,10,11,12,13).?[#this < 10] \n",
            List.class);
      out.printf("numbers less than 10=%s \n", numbersLessThan10G);

      // map selection
      Map<String, String> onlyStatesWhoseCapitalBeginsWithS = valueOfExpression(
            "T(com.apress.springenterpriserecipes.spring3.spel.SpelExamplesDemo).mapOfStatesAndCapitals.?[value.toLowerCase().startsWith('s')]",
            Map.class);
      out.printf("map of capitals starting with 's' =%s \n",
            onlyStatesWhoseCapitalBeginsWithS);

      // list projection
      Collection<String> catNamesFromCollection = valueOfExpression(
            "T(java.util.Arrays).asList("
                  + "new com.apress.springenterpriserecipes.spring3.spel.Cat('felix'), "
                  + "new com.apress.springenterpriserecipes.spring3.spel.Cat('fido'), "
                  + "new com.apress.springenterpriserecipes.spring3.spel.Cat('fala')).![name]",
            Collection.class);
      out.printf("cat names from collection=%s \n", catNamesFromCollection);

      // map projection
      Collection<String> catNamesFromMap = valueOfExpression(
            "T(com.apress.springenterpriserecipes.spring3.spel.SpelExamplesDemo).mapOfCatsByName.![value.name]",
            Collection.class);
      out.printf("cats names from map=%s \n", catNamesFromMap);

      StandardEvaluationContext ctx1 = new StandardEvaluationContext();

      // property iteration using Expression classes
      SocialNetworkingSiteContext socialNetworkingSiteContext = new SocialNetworkingSiteContext();
      Friend myFriend = new Friend();
      myFriend.setFirstName("Manuel");
      socialNetworkingSiteContext.setLoggedInUser(myFriend);
      ctx1.setVariable("socialNetworkingSiteContext", socialNetworkingSiteContext);
      Expression loggedInUserFirstNameExpression = parser
            .parseExpression("#socialNetworkingSiteContext.loggedInUser.firstName");
      String loggedInUserFirstName = loggedInUserFirstNameExpression.getValue(ctx1,
            String.class);
      out.printf("loggedInUserName:%s\n ", loggedInUserFirstName);

      // registering functions
      Expression functionEval = parser
            .parseExpression("#empty(null) ? 'empty':'not empty'");
      ctx1.registerFunction("empty", StringUtils.class.getDeclaredMethod("isEmpty",
            new Class[] { String.class }));
      String result = functionEval.getValue(ctx1, String.class);
      out.printf("empty(null)=%s \n", result);

      ParserContext pc = new ParserContext() {
         public String getExpressionPrefix() {
            return "${";
         }

         public String getExpressionSuffix() {
            return "}";
         }

         public boolean isTemplate() {
            return true;
         }

      };
      String templatedExample = parser.parseExpression(
            "The millisecond is ${T(System).currentTimeMillis()}.", pc).getValue(
            String.class);
      out.println(templatedExample);
   }
}
