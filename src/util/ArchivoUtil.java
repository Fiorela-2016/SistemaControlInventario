/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;
import excepciones.ArchivoException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import modelo.Producto;
/**
 *
 * @author fiore
 */
public class ArchivoUtil {
    public static void exportar(File archivo, List<Producto> productos) throws ArchivoException {
        
        try (BufferedWriter bw = new BufferedWriter( new FileWriter(archivo))) {
            
            bw.write("ID, Codigo, Nombre, Categoria, Cantidad, Precio, Disponible");
            bw.newLine();
            
            
            for(Producto p : productos){
                
                bw.write(
                        p.getId() + "," +
                        p.getCodigo() + "," +
                        p.getNombre() + "," +
                        p.getCategoria() + "," +
                        p.getCantidad() + "," +
                        p.getPrecio() + ", " +
                        p.getDisponible());
                bw.newLine();
            }
            
        }
        catch(IOException e) {
            
            throw new ArchivoException("Error al exportar el archivo. ",  e);
        }
    }
}
