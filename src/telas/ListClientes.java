/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory;
import dao.ClienteDAO;
import dao.ClienteFisicoJuridicoDAO;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.Cliente;
import model.ClienteFisico;
import model.ClienteJuridico;

/**
 *
 * @author assparremberger
 */
public class ListClientes extends javax.swing.JInternalFrame {

    /**
     * Creates new form ListClientes
     */
    public ListClientes() {
        initComponents();
        carregarTabela( "" );
    }
    
    private void carregarTabela(String tipo){
        DefaultTableModel modelo = new DefaultTableModel();
        String[] colunas = {};
        switch ( tipo ){
            case "":
                List<Cliente> lista = ClienteDAO.getClientes();
                colunas = new String[]{"Código", "Nome", "Endereço","Cidade"};
                modelo.setColumnIdentifiers( colunas );
                for( Cliente cli : lista ){
                    Object[] obj = {
                        cli.getCodigo() ,
                        cli.getNome() , 
                        cli.getEndereco() ,
                        cli.getCidade()
                    };
                    modelo.addRow( obj );
                }
                tableClientes.setModel( modelo );
                break;
            case Cliente.PESSOA_FISICA :
                colunas = new String[]{ "Código" , "Nome" ,
                        "Endereço", "Cidade", "CPF", "RG" };
                modelo.setColumnIdentifiers(colunas);
                List<ClienteFisico> listaFisicos = 
                        ClienteFisicoJuridicoDAO.getClientesFisicos();
                for( ClienteFisico cli : listaFisicos ){
                    Object[] obj = { 
                        cli.getCodigo() , 
                        cli.getNome(),
                        cli.getEndereco(),
                        cli.getCidade().getNome() ,
                        cli.getCpf(),
                        cli.getRg()
                    };
                    modelo.addRow( obj );
                }
                tableClientes.setModel( modelo );
                break;
            case Cliente.PESSOA_JURIDICA :
                colunas = new String[]{ "Código" , "Nome" ,
                        "Endereço", "Cidade", "CNPJ", "IE" };
                modelo.setColumnIdentifiers(colunas);
                List<ClienteJuridico> listaJuridicos = 
                        ClienteFisicoJuridicoDAO.getClientesJuridicos();
                for( ClienteJuridico cli : listaJuridicos ){
                    Object[] obj = { 
                        cli.getCodigo() , 
                        cli.getNome(),
                        cli.getEndereco(),
                        cli.getCidade().getNome() ,
                        cli.getCnpj(),
                        cli.getIe()
                    };
                    modelo.addRow( obj );
                }
                tableClientes.setModel( modelo );
                break;
            case "todos" :
                colunas = new String[]{"Código", "Nome",
                      "Endereço", "Cidade", "Tipo", 
                      "CPF / CNPJ", "RG / IE"}; 
                modelo.setColumnIdentifiers( colunas );
                lista = ClienteDAO.getClientes();
                listaFisicos = ClienteFisicoJuridicoDAO.getClientesFisicos();
                listaJuridicos = ClienteFisicoJuridicoDAO.getClientesJuridicos();
                for ( Cliente cli : lista ){
                    Object[] obj = {
                        cli.getCodigo() ,
                        cli.getNome() ,
                        cli.getEndereco() ,
                        cli.getCidade().getNome() ,
                        cli.getTipo() ,
                        "",
                        ""
                        };
                    modelo.addRow(obj);
                }
                for ( ClienteFisico cli : listaFisicos ){
                    Object[] obj = {
                        cli.getCodigo() ,
                        cli.getNome() ,
                        cli.getEndereco() ,
                        cli.getCidade().getNome() ,
                        cli.getTipo() ,
                        cli.getCpf(),
                        cli.getRg()
                        };
                    modelo.addRow(obj);
                }
                for ( ClienteJuridico cli : listaJuridicos ){
                    Object[] obj = {
                        cli.getCodigo() ,
                        cli.getNome() ,
                        cli.getEndereco() ,
                        cli.getCidade().getNome() ,
                        cli.getTipo() ,
                        cli.getCnpj(),
                        cli.getIe()
                        };
                    modelo.addRow(obj);
                }
                tableClientes.setModel( modelo );
                break;
        }
        
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cmbTipo = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableClientes = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Lista de Clientes");
        setPreferredSize(new java.awt.Dimension(800, 600));

        jLabel1.setText("Tipo: ");

        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Clientes", "Clientes Físicos", "Clientes Jurídicos", "Todos" }));
        cmbTipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbTipoItemStateChanged(evt);
            }
        });

        tableClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tableClientes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 525, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbTipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbTipoItemStateChanged
        int posicao = cmbTipo.getSelectedIndex();
        switch( posicao ){
            case 0 :
                carregarTabela("");
                break;
            case 1 :
                carregarTabela( Cliente.PESSOA_FISICA);
                break;
            case 2 :
                carregarTabela( Cliente.PESSOA_JURIDICA);
                break;
            case 3 :
                carregarTabela( "todos");
                break;
                
        }
    }//GEN-LAST:event_cmbTipoItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableClientes;
    // End of variables declaration//GEN-END:variables
}
