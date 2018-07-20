package model;

/**
 *
 * @author assparremberger
 */
public class ClienteJuridico extends Cliente{
    private String cnpj, ie;

    public ClienteJuridico() {
    }

    public ClienteJuridico(String cnpj, String ie, String nome, String endereco, String tipo, Cidade cidade) {
        super(nome, endereco, tipo, cidade);
        this.cnpj = cnpj;
        this.ie = ie;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getIe() {
        return ie;
    }

    public void setIe(String ie) {
        this.ie = ie;
    }
    
    
    
}





