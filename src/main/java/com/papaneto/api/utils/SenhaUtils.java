package com.papaneto.api.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SenhaUtils {
	
//	Gera hash
	public static String gerarBCrypt(String senha) {
		if (senha == null) {
			return senha;
		}
		
		BCryptPasswordEncoder bCryptEncoder = new BCryptPasswordEncoder();
		return bCryptEncoder.encode(senha);
	}
	
//	Valida senha
	public static boolean senhaValida(String senha, String senhaEncoded) {
		BCryptPasswordEncoder bCryptEncoder = new BCryptPasswordEncoder();
		return bCryptEncoder.matches(senha, senhaEncoded);
	}

}
