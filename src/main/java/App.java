import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.lang.Object;
import java.util.Random;
import java.lang.String;
import spark.ModelAndView;
import static java.lang.System.out;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;


public class App {
  public static void main(String[] args) {
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/home.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


    get("/winner", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/winner.vtl");

      String sentence = request.queryParams("sentence");
      String winner = coinsCounter(sentence);

      model.put("winner", winner);
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }

  public static String coinsCounter(String sentence) {
    int pennies = Integer.parseInt(sentence);
    int temp = 0;
    String returnValue = "";

    temp=pennies/25; // Qs
    returnValue+="Quarters: "+temp;
    pennies-=temp*25;

    temp=pennies/10; //  Ds
    returnValue+=" Dimes: "+temp;
    pennies-=temp*10;

    temp=pennies/5; //  Ns
    returnValue+=" Nickles: "+temp;
    pennies-=temp*5;

    returnValue+=" Pennies: "+pennies;

    return returnValue;
  }
}
