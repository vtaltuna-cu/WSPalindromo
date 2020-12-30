# WSPalindromo

WebService que devuelve listado de productos, en caso que el texto de búsqueda sea un palíndromo con mas de 3 caracteres devuelve los productos (campos brand y description) con descuento del 50%. En caso que el texto de búsqueda sea un valor entero, se busca si existe el producto con ese id con su respectivo descuento del 50% si se cumpliera que es un palindromo, para lo cual solo es necesario que sea mayor que 10.

@WebMethod(operationName = "getProducts")

@WebParam(name = "search")  Texto de búsqueda
@WebParam(name = "page")     Página de dentro del paginado 
@WebParam(name = "pageSize") Cantidad de elemento por página

Se devuelve un Json con el listado de productos
El objeto Producto trae como atributos discount, percent y finalPrice, que corresponden a si tiene descuento, el porciento que se decuenta (0 en caso que no) y el precio final luego de aplicado el descuento.

Con esta estructura permite que la página web que obtiene los datos n tenga que hacer ninguna validación adicional a producto en especifico o a lote de productos.

Se devuelve también la página del paginado, la cantidad de elementos de la lista sin aplicar el paginado.
