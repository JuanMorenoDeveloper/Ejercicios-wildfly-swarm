# libreria-rest-endpoint
Servidor Rest de ejemplo con wildfly swarm, se usa para administrar datos de inventario de una libreria.

URL disponibles
	http://localhost:8080/v1/libro/
	http://localhost:8080/v1/categoria/

Métodos disponibles:
GET “/” Devuelve la lista completa de objetos, ejemplo: 
	Petición:  http://localhost:8080/v1/libro/
	Respuesta:[{"id":1,"nombre":"Cien años de soledad","codigo":"NOV01","cantidad":10,"categoria":{"id":1,"nombre":"Novela"}},{"id":2,"nombre":"Harry Potter Serie","codigo":"AVEN01","cantidad":10,"categoria":{"id":3,"nombre":"Aventura"}},{"id":3,"nombre":"El principito","codigo":"INF01","cantidad":10,"categoria":{"id":5,"nombre":"Infantil"}}]

	Petición GET:  http://localhost:8080/v1/categoria/
	Respuesta: [{"id":1,"nombre":"Novela"},{"id":2,"nombre":"Sci-fi"},{"id":3,"nombre":"Aventura"},{"id":4,"nombre":"Misterio"},{"id":5,"nombre":"Infantil"}]

GET “/{id}”, Devuelve objeto con id especificado, ejemplo
	Petición GET: http://localhost:8080/v1/libro/1
	Respuesta: {"id":1,"nombre":"Doscientos años de soledad","codigo":"NOV01","cantidad":10,"categoria":{"id":1,"nombre":"Novela"}}

POST “/”, Inserta objeto en la lista, se envía parámetro de formulario “libro:json”, ejemplo:

	Petición POST: http://localhost:8080/v1/libro/
	Body: 
	Content-Type: x-www-form-urlencoded
	libro={"id":0,"nombre":"Trescientos años de soledad","codigo":"NOV01","cantidad":10,"categoria":{"id":1,"nombre":"Novela"}}
	Respuesta: Guardado correctamente

PUT “/”, Actualiza objeto en la lista, se envía parámetro de formulario “libro:json”, ejemplo:

	Petición PUT: http://localhost:8080/v1/libro/
	Body: 
	Content-Type: x-www-form-urlencoded
	libro={"id":0,"nombre":"Trescientos años de soledad","codigo":"NOV01","cantidad":10,"categoria":{"id":1,"nombre":"Novela"}}
	Respuesta: Actualizado correctamente

DELETE “/{id}”, Borrar objeto con id especificado, ejemplo
	Petición DELETE: http://localhost:8080/v1/libro/1
	Respuesta: Borrado correctamente

