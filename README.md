# Taller4_AREP

Extencion de un servidor web que realiza busquedas de archivos en una carpeta y devuelve en un principio aquellas clases que contienen la etiqueta @component y sus metodos

## Iniciando

Primero se debe clonar el repositorio con el siguiente comando 


git clone https://github.com/camiloarchila/Taller4_AREP.git


Posteriormente debemos Abrir en consola la carpeta clonada y utilizar el siguiente comando:


java -cp ./target/classes eci.arep.RunTest


y en el navegador de su preferencia ponemos la siguiente url http://localhost:35000/apps/ "nombre del serivicio" dentro de los nombres del servicio esta hello 

## Construido con 
* [Maven] - Administrador de dependencias

## Version 
Versión 1.0

## Autor
* [camiloarchila] Esteban Camilo Archila Bastidas 

## Descripcion estecifica

realiza busquedas de archivos en una carpeta y devuelve en un principio aquellas clases que contienen la etiqueta @component y sus metodos, los almacena dentro de un diccionario y se mmuestran en el browser indicando en la url el nombre del servicio 

Ejemplo: http://localhost:35000/apps/hello

![image](https://user-images.githubusercontent.com/69320250/221082742-ca5b8584-6d0d-42c7-86e9-1ee24e36fc97.png)
