# Software-
**Sistema de gestión de una empresa de transporte de paquetería**

**Importante leer antes de su uso:**

Manual de usuario

Manual de requerimientos funcionales y no funcionales

Manual técnico del software


**Problema presentado:**

Imagina que estás trabajando en el desarrollo de un sistema de gestión de una empresa de transporte de paquetería. Necesitas diseñar un conjunto de clases que permitan manejar diferentes tipos de envíos, como paquetes estándar, documentos urgentes y artículos frágiles. Además, debes considerar cómo calcular el costo del envío en función del tipo de servicio y las características del paquete, como peso, dimensiones y fragilidad. ¿Cómo estructurarías estas clases en un diseño orientado a objetos y qué métodos implementarías para garantizar un cálculo preciso y eficiente del costo del envío?

**Desarrollado:**

1. **Clase padre**: ("Envio"): Esta clase representa un envío genérico e incluye atributos como peso, dimensiones, fragilidad y los detalles del remitente y destinatario. También implementa un método para calcular el costo del envío, que es común para todos los tipos de envíos. Podrías considerar refinar este método en clases hijas según las necesidades específicas de cada tipo de envío.

2. **Clases Derivadas:** Para cada tipo de envío (paquete estándar, documento urgente, artículo frágil), cree una clase derivada que herede de la clase padre "Envio". Cada una de estas clases le implemente métodos específicos según las características únicas del tipo de envío. Por ejemplo, podrías incluir un método para manejar el cálculo del costo del envío que tenga en cuenta las tarifas adicionales por urgencia o fragilidad.

3. **Métodos Específicos:** Además del método "calcularCostoEnvio", implemente otros métodos específicos en las clases derivadas, como por ejemplo, un método para determinar si un envío es frágil, un método para verificar si un paquete cumple con ciertas dimensiones mínimas, etc.

4. **Reutilización de Código:** Hice mucho uso de lo que llamamos 'reutilización de código' ya que esto nos acota el tiempo que podemos gastar en el código.

5. **Encapsulamiento y Modularidad:** Me asegure de que este diseño sea modular y esté bien encapsulado. Esto significa que cada clase debe tener una responsabilidad clara y no depender demasiado de otras clases para su funcionamiento.


Le hizo falta muchas funciones al proyecto que me hubiese gustado agregar, pero espero poder hacerlo en un futuro ;)
