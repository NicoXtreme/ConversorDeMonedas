# 💱 Conversor de Monedas

## 📝 Descripción

Este proyecto es un **Conversor de Monedas** desarrollado en Java que permite a los usuarios convertir cantidades de una moneda a otra utilizando tasas de conversión obtenidas de una API externa. La aplicación cuenta con una interfaz gráfica intuitiva que facilita el uso, permitiendo seleccionar las monedas de origen y destino, así como ingresar la cantidad a convertir.

## 🌟 Características

- Interfaz gráfica amigable con Java Swing.
- Selección de monedas a convertir.
- Cálculo de tasas de conversión utilizando datos en tiempo real de una API.
- Resultados instantáneos de la conversión.
- Manejo de errores para entradas inválidas y problemas de conexión a la API.

## ⚙️ Tecnologías Utilizadas

- **Java**: Lenguaje de programación principal.
- **Gson**: Biblioteca para trabajar con JSON.
- **Swing**: Para la creación de la interfaz gráfica de usuario.

## 🌐 API Utilizada

El conversor de monedas utiliza la **API ExchangeRate-API** para obtener las tasas de conversión en tiempo real. Esta API proporciona datos actualizados sobre tasas de cambio entre diferentes monedas. 

### 🛠️ Características de la API

- **Endpoint**: `https://api.exchangerate-api.com/v4/latest/{currency}`
- **Método**: GET
- **Formato de respuesta**: JSON, que incluye la tasa de conversión para varias monedas en relación con la moneda base especificada.

## 📂 Estructura del Proyecto

El proyecto está organizado en dos paquetes principales:

- **backend**: Contiene la lógica de negocio y la conexión a la API.
- **frontend**: Incluye la interfaz gráfica y la interacción con el usuario.

### 🏗️ Clases Principales

- **ApiConnector**: Maneja la comunicación con la API de tasas de conversión. Realiza solicitudes HTTP y procesa la respuesta JSON.
- **Moneda**: Representa una moneda con su código y nombre. Se utiliza para mostrar las opciones en la interfaz gráfica.
- **RespuestaConversion**: Maneja la respuesta de la API, extrayendo las tasas de conversión para diferentes monedas.
- **ConversorMonedasGUI**: Clase principal para la interfaz gráfica y la lógica de conversión. Contiene los elementos visuales y maneja los eventos de la interfaz.

## 📥 Instalación

Para utilizar el conversor de monedas, simplemente descarga el archivo JAR que se encuentra en el repositorio.

### 🚀 Ejecución

1. Asegúrate de tener Java instalado en tu sistema.
2. Abre una terminal y navega al directorio donde descargaste el archivo JAR.
3. Ejecuta la aplicación con el siguiente comando:
   ```bash
   java -jar nombre_del_archivo.jar
### 🚧 Futuras Mejoras
Actualmente, también estoy desarrollando una versión web de este conversor de monedas. Planeo implementar esta funcionalidad una vez adquiera más conocimientos sobre cómo enviar información del lado del frontend al backend.
