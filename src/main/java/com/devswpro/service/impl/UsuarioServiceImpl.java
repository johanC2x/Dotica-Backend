package com.devswpro.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Properties;
import java.util.UUID;

import com.devswpro.dao.IEmailResetDAO;
import com.devswpro.dao.IUserAccountDAO;
import com.devswpro.model.EmailReset;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.devswpro.dao.IUsuarioDAO;
import com.devswpro.dto.UsuarioDTO;
import com.devswpro.model.Usuario;
import com.devswpro.service.IUsuarioService;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Slf4j
@Service
public class UsuarioServiceImpl implements IUsuarioService {

	@Autowired
	private IUsuarioDAO dao;

	@Autowired
	private IEmailResetDAO emailResetDAO;

	@Autowired
	private IUserAccountDAO userAccountDAO;

	@Value("${app.email.user}")
	private String userEmail;

	@Value("${app.email.pass}")
	private String passEmail;

	@Value("${app.front.url}")
	private String appFrontUrl;

	@Override
	public Usuario login(UsuarioDTO usuarioDTO) {
		return dao.findByUsernameAndPassword(usuarioDTO.getUsername(), usuarioDTO.getPassword());
	}

	@Override
	public Usuario registrar(Usuario obj) {
		Usuario user = dao.save(obj);
		userAccountDAO.saveAccount(LocalDateTime.now(), 1, user.getIdUsuario());
		return user;
	}

	@Override
	public Usuario modificar(Usuario obj) {
		return dao.save(obj);
	}

	@Override
	public List<Usuario> listar() {
		return dao.findAll();
	}

	@Override
	public Usuario leer(Integer id) {
		Optional<Usuario> op = dao.findById(id);
		return op.isPresent() ? op.get() : new Usuario();
	}
	
	public Usuario leerPorUsuario(String userName){
		Usuario op = dao.findOneByUsername(userName);
		return op != null ? op : new Usuario();
	}

	@Override
	public void eliminar(Integer id) {
		dao.deleteById(id);
	}

	@Override
	public void sendEmail(String email){
		UUID uuid = UUID.randomUUID();

		EmailReset emailReset=new EmailReset();
		emailReset.setToken(uuid.toString());
		emailReset.setEmail(email);
		emailReset.setCreatedDate(LocalDateTime.now());
		emailReset.setActive(Boolean.TRUE);
		emailResetDAO.save(emailReset);

		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");

		Session session = Session.getInstance(prop,
		new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userEmail, passEmail);
			}
		});

		try {
			StringBuilder html = new StringBuilder();
			html.append("<!DOCTYPE html>");
			html.append("<html lang='en'>");
				html.append("<head>");
					html.append("<meta charset='UTF-8'>");
					html.append("<meta http-equiv='X-UA-Compatible' content='IE=edge'>");
					html.append("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
					html.append("<title>Document</title>");
				html.append("</head>");
				html.append("<body>");
					html.append("<p>Ha solicitado el cambio de contraseña, <b>haz click <a href='"+ appFrontUrl + uuid.toString() +"'>aquí</a></b></p>");
				html.append("</body>");
			html.append("</html>");

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("Tarunsunny143@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
			message.setSubject("Cambio de contraseña");
			message.setContent(html.toString(), "text/html; charset=utf-8");
			Transport.send(message);
			log.info(LocalDateTime.now() + " correo enviado exitosamente " + email);
		} catch (Exception e) {
			log.error("error :: ", e);
		}
	}

	@Override
	@Transactional
	public boolean reset(UsuarioDTO usuarioDTO) {
		EmailReset emailReset= emailResetDAO.findByActiveAndToken(Boolean.TRUE, usuarioDTO.getToken());
		if(emailReset != null){
			emailReset.setActive(Boolean.FALSE);
			emailResetDAO.save(emailReset);

			Usuario usuario = dao.findOneByUsername(emailReset.getEmail());
			usuario.setPassword(usuarioDTO.getPassword());
			dao.save(usuario);
			return Boolean.TRUE;
		}else{
			log.error("El token ingresado está vencido o no existe");
			return Boolean.FALSE;
		}
	}

}
