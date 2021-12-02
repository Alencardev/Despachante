/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package despach.dao;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import despach.jdbc.ConnectionFactory;
import despach.model.Veiculos;

/**
 *
 * @author acer
 * 
 * 
 */
public class DespachDAO {
    
     //Atributos

    private Connection conexao;

    //Construtor
    public DespachDAO() {
        //1º passo: disponibilizar uma conexão com o BD
        this.conexao = ConnectionFactory.getConnection();
    }

    public void cadastrarVeiculo(Veiculos obj) {
        try {
            //2º passo: criar uma string de comando SQL
            String sql = "insert into cadastro(placa_veiculo,marca_veiculo,modelo_veiculo,ano_veiculo)"
                    + "values (?,?,?,?)";

            //3º passo: preparar o comando SQL para o driver
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, obj.getplaca_veiculo());
            comando.setString(2, obj.getmarca_veiculo());
            comando.setString(3, obj.getmodelo_veiculo());
            comando.setString(4, obj.getano_veiculo());

            //4º passo: executar o comando sql e fechar a conexão
            comando.execute();
            comando.close();

            //5º passo: pegar o id gerado pelo banco de dados através do CPF
            sql = "select id from tb_cadastro where placa_veiculo=?";
            comando = conexao.prepareStatement(sql);
            comando.setString(1, obj.getplaca_veiculo());

            //Com o comando preparado, executo o comando
            //Esse comando é de leitura do BD, logo ele retorna um ResultSet
            ResultSet resultado = comando.executeQuery();

            //Percorro o resultado até achar o campo "id"
            while (resultado.next()) {
               // obj.setplaca_veiculo(resultado.getInt("placa_veiculo"));
            }
            //Sevchegar aqui mostra a janela de cadastro com sucesso;
            JOptionPane.showMessageDialog(null, "Cadastro de veiculo efetuado com sucesso!");

        } catch (SQLException e) {
        }

    /**
     * @param args the command line arguments
     */
    }
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    //public void deletarVeiculos (Veiculos obj) {
     //   try {
     //       int opcao = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir o Veiculo?", "CONFIRMAÇÃO DE EXCLUSÃO", JOptionPane.OK_CANCEL_OPTION);
    //        if (opcao == 0) {
     //           //2º passo: criar uma string de comando SQL
     //           String sql = "delete from cadastro where placa_veiculo=?";

                //3º passo: preparar o comando SQL para o driver
     //           PreparedStatement comando = conexao.prepareStatement(sql);
     //           comando.String(1, obj.getplaca_veiculo());

                //4º passo: executar o comando sql e fechar a conexão
      //          comando.execute();
      //          comando.close();

                //Se chegar aqui mostra a janela de exclusao com sucesso;
      //          JOptionPane.showMessageDialog(null, "Veiculo excluído com sucesso!");
            }
      //  } catch (SQLException e) {
      //      JOptionPane.showMessageDialog(null, e);
      //  }
   // }

