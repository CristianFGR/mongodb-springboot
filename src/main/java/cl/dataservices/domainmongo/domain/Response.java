package cl.dataservices.domainmongo.domain;

/**
 * Created by cgonzalezr on 19-12-19.
 */
public class Response {

    private String mensaje;
    private int codigoHttp;

    public Response(String mensaje, int codigoHttp) {
        this.mensaje = mensaje;
        this.codigoHttp = codigoHttp;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public int getCodigoHttp() {
        return codigoHttp;
    }

    public void setCodigoHttp(int codigoHttp) {
        this.codigoHttp = codigoHttp;
    }

    @Override
    public String toString() {
        return "Response{" +
                "mensaje='" + mensaje + '\'' +
                ", codigoHttp=" + codigoHttp +
                '}';
    }
}
