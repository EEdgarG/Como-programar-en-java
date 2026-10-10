# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Qué es este repositorio

Ejercicios resueltos del libro *Cómo programar en Java*, 10ª edición (Deitel). Todo el código, los comentarios y los nombres de clases y carpetas están en español; mantén esa convención.

No es un proyecto único: cada ejercicio es un **proyecto NetBeans 8 independiente** (Ant, `build.xml` + `nbproject/`), sin dependencias externas, sin pruebas unitarias y sin linter. Los proyectos no comparten código entre sí: clases con el mismo nombre (`Fecha`, `Cuenta`, `Empleado`…) se copian y modifican en cada ejercicio que las necesita.

## Estructura y nomenclatura

- `CapituloNN/` agrupa los ejercicios de un capítulo (faltan los capítulos 11–13).
- Capítulos 02–14: carpeta `CapNN - XX Ejercicio N.MM Descripción`, donde `XX` es el orden dentro del capítulo y `N.MM` el número del ejercicio en el libro (un proyecto puede cubrir varios, p. ej. `Ejercicio 5.24 y 5.25`).
- Capítulo 15 usa otro formato: `EjercicioXX-15.MM-Descripción`. Sigue el formato del capítulo en el que trabajes.
- El código está en `src/`. Casi todo usa el paquete por defecto; la excepción es `Capitulo15/Ejercicio02-15.06-…`, con paquetes `Objetos`, `abrirArchivos` y `creacionArchivos`.
- La clase con `main` suele ser `Prueba<Clase>`; la fuente de verdad es `main.class` en `nbproject/project.properties`.
- Capítulo 09 incluye diagramas UML (`.mdj` de StarUML, `.svg`) sin código en algunos ejercicios.
- Todos los proyectos apuntan a Java 1.8 (`javac.source/target=1.8`) y UTF-8. No uses características posteriores a Java 8 (`var`, records, text blocks, etc.).

## Compilar y ejecutar un ejercicio

Ant no está instalado en el entorno; compila directamente con `javac`. Las rutas tienen espacios y comas, así que siempre entre comillas:

```bash
P="Capitulo03/Cap03 - 02 Ejercicio 3.12 Factura"
javac -d /tmp/out "$P"/src/*.java
java -cp /tmp/out PruebaFactura
```

Para proyectos con paquetes (subcarpetas en `src/`):

```bash
find "$P/src" -name '*.java' -print0 | xargs -0 javac -d /tmp/out
```

Compila fuera del repo (`-d` a un directorio temporal): `build/` y `dist/` están en `.gitignore`.

Los ejercicios del capítulo 15 leen y escriben archivos con rutas relativas (`trans.txt`, `antmaest.txt`, `*.ser`…), que están versionados en la raíz de cada proyecto. Ejecútalos con el directorio de trabajo en la raíz del proyecto (como hace NetBeans), no en la raíz del repo: `cd "$P" && java -cp /tmp/out <MainClass>`. Ejecutarlos sobrescribe esos archivos de datos.

## Al agregar un ejercicio nuevo

Replica la estructura de un proyecto vecino del mismo capítulo (`src/`, `build.xml`, `manifest.mf`, `nbproject/` con `project.properties` ajustando `main.class` y nombre). En los proyectos recientes `nbproject/private/` se excluye añadiendo la ruta de cada proyecto al `.gitignore` raíz (muchos proyectos antiguos sí la tienen versionada; no la borres de ellos). Las cabeceras Javadoc existentes usan `@author EEdgar`.
