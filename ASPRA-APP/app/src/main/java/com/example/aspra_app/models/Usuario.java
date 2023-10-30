package com.example.aspra_app.models;

public class Usuario {

    // Atributos
    private String nombre;
    private String email;

    private String phone;
    private String pass;

    // Constructor
    public Usuario() {
        // Constructor vacío
    }

    // Constructor con parámetros
    public Usuario(String nombre, String email, String phone, String pass) {
        this.nombre = nombre;
        this.email = email;
        this.phone = phone;
        this.pass = pass;
    }

    // Métodos getter y setter para cada atributo

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

    public String getPhone() { return phone; }

    public void setPhone(String phone) { this.phone = phone; }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}