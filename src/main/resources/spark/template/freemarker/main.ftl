<!DOCTYPE html>
<html>
  <head>
    <link href="/css/bootstrap.css" rel="stylesheet" />
    <script src="/js/bootstrap.js"></script>
    <link href="/css/main.css" rel="stylesheet" />
    <title>Listado de estudiantes</title>
  </head>
  <body>
    <h2 class="list-title">Lista de estudiantes</h2>
    <div class="students-list">
      <table class="table table-striped">
        <thead>
          <tr>
            <th scope="col">Matricula</th>
            <th scope="col">Nombre</th>
            <th scope="col">Apellido</th>
            <th scope="col">Telefono</th>
            <th scope="col">Modificar</th>
            <th scope="col">Eliminar</th>
          </tr>
        </thead>
        <tbody>
        <#list misEstudiantes as estudiante>
          <tr>
            <th scope="row">${estudiante.matricula}</th>
            <td>${estudiante.nombre}</td>
            <td>${estudiante.apellido}</td>
            <td>${estudiante.telefono}</td>
            <td>
              <a class="btn btn-primary" href="modificar-estudiante/${estudiante.matricula}" role="button">Modificar</a>
            </td>
            <td>
              <form method="POST" action="eliminar-estudiante/${estudiante.matricula}">
                <button type="submit" class="btn btn-danger">Eliminar</button>
              </form>
            </td>
          </tr>
        </#list>
        </tbody>
      </table>
    </div>
    <a class="add-student btn btn-primary" href="crear-estudiante">
      Crear Estudiante
    </a>
  </body>
</html>
