
package model;

/**
 *
 * @author assparremberger
 */
public class Cliente {
    public static final String PESSOA_FISICA = "pf";
    public static final String PESSOA_JURIDICA = "pj";
    
    private int codigo;
    private String nome, endereco, tipo;
    private Cidade cidade;
    
    public Cliente(){
        
    }
    
    public Cliente(String nome){
        this.nome = nome;
    }
     
    public Cliente(String nome, String endereco, String tipo, Cidade cidade) {
        this.nome = nome;
        this.endereco = endereco;
        this.tipo = tipo;
        this.cidade = cidade;
    }

    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

   
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

   
    
}






