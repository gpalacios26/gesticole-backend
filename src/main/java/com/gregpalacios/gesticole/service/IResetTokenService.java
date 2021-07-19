package com.gregpalacios.gesticole.service;

import com.gregpalacios.gesticole.model.ResetToken;

public interface IResetTokenService {

	ResetToken findByToken(String token) throws Exception;
	
	void guardar(ResetToken token) throws Exception;
	
	void eliminar(ResetToken token) throws Exception;
}
