
package dao;

import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Cidade;


public class CidadeDAO {
    
    public static boolean inserir(Cidade cidade){
        String sql = "INSERT INTO cidades "
            + " ( nome ) VALUES "
            + " ( '" + cidade.getNome() + "' );";
        return Conexao.executar(sql);
    }
      
    public static boolean editar(Cidade cidade){
        String sql = "UPDATE cidades SET "
            + " nome =  '" + cidade.getNome() + "' "
            + " WHERE codigo = " + cidade.getCodigo();
        return Conexao.executar(sql);
    }
    
    public static boolean excluir(Cidade cidade){
        String sql = "DELETE FROM cidades "
            + " WHERE codigo = " + cidade.getCodigo();
        return Conexao.executar(sql);
    }
    
    public static List<Cidade> getCidades(){
        List<Cidade> lista = new ArrayList<>();
        String sql = "SELECT * FROM cidades ORDER BY nome";
        ResultSet rs = Conexao.consultar( sql );
        
        if( rs != null ){
            try{
                while ( rs.next() ) {  
                    Cidade cid = new Cidade();
                    cid.setCodigo( rs.getInt(1) );
                    cid.setNome( rs.getString(2) );
                    lista.add(cid);
                } 
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e.toString());
            }
        }
        
        return lista;
    }
    
    
    public static Cidade getCidadeByCodigo(int codigo){
        Cidade cid = new Cidade();
        String sql = "SELECT codigo, nome FROM cidades "
                   + " WHERE codigo = " + codigo ;
        ResultSet rs = Conexao.consultar( sql );
        
        try {
            rs.first();
            cid.setCodigo( rs.getInt( 1 ) );
            cid.setNome( rs.getString( 2 ) );
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        
        return cid;
    }
    
    
}



