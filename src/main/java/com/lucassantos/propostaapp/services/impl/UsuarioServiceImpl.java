package com.lucassantos.propostaapp.services.impl;

import com.lucassantos.propostaapp.dtos.usuario.UsuarioRequestDto;
import com.lucassantos.propostaapp.dtos.usuario.UsuarioResponseDto;
import com.lucassantos.propostaapp.entities.Usuario;
import com.lucassantos.propostaapp.mapper.UsuarioMapper;
import com.lucassantos.propostaapp.repositories.UsuarioRepository;
import com.lucassantos.propostaapp.services.UsuarioService;
import com.lucassantos.propostaapp.services.exceptions.ResourceAlreadyExists;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@AllArgsConstructor
public class UsuarioServiceImpl  implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    @Override
    @Transactional
    public UsuarioResponseDto create(UsuarioRequestDto usuarioRequestDto) {
       var userAlreadyExists = usuarioRepository.findByCpf(usuarioRequestDto.getCpf());
       if (userAlreadyExists != null) throw new ResourceAlreadyExists("This cpf is already taken");
       Usuario createdUser = UsuarioMapper.INSTANCE.convertDtoToUsuario(usuarioRequestDto);
       createdUser = usuarioRepository.save(createdUser);
       return UsuarioMapper.INSTANCE.convertEntityToUsuarioResponseDto(createdUser);
    }
}
