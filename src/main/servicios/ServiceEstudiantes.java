
public class ServiceEstudiantes{

    private ArrayList<Estudiante> misEstudiantes;
    private static ServiceEstudiantes serviceEstudiantes;

    public static serviceEstudiantes getInstance(){
        if(serviceEstudiantes == null){
            serviceEstudiantes = new ServiceEstudiantes();
        }
        return serviceEstudiantes;
    }
}