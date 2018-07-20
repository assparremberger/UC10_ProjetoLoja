
package model;

/**
 *
 * @author assparremberger
 */
public class ClienteFisico extends Cliente{
    private String cpf, rg;

    public ClienteFisico() {
    }

    public ClienteFisico(String cpf, String rg, String nome, String endereco, String tipo, Cidade cidade) {
        super(nome, endereco, tipo, cidade);
        this.cpf = cpf;
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }
    
    
    
}






