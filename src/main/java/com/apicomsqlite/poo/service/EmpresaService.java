package com.apicomsqlite.poo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.apicomsqlite.poo.enity.Empresa;
import com.apicomsqlite.poo.repository.EmpresaRepository;
import jakarta.transaction.Transactional;

@Service
public class EmpresaService {

    @Autowired(required = false)
    private EmpresaRepository empresaRepository;

    @Transactional
    public String createEmpresa(Empresa empresa) {
        try {
            if (!empresaRepository.existsByNome(empresa.getNome())) {
                empresa.setId(null == empresaRepository.findMaxId() ? 1 : empresaRepository.findMaxId() + 1);
                empresaRepository.save(empresa);

                return "empresa cadastrada com sucesso.";
            } else {
                return "empresa já existe no banco.";
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Empresa> readEmpresa() {
        return empresaRepository.findAll();
    }

    @Transactional
    public String updateEmpresa(Empresa empresa) {

        if (empresaRepository.existsById(empresa.getId())) {
            try {

                Optional<Empresa> empresaOptional = empresaRepository.findById(empresa.getId());

                if (empresaOptional.isPresent()) {
                    Empresa empresaToBeUpdate = empresaOptional.get();

                    if (empresaRepository.existsById(empresa.getId())) {

                        empresaToBeUpdate.setNome(empresa.getNome());
                        empresaToBeUpdate.setCnpj(empresa.getCnpj());

                        empresaRepository.save(empresaToBeUpdate);

                        return "empresa atualizado com sucesso.";
                    } else {
                        return "Já existe um empresa com o cnpj fornecido.";
                    }
                } else {
                    return "empresa não encontrado no banco.";
                }
            } catch (Exception e) {
                throw e;
            }
        } else {
            return "empresa não existe no banco.";
        }
    }

    @Transactional
    public String deleteEmpresa(int id) {
        try {
            if (empresaRepository.existsById(id)) {
                empresaRepository.deleteById(id);
                return "empresa deletado com sucesso.";
            } else {
                return "empresa não existe no banco de dados.";
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
