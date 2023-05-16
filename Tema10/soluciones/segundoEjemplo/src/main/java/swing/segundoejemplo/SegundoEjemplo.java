/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package swing.segundoejemplo;

import javax.swing.JOptionPane;

/**
 *
 * @author cic
 */
public class SegundoEjemplo {

    public static void main(String[] args) {
       
        //showMessageDialog
        // mensaje plano
        JOptionPane.showMessageDialog(null, "Mensaje plano", "Mensaje", JOptionPane.PLAIN_MESSAGE);
        // mensaje de error
        JOptionPane.showMessageDialog(null, "Mensaje de error", "Error", JOptionPane.ERROR_MESSAGE);
        // mensaje informativo
        JOptionPane.showMessageDialog(null, "Mensaje informativo", "Información", JOptionPane.INFORMATION_MESSAGE);
        // mensaje de atención o aviso
        JOptionPane.showMessageDialog(null, "Mensaje de atención ", "Aviso", JOptionPane.WARNING_MESSAGE);
        // mensaje de pregunta
        JOptionPane.showMessageDialog(null, "Mensaje de pregunta", "Pregunta", JOptionPane.QUESTION_MESSAGE);
        
        int respuesta;
        String mensaje="";
        //showConfirmDialog
        // mensaje de confirmacion por defecto
        JOptionPane.showConfirmDialog(null, "Aqui va el mensaje", "Ventana por defecto", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
        // mensaje de confirmacion SI_NO
        respuesta = JOptionPane.showConfirmDialog(null, "Aqui va el mensaje", "Ventana SI-NO", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (respuesta ==0){
            mensaje="ha contestado si";
        } else {
            mensaje="ha respondido no";
        }
        JOptionPane.showMessageDialog(null, mensaje, "Respuesta", JOptionPane.PLAIN_MESSAGE);

        // mensaje de confirmacion SI_NO_Cancelar
        respuesta = JOptionPane.showConfirmDialog(null, "Aqui va el mensaje", "Ventana SI-NO-Cancelar", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        switch (respuesta) {
            case 0 ->
                mensaje="ha contestado si";
            case 1 ->
                mensaje="ha respondido no";
            default ->
                mensaje="ha cancelado";
        }
        JOptionPane.showMessageDialog(null, mensaje, "Respuesta", JOptionPane.PLAIN_MESSAGE);
        
        // mensaje de Aceptar -Cancelar
        respuesta = JOptionPane.showConfirmDialog(null, "Aqui va el mensaje", "Ventana Aceptar-Cancelar", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (respuesta == 0) {
            mensaje="ha contestado aceptar";
        } else {
            mensaje="ha respondido cancelar";
        }
         JOptionPane.showMessageDialog(null, mensaje, "Respuesta", JOptionPane.PLAIN_MESSAGE);
        
        //ShowOptionDialog
        //Para escoger entre botones
        Object[] options = {"Si, lo es", "No, para nada", "Cancelar"};

        respuesta = JOptionPane.showOptionDialog(null, "¿Es importante unir programacion y creatividad?", "Pregunta",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,null, options, options[0]);

        //Para mostrar informacion
        mensaje = switch (respuesta) {
            case 0 -> "tu si que sabes";
            case 1 -> "apaga y vamonos";
            default -> "no sabe, no contesta";
        };
        JOptionPane.showMessageDialog(null, mensaje, "Respuesta", JOptionPane.WARNING_MESSAGE);
        
       //ShowInputDialog
       //Para introducir un string
        String contesta = JOptionPane.showInputDialog("Dime tu nombre: ");
        JOptionPane.showMessageDialog(null, "Hola " + contesta);

        //Para elegir entre diferentes opciones
        Object color = JOptionPane.showInputDialog(null, "Seleccione un color",
                "COLORES", JOptionPane.QUESTION_MESSAGE, null,
                new Object[]{"Seleccione", "Amarillo", "Azul", "Rojo"}, "Seleccione");
        JOptionPane.showMessageDialog(null, color.toString());

    }
}
