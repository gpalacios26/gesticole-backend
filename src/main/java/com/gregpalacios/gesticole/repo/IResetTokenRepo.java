package com.gregpalacios.gesticole.repo;

import com.gregpalacios.gesticole.model.ResetToken;

public interface IResetTokenRepo extends IGenericRepo<ResetToken, Integer> {

	ResetToken findByToken(String token);
}
