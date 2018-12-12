package sdm.ifsp.edu.br.gerenciadorfinanceiro.repository;

import java.util.ArrayList;

import sdm.ifsp.edu.br.gerenciadorfinanceiro.model.ContaEntity;

public class CadastrarRepository {

    private ArrayList<ContaEntity> contas;

    public void salvar(ContaEntity conta) {

        if(contas == null || contas.size() <= 0) {
            contas = new ArrayList<>();
            contas.add(conta);
        }

        contas.add(conta);

    }
}
