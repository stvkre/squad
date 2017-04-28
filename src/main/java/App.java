import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/success", (request, response) -> {
     Map<String, Object> model = new HashMap<String, Object>();
     model.put("template", "templates/success.vtl");
     return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());

  post("/success", (request, response) -> {
  Map<String, Object> model = new HashMap<String, Object>();

  String inputtedName = request.queryParams("name");
  request.session().attribute("name", inputtedName);
  model.put("name", inputtedName);

  model.put("template", "templates/success.vtl");
  return new ModelAndView(model, layout);
}, new VelocityTemplateEngine());

// post("/success", (request, response) -> {
//     Map<String, Object> model = new HashMap<String, Object>();
//
//     ArrayList<Hero> heroes = request.session().attribute("heroes");
//     if (heroes == null) {
//       heroes = new ArrayList<Hero>();
//       request.session().attribute("heroes", heroes);
//     }
//
//     String name = request.queryParams("name");
//     int age = Integer.parseInt(request.queryParams("age"));
//     String power = request.queryParams("power");
//     String weakness = request.queryParams("weakness");
//     Hero newHero = new Hero();
//     heroes.add(newHero);
//
//     model.put("template", "templates/success.vtl");
//     return new ModelAndView(model, layout);
//    }, new VelocityTemplateEngine());

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
       Hero newHero = new Hero();
       heroes.add(newHero);

       model.put("template", "templates/success.vtl");
       return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());

  }
}
