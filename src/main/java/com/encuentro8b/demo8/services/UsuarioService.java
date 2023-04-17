package com.encuentro8b.demo8.services;

import com.encuentro8b.demo8.models.Usuario;
import com.encuentro8b.demo8.repositories.IUsuarioRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Override
    public List getUsers() {
        return usuarioRepository.findAll();
    }

    @Override
    public Optional getUser(Long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public Usuario addUser(Usuario user) {

        return usuarioRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        usuarioRepository.deleteById(id);

    }

}
