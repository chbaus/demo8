/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.encuentro8b.demo8.services;

import com.encuentro8b.demo8.models.Usuario;
import java.util.List;
import java.util.Optional;

public interface IUsuarioService {
    
    public List getUsers();
    
    public Optional getUser(Long id);    
    
    public Usuario addUser(Usuario user);
    
    public void deleteUser(Long id);   
    
}
