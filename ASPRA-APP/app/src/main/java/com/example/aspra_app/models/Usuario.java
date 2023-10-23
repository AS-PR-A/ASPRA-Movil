package com.example.aspra_app.models;

public class Usuario {

    // Atributos
    private String dni; // En lugar de ID
    private String nombre;
    private String email;
    private String pass;

    // Constructor
    public Usuario() {
        // Constructor vacío
    }

    // Constructor con parámetros
    public Usuario(String dni, String nombre, String email, String pass) {
        this.dni = dni;
        this.nombre = nombre;
        this.email = email;
        this.pass = pass;
    }

    // Métodos getter y setter para cada atributo
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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
}