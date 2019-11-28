package edu.pucmm.practica2;

import edu.pucmm.practica2.encapsulacion.Estudiante;
import edu.pucmm.practica2.servicios.ServicioEstudiantes;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class Main {
    public static String renderFreemarker(Map<String, Object> model, String templatePath) {
        return new FreeMarkerEngine().render(new ModelAndView(model, templatePath));
    }

    public static void main(String[] args) {
        port(getHerokuPort());

        staticFiles.location("/publico");
        get("/", (request, response) -> {
            Map<String, Object> estudiantes = new HashMap<>();
            estudiantes.put("misEstudiantes", ServicioEstudiantes.getInstance().getMisEstudiantes());
            return renderFreemarker(estudiantes, "/main.ftl");
        });

        get("/crear-estudiante", (request, response) -> {
            Map<String, Object> fields = new HashMap<>();
            Estudiante estudiante = new Estudiante("","","","");
            fields.put("field","Crear");
            fields.put("estudiante", estudiante);
            fields.put("endpoint", "crear-estudiante");
            fields.put("matricula_enabled", "");
            return renderFreemarker(fields,"/formulario.ftl");
        });

        get("/modificar-estudiante/:matricula", (request, response) -> {
            Map<String, Object> fields = new HashMap<>();
            Estudiante estudiante = ServicioEstudiantes.getInstance().buscarEstudiante(request.params("matricula"));
            fields.put("field","Modificar");
            fields.put("estudiante", estudiante);
            fields.put("endpoint", "/modificar-estudiante");
            fields.put("matricula_enabled", "readonly");
            return renderFreemarker(fields,"/formulario.ftl");
        });

        post("/modificar-estudiante", (request, response) -> {
            ServicioEstudiantes.getInstance().modificarEstudiante(request.queryParams("matricula"),
                    request.queryParams("nombre"), request.queryParams("apellido"), request.queryParams("telefono"));

            response.redirect("/");
            return "";
        });

        post("/crear-estudiante", (request, response) -> {
            ServicioEstudiantes.getInstance().crearEstudiante(request.queryParams("matricula"),
                    request.queryParams("nombre"), request.queryParams("apellido"), request.queryParams("telefono"));
            response.redirect("/");
            return "";
        });

        post("/eliminar-estudiante/:matricula", (request, response) -> {
            ServicioEstudiantes.getInstance().eliminarEstudiante(request.params("matricula"));
            response.redirect("/");
            return "";
        });


    }

    static int getHerokuPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567;
    }
}
