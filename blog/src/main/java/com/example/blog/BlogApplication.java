package com.example.blog;

import com.example.blog.model.Categoria;
import com.example.blog.model.Comentario;
import com.example.blog.model.Favoritos;
import com.example.blog.model.PerfilAcesso;
import com.example.blog.model.Post;
import com.example.blog.model.Usuario;
import com.example.blog.repository.CategoriaRepository;
import com.example.blog.repository.ComentarioRepository;
import com.example.blog.repository.FavoritosRepository;
import com.example.blog.repository.PerfilAcessoRepository;
import com.example.blog.repository.PostRepository;
import com.example.blog.repository.UsuarioRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args);
	}

	// #region populando o BD

	@Bean
	public CommandLineRunner populatePerfilAcesso(PerfilAcessoRepository repo) {

		return args -> {
			repo.save(new PerfilAcesso(1, "Admin"));
			repo.save(new PerfilAcesso(2, "Autor"));
			repo.save(new PerfilAcesso(3, "Usuário"));
		};
	}

	@Bean
	public CommandLineRunner populateUsuario(UsuarioRepository repo) {
		PerfilAcesso admin = new PerfilAcesso(1, "Admin");
		
		return args -> {
			repo.save(new Usuario(1, "Giugiu ademir", "giu@bloggersin.com", "senha123", "default.png", "lorem ipsum ai que dor", admin));
			repo.save(new Usuario(2, "Gustavin", "gustavin@bloggersin.com", "senha123", "default.png", "lorem ipsum ai que dor", admin));
			repo.save(new Usuario(3, "Gustavo", "gustavo@bloggersin.com", "senha123", "default.png", "lorem ipsum ai que dor", admin));
			repo.save(new Usuario(4, "Fellipe", "fellipe@bloggersin.com", "senha123", "default.png", "lorem ipsum ai que dor", admin));
			repo.save(new Usuario(5, "Kael", "mikael@bloggersin.com", "senha123", "default.png", "lorem ipsum ai que dor", admin));
		};
	}

	@Bean
	public CommandLineRunner populateCategoria(CategoriaRepository repo) {
	
		return args -> {
			repo.save(new Categoria(1, "Tecnologia"));
			repo.save(new Categoria(2, "Automatos"));
			repo.save(new Categoria(3, "Modelagem de sistemas"));
		};
	}

	// @Bean
	// public CommandLineRunner populatePost(PostRepository repo) {
	// 	String lorem = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean convallis quam eu mauris lacinia suscipit. Suspendisse potenti. Curabitur vitae turpis in tortor eleifend pulvinar eget vitae arcu. Aliquam erat volutpat. Nam dignissim dolor nec sapien aliquam, nec iaculis lacus porta. Donec lacinia et nisi tempus consequat. Donec ut rutrum sem. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Ut pretium nulla eros, sit amet aliquam diam porttitor eget. In blandit lorem sed volutpat ultricies. In vulputate, purus in pharetra auctor, urna lorem iaculis purus, et luctus tortor metus a ipsum.Vestibulum vestibulum enim non dui dapibus, vel consectetur turpis iaculis. Sed ac mi neque. Fusce volutpat, urna et luctus auctor, ex sapien varius lorem, quis efficitur quam arcu et mauris. Nulla facilisi. Morbi volutpat felis id velit pulvinar pharetra. Aenean sit amet odio gravida, ultrices ex quis, pretium felis. Donec aliquam odio nec dignissim luctus. Quisque quis finibus dolor. Pellentesque vestibulum, erat et pharetra lacinia, odio nunc hendrerit ante, vitae viverra nisl odio sed nulla. Donec eros ante, rhoncus eget luctus et, lobortis non ex. Curabitur purus nunc, scelerisque eget nisi lacinia, finibus pellentesque nisi.Proin gravida mauris eu interdum dictum. Nunc pellentesque augue nisl, mollis pellentesque lacus viverra mattis. Mauris pulvinar laoreet tortor eu ornare. Quisque pretium consequat iaculis. Aliquam pretium massa porta porta sodales. Vestibulum malesuada quam erat, non lobortis mauris convallis eu. Nunc vel ante luctus, condimentum mauris et, commodo dolor. Ut ac interdum ipsum. Suspendisse venenatis tempor elit non finibus. Nam in feugiat lectus.Sed gravida nunc porttitor ante suscipit tempus. Pellentesque sit amet dignissim nibh. Duis consequat sem est, nec sollicitudin dolor maximus id. Mauris sollicitudin semper dapibus. Nam lobortis volutpat sapien, eget aliquet massa congue nec. Aenean nec semper dui. Donec hendrerit vulputate pretium. Sed molestie dui tortor, a finibus mi luctus ut. Nulla sit amet lobortis tellus. Vestibulum ligula metus, varius sed scelerisque et, fringilla a orci. Nam eget libero eget libero vestibulum rutrum. Vivamus convallis felis eu eros ultricies, in mollis mauris elementum. Vivamus lobortis risus ultrices tellus mattis molestie.Etiam lacus dolor, semper non faucibus blandit, vestibulum quis ipsum. Duis magna mi, ornare eu mollis in, interdum auctor leo. Aliquam pharetra justo quis odio venenatis, eu mattis sapien semper. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Donec in accumsan risus. Duis quis porta nulla, id lacinia justo. Donec tristique euismod purus, at tempor nisi elementum at. Sed varius velit augue, ac egestas risus varius non.";
		
	// 	PerfilAcesso admin = new PerfilAcesso(1, "Admin");
		
	// 	Usuario giu = new Usuario(1, "Giugiu ademir", "giu@bloggersin.com", "senha123", "default.png", "lorem ipsum ai que dor", admin);
	// 	Usuario gustavin = new Usuario(2, "Gustavin", "gustavin@bloggersin.com", "senha123", "default.png", "lorem ipsum ai que dor", admin);
	// 	Usuario kael = new Usuario(5, "Kael", "mikael@bloggersin.com", "senha123", "default.png", "lorem ipsum ai que dor", admin);

	// 	Categoria tecnologia = new Categoria(1, "Tecnologia");
	// 	Categoria automatos = new Categoria(2, "Automatos");
	// 	Categoria modelagem = new Categoria(3, "Modelagem de sistemas");

	// 	return args -> {
	// 		repo.save(new Post(1, "Como sofrer com automatos", lorem, automatos, giu));
	// 		repo.save(new Post(2, "Como criar um sistema de abate do zero", lorem, modelagem, gustavin));
	// 		repo.save(new Post(3, "O que é scrum?", lorem, tecnologia, kael));
	// 		repo.save(new Post(4, "Como programar em spring boot", lorem, tecnologia, kael));
	// 	};
	// }

	// @Bean
	// public CommandLineRunner populateFavoritos(FavoritosRepository repo) {
	// 	String lorem = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean convallis quam eu mauris lacinia suscipit. Suspendisse potenti. Curabitur vitae turpis in tortor eleifend pulvinar eget vitae arcu. Aliquam erat volutpat. Nam dignissim dolor nec sapien aliquam, nec iaculis lacus porta. Donec lacinia et nisi tempus consequat. Donec ut rutrum sem. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Ut pretium nulla eros, sit amet aliquam diam porttitor eget. In blandit lorem sed volutpat ultricies. In vulputate, purus in pharetra auctor, urna lorem iaculis purus, et luctus tortor metus a ipsum.Vestibulum vestibulum enim non dui dapibus, vel consectetur turpis iaculis. Sed ac mi neque. Fusce volutpat, urna et luctus auctor, ex sapien varius lorem, quis efficitur quam arcu et mauris. Nulla facilisi. Morbi volutpat felis id velit pulvinar pharetra. Aenean sit amet odio gravida, ultrices ex quis, pretium felis. Donec aliquam odio nec dignissim luctus. Quisque quis finibus dolor. Pellentesque vestibulum, erat et pharetra lacinia, odio nunc hendrerit ante, vitae viverra nisl odio sed nulla. Donec eros ante, rhoncus eget luctus et, lobortis non ex. Curabitur purus nunc, scelerisque eget nisi lacinia, finibus pellentesque nisi.Proin gravida mauris eu interdum dictum. Nunc pellentesque augue nisl, mollis pellentesque lacus viverra mattis. Mauris pulvinar laoreet tortor eu ornare. Quisque pretium consequat iaculis. Aliquam pretium massa porta porta sodales. Vestibulum malesuada quam erat, non lobortis mauris convallis eu. Nunc vel ante luctus, condimentum mauris et, commodo dolor. Ut ac interdum ipsum. Suspendisse venenatis tempor elit non finibus. Nam in feugiat lectus.Sed gravida nunc porttitor ante suscipit tempus. Pellentesque sit amet dignissim nibh. Duis consequat sem est, nec sollicitudin dolor maximus id. Mauris sollicitudin semper dapibus. Nam lobortis volutpat sapien, eget aliquet massa congue nec. Aenean nec semper dui. Donec hendrerit vulputate pretium. Sed molestie dui tortor, a finibus mi luctus ut. Nulla sit amet lobortis tellus. Vestibulum ligula metus, varius sed scelerisque et, fringilla a orci. Nam eget libero eget libero vestibulum rutrum. Vivamus convallis felis eu eros ultricies, in mollis mauris elementum. Vivamus lobortis risus ultrices tellus mattis molestie.Etiam lacus dolor, semper non faucibus blandit, vestibulum quis ipsum. Duis magna mi, ornare eu mollis in, interdum auctor leo. Aliquam pharetra justo quis odio venenatis, eu mattis sapien semper. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Donec in accumsan risus. Duis quis porta nulla, id lacinia justo. Donec tristique euismod purus, at tempor nisi elementum at. Sed varius velit augue, ac egestas risus varius non.";

	// 	PerfilAcesso admin = new PerfilAcesso(1, "Admin");
		
	// 	Usuario giu = new Usuario(1, "Giugiu ademir", "giu@bloggersin.com", "senha123", "default.png", "lorem ipsum ai que dor", admin);
	// 	Usuario fellipe = new Usuario(3, "Gustavo", "gustavo@bloggersin.com", "senha123", "default.png", "lorem ipsum ai que dor", admin);
	// 	Usuario gustavo = new Usuario(4, "Fellipe", "fellipe@bloggersin.com", "senha123", "default.png", "lorem ipsum ai que dor", admin);
	// 	Usuario gustavin = new Usuario(2, "Gustavin", "gustavin@bloggersin.com", "senha123", "default.png", "lorem ipsum ai que dor", admin);
	// 	Usuario kael = new Usuario(5, "Kael", "mikael@bloggersin.com", "senha123", "default.png", "lorem ipsum ai que dor", admin);

	// 	Categoria tecnologia = new Categoria(1, "Tecnologia");
	// 	Categoria automatos = new Categoria(2, "Automatos");
	// 	Categoria modelagem = new Categoria(3, "Modelagem de sistemas");

	// 	Post post1 = new Post(1, "Como sofrer com automatos", lorem, automatos, giu);
	// 	Post post2 = new Post(2, "Como criar um sistema de abate do zero", lorem, modelagem, gustavin);
	// 	Post post3 = new Post(3, "O que é scrum?", lorem, tecnologia, kael);
	// 	Post post4 = new Post(4, "Como programar em spring boot", lorem, tecnologia, kael);
	
	// 	return args -> {
	// 		repo.save(new Favoritos(1, post2, fellipe));
	// 		repo.save(new Favoritos(2, post4, kael));
	// 		repo.save(new Favoritos(3, post4, gustavin));
	// 		repo.save(new Favoritos(4, post3, gustavo));
	// 		repo.save(new Favoritos(5, post1, kael));
	// 		repo.save(new Favoritos(6, post1, giu));
	// 		repo.save(new Favoritos(7, post1, fellipe));
	// 		repo.save(new Favoritos(8, post1, gustavin));
	// 	};
	// }

	// @Bean
	// public CommandLineRunner populateComentarios(ComentarioRepository repo) {
	// 	String lorem = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean convallis quam eu mauris lacinia suscipit. Suspendisse potenti. Curabitur vitae turpis in tortor eleifend pulvinar eget vitae arcu. Aliquam erat volutpat. Nam dignissim dolor nec sapien aliquam, nec iaculis lacus porta. Donec lacinia et nisi tempus consequat. Donec ut rutrum sem. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Ut pretium nulla eros, sit amet aliquam diam porttitor eget. In blandit lorem sed volutpat ultricies. In vulputate, purus in pharetra auctor, urna lorem iaculis purus, et luctus tortor metus a ipsum.Vestibulum vestibulum enim non dui dapibus, vel consectetur turpis iaculis. Sed ac mi neque. Fusce volutpat, urna et luctus auctor, ex sapien varius lorem, quis efficitur quam arcu et mauris. Nulla facilisi. Morbi volutpat felis id velit pulvinar pharetra. Aenean sit amet odio gravida, ultrices ex quis, pretium felis. Donec aliquam odio nec dignissim luctus. Quisque quis finibus dolor. Pellentesque vestibulum, erat et pharetra lacinia, odio nunc hendrerit ante, vitae viverra nisl odio sed nulla. Donec eros ante, rhoncus eget luctus et, lobortis non ex. Curabitur purus nunc, scelerisque eget nisi lacinia, finibus pellentesque nisi.Proin gravida mauris eu interdum dictum. Nunc pellentesque augue nisl, mollis pellentesque lacus viverra mattis. Mauris pulvinar laoreet tortor eu ornare. Quisque pretium consequat iaculis. Aliquam pretium massa porta porta sodales. Vestibulum malesuada quam erat, non lobortis mauris convallis eu. Nunc vel ante luctus, condimentum mauris et, commodo dolor. Ut ac interdum ipsum. Suspendisse venenatis tempor elit non finibus. Nam in feugiat lectus.Sed gravida nunc porttitor ante suscipit tempus. Pellentesque sit amet dignissim nibh. Duis consequat sem est, nec sollicitudin dolor maximus id. Mauris sollicitudin semper dapibus. Nam lobortis volutpat sapien, eget aliquet massa congue nec. Aenean nec semper dui. Donec hendrerit vulputate pretium. Sed molestie dui tortor, a finibus mi luctus ut. Nulla sit amet lobortis tellus. Vestibulum ligula metus, varius sed scelerisque et, fringilla a orci. Nam eget libero eget libero vestibulum rutrum. Vivamus convallis felis eu eros ultricies, in mollis mauris elementum. Vivamus lobortis risus ultrices tellus mattis molestie.Etiam lacus dolor, semper non faucibus blandit, vestibulum quis ipsum. Duis magna mi, ornare eu mollis in, interdum auctor leo. Aliquam pharetra justo quis odio venenatis, eu mattis sapien semper. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Donec in accumsan risus. Duis quis porta nulla, id lacinia justo. Donec tristique euismod purus, at tempor nisi elementum at. Sed varius velit augue, ac egestas risus varius non.";

	// 	PerfilAcesso admin = new PerfilAcesso(1, "Admin");
		
	// 	Usuario giu = new Usuario(1, "Giugiu ademir", "giu@bloggersin.com", "senha123", "default.png", "lorem ipsum ai que dor", admin);
	// 	// Usuario fellipe = new Usuario(3, "Gustavo", "gustavo@bloggersin.com", "senha123", "default.png", "lorem ipsum ai que dor", admin);
	// 	// Usuario gustavo = new Usuario(4, "Fellipe", "fellipe@bloggersin.com", "senha123", "default.png", "lorem ipsum ai que dor", admin);
	// 	Usuario gustavin = new Usuario(2, "Gustavin", "gustavin@bloggersin.com", "senha123", "default.png", "lorem ipsum ai que dor", admin);
	// 	Usuario kael = new Usuario(5, "Kael", "mikael@bloggersin.com", "senha123", "default.png", "lorem ipsum ai que dor", admin);

	// 	Categoria tecnologia = new Categoria(1, "Tecnologia");
	// 	Categoria automatos = new Categoria(2, "Automatos");
	// 	Categoria modelagem = new Categoria(3, "Modelagem de sistemas");

	// 	Post post1 = new Post(1, "Como sofrer com automatos", lorem, automatos, giu);
	// 	Post post2 = new Post(2, "Como criar um sistema de abate do zero", lorem, modelagem, gustavin);
	// 	Post post3 = new Post(3, "O que é scrum?", lorem, tecnologia, kael);
	// 	Post post4 = new Post(4, "Como programar em spring boot", lorem, tecnologia, kael);
	
	// 	return args -> {
	// 		repo.save(new Comentario(1, "Melhor post que já fiz na minha vida", giu, post1));
	// 		repo.save(new Comentario(2, "Post ruim", giu, post2));
	// 		repo.save(new Comentario(3, "Post horrível!!!", giu, post3));
	// 		repo.save(new Comentario(4, "Gostei não, discordo!!!!", giu, post4));
	// 	};
	// }

	// #endregion

}
