Moraleja:
-Ten cuidado con las llamadas entre clases, es decir si una clase A en su instancia/atributo llama a la clase B y esta clase B en su instancia/atributo llama a la clase A se genera un bucle de llamadas que al final colapsan la ejecución el programa.
Por lo tanto en la clase Inicio declaré que se cree una instancia de de AdministradorInterfaz y UsuarioInterfaz, en en ambas interfaces no declaro una instancia de Inicio como atributo o en el constructor, si no cuando necesito usar dicha instancia
como por ejemplo cuando estoy en la clase AdministradorInterfaz, creo un objeto de tipo Inicio más no declaro su instancia como atributo ni en el constructo y al darle click al boton de regresaInicio este boton cree una instancia y declare dicho objeto Inicio
y con ese objeto realize las operaciones correspondientes.

-Lo mismo aplique con la clase AdministradorInterfaz y las clases CrearRegistro y EditarRegistro. En la clase AdministradorInterfaz cree las intancias de ambas clases en la seccion de atributos, pero en ambas clases solo cree un objeto de tipo AdministradorInterfaz
y cuando necesitaba usar dicho objeto, lo iniciaziba en su bloque de codigo correspondiente.

Esta reflexión es luego de fracasar mi primer intento en crear esta aplicación, pues me vi forzado a usar git y github para ver cual era el error que me tuvo 2 dias enteros intentando darle solución, ya que mi curso de Java se me hacia incapie que instanciar
una clase cada que se realize un evento es una mala práctica, sin embargo tuve que aplicar este concepto para sacarme de ese apuro pues no encontraba otra solución. 

Gracias por leer y probar mi aplicación es una beta que hice luego de leer la consigna del proyecto final, recalco que no es como tal el proyecto final pues en el momento que redacto esto no vi la solucion de la profesora, solo leí la consiga y trabajé sobre lo que
he aprendido en anteriores ejercicios del mismo curso.
El curso es "Programación Orientada a Objetos con Java" de la profesora "Luisina de Paula".

https://todocodeacademy.com/course/programacion-orientada-a-objetos-con-java/
