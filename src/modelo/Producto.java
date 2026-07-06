/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
//Clase principal
/**
 *
 * @author fiore
 */
public class Producto {
    private int id;
    private String codigo;
    private String nombre;
    private String categoria;
    private int cantidad;
    private double precio;
    private boolean disponible;
    private String descripcion;

public Producto( int id, String codigo, String nombre, String categoria, int cantidad, double precio, boolean disponible, String descripcion){
    
    this.id = id;
    this.codigo = codigo;
    this.nombre = nombre;
    this.categoria = categoria;
    this.cantidad = cantidad;
    this.precio = precio;
    this.disponible = disponible;
    this.descripcion = descripcion;
}
public int getId(){
    return id;
}
public void setId(int id ) {
    this.id = id; 
}
public String getCodigo(){
    return codigo;
}
public void setCodigo(String codigo){
    this.codigo = codigo;
    
}
public String getNombre(){
    return nombre;
}

public void setNombre(String nombre){
    this.nombre = nombre;
}
public String getCategoria(){
    return categoria;
}
public void setCategoria(String categoria){
    this.categoria = categoria;
}
public int getCantidad() {
    return cantidad;
}
public void setCantidad(int cantidad ){
    this.cantidad = cantidad;
}
public double getPrecio(){
    return precio;
}
public void setPrecio(double precio){
    this.precio = precio;
}
public boolean getDisponible(){
    return disponible;
}
public void setDisponible(boolean disponible){
    this.disponible = disponible;
}
public String getDescripcion(){
    return descripcion;
}
public void setDescripcion(String descripcion){
    this.descripcion = descripcion;
}

@Override
public String toString(){
    return "Id: " + id + 
            "\nCodigo: " + codigo +
            "\nNombre: " + nombre +
            "\nCategoria: " + categoria +
            "\nCantidad: " + cantidad +
            "\nPrecio: " + precio +
            "\nDisponible: " + disponible +
            "\nDescripcion: " + descripcion;
    
}
}
