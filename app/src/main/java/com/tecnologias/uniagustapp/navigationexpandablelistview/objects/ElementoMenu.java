package com.tecnologias.uniagustapp.navigationexpandablelistview.objects;

/**
 * Created by ivan.lobelo on 10/26/2017.
 */

public class ElementoMenu {

    private String titulo;
    private int imagenResource;


    public ElementoMenu(String titulo, int imagenResource){
        this.titulo = titulo;
        this.imagenResource = imagenResource;
    }

    public int getImagenResource() {
        return imagenResource;
    }

    public void setImagenResource(int imagenResource) {
        this.imagenResource = imagenResource;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

}