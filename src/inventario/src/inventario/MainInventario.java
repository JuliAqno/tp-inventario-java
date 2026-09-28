package inventario;

public class MainInventario {
    public static void main(String[] args) {

        // ============================================
        // 1. CREACIÓN DE TRES OBJETOS INDEPENDIENTES
        // ============================================
        Producto productoUno = new Producto();
        productoUno.nombre = "Teclado mecánico";
        productoUno.codigo = "P-001";
        productoUno.precio = 45000.0;
        productoUno.stock = 12;

        Producto productoDos = new Producto();
        productoDos.nombre = "Auriculares Bluetooth";
        productoDos.codigo = "A-207";
        productoDos.precio = 32500.0;
        productoDos.stock = 8;

        Producto productoTres = new Producto();
        productoTres.nombre = "Webcam Full HD";
        productoTres.codigo = "W-045";
        productoTres.precio = 28900.0;
        productoTres.stock = 15;

        // ============================================
        // 2. FICHA INICIAL DE CADA PRODUCTO
        // ============================================
        System.out.println("### ESTADO INICIAL DEL INVENTARIO ###\n");
        productoUno.mostrarFicha();
        productoDos.mostrarFicha();
        productoTres.mostrarFicha();

        // ============================================
        // 3. OPERACIONES SOBRE productoUno
        // ============================================
        System.out.println("\n### OPERACIONES SOBRE productoUno ###");
        productoUno.venderUnidades(3);    // 12 -> 9
        productoUno.venderUnidades(50);   // error: stock insuficiente
        productoUno.reponerStock(20);     // 9 -> 29
        productoUno.actualizarPrecio(39900.0);

        // ============================================
        // 4. OPERACIONES SOBRE productoDos
        // ============================================
        System.out.println("\n### OPERACIONES SOBRE productoDos ###");
        productoDos.venderUnidades(2);    // 8 -> 6
        productoDos.reponerStock(10);     // 6 -> 16
        productoDos.reponerStock(-5);     // error: cantidad inválida
        productoDos.actualizarPrecio(29900.0);

        // ============================================
        // 5. OPERACIONES SOBRE productoTres
        // ============================================
        System.out.println("\n### OPERACIONES SOBRE productoTres ###");
        productoTres.venderUnidades(15);  // 15 -> 0
        productoTres.venderUnidades(1);   // error: stock insuficiente
        productoTres.reponerStock(7);     // 0 -> 7
        productoTres.venderUnidades(0);   // error: cantidad inválida
        productoTres.actualizarPrecio(26900.0);

        // ============================================
        // 6. VERIFICAR INDEPENDENCIA ENTRE OBJETOS
        // ============================================
        System.out.println("\n### ESTADO FINAL - CADA OBJETO MANTUVO SU PROPIO ESTADO ###\n");
        productoUno.mostrarFicha();
        productoDos.mostrarFicha();
        productoTres.mostrarFicha();

        // ============================================
        // 7. DEMOSTRACIÓN DE ALIASING DE REFERENCIAS
        // ============================================
        System.out.println("\n--- Aliasing de referencias ---");
        Producto copia = productoUno;   // NO crea objeto nuevo: copia la referencia
        copia.stock = 29;

        System.out.println("Stock de productoUno tras modificar copia: "
                + productoUno.stock + " (mismo objeto en el Heap)");

        System.out.println("Stock de productoDos (objeto independiente): "
                + productoDos.stock + " (no se vio afectado)");
    }
}
