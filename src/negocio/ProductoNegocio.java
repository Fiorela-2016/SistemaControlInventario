/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;
import excepciones.DatoInvalidoException;
import excepciones.ProductoDuplicadoException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import modelo.Producto;
import repositorio.ProductoRepositorio;
import java.util.ArrayList;
/**
 *
 * @author fiore
 */
public class ProductoNegocio {
    
    private ProductoRepositorio repositorio;
    
    
    public ProductoNegocio(){
        repositorio = new ProductoRepositorio();
    }
    
    public void agregar(Producto producto)throws DatoInvalidoException, ProductoDuplicadoException {
        
        if(producto.getCodigo() == null || producto.getCodigo().trim().isEmpty()){
            
            throw new DatoInvalidoException("El codigo es obligatorio. ");
        }
        if(producto.getNombre()== null|| producto.getNombre().trim().isEmpty()){
            throw new DatoInvalidoException("El nombre es obligatorio. ");
        }
        if(producto.getNombre().trim().length()< 3){
            throw new DatoInvalidoException("El nombre debe contener almenos 3 caracteres. ");
        }
        if(producto.getCantidad() < 0){
            throw new DatoInvalidoException("La cantidad debe ser mayor o igual a cero");
        }
        if(producto.getPrecio() <= 0){
            throw new DatoInvalidoException("El precio debe ser mayor que cero. ");
        }
        if(producto.getCategoria() == null || producto.getCategoria().trim().isEmpty()){
            throw new DatoInvalidoException("Debe seleccionar una categoria. ");
        }
        if(repositorio.existeCodigo(producto.getCodigo())){
            throw new ProductoDuplicadoException("El codigo ya existe. ");
        }
        
        
        repositorio.agregar(producto);
            
            
    }
    public List<Producto> listar(){
        return repositorio.listar();
    }
    
    
    public Producto buscarPorCodigo(String codigo){
        return repositorio.buscarPorCodigo(codigo);
    }
    
    public List<Producto> buscar(String texto){
    
         List<Producto> encontrados = new java.util.ArrayList<>();
        
        for(Producto p : repositorio.listar()){
            
            
            if(p.getCodigo().toLowerCase().contains(texto.toLowerCase()) || p.getNombre().toLowerCase().contains(texto.toLowerCase())) {
                
             encontrados.add(p);
            }
        }    
            return encontrados;
    }

    
    public boolean eliminar(String codigo){
        return repositorio.eliminar(codigo);
    }
    
    public boolean editar(Producto producto) throws DatoInvalidoException {
        
         if(producto.getCodigo() == null || producto.getCodigo().trim().isEmpty()){
            
            throw new DatoInvalidoException("El codigo es obligatorio. ");
        }
        if(producto.getNombre()== null|| producto.getNombre().trim().isEmpty()){
            throw new DatoInvalidoException("El nombre es obligatorio. ");
        }
        if(producto.getNombre().trim().length()< 3){
            throw new DatoInvalidoException("El nombre debe contener almenos 3 caracteres. ");
        }
        if(producto.getCantidad() < 0){
            throw new DatoInvalidoException("La cantidad debe ser mayor o igual a cero");
        }
        if(producto.getPrecio() <= 0){
            throw new DatoInvalidoException("El precio debe ser mayor que cero. ");
        }
        if(producto.getCategoria() == null || producto.getCategoria().trim().isEmpty()){
            throw new DatoInvalidoException("Debe seleccionar una categoria. ");
        }
       
        
        return repositorio.editar(producto);
    }
    
    public void ordenarPorNombre(){
        Collections.sort(repositorio.listar(), new Comparator<Producto>(){
            
            @Override
            public int compare(Producto p1, Producto p2){
                
                return p1.getNombre().compareToIgnoreCase(p2.getNombre());
            }
        });
        
    }
    public void ordenarPorPrecio(){
        
        Collections.sort(repositorio.listar(), new Comparator<Producto>(){
            
            @Override
            
            public int compare(Producto p1, Producto p2){
                
                return Double.compare(p1.getPrecio(), p2.getPrecio());
                }
                    
            });
        }
    
    public void ordenarPorCantidad(){
        
        Collections.sort(repositorio.listar(), new Comparator<Producto>(){
            @Override
            
            public int compare(Producto p1, Producto p2){
                
                return Integer.compare(p1.getCantidad(), p2.getCantidad());
            }
                
        });
    }
    public List<String> obtenerHistorial(){
        
        return new java.util.ArrayList<>(repositorio.obtenerHistorial());
        
    }
    
    public java.util.Map<String, Integer> obtenerCategorias(){
        
        return repositorio.obtenerCategorias();
    }
    public int totalProductos(){
        return repositorio.listar().size();
        
    }
    
    
    public int productosDisponibles(){
        
        int contador = 0;
        
        for(Producto p : repositorio.listar()){
            
            if(p.getDisponible()){
                contador ++;
            }
        }
        return contador;
    }
    
    public int productosNoDisponibles(){
        
        return totalProductos() - productosDisponibles();
    }
    
    public int totalUnidades(){
        
        int total = 0;
        
        for(Producto p : repositorio.listar()){
            
            total += p.getCantidad();
        }
        
        return total;
    }
    
    public Producto productoMasCaro(){
        
        if(repositorio.listar().isEmpty()){
            
        return null;
        }
    
    
    Producto mayor = repositorio.listar().get(0);
    
    for(Producto p : repositorio.listar()){
        
        if(p.getPrecio() > mayor.getPrecio()){
            
            mayor = p;
        }
            
   }

    return mayor;
    
    } 
    public Producto productoMasBarato(){
        
        if(repositorio.listar().isEmpty()){
            return null;
        }
        
        Producto menor = repositorio.listar().get(0);
        
        for(Producto p : repositorio.listar()){
            
            if(p.getPrecio()< menor.getPrecio()) {
                
                menor = p;
            }
        }
        return menor;
    }
    
    public double valorInventario(){
        
        double total = 0;
        
        for(Producto p : repositorio.listar()){
            
            total += p.getCantidad() * p.getPrecio();
        }
        
        return total;
    }
}


    

