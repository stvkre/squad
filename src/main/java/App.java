import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    ProcessBuilder process = new ProcessBuilder();
     Integer port;
     if (process.environment().get("PORT") != null) {
         port = Integer.parseInt(process.environment().get("PORT"));
     } else {
         port = 4567;
     }

    setPort(port);
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    // fetching data from the layout page

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    // retrieving data from the success page

    get("/success", (request, response) -> {
     Map<String, Object> model = new HashMap<String, Object>();
     model.put("template", "templates/success.vtl");
     return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());

   // displaying data from the success page

  post("/success", (request, response) -> {
  Map<String, Object> model = new HashMap<String, Object>();

  String inputtedName = request.queryParams("name");
  request.session().attribute("name", inputtedName);
  model.put("name", inputtedName);

  model.put("template", "templates/success.vtl");
  return new ModelAndView(model, layout);
}, new VelocityTemplateEngine());

// retrieving data from the heroes page

get("/heroes", (request, response) -> {
 Map<String, Object> model = new HashMap<String, Object>();
 model.put("template", "templates/heroes.vtl");
 return new ModelAndView(model, layout);
}, new VelocityTemplateEngine());

// displaying data from the heroes page
   post("/heroes", (request, response) -> {
       Map<String, Object> model = new HashMap<String, Object>();

       ArrayList<Hero> heroes = request.session().attribute("heroes");
       if (heroes == null) {
         heroes = new ArrayList<Hero>();
         request.session().attribute("heroes", heroes);
       }

       String name = request.queryParams("name");
       int age = Integer.parseInt(request.queryParams("age"));
       String power = request.queryParams("power");
       String weakness = request.queryParams("weakness");
       Hero newHero = new Hero(name);
       heroes.add(newHero);

       model.put("template", "templates/success.vtl");
       return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());

  }
}
