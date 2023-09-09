package br.com.ifgoiano.equoterapia.equoterapiaapi.security;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Collections;
import java.util.Date;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import br.com.ifgoiano.equoterapia.equoterapiaapi.domain.model.UsuarioModel;
import jakarta.servlet.http.HttpServletRequest;

public class TokenUtil {

	private static final String EMISSOR = "mateusdev";
	private static final String TOKEN_KEY = "01234567890123456789012345678901"; // Chave deve ter 256 bits, nesse caso
																				// 32 caracteres, para a criptografia
	private static final long MINUTOS = 1;

	public static String obterToken(UsuarioModel usuarioModel) {

		String token = JWT.create().withSubject(usuarioModel.getNome()) // (Payload) define para quem é esse token
																		// (Sujeito)
				.withIssuer(EMISSOR) // (Payload) minha referencia (Emissor)
				.withExpiresAt(LocalDateTime.now().plusMinutes(MINUTOS).toInstant(ZoneOffset.of("-03:00"))) // (Payload)
																											// validade
																											// do token
				.withClaim("id", usuarioModel.getIdFuncionario()) // (Payload) id do usuário
				.sign(Algorithm.HMAC256(TOKEN_KEY.getBytes())); // (Signature)

		return token;
	}

	public static Authentication obterAuthentication(HttpServletRequest request) throws Exception {

		String token = request.getHeader("Authorization");
		String sujeito = "";
		String emissor = "";
		Date validade;
		int id;

		if (token != null && !token.isEmpty()) {

			token = token.replace("Bearer ", "");

			// A segurança do token, está na chave, apenas eu tenho
			DecodedJWT decode = JWT.require(Algorithm.HMAC256(TOKEN_KEY))
					.withIssuer(EMISSOR)
					.build()
					.verify(token);

			if (decode != null) {
				// token verificado e descriptografado

				sujeito = decode.getSubject();
				emissor = decode.getIssuer();
				validade = decode.getExpiresAt();
				id = Integer.parseInt(decode.getClaim("id").toString());

				if (!sujeito.isEmpty() && emissor.equals(EMISSOR) && validade.after(new Date(System.currentTimeMillis()))) {

					// caso a requisição tenha o cabeçalho correto, gero um "token interno"
					UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken("user", null,
							Collections.emptyList());

					return auth;
				}
				
			}else {
				return null;
			}

		} else {
			return null;
		}

		return null;
	}

}
