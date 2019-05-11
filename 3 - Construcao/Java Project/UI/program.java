import java.util.List;

import TOs.DoencaTO;
import TOs.TratamentoTO;
import TOs.UsuarioTO;
import controllers.Login;

public class program {

	public static void main(String[] args) {	
		
		
		Login a = new Login();
		a.Index();
		
		
		String usu = "nano";
		String sen = "123";
		try {
			UsuarioTO  usuario =  Negocio.Acesso.consultarById(1);
			System.out.print("Logou "+ usuario.LOGIN);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			List<DoencaTO> d = Negocio.Doenca.listarTodos();
			for (DoencaTO doencaTO : d) {
				System.out.print("Doenca "+ doencaTO.NOME_DOENCA);
				for (TratamentoTO t : doencaTO.Tratamentos) {
					System.out.print("aaa "+ t.DS_TRATAMENTO);
					System.out.print("aaa2 "+ t.DS_TIPOTRATAMENTO);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
