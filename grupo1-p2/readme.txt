Carga de datos
Para comenzar con la carga de datos, primero creamos un File llamado "fileDir" al que se le pone como argumento la direccion 
(el nombre) del archivo que se quiere cargar. Luego creamos un BufferedReader, que como argumento lleva un InputStreamReader, 
que extende de Reader, y permite leer el archivo con la codificacion "UTF8". Para hacer esto, ponemos como argmento un 
FileInputStream y el nombre de la codificación deseada, en este caso "UTF8".
El documento tiene comillas alrededor de cada elemento de cada columna, y para evitar los problemas al guardar los datos 
como String y que no se guarden con comillas extras, primero borramos las comillas al comienzo y al final de cada linea y 
luego utilizamos como separadores de las columnas "/";/"";

Para que sea mas entendible a que columna corresponde cada elemento del array que devuelve el BufferedReader, creamos una 
clase llamada "Especificaciones", que al instanciarla, se le pasa como argumento un array de String con los nombres de 
las columnas y devuelve un array con los indices de la columna correspondiente.
Creamos metodos privados, para determinar si las empresas, clases, paises y marcas ya fueron creados anteriormente, 
y en ese caso utilizamos esos objetos, en cambio si todavia no existen los creamos.
El rubro tiene dos posibles valores disponibles, ypuede contenerlos a ambos, entonces para arreglar este problema 
creamos un metodo auxiliar que separa por "-" y guarda cada elemento en una lista, que podra tener maximo dos elementos.

Para guardar los datos del archivo csv, creamos estructuras Hash y pusimos como tamaño inicial una aproximacion a la 
cantidad de datos que hay en la tabla para ahorrar tiempo en la carga de datos, pero si se cargan mas datos los Hash 
adaptan su tamaño.

Encontramos una peculiaridad en los nombres de las marcas, donde en momentos se encontraban dos espacios en blanco 
seguidos, por lo que le quitamos un espacio a la marca que contiene dos espacios, para que podamos identificarlas como 
la misma marca.

Reporte
Para la realizacion de cada reporte debemos recorrer el Hash que contiene todos los productos, y para realizar esto 
utilizamos la clase MyIterator que extiende de Iterator que es de java.util, para una efectiva recorrida del Hash.
Ademas creamos clases auxiliares, en las que guardamos, ademas de las Empresas, Pais, etc un atributo que es la cantidad 
de productos habilitados que contiene esa instancia. De esta manera podemos guardar los datos necesarios para los reportes 
sin tener que agregar propiedades especificas a los reportes a las clases principales. Estas clases auxiliares son creadas 
solo dentro de los reportes, lo que evita el gasto de recursos y memoria para las acciones fuera de los mismos. 
Para el ordenamiento de los datos segun la cantidad de productos habilitados, los insertamos en una estructura de Queue 
con prioridad, donde la prioridad es la cantidad de productos habilitados. 

Medicion de eficiencia
Duracion promedio de la carga de datos: 1060ms
Duracion promedio del reporte 1: 31ms
Duracion promedio del reporte 2: 280ms
Duracion promedio del reporte 3: 25ms
Duracion promedio del reporte 4: 196ms