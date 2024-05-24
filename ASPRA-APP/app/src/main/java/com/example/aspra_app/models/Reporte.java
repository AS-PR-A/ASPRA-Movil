package com.example.aspra_app.models;

public class Reporte {
    private long id; // El ID de la BD
    private String fecha;
    private String direccion;
    private String motivo;
    private String descripcion;
    private String usuario;

    public Reporte() {
    }

    public Reporte(long id, String fecha, String direccion, String motivo, String descripcion, String usuario) {
        this.id = id;
        this.fecha = fecha;
        this.direccion = direccion;
        this.motivo = motivo;
        this.descripcion = descripcion;
        this.usuario = usuario;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}


