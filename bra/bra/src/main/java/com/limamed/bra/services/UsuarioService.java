package com.limamed.bra.services;

import com.limamed.bra.dtos.UsuarioDto;
import com.limamed.bra.models.UsuarioModel;
import com.limamed.bra.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public Boolean criarUsuario(UsuarioDto dados){
        UsuarioModel usuarioModel = new UsuarioModel();

        usuarioModel.setEmail(dados.getEmail());
        usuarioModel.setSenha(dados.getSenha());
        usuarioRepository.save(usuarioModel);

        return true;
    }

    public Boolean validaUsuario(UsuarioDto dados){
        Optional<UsuarioModel> usuarioOP = usuarioRepository.findByEmailAndSenha(dados.getEmail(), dados.getSenha());
        if (usuarioOP.isEmpty()){
            return false;
        }
        return true;
    }
}
