1. Resumen del ProyectoEste proyecto consiste en una aplicación desarrollada en Java, destinada a la gestión de contenido audiovisual, abarcando películas, series de televisión y documentales. La aplicación está diseñada conforme al patrón de diseño MVC (Modelo-Vista-Controlador), lo que permite una clara separación de responsabilidades y facilita el mantenimiento del código.
2. Cambios RealizadosSe llevaron a cabo las siguientes modificaciones para implementar el patrón MVC:
    Refactorización del código existente:
    - Separación de las responsabilidades en el modelo (model), el controlador (controller) y la vista (view).- Eliminación del código redundante.- Mejora en la organización de las clases.
Implementación de nuevas clases:
    Controlador: Clase ContenidoAudiovisualController destinada a gestionar la lógica principal.Vista: Clase ContenidoAudiovisualView que permite la interacción con el usuario.Main: Clase MainApp, que actúa como el punto de entrada al programa.

Uso de principios SOLID:
Responsabilidad única: Cada clase posee una responsabilidad clara y singular.Abierto/Cerrado: Es posible ampliar la funcionalidad del programa (introducir nuevos tipos de contenido) sin necesidad de modificar las clases existentes.Inversión de dependencias: Las clases se basan en abstracciones en lugar de implementaciones concretas.

4. Clonar el Proyecto
Para clonar el proyecto desde GitHub (si está alojado allí), utiliza los siguientes pasos:

Abre la terminal y ejecuta:

bash
Copiar código
git clone <URL_DEL_REPOSITORIO>
Cambia al directorio del proyecto:

bash
Copiar código
cd <NOMBRE_DEL_REPOSITORIO>


Documentación del Proyecto
1. Resumen del Proyecto
Este proyecto es una aplicación en Java para gestionar contenido audiovisual, como películas, series de TV y documentales. Se ha estructurado siguiendo el patrón de diseño MVC (Modelo-Vista-Controlador), lo que facilita la separación de responsabilidades y el mantenimiento del código.

2. Cambios Realizados
Se realizaron las siguientes modificaciones para implementar el patrón MVC:

Refactorización del código existente:

Separación de responsabilidades en el modelo (model), controlador (controller), y vista (view).
Eliminación de código redundante.
Mejora en la organización de clases.
Estructura de paquetes:

Se creó una estructura más clara y organizada:
text
Copiar código
src/
├── main/
│   ├── java/
│   │   ├── controller/      # Lógica de negocio y control
│   │   ├── model/           # Clases de dominio
│   │   ├── util/            # Utilidades (manejo de archivos, etc.)
│   │   └── view/            # Interfaz del usuario
│   └── resources/           # Archivos de recursos
Implementación de nuevas clases:

Controlador: Clase ContenidoAudiovisualController para gestionar la lógica principal.
Vista: Clase ContenidoAudiovisualView para interactuar con el usuario.
Main: Clase MainApp como punto de entrada al programa.
Uso de principios SOLID:

Responsabilidad única: Cada clase tiene una responsabilidad clara y única.
Abierto/Cerrado: Se puede extender la funcionalidad del programa (nuevos tipos de contenido) sin modificar las clases existentes.
Inversión de dependencias: Las clases dependen de abstracciones, no de implementaciones específicas.
3. Estructura del Código
Paquete model
Contiene las clases de dominio que representan los objetos principales del sistema:

Actor: Representa a un actor.
ContenidoAudiovisual: Clase base para los diferentes tipos de contenido.
Pelicula: Representa una película.
SerieDeTV: Representa una serie de TV.
Temporada: Representa una temporada de una serie.
Documental: Representa un documental.
Paquete util
Contiene clases auxiliares:

ArchivoUtil: Manejo de lectura y escritura de archivos.
Paquete controller
Contiene la lógica de negocio y control:

ContenidoAudiovisualController: Gestiona la creación, edición, eliminación y consulta de contenido audiovisual.
Paquete view
Contiene la interfaz del usuario:

ContenidoAudiovisualView: Muestra los menús e interactúa con el usuario.
Clase MainApp
Punto de entrada principal del programa.

4. Clonar el Proyecto
Para clonar el proyecto desde GitHub (si está alojado allí), utiliza los siguientes pasos:

Abre la terminal y ejecuta:

bash
Copiar código
git clone <URL_DEL_REPOSITORIO>
Cambia al directorio del proyecto:

bash
Copiar código
cd <NOMBRE_DEL_REPOSITORIO>

5. Ejecutar el Proyecto
Requisitos Previos
Java Development Kit (JDK): Asegúrate de tener instalada una versión compatible (JDK 11 o superior).
IDE (opcional): Eclipse, VisualStudio
Maven: Para gestionar dependencias.
Instrucciones para Ejecutar
En Eclipse:
Ve a File → Import → Existing Maven Projects.
Selecciona el directorio del proyecto.
Ejecuta la clase MainApp:
Navega hasta src/main/java/MainApp.
Haz clic derecho en la clase y selecciona Run.
En VisualStudio:
Desde la opcion File puedes abrir el programa desde la carpera donde hayas guardado el proyecto
luego lo compilas y correra el programa 

6. Ejemplo de Uso
Menú Principal:
Opción 1: Crear contenido audiovisual.
Opción 2: Mostrar la lista de contenido existente.
Opción 3: Buscar contenido por título.
Opción 4: Guardar contenido en archivos.

Una vez gaurdado los contenidos se creara un archivo con txt "conetenido.txt" el cual mostrara todos los datos ingresados al igual de mostrar en el Terminal la impresion final