package com.practica.Negocio;

public interface IPublicable {
    //*Una interfaz solo define los metodos, se implementan en la clase que la usa
    //TODO: No se agrega lombok en interfaces
    public abstract String generarCitaRIS();
    public abstract String generarCitaBibText();
    public abstract String generarCitaRefWorks();
}
