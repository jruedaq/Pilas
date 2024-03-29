package PilaLista;

import javax.swing.*;

public class Main {
    public static void main(String... s) throws Exception {
        PilaLista list = new PilaLista(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de cupos")));

        while (true) {
            int option = Integer.parseInt(JOptionPane.showInputDialog("Seleccione una opción\n" +
                    "1 - Ingresar\n" +
                    "2 - Retirar\n" +
                    "3 - Consultar\n" +
                    "4 - ¿Hay espacio?\n" +
                    "5 - Salir\n"
            ));

            switch (option) {
                case 1:
                    if (list.length() < list.getMaxLength()) {
                        list.insertar(new Vehicle(JOptionPane.showInputDialog("Ingrese la placa del vehiculo")));
                    } else {
                        JOptionPane.showMessageDialog(null, "La pila está llena");
                        list.print();
                    }
                    break;

                case 2:
                    String enrollment = JOptionPane.showInputDialog("Ingrese la placa del vehiculo a retirar");
                    Vehicle vehicle = (Vehicle) list.cimaPila();
                    if (vehicle.enrollment.equals(enrollment)) {
                        list.quitar();
                        JOptionPane.showMessageDialog(null, "Se ha retirado el vehiculo de placas " + enrollment);
                    } else {
                        JOptionPane.showMessageDialog(null, "No fue posible retirar debido a que no está en la cima, debe esperar a los vehiculos listados en la consola");
                        list.print(enrollment);
                    }
                    break;

                case 3:
                    list.print();
                    break;

                case 4:
                    if (list.length() < list.getMaxLength()) {
                        JOptionPane.showMessageDialog(null, "La pila tiene espacio disponible");
                        list.print();
                    } else {
                        JOptionPane.showMessageDialog(null, "La pila está llena");
                        list.print();
                    }
                    break;

                case 5:
                    System.exit(20);
            }
        }
    }
}
