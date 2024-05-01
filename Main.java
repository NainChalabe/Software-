package empresa;
import java.util.Scanner;

// Clase 
public class Main {

    // Método para imprimir lentamente
    public static void mostrarTextoLentamente(String texto) {
        for (char caracter : texto.toCharArray()) {
            System.out.print(caracter);
            try {
                Thread.sleep(0);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }

    // Método principal q inicia
    public static void main(String[] args) {
        // Bienvenida
        String bienvenida = "¡Bienvenid@ a FastHaul!\n" +
        "\nEn FastHaul nos dedicamos a brindarte soluciones rápidas y confiables para tus necesidades de envío.\n" +
        "Ofrecemos una variedad de tipos de envío para adaptarnos a tus necesidades específicas:\n" +
        "\n(Estos envios se hacen a nivel nacional)"+
        "\n1. Envío Estándar: Para tus paquetes regulares que no tienen prisa.\n" +
        "2. Envío Urgente: Si necesitas que tu paquete llegue rápidamente a su destino.\n" +
        "3. Envío de Artículos Frágiles: Para objetos delicados que requieren un manejo especial y cuidadoso.\n" +
        "\nEn FastHaul, estamos comprometidos a proporcionarte la mejor experiencia de envío posible.\n" +
        "¡Confía en nosotros para llevar tus paquetes rápido y seguro a su destino!\n";
        mostrarTextoLentamente(bienvenida);

        Scanner scanner = new Scanner(System.in); 
        int opcion; 

        // Ciclo para solicitar una opción 
        while (true) {
            System.out.println("___________________________________________________________________________________________________________");
            System.out.println("\n¿Qué tipo de servicio de envío deseas utilizar?");
            System.out.println("\n1. Envío Estándar");
            System.out.println("2. Envío Urgente");
            System.out.println("3. Envío de Artículos Frágiles");
            System.out.print("\nPor favor selecciona una opción: ");
            opcion = scanner.nextInt(); 
            scanner.nextLine(); 

            // Validar la opción seleccionada 
            switch (opcion) {
                case 1:
                case 2:
                case 3:
                    break;
                default:
                    System.out.println("Opción no válida. Por favor selecciona una opción válida.");
                    continue; 
            }
            break; 
        }

        // Solicitar datos esenciales para el envío
        System.out.println("\nPor favor ingresa los datos esenciales para el envío:");
        System.out.println("\nRemitente:");
        System.out.print("Nombre completo del remitente: ");
        String nombreRemitente = scanner.nextLine();
        System.out.print("Número de documento del remitente: ");
        String documentoRemitente = scanner.nextLine();
        System.out.print("Número de celular del remitente: ");
        String celularRemitente = scanner.nextLine();
        System.out.print("Ciudad del remitente: ");
        String ciudadRemitente = scanner.nextLine();
        System.out.print("Dirección del remitente: ");
        String direccionRemitente = scanner.nextLine();

        // Solicitar datos del destinatario
        System.out.println("\nDestinatario:");
        System.out.print("Nombre completo del destinatario: ");
        String nombreDestinatario = scanner.nextLine();
        System.out.print("Número de documento del destinatario: ");
        String documentoDestinatario = scanner.nextLine();
        System.out.print("Número de celular del destinatario: ");
        String celularDestinatario = scanner.nextLine();
        System.out.print("Ciudad del destinatario: ");
        String ciudadDestinatario = scanner.nextLine();
        System.out.print("Dirección del destinatario: ");
        String direccionDestinatario = scanner.nextLine();

        System.out.print("\nNombre del artículo: "); 
        String nombreArticulo = scanner.nextLine();
        System.out.print("Peso del envío (en kg): ");
        double peso = scanner.nextDouble();
        System.out.print("Dimensiones del envío (en cm): ");
        double dimensiones = scanner.nextDouble();
        System.out.print("¿El envío es frágil? (true/false): ");
        boolean fragil = scanner.nextBoolean();

        String tipoEnvio = ""; // Almacenar
        double precioEnvio = 0.0; // Almacenar 

        Envio envio = null; 
        // Crear el objeto de envío según la opción seleccionada por el usuario
        switch (opcion) {
            case 1:
                tipoEnvio = "Envío Estándar";
                envio = new Paquete(peso, dimensiones, fragil, nombreRemitente, nombreDestinatario, direccionRemitente, direccionDestinatario,
                                    documentoRemitente, documentoDestinatario, celularRemitente, celularDestinatario, ciudadRemitente, ciudadDestinatario);
                break;
            case 2:
                tipoEnvio = "Envío Urgente";
                envio = new DocumentoUrgente(peso, dimensiones, fragil, nombreRemitente, nombreDestinatario, direccionRemitente, direccionDestinatario,
                                             documentoRemitente, documentoDestinatario, celularRemitente, celularDestinatario, ciudadRemitente, ciudadDestinatario);
                break;
            case 3:
                tipoEnvio = "Envío de Artículos Frágiles";
                envio = new ArticuloFragil(peso, dimensiones, fragil, nombreRemitente, nombreDestinatario, direccionRemitente, direccionDestinatario,
                                           documentoRemitente, documentoDestinatario, celularRemitente, celularDestinatario, ciudadRemitente, ciudadDestinatario);
                break;
        }

        // Calcular el precio del envío y crear la factura
        if (envio != null) {
            precioEnvio = envio.calcularCostoEnvio();
            System.out.println("El costo del envío es: $" + precioEnvio + " pesos colombianos");

            Factura factura = new Factura(envio, tipoEnvio, precioEnvio,nombreArticulo);
            factura.imprimirFactura();
        } else {
            System.out.println("No se pudo crear el envío.");
        }

        scanner.close(); // cierre de scanner
    }
}
