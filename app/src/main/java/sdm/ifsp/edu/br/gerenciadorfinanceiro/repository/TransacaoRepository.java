package sdm.ifsp.edu.br.gerenciadorfinanceiro.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import sdm.ifsp.edu.br.gerenciadorfinanceiro.model.ContaEntity;
import sdm.ifsp.edu.br.gerenciadorfinanceiro.model.TransacaoEntity;

public class TransacaoRepository {

    private SQLiteDatabase database;   // CLASSE que provê os métodos de manipulação dos dados no banco insert/update/delete
    private SQLiteHelper dbHelper;

    public TransacaoRepository(Context context) {
        this.dbHelper = new SQLiteHelper(context);
    }

    public void salvar(TransacaoEntity transacao) {
        database = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(SQLiteHelper.DESCRICAO_CONTA, transacao.getConta().getDescricao());
        values.put(SQLiteHelper.VALOR, transacao.getValor());
        values.put(SQLiteHelper.OPERACAO, transacao.getOperacao());
        values.put(SQLiteHelper.TIPO_OPERACAO, transacao.getTipoOperacao());

        database.insert(SQLiteHelper.DATABASE_TABLE_OPERACOES, null, values);

        database.close();
    }


    public List<String> listarContas() {
        database = dbHelper.getReadableDatabase();
        List<String> contas = new ArrayList<>();

        Cursor cursor;

        String[] cols = new String[]{SQLiteHelper.KEY_ID};

        cursor = database.query(SQLiteHelper.DATABASE_TABLE, cols, null, null,
                null, null, SQLiteHelper.KEY_ID);

        while (cursor.moveToNext()) {
            contas.add(cursor.getString(0));
        }

        cursor.close();

        database.close();
        return contas;
    }

    public ContaEntity buscarContaPelaDescricao(String descricao) {
        database = dbHelper.getReadableDatabase();
        List<ContaEntity> contas = new ArrayList<>();

        Cursor cursor;

        String[] cols = new String[]{SQLiteHelper.KEY_ID, SQLiteHelper.KEY_SALDO};
        String where = SQLiteHelper.KEY_ID + " = ?";
        String[] argWhere = new String[]{descricao};


        cursor = database.query(SQLiteHelper.DATABASE_TABLE, cols, where, argWhere,
                null, null, SQLiteHelper.KEY_ID);

        while (cursor.moveToNext()) {
            ContaEntity conta = new ContaEntity();
            conta.setDescricao(cursor.getString(0));
            conta.setSaldo(cursor.getLong(1));
            contas.add(conta);
        }

        cursor.close();

        database.close();
        return contas != null && contas.size() > 0 ? contas.get(0) : null;
    }
}
