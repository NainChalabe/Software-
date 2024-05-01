package empresa;

// Clase padre
class Envio {
    // Atributos 
    private double peso;
    private double dimensiones;
    private boolean fragil;
    private String nombreRemitente;
    private String nombreDestinatario;
    private String direccionRemitente;
    private String direccionDestinatario;
    private String documentoRemitente;
    private String documentoDestinatario;
    private String celularRemitente;
    private String celularDestinatario;
    private String ciudadRemitente;
    private String ciudadDestinatario;

    // Constructor de la clase
    public Envio(double peso, double dimensiones, boolean fragil, String nombreRemitente, String nombreDestinatario,
                 String direccionRemitente, String direccionDestinatario, String documentoRemitente, String documentoDestinatario,
                 String celularRemitente, String celularDestinatario, String ciudadRemitente, String ciudadDestinatario) {
        
        this.peso = peso;
        this.dimensiones = dimensiones;
        this.fragil = fragil;
        this.nombreRemitente = nombreRemitente;
        this.nombreDestinatario = nombreDestinatario;
        this.direccionRemitente = direccionRemitente;
        this.direccionDestinatario = direccionDestinatario;
        this.documentoRemitente = documentoRemitente;
        this.documentoDestinatario = documentoDestinatario;
        this.celularRemitente = celularRemitente;
        this.celularDestinatario = celularDestinatario;
        this.ciudadRemitente = ciudadRemitente;
        this.ciudadDestinatario = ciudadDestinatario;
    }

    // Métodos para los atributos del remitente y destinatario
    public String getNombreRemitente() {
        return nombreRemitente;
    }

    public String getNombreDestinatario() {
        return nombreDestinatario;
    }

    public String getDireccionRemitente() {
        return direccionRemitente;
    }

    public String getDireccionDestinatario() {
        return direccionDestinatario;
    }

    public String getDocumentoRemitente() {
        return documentoRemitente;
    }

    public String getDocumentoDestinatario() {
        return documentoDestinatario;
    }

    public String getCelularRemitente() {
        return celularRemitente;
    }

    public String getCelularDestinatario() {
        return celularDestinatario;
    }

    public String getCiudadRemitente() {
        return ciudadRemitente;
    }

    public String getCiudadDestinatario() {
        return ciudadDestinatario;
    }

    // Métodos para el peso, dimensiones y fragilidad del envío
    public double getPeso() {
        return peso;
    }

    public double getDimensiones() {
        return dimensiones;
    }

    public boolean esFragil() {
        return fragil;
    }

    // Método para calcular el costo del envío
    public double calcularCostoEnvio() {
        double costoBase = getPeso() * 3000.0;
        double costoFinal = costoBase;

        if (esFragil()) {
            costoFinal += 10000.0;
        }

        double dimensionesExtras = getDimensiones() - 5;
        if (dimensionesExtras > 0) {
            double costoDimensiones = (dimensionesExtras / 5) * 1000.0;
            costoFinal += costoDimensiones;
        }

        return costoFinal;
    }
}

// Clase paquete, hereda clase padre
class Paquete extends Envio {
    // Constructor 
    public Paquete(double peso, double dimensiones, boolean fragil, String nombreRemitente, String nombreDestinatario,
                   String direccionRemitente, String direccionDestinatario, String documentoRemitente, String documentoDestinatario,
                   String celularRemitente, String celularDestinatario, String ciudadRemitente, String ciudadDestinatario) {
        // Llamado al constructor
        super(peso, dimensiones, fragil, nombreRemitente, nombreDestinatario, direccionRemitente, direccionDestinatario,
              documentoRemitente, documentoDestinatario, celularRemitente, celularDestinatario, ciudadRemitente, ciudadDestinatario);
    }
}

// Clase documeto urgente, hereda clase padre
class DocumentoUrgente extends Envio {
    // Constructor 
    public DocumentoUrgente(double peso, double dimensiones, boolean fragil, String nombreRemitente, String nombreDestinatario,
                             String direccionRemitente, String direccionDestinatario, String documentoRemitente, String documentoDestinatario,
                             String celularRemitente, String celularDestinatario, String ciudadRemitente, String ciudadDestinatario) {
        // Llamado al constructor
        super(peso, dimensiones, fragil, nombreRemitente, nombreDestinatario, direccionRemitente, direccionDestinatario,
              documentoRemitente, documentoDestinatario, celularRemitente, celularDestinatario, ciudadRemitente, ciudadDestinatario);
    }
}

// Clase artículo frágil, hereda clase padre
class ArticuloFragil extends Envio {
    // Constructor 
    public ArticuloFragil(double peso, double dimensiones, boolean fragil, String nombreRemitente, String nombreDestinatario,
                          String direccionRemitente, String direccionDestinatario, String documentoRemitente, String documentoDestinatario,
                          String celularRemitente, String celularDestinatario, String ciudadRemitente, String ciudadDestinatario) {
        // Llamado al constructor
        super(peso, dimensiones, fragil, nombreRemitente, nombreDestinatario, direccionRemitente, direccionDestinatario,
              documentoRemitente, documentoDestinatario, celularRemitente, celularDestinatario, ciudadRemitente, ciudadDestinatario);
    }

    // Método para calcular el costo del envío, sobrescribe el método de la clase padre
    @Override
    public double calcularCostoEnvio() {
        // Llamado al método de la clase padre y agrega un costo adicional por ser frágil
        double costoFinal = super.calcularCostoEnvio();
        costoFinal += 50000.0; // Agrega un costo fijo adicional por ser frágil
        return costoFinal;
    }
}

// Clase q representa una factura
class Factura {
    // Atributos 
    private Envio envio;
    private String tipoEnvio;
    private double precioEnvio;
    private String nombreArticulo;
    // Constructor 
    public Factura(Envio envio, String tipoEnvio, double precioEnvio, String nombreArticulo) {
        
        this.envio = envio;
        this.tipoEnvio = tipoEnvio;
        this.precioEnvio = precioEnvio;
        this.nombreArticulo = nombreArticulo;
    }

    // Método para imprimir la factura
    public void imprimirFactura() {
        System.out.println("\n************** Factura **************");
        System.out.println("Tipo de envío: " + tipoEnvio);
        System.out.println("Nombre del artículo: " + nombreArticulo);
        System.out.println("Datos del remitente:");
        System.out.println("Nombre: " + envio.getNombreRemitente());
        System.out.println("Documento: " + envio.getDocumentoRemitente());
        System.out.println("Celular: " + envio.getCelularRemitente());
        System.out.println("Ciudad: " + envio.getCiudadRemitente());
        System.out.println("Dirección: " + envio.getDireccionRemitente());
        System.out.println("Datos del destinatario:");
        System.out.println("Nombre: " + envio.getNombreDestinatario());
        System.out.println("Documento: " + envio.getDocumentoDestinatario());
        System.out.println("Celular: " + envio.getCelularDestinatario());
        System.out.println("Ciudad: " + envio.getCiudadDestinatario());
        System.out.println("Dirección: " + envio.getDireccionDestinatario());
        System.out.println("Precio del envío: $" + precioEnvio + " pesos colombianos");
        System.out.println("************************************");
    }
}