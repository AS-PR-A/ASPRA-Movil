package com.example.aspra_app.models;

public class Usuario {

    // Atributos
    private long id; // El ID de la BD
    private String nombre;
    private String email;
    private String pass;
    private String telefono;

    // Constructor vacio
    public Usuario() {

    }

    // Constructor con parametros
    public Usuario(String nombre, String email, String pass, String telefono) {
        this.nombre = nombre;
        this.email = email;
        this.pass = pass;
        this.telefono = telefono;
    }
    // Constructor para cuando instanciamos desde la BD
    public Usuario(long id, String nombre, String email, String pass, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.pass = pass;
        this.telefono = telefono;
    }

    // Métodos getter y setter para cada atributo
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getTelefono() { return telefono; }

    public void setTelefono(String telefono) { this.telefono = telefono; }
}