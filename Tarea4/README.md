# ESB_SOA BPEL

En este repositorio se encuentran proyectos desarrollados en la herramienta **OpenESB** que buscan simular un entorno de microservicios.

- El proyecto **BpelModule2** contiene toda la logica del ESB.

- El proyecto **Orquestador** gestiona el consumo de los distintos proveedores.

# Arquitectura general del ESB
![SOA](/arquitectura.png)

**paso 1**
invoca el servicio del proveedor "clientes"
![SOA](/arquitectura.png)

**paso 2**
Si la respuesta de la primera invocacion es positiva continua e invoca el servicio del proveedor "autos", de lo contrario asigna como respuesta de salida describiendo el error.
![SOA](/paso2.png)

**paso 3**
Si la respuesta de la invocacion anterior es positiva continua e invoca los servicios servicio del proveedor "pilotos" donde uno es asincrono, de lo contrario asigna como respuesta de salida describiendo el error.
![SOA](/paso3.png)

**paso 4**
Responde con los valores asignados segun las respuestas de los servicios consumidos.
![SOA](/paso4.png)

En el siguiente video se puede observar como se consume el orquestador desde el frontend:
- https://www.youtube.com/watch?v=S6cGhFtqlV8

Creado por **Byrich** 
- Carnet: 201404099
