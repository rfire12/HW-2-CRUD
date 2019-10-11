<!DOCTYPE html>
<html>
  <head>
    <link href="/css/bootstrap.css" rel="stylesheet" />
    <script src="/js/bootstrap.js"></script>
    <link href="/css/main.css" rel="stylesheet" />
    <title>Editar estudiante</title>
  </head>
  <body>
    <form class="edit-form" method="POST" action=${endpoint}>
      <div class="form-group">
        <label for="exampleInputEmail1">Matricula</label>
        <input
          type="text"
          class="form-control"
          name="matricula"
          id="matricula"
          placeholder="Introduzca su matricula"
          value="${estudiante.matricula}"
          ${matricula_enabled}
        />
      </div>
      <div class="form-group">
        <label for="exampleInputEmail1">Nombre</label>
        <input
          type="text"
          class="form-control"
          id="nombre"
          name="nombre"
          placeholder="Introduzca su nombre"
          value="${estudiante.nombre}"
        />
      </div>
      <div class="form-group">
        <label for="exampleInputEmail1">Apellido</label>
        <input
          type="text"
          class="form-control"
          id="apellido"
          name="apellido"
          placeholder="Introduzca su apellido"
          value="${estudiante.apellido}"
        />
      </div>
      <div class="form-group">
        <label for="exampleInputEmail1">Telefono</label>
        <input
          type="tel"
          class="form-control"
          id="telefono"
          name="telefono"
          placeholder="Introduzca su telefono"
          value="${estudiante.telefono}"
        />
      </div>
      <button type="submit" class="btn btn-primary">${field}</button>
    </form>
  </body>
</html>
