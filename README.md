# 💱 Conversor de Monedas en Java

Aplicación de consola en Java que permite convertir monedas usando la API pública [ExchangeRate API](https://www.exchangerate-api.com/). Ideal para practicar consumo de APIs, manejo de JSON, y modularización de código Java.

---

## 🚀 Características

- Menú interactivo en consola
- Conversión entre:
  - USD <=> ARS
  - USD <=> BRL
  - USD <=> COP
- Uso de `HttpClient` para solicitudes HTTP
- Parseo de JSON con **Gson**
- Lectura de claves de entorno con **dotenv**
- Organización por packages

---

## 📦 Requisitos

- Java 17 o superior
- Descarga manual de los siguientes `.jar`:

| Librería      | Descargar desde                                               |
|---------------|---------------------------------------------------------------|
| `gson.jar`    | [https://repo1.maven.org/maven2/com/google/code/gson/gson/2.10.1/gson-2.10.1.jar](https://mvnrepository.com/artifact/com.google.code.gson/gson) |
| `dotenv-java` | [https://repo1.maven.org/maven2/io/github/cdimascio/dotenv-java/2.2.4/dotenv-java-2.2.4.jar](https://mvnrepository.com/artifact/io.github.cdimascio/dotenv-java) |

> 📁 Copiá ambos archivos `.jar` en una carpeta `lib/` dentro de tu proyecto.


**Con IntelliJ IDEA (recomendado):**
   - En IntelliJ, simplemente agrega las dependencias utilizando el sistema de módulos.
     - Abre el proyecto en IntelliJ.
     - Ve a **File > Project Structure**.
     - En la sección **Libraries**, haz clic en el botón de "+" para agregar nuevas librerías.
     - Busca las librerías `gson.jar` y `dotenv-java.jar`, o usa la opción de agregar dependencias directamente desde Maven.

---

## 🛠️ Configuración

1. **Crear manualmente el archivo `.env`** en la raíz del proyecto con tu API key:

EXCHANGE_RATE_API_KEY=tu_api_key_aqui


## 📋 Menú de opciones (ejemplo)
******** CONVERSOR DE MONEDAS ********
1) USD => ARS
2) ARS => USD
3) USD => BRL
4) BRL => USD
5) USD => COP
6) COP => USD
7) Salir

Elija la opción: 1
Ingrese el monto a convertir: 100
Resultado: 100,00 USD = 117200,00 ARS



