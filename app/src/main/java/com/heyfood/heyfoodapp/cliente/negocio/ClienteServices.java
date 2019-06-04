package com.heyfood.heyfoodapp.cliente.negocio;

import android.content.Context;

import com.heyfood.heyfoodapp.cliente.dominio.Cliente;
import com.heyfood.heyfoodapp.cliente.persistencia.ClienteDAO;
import com.heyfood.heyfoodapp.contato.persistencia.ContatoDAO;
import com.heyfood.heyfoodapp.endereco.persistencia.EnderecoDAO;
import com.heyfood.heyfoodapp.infra.Sessao;
import com.heyfood.heyfoodapp.pessoa.persistencia.PessoaDAO;
import com.heyfood.heyfoodapp.usuario.dominio.Usuario;
import com.heyfood.heyfoodapp.usuario.persistencia.UsuarioDAO;

/**
 * Created by GABRIEL.CABOCLO on 29/05/2019.
 */

public class ClienteServices {
    private ClienteDAO clienteDAO;
    private UsuarioDAO usuarioDAO;
    private PessoaDAO pessoaDAO;
    private ContatoDAO contatoDAO;
    private EnderecoDAO enderecoDAO;

    public ClienteServices(Context context){
        clienteDAO = new ClienteDAO(context);
        usuarioDAO = new UsuarioDAO(context);
        pessoaDAO = new PessoaDAO(context);
        contatoDAO = new ContatoDAO(context);
        enderecoDAO = new EnderecoDAO(context);
    }

    public void cadastrar(Cliente cliente) throws Exception {
        if (usuarioDAO.getUsuario(cliente.getUsuario().getLogin()) != null) {
            throw new Exception();
        }
        int idContato = contatoDAO.cadastrar(cliente.getUsuario().getPessoa().getContato());
        cliente.getUsuario().getPessoa().getContato().setId(idContato);

        int idEndereco = enderecoDAO.cadastrar(cliente.getUsuario().getPessoa().getEndereco());
        cliente.getUsuario().getPessoa().getEndereco().setId(idEndereco);

        int idPessoa = pessoaDAO.cadastrar(cliente.getUsuario().getPessoa());
        cliente.getUsuario().getPessoa().setId(idPessoa);

        int idUsuario = usuarioDAO.cadastrar(cliente.getUsuario());
        cliente.getUsuario().setId(idUsuario);

        int idCliente = clienteDAO.cadastrar(cliente);
        cliente.setId(idCliente);
    }

    public void login(String email, String password) throws Exception {
        Usuario usuario = usuarioDAO.getUsuario(email, password);
        if (usuario == null) {
            throw new Exception();
        }
        Cliente cliente = clienteDAO.getCliente(usuario.getId());
        Sessao.instance.setCliente(cliente);
    }

    public void logout() {
        Sessao sessao = Sessao.instance;
        sessao.reset();
        //TODO: volta pra loginActivity ?
    }
}