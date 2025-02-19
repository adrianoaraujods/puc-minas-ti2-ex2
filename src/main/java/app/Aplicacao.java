package app;

import java.util.Date;

import dao.PostsDAO;
import model.Post;
import util.MyIO;

public class Aplicacao {
    static PostsDAO postsDAO = new PostsDAO();

    private static int menu() {
        MyIO.println("==== MENU ====");
        MyIO.println("\t1) Listar posts");
        MyIO.println("\t2) Inserir post");
        MyIO.println("\t3) Excluir post");
        MyIO.println("\t4) Atualizar post");
        MyIO.println("\t5) Sair");

        MyIO.println("\nDigite uma opcao [1-5]: ");
        return MyIO.readInt();
    }
	
	public static void main(String[] args) throws Exception {
        int option = menu();

        while (option != 5) {
            Post post = new Post();

            switch (option) {
                case 1:
                    for (Post p : postsDAO.getAll("id")) {
                        MyIO.println(p.toString());
                    }
                    break;
                case 2:
                    MyIO.println("Digite o id do post: ");
                    post.setId(MyIO.readInt());

                    MyIO.println("Digite o titulo do post: ");
                    post.setTitle(MyIO.readString());

                    MyIO.println("Digite o conteudo do post: ");
                    post.setContent(MyIO.readString());

                    post.setCreatedAt(new Date().getTime());

                    if(postsDAO.insert(post)) {
                        MyIO.println("Post inserido com sucesso!");
                    } else {
                        MyIO.println("Erro ao inserir post");
                    }

                    break;
                case 3:
                    MyIO.println("Digite o id do post para excluir: ");

                    if(postsDAO.delete(MyIO.readInt())) {
                        MyIO.println("Post excluido com sucesso!");
                    } else {
                        MyIO.println("Erro ao excluir post");
                    }

                    break;
                case 4:
                    MyIO.println("Digite o id do post: ");
                    post.setId(MyIO.readInt());

                    MyIO.println("Digite o titulo do post: ");
                    post.setTitle(MyIO.readString());

                    MyIO.println("Digite o conteudo do post: ");
                    post.setContent(MyIO.readString());

                    post.setCreatedAt(new Date().getTime());

                    if(postsDAO.update(post)) {
                        MyIO.println("Post atualizado com sucesso!");
                    } else {
                        MyIO.println("Erro ao atualizar post");
                    }

                    break;
                default:
                    MyIO.println("Opcao invalida, tente novamente. ");
            }

            option = menu();
        }

        MyIO.println("Obrigado por usar o programa!");
	}
}