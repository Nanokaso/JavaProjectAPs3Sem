import TOs.UsuarioTO;

public class program {

	public static void main(String[] args) {	
		String usu = "nano";
		String sen = "123";
		try {
			UsuarioTO  usuario =  Negocio.Acesso.Logar(usu, sen);
			System.out.print("Logou "+ usuario.LOGIN);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
