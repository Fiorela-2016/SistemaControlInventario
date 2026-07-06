/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositorio;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import modelo.Producto;
/**
 *
 * @author fiore
 */
public class ProductoRepositorio {
    
 private static  List<Producto> productos = new ArrayList<>();

private  static Set<String> codigos = new HashSet<>();

private static Map<String, Integer> categorias = new HashMap<>();

private static Stack<String> historial = new Stack<>();

private static int siguienteId = 1;




public void agregar(Producto producto){
    producto.setId(siguienteId);
    siguienteId++;
    
    productos.add(producto);
    codigos.add(producto.getCodigo());
    
    categorias.put(producto.getCategoria(), categorias.getOrDefault(producto.getCategoria(), 0) + 1);
    
    historial.push("Producto registrado: " + producto.getNombre());
}


public List<Producto> listar(){
    return productos;
}

public Producto buscarPorCodigo(String codigo){
    for(Producto producto: productos){
        
        if(producto.getCodigo().equalsIgnoreCase(codigo)){
        return producto;
    }
        
    }
    return null;
}


public boolean existeCodigo(String codigo){
    return buscarPorCodigo(codigo) != null;
    
}


public boolean editar(Producto productoActualizado){
    for(int i = 0; i <productos.size(); i ++) {
        
        if(productos.get(i).getId() == productoActualizado.getId()){
            
            
            productos.set(i, productoActualizado);
            
            historial.push("Producto editado: " + productoActualizado.getNombre());
            
            return true;
        }
        }
    return false;
    }
public boolean eliminar(String codigo){
    Producto producto = buscarPorCodigo(codigo);
    
    if(producto != null){
        
        productos.remove(producto);
        
        codigos.remove(producto.getCodigo());
        
        String categoria = producto.getCategoria();
        
        if(categorias.containsKey(categoria)){
            
            int cantidad = categorias.get(categoria) - 1;
            
            if(cantidad >  0){
                categorias.put(categoria, cantidad);
            }
            else{
                categorias.remove(categoria);
            }
                
        }
        historial.push("Producto eliminado: " + producto.getNombre());
        
        return true;
    }
    return false;
}

public Stack<String> obtenerHistorial(){
    return historial;
}

public Map<String, Integer> obtenerCategorias(){
    return categorias;
}
}

