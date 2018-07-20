
package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Cidade;
import model.Cliente;
import model.ClienteFisico;
import model.ClienteJuridico;

public class ClienteFisicoJuridicoDAO {
    public static boolean inserir(ClienteFisico cliente){
        String sql = "INSERT INTO clientes "
            + " ( nome, endereco, tipo, codCidade, cpf_cnpj, rg_ie ) "
            + " VALUES ( "
            + " '" + cliente.getNome()              + "' , "
            + " '" + cliente.getEndereco()          + "' , "
            + " '" + cliente.getTipo()              + "' , "
            + "  " + cliente.getCidade().getCodigo()+ "  , "
            + " '" + cliente.getCpf()               + "' , "
            + " '" + cliente.getRg()                + "'   "
            + " );";
        return Conexao.executar(sql);
    }
    
    public static boolean inserir(ClienteJuridico cliente){
        String sql = "INSERT INTO clientes "
            + " ( nome, endereco, tipo, codCidade, cpf_cnpj, rg_ie ) "
            + " VALUES ( "
            + " '" + cliente.getNome()              + "' , "
            + " '" + cliente.getEndereco()          + "' , "
            + " '" + cliente.getTipo()              + "' , "
            + "  " + cliente.getCidade().getCodigo()+ "  , "
            + " '" + cliente.getCnpj()+ "' , "
            + " '" + cliente.getIe()+ "'   "
            + " );";
        return Conexao.executar(sql);
    }
    
    public static boolean editar(ClienteFisico cliente){
        String sql = "UPDATE clientes SET "
            + " nome =     '" + cliente.getNome()              + "' , "
            + " endereco = '" + cliente.getEndereco()          + "' , "
            + " tipo =     '" + cliente.getTipo()              + "' , "
            + " codCidade = " + cliente.getCidade().getCodigo()+ "  , "
            + " cpf_cnpj = '" + cliente.getCpf()               + "' , "
            + " rg_ie =    '" + cliente.getRg()                + "'   "
            + " WHERE codigo = " + cliente.getCodigo();
        return Conexao.executar(sql);
    }
    
    public static boolean excluir(ClienteFisico cliente){
        String sql = "DELETE FROM clientes "
                + " WHERE codigo = " + cliente.getCodigo();
        return Conexao.executar(sql);
    }
    
    public static List<ClienteFisico> getClientesFisicos(){
        List<ClienteFisico> lista = new ArrayList<>();
        String sql = "SELECT c.codigo, c.nome, c.endereco,"
            + " c.tipo , d.codigo, d.nome, c.cpf_cnpj, c.rg_ie "
            + " FROM clientes c  "
            + " INNER JOIN cidades d ON c.codCidade = d.codigo "
            + " WHERE c.tipo = '" + Cliente.PESSOA_FISICA + "' "
            + " ORDER BY c.nome";
        ResultSet rs = Conexao.consultar( sql );
        if( rs != null ){
            try{
                while ( rs.next() ) {  
                    ClienteFisico cli = new ClienteFisico();
                    
                    cli.setCodigo( rs.getInt(1) );
                    cli.setNome( rs.getString(2) );
                    cli.setEndereco( rs.getString(3) );
                    cli.setTipo( rs.getString(4) );
                    cli.setCpf( rs.getString(7) );
                    cli.setRg( rs.getString(8) );
                    
                    Cidade cid = new Cidade();
                    cid.setCodigo( rs.getInt(5) );
                    cid.setNome( rs.getString(6) );
                    
                    cli.setCidade(cid);
                    
                    lista.add(cli);
                } 
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e.toString());
            }
        }
        return lista;
    }
    
    
    public static List<ClienteJuridico> getClientesJuridicos(){
        List<ClienteJuridico> lista = new ArrayList<>();
        String sql = "SELECT c.codigo, c.nome, c.endereco,"
            + " c.tipo , d.codigo, d.nome, c.cpf_cnpj, c.rg_ie "
            + " FROM clientes c  "
            + " INNER JOIN cidades d ON c.codCidade = d.codigo "
            + " WHERE c.tipo = '" + Cliente.PESSOA_JURIDICA + "' "
            + " ORDER BY c.nome";
        ResultSet rs = Conexao.consultar( sql );
        if( rs != null ){
            try{
                while ( rs.next() ) {  
                    ClienteJuridico cli = new ClienteJuridico();
                    
                    cli.setCodigo( rs.getInt(1) );
                    cli.setNome( rs.getString(2) );
                    cli.setEndereco( rs.getString(3) );
                    cli.setTipo( rs.getString(4) );
                    cli.setCnpj(rs.getString(7) );
                    cli.setIe(rs.getString(8) );
                    
                    Cidade cid = new Cidade();
                    cid.setCodigo( rs.getInt(5) );
                    cid.setNome( rs.getString(6) );
                    
                    cli.setCidade(cid);
                    
                    lista.add(cli);
                } 
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e.toString());
            }
        }
        return lista;
    }
    
}
