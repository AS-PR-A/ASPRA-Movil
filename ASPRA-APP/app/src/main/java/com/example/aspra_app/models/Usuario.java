package com.example.aspra_app.models;

public class Usuario {

    // Atributos
    private String email; // En lugar de ID
    private String nombre;
    private String contrasena;
    private String telefono;

    // Constructor
    public Usuario() {
        // Constructor vacío
    }

    // Constructor con parámetros
    public Usuario(String email, String nombre, String telefono, String contrasena) {
        this.email = email;
        this.nombre = nombre;
        this.telefono = telefono;
        this.contrasena = contrasena;
    }

    // Métodos getter y setter para cada atributo
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String email) {
        this.telefono = telefono;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String pass) {
        this.contrasena = contrasena;
    }
}