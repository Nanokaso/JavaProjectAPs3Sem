package conexao;

public class _config {

	//com.mysql.jdbc.Driver // <- outra opcap
	public static String driver = "com.mysql.cj.jdbc.Driver";
	//public static String driver = "com.mysql.jdbc.Driver";
	
	public static String servidor = "localhost";
	public static String baseDados = "APS3SEM";
	public static String usuario = "root";
	public static String senha = "root";
	public static String parametros = "?useTimezone=true&serverTimezone=UTC&defaultAutoCommit=false";

	// nao mudar
	public static String url = "jdbc:mysql://" + servidor + "/" + baseDados + parametros;
}
