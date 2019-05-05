package TOs;

import java.util.List;

public class DoencaTO {
	public int ID_DOENCA;
	public String NOME_DOENCA;
	public String DESCRICAO;
	public String SINTOMAS;
	public boolean FLG_COMUM;
	public boolean FLG_TRATACOMVACINA;
	public boolean FLG_TRATADOPORPESSOA;
	public boolean FLG_PROPAGAFACIL;
	public boolean FLG_REQUEREXAME;
	public int MEDIADIASCURA;
	public boolean FLG_GRAVE;
	
	public List<TratamentoTO> Tratamentos;
	
}


