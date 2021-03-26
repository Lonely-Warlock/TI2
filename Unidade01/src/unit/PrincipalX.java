package unit;



public class PrincipalX {
public static void main(String[] args) {
		
		DAOX dao = new DAOX();
		
		dao.conectar();

		
		//Inserir um elemento na tabela
		X usuario = new X(11, "pablo", "pablo",'M');
		if(dao.inserirX(usuario) == true) {
			System.out.println("Inserção com sucesso -> " + usuario.toString());
		}
		
		//Mostrar usuários do sexo masculino		
		System.out.println("==== Mostrar usuários do sexo masculino === ");
		X[] usuarios = dao.getUsuariosMasculinos();
		for(int i = 0; i < usuarios.length; i++) {
			System.out.println(usuarios[i].toString());
		}

		//Atualizar usuário
		usuario.setSenha("nova senha");
		dao.atualizarX(usuario);

		//Mostrar usuários do sexo masculino
		System.out.println("==== Mostrar usuários === ");
		usuarios = dao.getUsuariosMasculinos();
		for(int i = 0; i < usuarios.length; i++) {
			System.out.println(usuarios[i].toString());
		}
		
		//Excluir usuário
		dao.excluirX(usuario.getCodigo());
		
		//Mostrar usuários
		usuarios = dao.getUsuariosMasculinos();
		System.out.println("==== Mostrar usuários === ");		
		for(int i = 0; i < usuarios.length; i++) {
			System.out.println(usuarios[i].toString());
		}
		
		dao.close();
	}
}
