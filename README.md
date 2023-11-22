#   Semana 15 Taller de Programación 
Este repositorio es sobre la practica calificada 3 de la semana 15 del curso de taller de programación

## Requisitos previos
Antes de comenzar, asegúrate de tener instalado lo siguiente:
- [JDK 20](https://www.oracle.com/mx/java/technologies/downloads/) (la version 20 del JDK).
- [Apache NetBeans](https://netbeans.apache.org/download/index.html) (la versión mas reciente).
- [Git](https://git-scm.com/) (para clonar el repositorio y contribuir).

## Configuración del proyecto


1. Crea una carpeta 
2. Clona o descarga este repositorio en tu maquina local:

```
https://github.com/AngelChira/taller-de-programacion-practica-calificada-n3
```

2. Abrir el Apache NetBeans y seleccionar "Open Project" en la parte superior izquierda
3. Navega hasta la ubicación del proyecto "PracticaCalificadaN3" y haz 2 click en el proyecto.
4. Esperar a que NetBeans cargue el proyecto.

## Para subir cambios

1. Crear una rama: 
git checkout -b nombre-de-la-rama-nueva
2. Ver si estas en la rama creada anteriormente: 
git status
3. git add .
4. git status
5. git commit -m "Pequeño comentario sobre los cambios realizados"
6. git push origin nombre-de-la-rama-creada

## Para bajar cambios 

1. git checkout nombre-de-la-rama-a-bajar-cambios
2. git stash   (Pausaba o reset)
3. git pull origin main  (bajar cambios)
--- en caso de error ---
4. git reset --hard FETCH_HEAD   (resetear rama)
5. git pull origin main
   
Verificar que los cambios hayan sido bajado de manera existosa. 