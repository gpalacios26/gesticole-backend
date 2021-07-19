package com.gregpalacios.gesticole.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gregpalacios.gesticole.dto.MatriculaAulaDTO;
import com.gregpalacios.gesticole.model.MatriculaAula;
import com.gregpalacios.gesticole.model.MatriculaAulaDetalle;
import com.gregpalacios.gesticole.repo.IGenericRepo;
import com.gregpalacios.gesticole.repo.IMatriculaAulaDetalleRepo;
import com.gregpalacios.gesticole.repo.IMatriculaAulaRepo;
import com.gregpalacios.gesticole.service.IMatriculaAulaService;

@Service
public class MatriculaAulaServiceImpl extends CRUDImpl<MatriculaAula, Integer> implements IMatriculaAulaService {

	@Autowired
	private IMatriculaAulaRepo repo;

	@Autowired
	private IMatriculaAulaDetalleRepo repoDet;

	@Override
	protected IGenericRepo<MatriculaAula, Integer> getRepo() {
		return repo;
	}

	@Override
	public Page<MatriculaAula> listarPageable(Pageable pageable) {
		return repo.listarPaginado(pageable);
	}

	@Transactional
	@Override
	public MatriculaAula registrarTransaccional(MatriculaAulaDTO dto) throws Exception {
		MatriculaAula cabecera = repo.save(dto.getMatricula());

		for (MatriculaAulaDetalle detalle : dto.getDetalle()) {
			detalle.setMatricula(cabecera);
			repoDet.save(detalle);
		}

		return cabecera;
	}

	@Transactional
	@Override
	public MatriculaAula modificarTransaccional(MatriculaAulaDTO dto) throws Exception {
		List<MatriculaAulaDetalle> registros = repoDet.listarPorMatricula(dto.getMatricula().getIdMatricula());

		for (MatriculaAulaDetalle registro : registros) {
			repoDet.deleteById(registro.getIdMatriculaDetalle());
		}

		MatriculaAula cabecera = repo.save(dto.getMatricula());

		for (MatriculaAulaDetalle detalle : dto.getDetalle()) {
			detalle.setMatricula(cabecera);
			repoDet.save(detalle);
		}

		return cabecera;
	}

	@Transactional
	@Override
	public void eliminarTransaccional(Integer id) throws Exception {
		List<MatriculaAulaDetalle> registros = repoDet.listarPorMatricula(id);

		for (MatriculaAulaDetalle registro : registros) {
			repoDet.deleteById(registro.getIdMatriculaDetalle());
		}

		repo.deleteById(id);
	}

}
