package tikape.runko;

import java.util.HashMap;
import spark.ModelAndView;
import static spark.Spark.*;
import spark.template.thymeleaf.ThymeleafTemplateEngine;
import tikape.runko.database.Database;
import tikape.runko.database.AnnosDao;
import tikape.runko.database.RaakaAineDao;

public class Main {

    public static void main(String[] args) throws Exception {
        Database database = new Database("jdbc:sqlite:smthe.db");
//        database.init();

        AnnosDao AnnosDao = new AnnosDao(database);
        RaakaAineDao RaakaAineDao = new RaakaAineDao(database);

        get("/", (req, res) -> {
            HashMap map = new HashMap<>();
            map.put("annokset", AnnosDao.findAll());

            return new ModelAndView(map, "annokset");
        }, new ThymeleafTemplateEngine());

        get("/annos/luo", (req, res) -> {
            HashMap map = new HashMap<>();
            map.put("annokset", AnnosDao.findAll());
            map.put("raakaaineet", RaakaAineDao.findAll());

            return new ModelAndView(map, "annokset-luo");
        }, new ThymeleafTemplateEngine());

        get("/annos/lisaa", (req, res) -> {
            HashMap map = new HashMap<>();
            map.put("annokset", AnnosDao.findAll());
            map.put("raakaaineet", RaakaAineDao.findAll());

            return new ModelAndView(map, "annokset-luo");
        }, new ThymeleafTemplateEngine());
        
        get("/annos/:id", (req, res) -> {
            HashMap map = new HashMap<>();
            map.put("annos", AnnosDao.findOne(Integer.parseInt(req.params("id"))));
            map.put("raakaaineet", RaakaAineDao.findAllForAnnos(Integer.parseInt(req.params("id"))));

            return new ModelAndView(map, "annos");
        }, new ThymeleafTemplateEngine());

        get("/annos/poista/:id", (req, res) -> {
            HashMap map = new HashMap<>();
            AnnosDao.delete(Integer.parseInt(req.params("id")));

            return new ModelAndView(map, "annos");
        }, new ThymeleafTemplateEngine());
        
/*
        get("/opiskelijat", (req, res) -> {
            HashMap map = new HashMap<>();
            map.put("opiskelijat", opiskelijaDao.findAll());

            return new ModelAndView(map, "opiskelijat");
        }, new ThymeleafTemplateEngine());

        get("/opiskelijat/:id", (req, res) -> {
            HashMap map = new HashMap<>();
            map.put("opiskelija", opiskelijaDao.findOne(Integer.parseInt(req.params("id"))));

            return new ModelAndView(map, "opiskelija");
        }, new ThymeleafTemplateEngine());
*/
    }
}
