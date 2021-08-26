package pe.edu.upc.onewebs.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import pe.edu.upc.onewebs.repository.AuthorityRepository;
import pe.edu.upc.onewebs.repository.UsuarioRepository;

@Service 
public class AddUserDB implements CommandLineRunner {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private AuthorityRepository authorityRepository;
	
	/*@Autowired
	private PasswordEncoder passwordEncoder;*/
	
	@Override
	public void run(String... args) throws Exception {
		
		// SOLO DESBLOQUEAR CUANDO SE REQUIERA CREAR USUARIO DE FORMA MANUAL
		
		/*Usuario police = new Usuario();
		police.setUsername("police1");
		police.setPassword( new BCryptPasswordEncoder().encode("police") );
		police.setEnable(true);
		
		Usuario commissar = new Usuario();
		commissar.setUsername("commissar1");
		commissar.setPassword( new BCryptPasswordEncoder().encode("commissar") );
		commissar.setEnable(true);
		
		Usuario commander = new Usuario();
		commander.setUsername("commander1");
		commander.setPassword( new BCryptPasswordEncoder().encode("commander") );
		commander.setEnable(true);
		
		police.addAuthority("ROLE_POLICE");
		police.addAuthority("ACCESS_ADDMULCT");
		police.addAuthority("ACCESS_ADDDETAINEE");
		
		commissar.addAuthority("ROLE_COMMISSAR");
		commissar.addAuthority("ACCESS_DELMULCT");
		commissar.addAuthority("ACCESS_EDITMULCT");
		commissar.addAuthority("ACCESS_EDITDETAINEE");
		
		commander.addAuthority("ROLE_COMMANDER");
		commander.addAuthority("ACCESS_DELMULCT");
		commander.addAuthority("ACCESS_EDITMULCT");
		commander.addAuthority("ACCESS_ADDPOLICESTATION");
		
		usuarioRepository.save(police);	
		usuarioRepository.save(commissar);
		usuarioRepository.save(commander);*/
		
		
	}

}





