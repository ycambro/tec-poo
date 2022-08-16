**Practica 1**
==========

> Yurgen Isack Cambronero Mora, Carnet: 2022128005

## Comandos utilizados
```bash

# Clonar el repositorio
git clone https://github.com/ycambro/tec-poo

# Crear branch "develop"
git checkout -b develop

# Directorio practicas
md practicas
cd practicas

# Directorio practica-1
md practica-1
cd practica-1

.
.
.
# Crear archivo HelloWorld.java
Se creo de forma manual porque no encontre el comando para crear archivos desde el cmd en Windows

# Ejecutar archivo HelloWorld.java
javac HelloWorld.java
java HelloWorld

# Crear archivo README.md
Se creo de forma manual porque no encontre el comando para crear archivos desde el cmd en Windows

# Publicar primeros cambios a GitHub
git add .
git commit -m "Primera Practica"
git push --set-upstream origin develop

# Hacer tag practica-1
git tag -a practica-1 -m "Primera practica de POO"
git push practica-1

# Hacer merge de branch develop en main
git checkout main
git merge develop

# Publicar finales cambios a GitHub
git add .
git commit -m "Primera Practica"
git push origin main

# Borrar branch develop
git branch -d develop
git push origin :develop
.
.
.
```
